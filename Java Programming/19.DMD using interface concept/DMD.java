import java.util.Scanner;
//Shape
interface Shape{
    void area();
}
//Rectangle
class Rectangle implements Shape{
    double l,b;
    Rectangle(double l,double b){
        this.l=l;
        this.b=b;
    }
    public void area(){
        System.out.println("Area of Rectangle: "+(l*b));
    }
}
//Triangle
class Triangle implements Shape{
    double h,b;
    Triangle(double h,double b){
        this.h=h;
        this.b=b;
    }
    public void area(){
        System.out.println("Area of Triangle: "+((b*h)/2));
    }
}
//DMD
class DMD{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        Shape s;
        int a=scan.nextInt();
        switch(a){
            case 1:{s=new Rectangle(10.0,20.0);
                    s.area();
                    break;
                   }
            case 2:{s=new Triangle(10.0,20.0);
                    s.area();
                    break;
                   }
            default:System.out.println("Invalid Choice");
        }
    }
}