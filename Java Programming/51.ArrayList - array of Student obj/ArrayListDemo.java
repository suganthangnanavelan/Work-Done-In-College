import java.util.*;


class Student{
    int rno;
    String name;
    int m1,m2,m3;
    Student(int rno,String name,int m1,int m2,int m3){
        this.rno=rno;
        this.name=name;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
    }
    public String toString(){
        return "RollNo: "+rno+"  Name: "+name;
    }
}


class ArrayListDemo{
    public static void main(String[] args){
        ArrayList<Student> al=new ArrayList<Student>();//Creating object of template class
        al.add(new Student(3001,"xxx",99,98,78));
        al.add(new Student(3002,"yyy",79,76,90));
        al.add(new Student(3003,"zzz",91,100,86));
        System.out.println("Length..."+al.size());
        System.out.println("Elements\n"+al);
        System.out.println("Student Details");
        for(var s:al)
            System.out.println(s+"\t"+((s.m1+s.m2+s.m3)/3.0));;
    }
}
