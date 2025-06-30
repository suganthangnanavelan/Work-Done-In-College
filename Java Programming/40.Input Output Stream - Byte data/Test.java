import java.io.*;

class Test{
    public static void main(String[] args)throws IOException{
        InputStream in=System.in;
        OutputStream out=System.out;
        byte data[]=new byte[100];
        in.read(data);
        out.write("Entered: ".getBytes());
        out.write(data);
        in.close();
        out.close();
    }
}