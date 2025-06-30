import java.io.*;

class Demo{
    public static void main(String[] args)throws IOException{
        DataInputStream din=new DataInputStream(System.in);
        DataOutputStream dout=new DataOutputStream(System.out);
        dout.writeChars("Enter An Integer: ");
        int a=din.readInt();
        din.readLine();//To Flush NewLine Character in Input Stream 
        dout.writeChars("Enter An String: ");
        String s=din.readLine();
        dout.writeChars("\nInteger: ");
        dout.writeInt(a);
        dout.writeChars("\nString: ");
        dout.writeChars(s);
        din.close();
        dout.close();
    }
}