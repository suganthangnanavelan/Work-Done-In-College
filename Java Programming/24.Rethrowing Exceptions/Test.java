//Test
class Test{
    static void compute(){
        try{
            int a=0;
            int b=a/a;
            System.out.println(b);
        }catch(ArithmeticException e){
            System.out.println("Compute.."+e);
            throw e;
        }
    }
    public static void main(String[] args)throws Exception{
        try{
            compute();
        }catch(ArithmeticException e){
            System.out.println("Main.."+e);
        }
    }
} 
            