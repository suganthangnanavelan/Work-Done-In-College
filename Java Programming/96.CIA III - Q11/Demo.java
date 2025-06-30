import java.util.Scanner;

class OutOfRangeMarkException extends Exception{
    OutOfRangeMarkException(String msg){
	super(msg);
    }
    public String toString(){
	return "OutOfRangeMarkException: "+this.getMessage();
    }
}

class Student{
    String S_name,S_DOB,S_aadhar;;
    int S_age;
} 

class StudentMarkDetails extends Student{
    double marks[]=new double[5];
    double total=0.0,average=0.0; 
    void getdata(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Student Name, Age, Date of Birth and Aadhar Number: ");
        S_name=scan.next();
        S_age=scan.nextInt();
        S_DOB=scan.next();
        S_aadhar=scan.next();
	System.out.println("Enter The Marks Scored in Five Subjects");
        for(int i=0;i<marks.length;i++)
            try{
                System.out.print("Enter Mark"+(i+1)+": ");
                marks[i]=scan.nextDouble();
                if(marks[i]<0||marks[i]>100)
                	throw new OutOfRangeMarkException("Invalid Mark = "+marks[i]);
            }catch(OutOfRangeMarkException e){
                    System.out.println(e);
                    i--;
            }
    }
    void displayData(){
        System.out.println("Student Details");
        System.out.println("Name: "+S_name+"\tAge = "+S_age+"\tDOB: "+S_DOB+"\tAadhar: "+S_aadhar);
        System.out.print("Marks: ");
        for(int i=0;i<marks.length;i++)
            System.out.print(marks[i]+"\t");
        System.out.println();
        System.out.println("Total = "+total);
        System.out.println("Average = "+average);
    }
    void calculate(){
	average=total=0.0;
        for(int i=0;i<marks.length;i++)
		total+=marks[i];
        average=total/marks.length;
    }	
}

class Demo{
    public static void main(String[] args){
        StudentMarkDetails []smd=new StudentMarkDetails[3];    	 
        for(int i=0;i<smd.length;i++){
            smd[i]=new StudentMarkDetails();
            smd[i].getdata();
            smd[i].calculate();
        }
        System.out.println("Details of All Students");
        for(int i=0;i<smd.length;i++){
            smd[i].displayData();
        }
    }	
}	