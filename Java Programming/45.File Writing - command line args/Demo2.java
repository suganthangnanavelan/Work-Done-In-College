//InputStream...OutputStream
//writing into a file from user input
import java.io.*;

class Demo2{
    public static void main(String[] args)throws IOException{
        //File, FileInputStream, FileOutputStream, FileReader, FileWriter
        FileWriter fout=new FileWriter(args[0]);//Commond Line Argument to get the file path
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String c;
        while(!(c=in.readLine()).equals("stop"))
            fout.write(c+"\n");
        fout.close();
        in.close();
    }
}