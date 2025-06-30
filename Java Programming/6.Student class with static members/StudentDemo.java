import java.util.Scanner;
//Student
class Student{
    static int count;
    int rno;
    String name;
    static{
        System.out.println("Static Block");
        count=0;
    }
    Student(){
        rno=0;
    }
    Student(int rno,String name){
        count++;
        this.rno=rno;
        this.name=name;
    }
    static int getcount(){
        return count;
    }
    public String toString(){
        return "Rollno: "+rno+"\tName: "+name;
    }
}

//StudentDemo
class StudentDemo{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        Student a=new Student();//Static block also gets called
        Student s[]=new Student[10]; 
        int r;
        String n;
        for(int i=0;i<3;i++){
            r=scan.nextInt();
            scan.nextLine();
            n=scan.nextLine();
            s[i]=new Student(r,n);
        }
        //for each loop
        for(Student x:s)
            if(x!=null)
                System.out.println(x);
        System.out.println("Created "+Student.getcount()+" Students");
   }
}







