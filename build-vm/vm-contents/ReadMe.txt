What is Synoptic?
Synoptic is a command line tool that summarizes log files as directed graphs. The directed graphs describe the process that produced the logs.
More precisely, it takes a set of log files, and some rules that tell it how to interpret lines in those log files, and outputs a summary that concisely and accurately captures the important properties of lines in the log files.


How Synoptic works?
Synoptic is a command line tool that requires the need to use a shell. On this Ubuntu 14.04 VM, the terminal can be used to run the tool.

In order to view the working of the tool, these are the following steps:

(1)
Open the terminal using (Ctrl+Alt+T) from the desktop or by clicking on the terminal icon on the launcher to the left.

(2)
Once the terminal opens, the current working directory will be the home directory of the machine. In order to make run the tool, move to the directory  	 wherethe tool is located as follows:
cd Desktop/synoptic 
or if you want to get back to the directory from anywhere you may be, you can run the following command:
cd /home/synoptic/Desktop/synoptic

(3)
What's the simplest argument that can be given to check if the tool works?
./synoptic.sh -h
This displays a help page on the terminal with a list of all the arguments that can be given.

(4)Required inputs
(a)Log files: 
Synoptic takes a list of log files as its final command line argument. For example, the following command line passes the files file1.log and file2.log to Synoptic:
./synoptic.sh file1.log file2.log
(b)Output Path prefix:
Synoptic needs to know where to output graphviz dot files and the associated graphics files. The -o option takes a path prefix, which means that every file Synoptic generates will begin with this string. Here is an example:
./synoptic.sh -o output/apache-trace
(c)Dot command location
Synoptic uses the Graphviz dot command to generate graphical representations of graphs. Without knowing where dot is, Synoptic can't create the pictures most users want to see. Use the -d option to tell Synoptic where to find the dot command. For example:
./synoptic.sh -d /usr/local/bin/dot
(d)Regular Expressions:
Synoptic relies on user-supplied regular expressions (Java 7 regular expressions) to parse log lines (or event instance). To parse the log lines Synoptic needs a set of regular expressions to tell it three things about each event instance:
    Event type and time value (-r)
    Trace sample partition (-s or -m)
The user can also tell Synoptic to ignore all lines that are not matched by the specified expressions using the -i option.
The list of regular expressions can be passed to Synoptic as a series of command line arguments, like this:
./synoptic.sh -r regex1 -r regex2 -r regex3 ...

***************************************************************************************************************************************
https://github.com/ModelInference/synoptic/wiki/DocsSynopticCmdLineTutorial

The following example was obtained from the original git repository authored by Ivan Beschastnikh and colleagues.
**************************************************************************************************************************************
Example

An example that is demonstrated in the VM Tool Demo is the log file of an OSX Login Attempt. The log file looks something like this:

loginwindow[35]: Login Window Started Security Agent
May 20 16:15:27 my-mac SecurityAgent[130]: Showing Login Window
May 20 16:29:19 my-mac SecurityAgent[130]: User info context values set for jenny
May 20 16:29:19 my-mac authorizationhost[129]: Failed to authenticate user <jenny> (tDirStatus: -14090).
May 20 16:29:22 my-mac SecurityAgent[130]: User info context values set for jenny
May 20 16:29:22 my-mac SecurityAgent[130]: Login Window Showing Progress
May 20 16:29:22 my-mac SecurityAgent[130]: Login Window done
May 20 16:29:22 my-mac com.apple.SecurityServer[23]: Succeeded authorizing right 'system.login.console' by client '/System/Library/CoreServices/loginwindow.app' for authorization created by '/System/Library/CoreServices/loginwindow.app'


You can run Synoptic on /traces/abstract/osx-login-example/trace-full.txt with the commands: ./synoptic.sh -o osx-login-example -r ".+User\sinfo.+guest\$(?<TYPE=>guest_login)" -r ".+User\sinfo.+(?<TYPE=>login_attempt)" -r ".+Failed\sto\sauthenticate.+(?<TYPE=>failed_auth)" -r ".+Login\sWindow\sdone\$(?<TYPE=>authorized)" -s ".+Succeeded\sauthorizing.+" -i ./traces/abstract/osx-login-example/trace-full.txt

This command specifies four -r options to use three regex statements to parse the log file. The first regex ".+User\sinfo.+guest\$(?guest_login)" will match lines of the event type "guest_login". The second regex ".+User\sinfo.+(?login_attempt)" will match lines of event type "login_attempt". The third regix ".+Failed\sto\sauthenticate.+(?failed_auth)" will match all failed authorizations to type "failed_auth". And the fourth regex ".+Login\sWindow\sdone\$(?authorized)" will match all lines to event type "authorized".

The -s option commands Synoptic to separate the log lines above and below the matching regex into distinct partitions. For this log, Synoptic will group all lines above the line matching ".+Succeeded\sauthorizing.+" into one partition and all lines below it to another partition. You can then focus on the sequence of events that leads to an authorized login.

The log file contains lines that do not match any of the supplied regex, such as "loginwindow35: Login Window Started Security Agent". The -i option specifies Synoptic to ignore these non-matching lines.

This command produces a model file in the form of a graph.From the graph, you can analyze the sequence of events that follow each other for an OSX login. The output also highlights a bug in the system, as a failed_authorization event can be followed by an authorized event. This information can be used to identify bugs in the system










