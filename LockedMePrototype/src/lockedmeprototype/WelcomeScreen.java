package lockedmeprototype;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import lockedmeprototype.beans.BusinessOperations;

public class WelcomeScreen {

	public static void main(String[] args) {
		System.out.println("*************************************************************************************************");
		System.out.println("This is a Prototype of 'LockedMe.com' Application brought to you by Company Lockers Pvt. Ltd.");
		System.out.println("\t\t\tDesigned and Developed by Er. Faizan Iyzdi");
		
		start:
		while(true) {
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("\t\t\tYou are at Welcome Page of LockedMe.com");	
			System.out.println("\nPress 1 to view the contents of the directory");
			System.out.println("Press 2 to Add/Delete/Search the files");
			System.out.println("Press 3 to close the application\n");
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("Enter your Option");
			try {
				Scanner sc = new Scanner(System.in);
				int option = sc.nextInt();
								
				switch(option) {
				case 1:  // Retrieving file names in ascending order 
					try {
						System.out.println("Enter the Absolute Path of the Directory ");
						Scanner sc1 = new Scanner(System.in);
						String pathname  = sc1.next();
						
						File file = new File(pathname);
						String[] directorycontent = file.list();
						if(directorycontent.length!=0) {
							TreeSet<String> ts =new TreeSet<String>();
							for(String f:directorycontent) {
								ts.add(f);
							}
							
							Iterator<String> it = ts.iterator();
							System.out.println("\nThe list of files or folders in the directory : "+ pathname + " is as follows:-\n");
							while (it.hasNext()) {
								System.out.println(it.next());
							}
							continue start;
													
						}else 
							System.out.println("Directory : "+ pathname +" is empty.");
							continue start;
						
					}catch (Exception e) {
						System.out.println("The Absolute pathname is incorrect!");
						continue start;
					} 
					
				case 2: // Business Level Operations to Add/Delete/Search files
					
					System.out.println("\t\t\t\tAdd/Delete/Search files");
					System.out.println("Enter the Absolute Path of the Directory "
							+ "where you want to perform Add/Delete/Search Operations ");
					Scanner sc1 = new Scanner(System.in);
					String pathname  = sc1.next();
					BusinessOperations bops = new BusinessOperations(pathname);
					int i;
					
					do{
						i = bops.operations(); // Call to file Handling/Business level Operations
						if(i==4) {
							continue start;
					}
					}while(i!=4);
					break;
					
				case 3: // Closing the application
					System.out.println("Closing the Application");
					System.exit(0);
					
				default:
					System.out.println("Wrong Option");
					continue start;
					
					
				}
				
			}
		 catch (InputMismatchException e) {
				System.out.println("Input Mismatch, Enter only Integer 1/2/3 as input from user.");
				continue start;
		}
		break;
		}


	}

}
