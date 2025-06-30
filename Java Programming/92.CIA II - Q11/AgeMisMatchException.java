package userdefinedexception;
public class AgeMisMatchException extends Exception{
    public AgeMisMatchException(String msg){
        super(msg);
    }
    public String toString(){
        return "AgeMisMatchException: "+this.getMessage();
    }
}