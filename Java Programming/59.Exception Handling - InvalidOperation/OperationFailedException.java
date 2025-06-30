package userdefinedexception;

public class OperationFailedException extends Exception{
    public OperationFailedException(String msg){
        super(msg);
    }
    public OperationFailedException(String msg,Throwable th){
        super(msg,th); 
    }
    public String toString(){
        return "OperationFailedException: "+this.getMessage();
    }
}