import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;  

public class AddressBook {

	
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();
		addressBook.askUser();
	}


               void askUser() {
		System.out.println("Select an action..");
		System.out.println("1. To Create a new contact");
		System.out.println("2. To fill details of contact");
		System.out.println("3. To display/read details of contact");
		System.out.println("4. quit");
		
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			System.out.print("You Choose to create a new contact \n");
			createNewContact();
			System.out.println("\n");
			askUser();
			break;
		case 2:
 	        
			fillDetailsOfContact();
			System.out.println("\n");
			askUser();
			break;
		case 3:
		
			displayContacts();
			System.out.println("\n");
			askUser();
			break;
		
		default:
			break;
		}
	}
	
	void createNewContact() {
		System.out.print("Enter file name: ");
		String fileName = scanner.next();
		try {
			File myObj = new File("D:addressbookof"+fileName);
			if (myObj.createNewFile()) {
				System.out.println("File created: "+ myObj.getName());

			}  else {
				System.out.println("File already exists.");
   
		}
	} catch (IOException e) {
		System.out.println("An error occured.");
		e.printStackTrace();
	}
			 }
		
		void fillDetailsOfContact() {
			System.out.print("Enter file name to write: ");
			String fileName = scanner.next();
			File write = new File("D:addressbookof"+fileName);
			try{
			    if(!write.exists()){
			        System.out.println("We had to make a new file.");
			        write.createNewFile();
			    }

			    FileWriter fileWriter = new FileWriter(write, true);

			    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			    Scanner sc= new Scanner(System.in); 
			   
			    System.out.print("\nEnter firstname and last name: ");  
			    String firstname= sc.nextLine();
                           String lastname = sc.nextLine();  
			    System.out.print("\nYou entered firstname and lastname: "+firstname +lastname);   
				bufferedWriter.write( firstname);
                         	bufferedWriter.write( lastname );

                              System.out.print("\nEnter a address: ");
                            String address= sc.nextLine();
                            System.out.print("\nYou entered address: "+address);
                                bufferedWriter.write(   address.toString());

       	
  			    System.out.print("\nEnter city, state, zip ");  
			    String city= sc.nextLine();
                            String state=sc.nextLine();
                            String zip=sc.nextLine();                
                             System.out.print("\n entered city,state and zip is: "+city +state +zip);

			    bufferedWriter.write(city.toString());
			    bufferedWriter.write( state.toString());
                            bufferedWriter.write( zip.toString());
			    System.out.print("\nEnter phonenumber: ");  
			    String phonenumber= sc.nextLine();                 
			    System.out.print("\nYou entered phonenumber: "+phonenumber);   
				bufferedWriter.write( phonenumber.toString() );
			    bufferedWriter.close();
			    System.out.println("\nDone");
			} catch(IOException e) {
			    System.out.println("COULD NOT WRITE INTO FILE!!");
			}
			
		
		}
		void displayContacts() {
			System.out.print("Enter file name to read: ");
			String fileName = scanner.next();
		    try {
		  	  File myObj = new File("D:addressbookof" +fileName);
		        Scanner myReader = new Scanner(myObj);
		        while (myReader.hasNextLine()) {
		          String data = myReader.nextLine();
		          System.out.println(data);
		        }
		        myReader.close();
		      } catch (FileNotFoundException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      }


}
}


