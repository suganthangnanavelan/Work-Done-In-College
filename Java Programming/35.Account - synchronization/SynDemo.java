class Account{
    int accno;
    double balance;
    Account(int accno,double balance){
        this.accno=accno;
        this.balance=balance;
    }
    public String toString(){
        return "AccountNo: "+accno+"\tBalance: "+balance;
    }
    synchronized void deposit(double amnt){
        double t;
        t=balance;
        t=t+amnt;
        balance=t;
        System.out.println("After Deposit -> "+this);
    }
    synchronized void withdrawal(double amnt){
        double t;
        t=balance;
        t=t-amnt;
        balance=t;
        System.out.println("After Withdrawal -> "+this);
    }
}

class AccountThread implements Runnable{
    Account a;
    int choice;
    Thread t;
    AccountThread(Account a,int choice){
        this.a=a;
        this.choice=choice;
        t=new Thread(this);
    }
    public void run(){
        if(choice==1)
            a.deposit(500);
        else
            a.withdrawal(300);
    }
}

class SynDemo{
    public static void main(String[] args){
        Account a=new Account(18299271 ,1000.0);
        AccountThread t1=new AccountThread(a,1); 
        AccountThread t2=new AccountThread(a,2);
        t1.t.start();
        t2.t.start();
    }
} 
        