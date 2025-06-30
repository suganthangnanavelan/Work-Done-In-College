class Distance{
    double feet,inches;
    Distance(double feet,double inches){
        this.feet=feet;
        this.inches=inches;
    }
    Distance(){
        feet=inches=0.0;
    }
    Distance(Distance D){
        feet=D.feet;
        inches=D.inches;
    }
    double getFeet(){
        return feet;
    }
    double getInches(){
        return inches;
    }
    public String toString(){
        return "Feet = "+feet+"\tInches = "+inches;
    }
}


class DistanceDemo{
        public static void main(String args[]){ 
            Distance D[]=new Distance[3];
            D[0]=new Distance(10,7);
            D[1]=new Distance();
            D[2]=new Distance(D[0]);
            double avg=0.0;
            for(int i=0;i<D.length;i++)
                avg+=(D[i].getFeet()+(D[i].getInches()/12))*0.3048;
            avg/=D.length;
            System.out.println("Details of Objects");
            for(var x:D)
                System.out.println(x);
            System.out.println("Average: "+avg+"m"); 
         }
} 
