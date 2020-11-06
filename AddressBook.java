import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddressBook {

	
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Book methods = new Book();
		methods.askUser();
	}

}

class Book

{

               void askUser() {
                Scanner scanner = new Scanner(System.in);
		System.out.println("Select an action..");
		System.out.println("1. To Create a new contact");
		System.out.println("2. To fill details of contact");
		System.out.println("3. To display/read details of contact");
		System.out.println("4. to edit details of contact");
                 System.out.println("5. to delete contact");
                 System.out.println("6.quit");		
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			
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
                case 4:

                        editDetailsOfContacts();
                        System.out.println("\n");
                        askUser();
                        break;
		case 5:

                        deleteContact();
                        System.out.println("\n");
                        askUser();
                        break;

		default:
			break;
		}
	}
	
	void createNewContact() {
                Scanner scanner = new Scanner(System.in);
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
		
		public void fillDetailsOfContact() {
                       Scanner scanner = new Scanner(System.in);
			System.out.print("Enter file name to write: ");
			String fileName = scanner.next();
                        System.out.print("Enter file extension to write: ");
                        String fileExtension = scanner.next();
			File rite = new File("D:addressbookof"+fileName);
			try{
			    if(!rite.exists()){
			        System.out.println("We had to make a new file.");
			        rite.createNewFile();
			    }

			    FileWriter fileWriter = new FileWriter(rite, true);

			    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			    Scanner sc= new Scanner(System.in); 
			   
			    System.out.print("\nEnter firstname and last name: ");  
			    String firstname= sc.nextLine();
                           String lastname = sc.nextLine();  
			    System.out.print("\nYou entered firstname and lastname: "+firstname +lastname);   
				

                              System.out.print("\nEnter a address: ");
                            String address= sc.nextLine();
                            System.out.print("\nYou entered address: "+address);
                                

       	
  			    System.out.print("\nEnter city, state, zip ");  
			    String city= sc.nextLine();
                            String state=sc.nextLine();
                            String zip=sc.nextLine();                
                            System.out.print("\n entered city,state and zip is: "+city +state +zip);

			    System.out.print("\nEnter phonenumber: ");  
			    String phonenumber= sc.nextLine();                 
			    System.out.print("\nYou entered phonenumber: "+phonenumber);   
			    System.out.print("\n SAVINGMENU \n TOSAVE-1 \n DON'TSAVE-2\n SAVEAS-3\n");  
			      int choice_for_saving = scanner.nextInt();
		switch(choice_for_saving)
		{
		case 1:
			save(firstname,lastname,address,city,state,zip,phonenumber,fileName,fileExtension); 

			
			System.out.print("Your data is STORED\n");
			break;
		case 2:
			System.out.print("You Choose NOT TO SAVE \n");
			break;
		case 3:
			System.out.print("You Choose SAVE AS\n");
			save(firstname,lastname,address,city,state,zip,phonenumber,fileName,fileExtension); 
			System.out.print("Enter file extension to SAVEAS: ");
			String SaveasfileExtension = scanner.next();
			byte[] array = new byte[500];
		    try 
		    {
		      FileInputStream sourceFile = new FileInputStream("D:addressbookof"+fileName+fileExtension);
		      FileOutputStream destFile = new FileOutputStream("D:addressbookof"+fileName+SaveasfileExtension);

		      
		      sourceFile.read(array);

		      
		      destFile.write(array);
		      System.out.println("The input.txt file is copied to newFile.");

		     
		      sourceFile.close();
		      destFile.close();
		    }
		    catch (Exception e)
		    {
		      e.getStackTrace();
		    }
			default:
			break; 
		    }
			    System.out.println("\nDone");
			}   catch(IOException e) {
			    System.out.println("COULD NOT WRITE INTO FILE!!");
			}
			
		
		}
  void save(String firstname,String lastname,String address,String city,String state,String zip,String phonenumber,String fileName,String fileExtension)
                {

                File log = new File("D:addressbookof"+fileName+fileExtension);
           try
           {
                if(!log.exists())
                {
                System.out.println("We had to make a new file.");
                log.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(log, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(firstname + "\n");
                bufferedWriter.write(lastname + "\n");
                bufferedWriter.write(address.toString()+ "\n");
                bufferedWriter.write( city.toString() + "\n");
                bufferedWriter.write(state.toString()  + "\n");
                bufferedWriter.write( zip.toString() + "\n");
                bufferedWriter.write( phonenumber.toString() + "\n");
                bufferedWriter.close();
           }
            catch (Exception e)
           {
                      e.getStackTrace();
                    }

                }



		void displayContacts() {
                        Scanner scanner = new Scanner(System.in);
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
void editDetailsOfContacts() 
		{
			System.out.print("Enter file name to read: ");
			Scanner scanner = new Scanner(System.in);
			String fileName = scanner.next();
			System.out.println("\nYou choose to EDIT");
			System.out.println("Press 1 to EDIT Address");
			System.out.println("Press 2 to EDIT firstname");
			System.out.println("Press 3 to EDIT secondname");
			System.out.println("Press 4 to EDIT city");
			System.out.println("Press 5 to EDIT state");
			System.out.println("Press 6 to EDIT zip");
			System.out.println("Press 7 to EDIT phonenumber");

			int choice = scanner.nextInt();
			switch(choice) 
			{
			case 1:
				editoptions(choice,fileName); 
                break;
			case 2:
				editoptions(choice,fileName); 
                break;
			case 3:
				editoptions(choice,fileName); 
                break;
			case 4:
				editoptions(choice,fileName); 
                break;
			case 5:
				editoptions(choice,fileName); 
                break;
			case 6:
				editoptions(choice,fileName); 
                break;
			case 7:
				editoptions(choice,fileName); 
                break;
		}
      }
		 public static void setVariable(int lineNumber, String data,String fileName) throws IOException 
		 {
				
			    Path path = Paths.get("D:addressbookof"+fileName);
			    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			    lines.set(lineNumber - 1, data);
			    Files.write(path, lines, StandardCharsets.UTF_8);
		 }
		 void editoptions(int choice,String fileName) 
		 {
			    Scanner scanner = new Scanner(System.in);
			    System.out.print("\n Enter text :");
				String Text = scanner.next();
				try
				{
				File obj =new File("D:addressbookof"+fileName);
			    setVariable(choice, Text,fileName);
			    System.out.println("Done");
				} 
				catch(IOException e)
				{
							    System.out.println("COULD NOT EDIT FILE");
							
				}
		 }

void deleteContact() 
		 {     
			   Scanner scanner = new Scanner(System.in);
			   System.out.print("Enter file name to delete: ");
			   String fileName = scanner.next();
			   File file = new File("D:addressbookof"+fileName); 
		        if(file.delete()) 
		        { 
		            System.out.println("File deleted successfully"); 
		        } 
		        else
		        { 
		            System.out.println("Failed to delete the file"); 
		        }
			   
		 }


}


