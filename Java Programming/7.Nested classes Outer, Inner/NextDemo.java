//Outer
class Outer{
    int a;
    Inner in;
    class Inner{
        int b;
        Inner(int b){
            this.b=b;
        } 
        public String toString(){
            return "Inner Class: b="+b;
        }
    }
    Outer(int a){
        this.a=a;
        this.in=new Inner(5);
    }
    public String toString(){
        return "Outer Class: a="+a+"\n"+in;
    }
}

//NextDemo
class NextDemo{
    public static void main(String args[]){
        Outer o=new Outer(10);
        System.out.println(o);
    }
}