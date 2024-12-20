package com.pelatro.automation.gui.backend.thirdpartysite.server;

import java.io.File;

import com.pelatro.automation.gui.backend.thirdpartysite.utils.ConnectRemoteServer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class ServerSteps {
	
	@Given("I created a directory (.*) in my home directory")
	public void createDirectory(String dirName) {
		String s= new ConnectRemoteServer().execute("mkdir /home/pelatro/" + dirName);

		if(s.equals("mkdir: cannot create directory ‘/home/pelatro/"+dirName+"’: File exists")) {
			new ConnectRemoteServer().execute("rm -rf /home/pelatro/"+dirName);
			new ConnectRemoteServer().execute("mkdir /home/pelatro/"+dirName);
			System.out.println("Directory was existing, so deleted and created new");
		}
		
		String ls = new ConnectRemoteServer().execute("ls /home/pelatro/");
		if (!ls.contains(dirName))
			throw new AssertionError("Directory creation failed !!!");
	}
	
	@Given("I create files (.*) in (.*)")
	public void createFiles(String fileName, String dirName) {		
		
		new ConnectRemoteServer().execute("touch /home/pelatro/"+dirName+"/"+fileName);
		
		for(int i=1;i<=10;i++) {
			new ConnectRemoteServer().execute("echo 'line "+i+"' >> /home/pelatro/"+dirName+"/"+fileName);
			String lsFile=new ConnectRemoteServer().execute("ls /home/pelatro/"+dirName+"/"+fileName);
			if(lsFile.isEmpty()) {
				throw new AssertionError("Failed to load data to"+fileName);
			}
		}
		
		String ls = new ConnectRemoteServer().execute("ls /home/pelatro/"+dirName);
		if (!ls.contains(fileName))
			throw new AssertionError("File creation failed !!!");
	}
	
	@Given("list all the files in (.*)")
	public void listAllFiles(String dirName) {
		String ls= new ConnectRemoteServer().execute("ls /home/pelatro/"+dirName);
		System.out.println(ls);
	}
	
	@Given("Put contents of all file in (.*) to (.*)")
	public void catAllFilesContentToNewFile(String dirName, String destDirName) {
		new ConnectRemoteServer().execute("mkdir -p /home/pelatro/"+ destDirName);
		new ConnectRemoteServer().execute("cat /home/pelatro/"+dirName+"/* >> /home/pelatro/"+destDirName+"/allContent");
		
		String cat = new ConnectRemoteServer().execute("cat /home/pelatro/"+destDirName+"/allContent");
		if(cat.isEmpty()) {
			throw new AssertionError("Failed to copy all files content to new File");
		}
	}
	
	@And("Download the new file in local machine and display its content")
	public void downloadNewFile() {
		String downloadedFile =new ConnectRemoteServer().download("/home/pelatro","/home/pelatro/copyContent/allContent" );
		String ls =new ConnectRemoteServer().execute("ls /home/pelatro");
		
		String file = new File(downloadedFile).getName();
		if(!ls.contains(file)) {
			throw new AssertionError("Failed to Download");
		}
		System.out.println("downloaded file : "+ downloadedFile);
		
		String cat = new ConnectRemoteServer().execute("cat "+downloadedFile);
		System.out.println("File content: +"+cat);
	}

}
