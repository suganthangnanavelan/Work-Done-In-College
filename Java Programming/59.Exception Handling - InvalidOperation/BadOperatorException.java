package userdefinedexception;

public class BadOperatorException extends Exception{
    char opr;
    public BadOperatorException(char opr){
        this.opr=opr;
    }
    public String toString(){
        return "BadOperatorException: Operator '"+opr+"'";
    }
}

