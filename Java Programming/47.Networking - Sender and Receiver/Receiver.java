import java.io.*;
import java.net.*;
class Receiver{
    public static void main(String[] args)throws Exception{
        Socket s=new Socket("localhost",1234);
        System.out.println("Connection Created");
        InputStream in=s.getInputStream();
        byte data[]=new byte[100];
        in.read(data);
        System.out.println("Received: "+new String(data));
        in.close();
        s.close();
    }
}