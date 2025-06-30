//Test
class Test{
    public static void main(String args[]){
        try{
            try{
                int a=0;
                int b=1/a;
                System.out.println(b);
            }catch(ArithmeticException e){
                System.out.println("InnerCatchBlock.."+e);
            }
            int x[]=new int[4];
            System.out.println(x[4]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("OuterCatchBlock.."+e);
        }
        
    }
}