package pkaccount;
public abstract class Account{
    int accountno;
    public double balance;
    public Account(int accountno,double balance){ 
        this.accountno=accountno;
        this.balance=balance;
    }
    public abstract void deposit(double amount);
    public abstract void withdrawal(double amount);
    public String toString(){
       return "Account No: "+accountno+"\tBalance: "+balance; 
    }
} 
   