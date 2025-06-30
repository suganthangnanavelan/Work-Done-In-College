/*
Data Structures - ArrayList, TreeSet, HashMap, TreeMap
map - key value pair based representation 
Traverse Classes
Iterator, ListIterator, Spliterator, Comparator
Iterator - used to traverse any data structure - interface 
         - only Forward traversal
         - sequential processing
ListIterator - Extends Interator 
             - both forward and backward traversal possible
Spliterator - Split the iterable to speed up the process
            - parallel processing
Iterator can be used to traverse/ add into the arraylist but cannot remove or clear is not possible

Iterator - hasNext() - boolean
         - next() - returns the next element in the iterable
ListIterator - hasPrevious(), previous()
*/

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

class Test{
    public static void main(String[] args){
        ArrayList<Student> al=new ArrayList<Student>();
        al.add(new Student(3000,"Alice Paul"));
        al.add(new Student(3001,"Darth Paul"));
        al.add(new Student(3002,"Bob Mark"));
        System.out.println("Before: "+al);
        Iterator<Student> itr=al.iterator();//returns an iterator object
        while(itr.hasNext()){
            Student s=itr.next();//u can change it
            s.rno+=200;//updation in the iterable
            System.out.println(s);
        }
        System.out.println("After: "+al);
    }
}