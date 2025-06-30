//InputStream...OutputStream
//writing into a file from user input
import java.io.*;

class Demo{
    public static void main(String[] args)throws IOException{
        //File, FileInputStream, FileOutputStream, FileReader, FileWriter
        File f=new File("sample.txt");
        FileWriter fout=new FileWriter(f);
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        char c;
        do{
            c=(char)in.read();
            fout.write(c);
        }while(c!='.');
        fout.close();
        in.close();
    }
}