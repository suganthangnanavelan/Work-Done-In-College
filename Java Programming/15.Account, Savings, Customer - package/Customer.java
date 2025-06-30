package pkcustomer;
import pkaccount.Account;
import pksavings.Savings;
import java.util.Scanner;
public class Customer{
    String customername,customeraddress;
    int customerid;
    Account acc;
    public Customer(String customername,String customeraddress,int customerid,int accno,double bal){
        acc=new Savings(accno,bal);
        this.customername=customername;
        this.customeraddress=customeraddress;
        this.customerid=customerid;
    }
    public int calculate(int cid){
        Scanner scan=new Scanner(System.in);
        int option;double amnt;
        if(customerid == cid){
            System.out.print("\t\t1.Deposit\n\t\t2.Withdrawal\nEnter The Choice: ");
            option=scan.nextInt();
            System.out.print("Enter The Amount: ");
            amnt=scan.nextDouble();
            if(option==1)
                 acc.deposit(amnt);
            else if(option==2)
                 acc.withdrawal(amnt);
            else
                 System.out.println("Invalid Choice");
        return 1;
        }
        else
            return 0;  
    }
    public String toString(){
        return "\nCustomer Id: "+customerid+"\nCustomer Name: "+customername+"\nCustomer Address: "+customeraddress+"\n"+acc;
    }
}