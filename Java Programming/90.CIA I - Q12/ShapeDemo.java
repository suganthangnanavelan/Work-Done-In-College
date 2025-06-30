import java.lang.Math;
import java.util.Scanner;
abstract class Shape3D{
	abstract double volume();
}

class Sphere extends Shape3D{
        double radius;
        Sphere(double radius){
        	this.radius=radius;
        }
        public double volume(){
		return 4*Math.PI*radius*radius*radius/3.0;
        }
}

class Cylinder extends Shape3D{
        double radius,height;
        Cylinder(double radius,double height){
        	this.radius=radius;
		this.height=height;
        }
        public double volume(){
		return Math.PI*radius*radius*height;
        }
}		

class Cone extends Shape3D{
        double radius,height;
        Cone(double radius,double height){
        	this.radius=radius;
		this.height=height;
        }
        public double volume(){
		return Math.PI*radius*radius*height/3.0;
        }
}	

class ShapeDemo{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in); 
                int choice;
                Shape3D S;
                do{
                    System.out.print("\n\t\t1.Sphere\n\t\t2.Cone\n\t\t3.Cylinder\nEnter The Choice: ");
                    choice=scan.nextInt();
                    switch(choice){
		        case 1:{System.out.print("Enter The Radius of Sphere: ");
                                S=new Sphere(scan.nextDouble());
                                System.out.println("Volume = "+S.volume());
                                break;
                               }
                        case 2:{System.out.print("Enter The Radius,Height of Sphere: ");
                                S=new Cone(scan.nextDouble(),scan.nextDouble());
                                System.out.println("Volume = "+S.volume());
                                break;
                               }
			case 3:{System.out.print("Enter The Radius,Height of Sphere: ");
                                S=new Cylinder(scan.nextDouble(),scan.nextDouble());
				System.out.println("Volume = "+S.volume());
                                break;
                               }
                        default:System.out.println("Invalid Choice");
                    }
                }while(choice==1||choice==2||choice==3);
        }
}    
