//Person
class Person{
    String name,dateofbirth;
    Person(String name,String dateofbirth){
        this.name=name;
        this.dateofbirth=dateofbirth;
    }
    void display(){
        System.out.println("Name: "+name+"\tDate of Birth: "+dateofbirth);
    }
}

//Student
class Student extends Person{
    int rollno;
    String department;
    Marks mrk;
    class Marks{
        double mark1,mark2,mark3;
        Marks(double mark1,double mark2,double mark3){
            this.mark1=mark1;          
            this.mark2=mark2;
            this.mark3=mark3;
        }
        double calculate(){
            return (mark1+mark2+mark3)/3;
        }
        void display(){
            System.out.println("Mark1: "+mark1+"\tMark2: "+mark2+"\tMark3: "+mark3);
            System.out.println("Result: "+calculate());
        }
    }  
    Student(String name,String dateofbirth,int rollno,String department,double m1,double m2,double m3){
        super(name,dateofbirth);
        mrk=new Marks(m1,m2,m3);
        this.rollno=rollno;
        this.department=department;
    }
    void display(){
        super.display();
        System.out.println("Rollno: "+rollno+"\tDepartment: "+department);
        mrk.display();
    }
}

class Inheritance{
    public static void main(String args[]){
        Student S1=new Student("Naveen","19-07-2004",129091091,"Bio Tech",78.0,64.5,80.0);
        System.out.println("Student Details");
        S1.display();
    }
}

        
    
       