import java.io.*;
class Student implements Serializable{
    int rno;
    String name;
    Student(int rno,String name){
        this.rno=rno;
        this.name=name;
    }
    public String toString(){
        return ""+rno+"\t"+name;
    }
}

class Test2{
    public static void main(String[] args)throws Exception{
        FileInputStream fout=new FileInputStream("sample1.dat");
        ObjectInputStream out=new ObjectInputStream(fout);
        //convertion of instance of Object class to Student(Derived) class
        try{
        while(true){
        Student s=(Student)out.readObject();
        System.out.println(s);
        }}catch(EOFException e){
        System.out.println("End of File");}
        out.close();
        fout.close();
    }
}