package userdefinedexception;

public class NegativeValueException extends Exception{
     public NegativeValueException(String msg){
        super(msg); 
     }
     public String toString(){
         return "NegativeValueException: "+this.getMessage();
     }
}