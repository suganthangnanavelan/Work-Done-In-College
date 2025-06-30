import java.util.Scanner;
//Shape
abstract class Shape{
    double dimension1,dimension2;
    Shape(double dimension1,double dimension2){
        this.dimension1=dimension1;
        this.dimension2=dimension2;
    }
    abstract double area();
}

//Triangle
class Triangle extends Shape{
    Triangle(double base,double height){
        super(base,height); 
    }
    double area(){
        System.out.println("Area of Triangle: ");
        return (dimension1*dimension2)/2;
    }
}

//Rectangle
class Rectangle extends Shape{
    Rectangle(double length,double breadth){
        super(length,breadth);
    }
    double area(){
        System.out.println("Area of Rectangle: ");
        return (dimension1*dimension2);
    }
}

//Demo
class Demo{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        Shape s;
        int choice=scan.nextInt();
        switch(choice){
            case 1:{s=new Rectangle(10.0,20.0);
                    System.out.println(s.area());
                    break;}
            case 2:{s=new Triangle(10.0,20.0);
                    System.out.println(s.area());
                    break;}
            default:System.out.println("Invalid Choice");
        }
     }
}
        
     
   


