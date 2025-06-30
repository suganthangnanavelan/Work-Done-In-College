package userdefinedexception;

public class BadOperandException extends Exception{
    int op;
    public BadOperandException(int op){
        this.op=op;
    }
    public String toString(){
        return "BadOperandException: Operand value = "+op;
    }
}