//comparator is used to compare the elements - compatible to TreeSet & TreeMap
//override compare by implementing Comparator<Student> to create our own //comparison
//only based on one comparison if equal then it is there will be no other comparision and only one them is present in the TreeSet
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

class Test2{
    public static void main(String[] args){
        TreeSet<Student> al=new TreeSet<Student>(new MyComp().reversed());//ordered based on rollno in decending order
        al.add(new Student(3020,"Alice Paul"));
        al.add(new Student(3020,"Darth Paul"));//duplicate entry because rollno's are equal
        al.add(new Student(3002,"Bob Mark"));
        System.out.println(al);//no duplicate entries present
    }
}