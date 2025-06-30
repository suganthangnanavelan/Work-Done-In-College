import java.util.*;

class Vehicle{    
    String make,model;
    int year;
    int price;
    Vehicle(){}
    Vehicle(String make,String model,int year,int price){
        this.make=make;
        this.model=model;
        this.year=year;
        this.price=price;
    }
    void get(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Make, Model, Year, Price Of The Vehicle: ");
        make=scan.next();
        model=scan.next();
        year=scan.nextInt();
        price=scan.nextInt();
    }
    void put(){
        System.out.println("[Make = "+make+", Model = "+model+", Year = "+year+", Price = "+price+"]");
    }
    public String toString(){
        return "[Make = "+make+", Model = "+model+", Year = "+year+", Price = "+price+"]";    
    }
}

class PriceComparator implements Comparator<Vehicle>{
     public int compare(Vehicle v1,Vehicle v2){
         if(v1.price==v2.price)
             return 0;
         else
             return (int)(v1.price-v2.price);
     }
}    

class Demo{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        ArrayList<Vehicle> al=new ArrayList<Vehicle>();
        PriceComparator pc=new PriceComparator();
        int n;Vehicle temp;
        System.out.print("Enter The Number of Vehicles: ");
        n=scan.nextInt();
        for(int i=0;i<n;i++){
            temp=new Vehicle();
            temp.get();
            al.add(temp); 
        }
/*
        al.add(new Vehicle("Tata","Nexon",2023,800000));
        al.add(new Vehicle("Maruti Suzuki","Swift",2023,600000));
        al.add(new Vehicle("Hyundai","Creta",2020,970000));
        al.add(new Vehicle("Hyundai","Verna",2022,1540000));
        al.add(new Vehicle("Mercedes Benz","S-Class",2023,15000000));
        al.add(new Vehicle("Audi","Q5",2023,6200000));
*/
        System.out.println("Before Sorting");
        for(Vehicle v:al)v.put();
        int i,j;
        boolean sorted;
        for(i=0,sorted=false;i<al.size()&&sorted==false;i++)
            for(j=0,sorted=true;j<al.size()-i-1;j++)
                if(pc.compare(al.get(j),al.get(j+1))>0){
                    sorted=false;
                    temp=al.set(j,al.get(j+1));
                    al.set(j+1,temp);
                }
        System.out.println("After Sorting");
        for(Vehicle v:al)v.put();
    }
}

