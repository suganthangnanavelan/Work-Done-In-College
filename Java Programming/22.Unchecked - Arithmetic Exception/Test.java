//Test
class Test{
    public static void main(String[] args){
        int a=1,b=0;
        try{
            a/=b;//Exception
            System.out.println(a);
        }catch(ArithmeticException e){
            System.out.println("Caught "+e);
        }
        System.out.println("Gets Executed...");
    }
}