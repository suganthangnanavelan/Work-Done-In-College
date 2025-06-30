package userdefinedexception;

public class DuplicateContactException extends Exception{
    public DuplicateContactException(String msg){
        super(msg); 
    }
    public String toString(){
        return "DuplicateContactException: "+this.getMessage();
    }
}