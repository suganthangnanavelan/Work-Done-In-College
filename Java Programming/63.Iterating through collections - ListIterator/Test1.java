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

class Test1{
    public static void main(String[] args){
        ArrayList<Student> al=new ArrayList<Student>();
        al.add(new Student(3000,"Alice Paul"));
        al.add(new Student(3001,"Darth Paul"));
        al.add(new Student(3002,"Bob Mark"));   
        System.out.println("Before: "+al);         
        ListIterator<Student> listitr=al.listIterator();//returns an iterator object
        //Pointer is pointing to first element
        System.out.println("Forward Traversal");
        while(listitr.hasNext()){
            Student s=listitr.next();//u can change it
            s.rno+=200;//updation in the iterable
            System.out.println(s);
        }
        //Pointer has moved to last element
        System.out.println("Backward Traversal");
        while(listitr.hasPrevious()){
            Student s=listitr.previous();//u can change it
            s.name=s.name.toUpperCase();//updation in the iterable
            System.out.println(s);
        }
        System.out.println("After: "+al);
    }
}