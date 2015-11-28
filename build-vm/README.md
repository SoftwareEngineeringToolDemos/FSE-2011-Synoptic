# Contents of build-vm folder
In this folder you will find:
*  [**Vagrantfile**] (https://github.com/SoftwareEngineeringToolDemos/FSE-2011-Synoptic/blob/master/build-vm/Vagrantfile)- Contains the vagrant script to load the Ubuntu 14.04 Desktop VM. 
*  [**vm-contents**] (https://github.com/SoftwareEngineeringToolDemos/FSE-2011-Synoptic/tree/master/build-vm/vm-contents) -Contains the files that will be copied over to the VM desktop.

***

# Minimum requirements for using this Vagrant Script 
* Any 64-bit OS
* VirtualBox (preferrably 5.0.6)
* Vagrant (preferrably 1.7.4) 

***

# Steps to create the VM using Vagrant 
 1. Download and install [Vagrant] (https://www.vagrantup.com/downloads.html) appropriate to your host OS.
 2. Download and install [VirtualBox] (https://www.virtualbox.org/wiki/Downloads) appropriate to your host OS.
 3. Copy the "Vagrantfile" in this folder to your host OS.
 4. On the command prompt (on Windows) or terminal (on Linux), go to the directory which contains the copied Vagrantfile.
 5. Run the command "vagrant up --provider virtualbox"
 6. The vagrant file will begin execution and boot up a VM after some time. 
    * **Note** : Please wait for the entire script to finish execution before using the VM. 
    
***

# Details of the built VM
1. Ubuntu Desktop 14.04
    * Username : vagrant
    * Password : vagrant
2. Packages installed:
    * Java OpenJDK 7
    * Apache ant
    * Graphviz
    * Flash plugin (to view the Youtube video)
    * Unzip

***

# Acknowledgements
* This VM uses the base box [box-cutter/ubuntu1404-desktop](https://atlas.hashicorp.com/box-cutter/boxes/ubuntu1404-desktop/versions/2.0.5) 
which is a standard and stable external resource. 
* A simple tutorial to help new users install Java onto their machines can be viewed [here] (https://www.digitalocean.com/community/tutorials/how-to-install-java-on-ubuntu-with-apt-get)
* A tutorial to create the Vagrant script was followed which can be found [here] (https://blog.engineyard.com/2014/building-a-vagrant-box)

