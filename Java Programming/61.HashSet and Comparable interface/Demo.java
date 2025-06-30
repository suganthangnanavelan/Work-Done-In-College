import java.util.*;

class Point implements Comparable<Point>{
    double x,y;
    Point(){
        x=y=0.0;
    }
    Point(double x,double y){
        this.x=x;
        this.y=y;
    }
    Point(Point p){
        x=p.x;
        y=p.y;
    }
    public int compareTo(Point p){
       if(this.calculate()==p.calculate())
           return 0;
       else if(this.calculate()>p.calculate())
           return 1;
       else
           return -1;
    }
    double calculate(){
        return Math.sqrt(x*x+y*y);
    }
    double calculate(Point p){
        return Math.sqrt(Math.pow(x-p.x,2)+Math.pow(y-p.y,2));
    }
    public  String toString(){
        return "("+x+","+y+")";
    }
}
    
class Demo{
    public static void main(String[] args){
        //HashSet is unsorted data structure
        HashSet<Point> hs=new HashSet<Point>();
        hs.add(new Point(3,4));
        hs.add(new Point(6,8));
        hs.add(new Point(0,0));
        System.out.println("Ascending order of points based on their distance from origin");
        for(var x:new TreeSet<Point>(hs))
            System.out.println(x);
        System.out.println("\nDistance between all possible pair of points");
        for(var x:hs)
            for(var y:hs)
                if(x!=y){
                    System.out.print(x+" - "+y+" = ");
                    System.out.printf("%.3f\n",x.calculate(y));
                } 
    }
}