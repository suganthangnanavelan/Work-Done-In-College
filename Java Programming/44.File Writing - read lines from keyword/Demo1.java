//InputStream...OutputStream
//writing into a file from user input
import java.io.*;

class Demo1{
    public static void main(String[] args)throws IOException{
        //File, FileInputStream, FileOutputStream, FileReader, FileWriter
        File f=new File("sample.txt");
        FileWriter fout=new FileWriter(f);
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String c;
        while(!(c=in.readLine()).equals("stop"))
            fout.write(c+"\n");
        fout.close();
        in.close();
    }
}