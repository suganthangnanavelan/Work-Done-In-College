package pksavings;
import pkaccount.Account;
public class Savings extends Account{
    public Savings(int accno,double bal){
        super(accno,bal);
    }
    public void deposit(double amount){
        super.balance+=amount;
        System.out.println("Current Balance: "+super.balance);
    }  
    public void withdrawal(double amount){
        super.balance-=amount;
        System.out.println("Current Balance: "+super.balance);
    }
    public String toString(){
        return super.toString(); 
    }
}