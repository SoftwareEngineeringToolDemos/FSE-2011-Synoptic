# Contents of build-vm folder
In this folder you will find:
*  **Vagrantfile** - Contains the vagrant script to load the Ubuntu 15 Desktop VM. 

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
1. Ubuntu Desktop 15.04
    * Username : vagrant
    * Password : vagrant
2. Java 7

***

# Acknowledgements
* This VM uses the base box [box-cutter/ubuntu1504-desktop](https://atlas.hashicorp.com/box-cutter/boxes/ubuntu1504-desktop/versions/2.0.5) 
which is a standard and stable external resource. This is identical to the operating system as used by the hand built VM.
* A simple tutorial to help new users install Java onto their machines can be viewed [here] (https://www.digitalocean.com/community/tutorials/how-to-install-java-on-ubuntu-with-apt-get)
* A tutorial to create the Vagrant script was followed which can be found [here] (https://blog.engineyard.com/2014/building-a-vagrant-box)

