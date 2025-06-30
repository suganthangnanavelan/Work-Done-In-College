import java.util.Scanner;
import userdefinedexception.BadOperatorException;
import userdefinedexception.BadOperandException;
import userdefinedexception.OperationFailedException;


class Demo{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);   
        int op1,op2;
        char opr; 
        double result;
        for(int i=0;i<8;i++){
            System.out.print("Enter Operand1, Operator, Operand2: ");
            op1=scan.nextInt();
            opr=scan.next().charAt(0);
            op2=scan.nextInt();
            try{
                try{
                    switch(opr){
                        case '+':result=op1+op2;break;
                        case '-':result=op1-op2;break;
                        case '*':result=op1*op2;break;
                        case '/':if(op2!=0)
                                     result=op1/op2;
                                 else
                                     throw new BadOperandException(op2);
                                 break;
                        case '%':if(op2!=0)
                                     result=op1%op2;
                                 else
                                     throw new BadOperandException(op2);
                                 break;
                        case '&':result=op1&op2;break;
                        case '|':result=op1|op2;break;
                        case '^':result=op1^op2;break;
                        default:throw new BadOperatorException(opr);
                    }
                    System.out.println("Result of "+op1+" "+opr+" "+op2+" = "+result);
                }catch(BadOperandException e){
                    throw new OperationFailedException("Divison/Modulus by zero is not possible",e);
                }catch(BadOperatorException e){
                    throw new OperationFailedException("Bad operator for operands of type int",e);
                }
            }catch(OperationFailedException e){
                System.out.println("Caught: "+e+"\nCaused by: "+e.getCause());
            }
            System.out.println();
        }
    }   
}