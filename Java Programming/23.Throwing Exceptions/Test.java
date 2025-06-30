import java.util.Scanner;
//Test
class Test{
    static void func1(int op)throws InterruptedException{
        int a=1,b=0,x[]=new int[4];
        switch(op){
            case 1: a/=b;
            case 2: System.out.println(x[4]);
            default: throw new InterruptedException();
        }
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        try{
            System.out.print("Enter: "); 
            func1(scan.nextInt());
        }catch(Exception e){
            System.out.println("Caught "+e);
        }
        System.out.println("Gets Executed...");
    }
}