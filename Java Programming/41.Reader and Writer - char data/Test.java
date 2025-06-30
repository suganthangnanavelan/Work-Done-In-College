//InputStream...OutputStream
//char based read and write operations
import java.io.*;

class Test{
    public static void main(String[] args)throws IOException{
        Reader in=new InputStreamReader(System.in);//to read char instead of byte
        char data[]=new char[100];
        in.read(data);
        Writer out=new OutputStreamWriter(System.out);//to write char instead of byte
        out.write("Entered: ");
        out.write(data);
        out.close(); 
    }
}