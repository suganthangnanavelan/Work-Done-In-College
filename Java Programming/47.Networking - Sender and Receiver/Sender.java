import java.io.*;
import java.net.*;
class Sender{
    public static void main(String[] args)throws Exception{
        ServerSocket ss=new ServerSocket(1234);
        Socket s=ss.accept();
        System.out.println("Connection Created");
        String data="Hello World";
        OutputStream out=s.getOutputStream();
        out.write(data.getBytes());
        System.out.println("Sent: "+data);
        out.close();
        s.close();
    }
}