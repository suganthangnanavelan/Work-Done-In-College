import java.util.Scanner;
import java.util.ArrayList;
import userdefinedexception.DuplicateContactException;
import pkcontact.Contact;
import pkcontact.ContactManagement;


class Demo{
    public static void main(String[] args){
            Scanner scan=new Scanner(System.in);
            ContactManagement cm=new ContactManagement();
            int choice;
            System.out.println("\tContact Management System");
            do{
                System.out.println("\t\tMenu\n\t\t1.Add contact\n\t\t2.Search and display contacts with matching substring(Ignore Case)\n\t\t3.Display in sorted order\n\t\t4.Exit");
                System.out.print("Enter The Choice: ");
                choice=scan.nextInt();
                switch(choice){
                    case 1:{System.out.print("Enter Name and Mobile no: ");
                            try{
                                cm.add(new Contact(scan.next(),scan.next()));
                                System.out.println("Insertion successful");
                            }catch(DuplicateContactException e){
                                System.out.println("Insertion unsuccessful\n"+e);
                            } 
                            break;
                           }
                    case 2:{System.out.print("Enter the substring to be matched: ");
                            String substring=scan.next();
                            ArrayList<String> temp=cm.search(substring);
                            if(temp.size()!=0)
                                System.out.println("Contact details with \""+substring+"\" as substring: "+temp);
                            else
                                System.out.println("No Contacts found with \""+substring+"\" as substring");
                            break;
                           }
                    case 3:{System.out.println("All Contacts detail(sorted)");
                            ArrayList<Contact> temp=cm.display();
                            for(var v:temp)
                                System.out.println(v);
                            break;
                           }
                    case 4:{break;}
                    default:System.out.println("Invalid Choice");
                }
            }while(choice!=4);   
    }
}