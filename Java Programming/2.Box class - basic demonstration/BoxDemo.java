//Box
class Box{
    double width,height,length;
    Box(){
        width=height=length=0.0;
    }
    Box(double width,double height,double length){
        this.width=width;
        this.height=height;
        this.length=length;
    }
    Box(Box b){
       width=b.width;
       height=b.height;
       length=b.length;
    }
    public String toString(){
         return "Width="+width+"\tHeight="+height+"\tLength="+length;
    }
}

//BoxDemo
class BoxDemo{
    public static void main(String args[]){
        Box mybox1=new Box();
        Box mybox2=new Box(12.28,13.67,89.78);
        Box mybox3=mybox2;
        Box mybox4=new Box(mybox3);
        System.out.println("Box1\t"+mybox1);
        System.out.println("Box2\t"+mybox2);
        System.out.println("Box3\t"+mybox3);
        System.out.println("Box4\t"+mybox4);
    }
}
    












       
    