abstract class Account{
    int accountno;
    double balance;
    Account(int accountno,double balance){ 
        this.accountno=accountno;
        this.balance=balance;
    }
    abstract void deposit(double amount);
    abstract void withdrawal(double amount);
    public String toString(){
       return "Account No: "+accountno+"\tBalance: "+balance; 
    }
}
   
   