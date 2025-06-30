//Test
class Test{
    public static void main(String[] args){
    	String str1=new String();
        String str2=new String("SASTRA");
        String str3="SASTRA";//implicit call of copy constructor
        if(str3.equals("SASTRA"))
        	System.out.println(str3);
        for(int i=0;i<str3.length();i++){
            char x=str3.charAt(i);
            int y=str3.indexOf(x);
            System.out.println(x+","+y);
        }
    }
}
        
        