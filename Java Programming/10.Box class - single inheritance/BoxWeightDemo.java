//Box
class Box{
    private double width,height,length;
    Box(double width,double height,double length){
        this.width=width;
        this.height=height;
        this.length=length;
    }
    public String  toString(){
        return "Box:"+width+","+height+","+length;
    }
}

//BoxWeight
class BoxWeight extends Box{
    double weight;
    BoxWeight(double width,double height,double length,double weight){
        super(width,height,length);//need to be the first statement 
        System.out.println("BoxWeight Constructor");       
        this.weight=weight;
    }
    public String toString(){
        return super.toString()+","+weight;
    }
}

//BoxWeightDemo
class BoxWeightDemo{
    public static void main(String args[]){
        BoxWeight bw=new BoxWeight(10.0,20.0,30.0,40.0);
        System.out.println(bw);
    }
}