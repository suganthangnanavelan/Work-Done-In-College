import java.util.Scanner;
import userdefinedexception.NegativeValueException;
import userdefinedexception.InvalidTransactionException;

class Account{
    private int accno;
    private double balance;
    Account(int accno,double balance){
        this.accno=accno;
        this.balance=balance;
    }
    private void changeBalance(){
        System.out.print("ReEnter The Balance: ");
        Scanner scan=new Scanner(System.in);
        balance=scan.nextInt();
        try{
            if(balance<0)
                throw new NegativeValueException("Balance Cannot be Negative\tBalance = "+balance);
        }catch(NegativeValueException e){
            System.out.println("Caught "+e);
            changeBalance();
        } 
    }
    private void changeAccountNo(){
        System.out.print("ReEnter The AccountNo: ");
        Scanner scan=new Scanner(System.in);
        accno=scan.nextInt();
        try{
            if(accno<0)
                throw new NegativeValueException("AccountNo Cannot be Negative\tAccountNo: "+accno);
        }catch(NegativeValueException e){
            System.out.println("Caught "+e); 
            changeAccountNo();
        }
    }
    void deposit(double amount){
        try{
            if(amount<0)
                throw new NegativeValueException("Deposit Amount Cannot be Negative\tAmount = "+amount);
            else
                balance+=amount;
        }catch(NegativeValueException e){
            System.out.println("Caught "+e);
        } 
    }
    void withdrawal(double amount){
        try{
            if(amount<0)
                throw new NegativeValueException("Withdrawal Amount Cannot be Negative\tAmount = "+amount);
            else
                 try{
                     balance-=amount;
                     if(balance<0){
                         InvalidTransactionException e=new InvalidTransactionException("Insufficient Balance",balance+amount);
                         e.initCause(new NegativeValueException("Balance Cannot be Negative\tBalance = "+balance));
                         throw e;
                     }
                 }catch(InvalidTransactionException e){
                     System.out.println("Caught "+e+"\nCaused by "+e.getCause());
                     balance+=amount;
                 }  
        }catch(NegativeValueException e){
            System.out.println("Caught "+e);
        } 
    }
    public String toString(){
        return "AccountNo: "+accno+"\t\tBalance = "+balance;
    }
}

class AccountDemo{
    public static void main(String[] args){
        int option=0,accno;
        double balance;
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter The Account Details");
        System.out.print("Enter AccountNo, Balance: ");
        accno=scan.nextInt();
        balance=scan.nextDouble();
        do{
            try{
                if(accno<0)
                    throw new NegativeValueException("AccountNo Cannot be Negative\tAccountNo: "+accno);
            }catch(NegativeValueException e){
                System.out.println("Caught "+e); 
                System.out.print("ReEnter AccountNo: ");
                accno=scan.nextInt(); 
            }
            try{
                if(balance<0)
                    throw new NegativeValueException("Balance Cannot be Negative\tBalance = "+balance);
            }catch(NegativeValueException e){
                System.out.println("Caught "+e);
                System.out.print("ReEnter Balance: ");
                balance=scan.nextDouble();
            }
        }while(accno<0||balance<0);
        Account a=new Account(accno,balance);
        System.out.println("\nDetails of Account\n"+a);
        do{
            System.out.println("\n\t\t1.Deposit\n\t\t2.Withdraw\n\t\t3.Exit");
            System.out.print("Enter: ");
            switch(option=scan.nextInt()){
                case 1:{System.out.print("Enter The Amount: ");
                        a.deposit(scan.nextDouble());
                        break;
                       }
                case 2:{System.out.print("Enter The Amount: ");
                        a.withdrawal(scan.nextDouble());
                        break;
                       }
                default:System.out.println("Invalid Choice");
            }
            System.out.println("\nDetails of Account\n"+a);
        }while(option==1||option==2);
    }
}
        










