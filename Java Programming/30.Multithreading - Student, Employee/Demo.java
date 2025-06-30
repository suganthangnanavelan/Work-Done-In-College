import java.util.Scanner;

class Student extends Thread{
    String name,dateofbirth;
    int rollno;   
    double m1,m2,m3,m4,m5;
    Student(){}
    Student(int rollno,String name,String dateofbirth,double m1,double m2,double m3,double m4,double m5){
        super("Student");
        this.rollno=rollno;
        this.name=name;
        this.dateofbirth=dateofbirth;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
        this.m4=m4;
        this.m5=m5;
    }
    public String toString(){
        double avg=(m1+m2+m3+m4+m5)/5;
        return "Rollno: "+rollno+"\nName: "+name+"\nDateofBirth: "+dateofbirth+"\nCGPA = "+(avg>=91?"S":avg>=86?"A+":avg>=75?"A":avg>=66?"B":avg>=55?"C":avg>=50?"D":"F");
    }
    public void run(){
        Scanner sc=new Scanner(System.in);
        Student S[]=new Student[5];
        for(int i=0;i<=S.length;i++){
            synchronized(System.out){
                if(i!=S.length){
                    System.out.print("\nEnter The Rollno, Name, Date of Birth(dd/mm/yyyy), Marks Scored in Five Subjects of Student "+(i+1)+": ");
                    S[i]=new Student(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble()); 
                }
            }
            try{
               Thread.sleep(500);
            }catch(InterruptedException e){} 
        }
        for(int i=0;i<S.length;i++){
            try{
               Thread.sleep(1500);
            }catch(InterruptedException e){} 
            synchronized(System.out){
                System.out.println("\n\nStudent "+(i+1));
                System.out.println("-----------------------");
                System.out.println(S[i]);
                System.out.println("-----------------------"); 
            }
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){}           
        }
    }
}

class Employee extends Thread implements scan{ 
    String empname;
    int empid;   
    double bp;
    Employee(){}
    Employee(int empid,String empname,double bp){
        super("Employee");
        this.empid=empid;
        this.empname=empname;
        this.bp=bp;
    }
    public String toString(){
        double hra=bp*(10/100.0);
        double da=bp*(50/100.0);
        double pf=bp*(1/100.0);
        double gp,np;
        gp=bp+hra+da;
        np=gp-pf;
        return "EmpId: "+empid+"\nName: "+empname+"\nBasic Pay = "+bp+"\nHRA = "+hra+"\nDA = "+da+"\nPF = "+pf+"\nGross Pay ="+gp+"\nNet Pay = "+np;
    }
    public void run(){  
        Scanner sc=new Scanner(System.in);
        Employee E[]=new Employee[5];
        for(int i=0;i<=E.length;i++){
            synchronized(System.out){
                if(i!=E.length){
                    System.out.print("\nEnter The Id, Name, Basic Pay of Employee "+(i+1)+": ");
                    E[i]=new Employee(sc.nextInt(),sc.next(),sc.nextDouble());
                }
            }
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){}
        }
        for(int i=0;i<E.length;i++){
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){} 
            synchronized(System.out){
                System.out.println("\n\nEmployee "+(i+1));
                System.out.println("-----------------------");
                System.out.println(E[i]);
                System.out.println("-----------------------");
            }
            try{
                Thread.sleep(1500);
            }catch(InterruptedException e){} 
       }
    }
}

class Demo{
    public static void main(String[] args){
        Student S=new Student();
        Employee E=new Employee();
        S.start();
        E.start();
    }
}