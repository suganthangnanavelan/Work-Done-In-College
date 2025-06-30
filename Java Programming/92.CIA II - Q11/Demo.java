import userdefinedexception.AgeMisMatchException;
import java.util.Scanner;
class Employee{
    String Emp_Id,Emp_Age,Emp_Name,Emp_Designation;
    Employee(String Emp_Id,String Emp_Name,String Emp_Designation,String Emp_Age){
        this.Emp_Id=Emp_Id;
        this.Emp_Name=Emp_Name;
        this.Emp_Designation=Emp_Designation;
        this.Emp_Age=Emp_Age;
    }
    public String toString(){
        return "[Id: "+Emp_Id+", Name: "+Emp_Name+", Designation: "+Emp_Designation+", Age: "+Emp_Age+"]";
    }
}

class Demo{
    public static void main(String args[]){
        Employee E=new Employee(args[0],args[1],args[2],args[3]);
        try{
            if(E.Emp_Age.compareTo("18")<0)
                throw new AgeMisMatchException("Age cannot be less than 18; Age = "+E.Emp_Age);
        }catch(AgeMisMatchException e){
            System.out.println(e);
            System.out.print("ReEnter Age: ");
            E.Emp_Age=new Scanner(System.in).next();
        }
        System.out.println("Employee Details: "+E);
    }
}
        
    