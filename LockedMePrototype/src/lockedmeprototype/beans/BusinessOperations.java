package lockedmeprototype.beans;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BusinessOperations {
	
	String pathname;
		
public BusinessOperations(String pathname) {
		super();
		this.pathname = pathname;
	}

	public int operations() {
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Press 1 to Add a file to the directory");
		System.out.println("Press 2 to Delete a file from the directory");
		System.out.println("Press 3 to Search a file from the directory");
		System.out.println("Press 4 to return to Welcome Page\n");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Enter your Option");
		try {	
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		
		if(option==1) { //Add a file to the directory
			try {
							
				System.out.println("Enter the filename you want to Add ");
				Scanner scadd = new Scanner(System.in);
				String addpathname = pathname + "\\" + scadd.next();
										
				File fileadd = new File(addpathname);
				System.out.println("Name : " + fileadd.getName());
				System.out.println("Parent : " + fileadd.getParent());
			
				if(!fileadd.exists()&&fileadd.createNewFile()) {
					System.out.println(fileadd.getName() + "created successfuly");
				}else {
					if(fileadd.exists())
						System.out.println(fileadd.getName()+" already exists");
					System.out.println(fileadd.getName()+" cannot be created.");
				}
			}catch (IOException e) {
					System.out.println(e.getMessage() + "-> To Re-enter Directory go to Welcome Page");
					return 0;			
			}
			
			return 1;
		}
		if(option==2) { //Delete a file from the directory
			System.out.println("Enter the filename you want to Delete ");
			Scanner scdel = new Scanner(System.in);
			String delfile = scdel.next();
			File file = new File(pathname);
			if(file.exists()) {
			File files[] = file.listFiles();
			boolean delete = false;
			
			for(File f:files) { // Using Linear Search Algorithm to delete a file
				String filename = f.getName();
				if(filename.equals(delfile)&&f.exists()) { // equals() to check sensitivity of the filename
					f.delete();
					delete = true;
				}	
			}
			if(delete==true) {
				System.out.println(delfile + " deleted successfully");
			}else
				System.out.println(delfile + " file not found!");
			
			return 2;
			}else {
				System.out.println("Wrong Directory Entered -> To Re-enter Directory go to Welcome Page");
				return 0;
			}
		}
		if(option==3) { //Search a file from the directory
			System.out.println("Enter the filename you want to Search/View ");
			Scanner scsearch = new Scanner(System.in);
			String searchfile = scsearch.next();
			File file = new File(pathname);
			if(file.exists()) {
				File files[] = file.listFiles();
				boolean found = false;
				
				for(File f:files) { // Using Linear Search Algorithm for searching a file
					String filename = f.getName();
					if(filename.equals(searchfile)&&f.exists()) { // equals() to check sensitivity of the filename
						System.out.println(filename + " :File found");
						System.out.println("Absolute path : " + f.getAbsolutePath());
						System.out.println("Size : " + f.length());
						System.out.println("Is Readable : " + f.canRead());
						System.out.println("Is Writable : " + f.canWrite());
						found = true;
					}	
				}
				if(found!=true) 
					System.out.println(searchfile + " file not found!");
								
				return 3;
				
				}else {
					System.out.println("Wrong Directory Entered -> To Re-enter Directory go to Welcome Page");
					return 0;
				}
		
		}
		if(option==4) { // navigating to main menu/context/Welcome page
			return 4;
		}else 
			System.out.println("Wrong input, Press 1 or 2 or 3 or 4 as per your choice");
		
		return 0;
		}catch(InputMismatchException e) {
			System.out.println("Input Mismatch, Enter only Integer 1/2/3/4 as input from user.");
			return 0;
		}
	}
}
