//only based on one comparison if equal then it is there will be another comparision
//here first based on rollno and ifqual then based on name
import java.util.*;


class Student{
    int rno;
    String name;
    Student(int rno,String name){
        this.rno=rno;
        this.name=name;
    }
    public String toString(){ 
        return rno+"-"+name;
    }
}

class MyComp implements Comparator<Student>{
    public int compare(Student s1,Student s2){
        return s1.rno-s2.rno;
    }
}

class MyComp1 implements Comparator<Student>{
    public int compare(Student s1,Student s2){
        return s1.name.compareTo(s2.name);
    }
}

class Test3{
    public static void main(String[] args){
        TreeSet<Student> al=new TreeSet<Student>(new MyComp().thenComparing(new MyComp1().reversed()));//ordered based on rollno in acending order if they are equal then ordered based on name in descending order
        al.add(new Student(3020,"Alice Paul"));
        al.add(new Student(3020,"Darth Paul"));
        al.add(new Student(3002,"Bob Mark"));
        System.out.println(al);
    }
}