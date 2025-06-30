import java.lang.Math;
class Point{
    double x,y;
    Point(){
        x=y=0.0;
    }
    Point(double a,double b){
         x=a;
         y=b;
    }
    Point(Point P){
        x=P.x;
        y=P.y;
    }
    double calculateDistance(double x,double y){
        return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
    }
    double calculateDistance(Point P){
        return Math.sqrt((x-P.x)*(x-P.x)+(y-P.y)*(y-P.y));
    }
    public String toString(){
         return"(" + x + "," + y + ")";
    }
}

class PointDemo{
    public static void main(String args[]){
        Point P1=new Point(10,0);
        Point P2=new Point(4,8);
        Point P4=new Point(P2);
        System.out.println("Distance Between "+P1+" & "+"(0,0)"+" = "+P1.calculateDistance(0,0));
        System.out.println("Distance Between "+P1+" & "+P2+" = "+P1.calculateDistance(P2));
        System.out.println("Distance Between "+P4+" & "+P2+" = "+P2.calculateDistance(P4));
    }
}







