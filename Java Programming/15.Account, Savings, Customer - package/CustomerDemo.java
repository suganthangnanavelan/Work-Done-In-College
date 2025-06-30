import pkaccount.Account;
import pksavings.Savings;
import pkcustomer.Customer;
import java.util.Scanner;
public class CustomerDemo{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter The No of Customers: ");
        int n=scan.nextInt();
        scan.nextLine();
        int cid;
        String name,address;
        Customer C[]=new Customer[n];
        Savings s;
        for(int i=0;i<n;i++){
            System.out.println("Enter Details of Customer "+(i+1));
            System.out.print("Enter Name: ");
            name=scan.nextLine();
            System.out.print("Enter Address: ");
            address=scan.nextLine();
            System.out.print("Enter Id, Account No, Balance: ");
            C[i]=new Customer(name,address,scan.nextInt(),scan.nextInt(),scan.nextDouble());
            scan.nextLine();
        }
        System.out.print("\n\nEnter The CustomerId:");
        cid=scan.nextInt();
        int flag=0;
        for(int i=0;i<n;i++){
           if(flag==1)
               break;
           flag=C[i].calculate(cid);
        }   
        if(flag==0)
            System.out.println("Customer Not Found");
        System.out.println();
        for(int i=0;i<n;i++)
            System.out.println("\nDetails of Customer "+(i+1)+"\n"+C[i]);
    }
}
 