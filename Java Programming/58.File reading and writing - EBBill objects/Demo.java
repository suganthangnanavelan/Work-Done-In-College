import java.io.*;
import java.util.Scanner;

class MyObjectOutputStream extends ObjectOutputStream{
    MyObjectOutputStream()throws IOException{
        super();
    }
    MyObjectOutputStream(OutputStream out)throws IOException{
        super(out);
    }
    public void writeStreamHeader()throws IOException{}//overriding
}
class EBBill implements Serializable{
    int houseno,startingEMR,endingEMR;
    String name;
    double bill;
    EBBill(int houseno,String name,int startingEMR,int endingEMR){
        this.houseno=houseno;
        this.name=name;
        this.startingEMR=startingEMR;
        this.endingEMR=endingEMR;
    }
    void saveData()throws IOException{
        File f=new File("EBbill Data.dat");
        FileOutputStream fout; 
        try{fout = new FileOutputStream(f,true);}
        catch(Exception e){fout = new FileOutputStream(f);}
        if(f.length()==0){
             ObjectOutputStream out=new ObjectOutputStream(fout);
             out.writeObject(this);
             out.close();
        }
        else{
             MyObjectOutputStream out=new MyObjectOutputStream(fout); 
             out.writeObject(this);
	     out.close();
        }
        fout.close();
    }
    void calculateBill(){
        bill=(endingEMR - startingEMR)*10;
    }
    public String toString(){
        return "House No: "+houseno+" Name: "+ name+" Bill Amount: "+bill;
    }
}

class Demo{
    static void read()throws IOException{
        File f=new File("EBbill Data.dat");
        FileInputStream fin=new FileInputStream(f);
        ObjectInputStream in=new ObjectInputStream(fin);
        try{
            EBBill e;
            while(true){
                e=(EBBill)in.readObject();
                System.out.println(e); 
            }
        }catch(EOFException e){
            System.out.println("EndOfFile");
        }catch(ClassNotFoundException e){}
        fin.close();
        in.close();
    }
    public static void main(String[] args)throws IOException{
        EBBill E[]=new EBBill[4]; 
        Scanner scan=new Scanner(System.in);
        for(int i=0;i<E.length;i++){
            System.out.println("Enter The HouseNo, Name, Starting and Ending Energy Meter Reading of House "+(i+1));
            E[i]=new EBBill(scan.nextInt(),scan.next(),scan.nextInt(),scan.nextInt());
            E[i].calculateBill();
            E[i].saveData();
        }
        read();
    }
}
   