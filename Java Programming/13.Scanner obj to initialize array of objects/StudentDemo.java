import java.util.Scanner;
//Student
class Student{
    int rno;
    String name;
    Student(int rno,String name){
        this.rno=rno;
        this.name=name;
    }
    public String toString(){
        return rno+","+name;
    }
}

//StudentDemo
class StudentDemo{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        Student s[]=new Student[10];
        for(int i=0;i<2;i++)
            s[i]=new Student(scan.nextInt(),scan.next());
        for(Student x:s)
            if(x!=null)
                System.out.println(x);
    }
} 