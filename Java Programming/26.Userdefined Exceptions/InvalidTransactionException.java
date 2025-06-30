package userdefinedexception;

public class InvalidTransactionException extends Exception{
     double balance;    
     public InvalidTransactionException(String msg,double b){
        super(msg); 
        balance=b;
     }
     public String toString(){
         return "InvalidTransactionException: "+this.getMessage()+"\tBalance = "+balance;
     }
}