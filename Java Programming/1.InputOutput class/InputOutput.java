import java.util.Scanner;
class InputOutput{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter an Integer, Float, Double, String: ");//to write to monitor
        int a=scan.nextInt();//to read an integer
        float b=scan.nextFloat();//to read an floating value
        double c=scan.nextDouble();//to read an double
        String d=scan.next();//to read an String without spaces
        System.out.println("Integer: "+a+"\nFloat: "+b+"\nDouble: "+c+"\nString: "+d);
    }
}