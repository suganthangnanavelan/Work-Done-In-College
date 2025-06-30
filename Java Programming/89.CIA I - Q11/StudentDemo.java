import java.util.Scanner;
class Student{
        static int count;
        static double avg;
	int rollno;
        String name;
        double mark1,mark2,mark3,mark4,mark5; 
        static{
        	count=0;
                avg=0.0;
        }
        Student(int rollno,String name,double mark1,double mark2,double mark3,double mark4,double mark5){
        	count++;
                this.rollno=rollno;
        	this.name=name;
        	this.mark1=mark1;
        	this.mark2=mark2;
        	this.mark3=mark3;
        	this.mark4=mark4;
        	this.mark5=mark5;
                avg=((avg*(count-1))+calAvg())/count;
        }
        double calAvg(){
        	return (mark1+mark2+mark3+mark4+mark5)/5.0;
        }
        static double getAvg(){
        	return avg;
        }
        public String toString(){
        	return "Name: "+name+"\tRollno: "+rollno+"\nMarks: "+mark1+"\t"+mark2+"\t"+mark3+"\t"+mark4+"\t"+mark5+"\n"+"Average: "+calAvg();
        }
}

class StudentDemo{
	public static void main(String args[]){ 
                Scanner scan=new Scanner(System.in);
		System.out.print("Enter The No of Students: ");
                int n=scan.nextInt();
                Student S[]=new Student[n];
                for(int i=0;i<n;i++){
                	System.out.print("Enter Rollno, Name, Marks in Five Subjects of Student"+(i+1)+": ");
                        S[i]=new Student(scan.nextInt(),scan.next(),scan.nextDouble(),scan.nextDouble(),scan.nextDouble(),scan.nextDouble(),scan.nextDouble());
                }
                for(int i=0;i<n;i++)
                	  System.out.println("Details of Student"+(i+1)+"\n"+S[i]);
                System.out.println("The Average of The Class = "+Student.getAvg());                        
        }
} 