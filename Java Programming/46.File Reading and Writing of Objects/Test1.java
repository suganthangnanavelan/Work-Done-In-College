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

class Test1{
    public static void main(String[] args)throws IOException{
        FileOutputStream fout=new FileOutputStream("sample1.dat");
        Student s=new Student(3001,"xxx");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        out.writeObject(s);
        s=new Student(3002,"yyy");
        out.writeObject(s);
        out.close();
        fout.close();
    }
}