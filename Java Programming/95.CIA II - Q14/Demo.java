import java.util.ArrayList;
class Demo{
    public static void main(String[] args){
        ArrayList<Double> Al=new ArrayList<Double>();
        Al.add(9.81);
        Al.add(7.89); 
        Al.add(6.85); 
        Al.add(8.34); 
        Al.add(9.31);
        System.out.println("ArrayList(before) = "+Al+"  Size = "+Al.size());
        Al.remove(8.34);
        Al.add(2,8.17);
        System.out.println("ArrayList(after) = "+Al);
    }
}
        