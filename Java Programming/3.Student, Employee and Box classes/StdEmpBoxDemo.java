//Box
class Box{
    double width,height,length;
    Box(){
        width=height=length=0.0;
    }
    Box(double width,double height,double length){
        this.width=width;
        this.height=height;
        this.length=length;
    }
    Box(Box b){
       width=b.width;
       height=b.height;
       length=b.length;
    }
    public String toString(){
         return "Width="+width+"\tHeight="+height+"\tLength="+length;
    }
}

//Student
class Student{
    int rollno;
    double m1,m2,m3;
    Student(){
        rollno=0;
        m1=m2=m3=0.0;
    }
    Student(int a,double b,double c,double d){
        rollno=a;
        m1=b;  
        m2=c;
        m3=d;
    }
    Student(Student S){
       rollno=S.rollno;
       m1=S.m1;
       m2=S.m2;
       m3=S.m3;
    }
    void get(int roll,double a,double b,double c){
        rollno=roll;
        m1=a;
        m2=b;
        m3=c;
    }
    void put(){
        System.out.println("Rollno: "+rollno+"\nMark1: "+m1+"\tMark2: "+m2+"\tMark3: "+m3);
    }
}

//Employee
class Employee{
    int empno;
    double salary;
    Employee(){
        empno=0;
        salary=0.0;
    }
    Employee(int a,double b){
        empno=a;
        salary=b;
    }
    Employee(Employee E){
       empno=E.empno;
       salary=E.salary;
    }
    void get(int roll,double sal){
        empno=roll;
        salary=sal;
    }
    void put(){
        System.out.println("Empno: "+empno+"\tSalary: "+salary);
    }
}

class StdEmpBoxDemo{
    public static void main(String args[]){
        System.out.println("Box Class");
        Box mybox1=new Box();
        Box mybox2=new Box(12.28,13.67,89.78);
        Box mybox3=mybox2;
        Box mybox4=new Box(mybox1);
        System.out.println("Box1\t"+mybox1);
        System.out.println("Box2\t"+mybox2);
        System.out.println("Box3\t"+mybox3);
        System.out.println("Box4\t"+mybox4);

        System.out.println("\nStudent Class");
        Student S1=new Student();
        S1.get(1929018201,60,79,94);
        Student S2=new Student(128901892,89.5,67,59.5);
        Student S3=S2;
        Student S4=new Student(S1);
        System.out.print("Student1\t"); S1.put();
        System.out.print("Student2\t"); S2.put();
        System.out.print("Student3\t"); S3.put();
        System.out.print("Student4\t"); S4.put();

        System.out.println("\nEmployee Class");
        Employee E1=new Employee();
        E1.get(1001,35000.00);
        Employee E2=new Employee(1002,29999.99);
        Employee E3=E2;
        Employee E4=new Employee(E1);
        System.out.print("Employee1\t"); E1.put();
        System.out.print("Employee2\t"); E2.put();
        System.out.print("Employee3\t"); E3.put();
        System.out.print("Employee4\t"); E4.put();
    }
}






