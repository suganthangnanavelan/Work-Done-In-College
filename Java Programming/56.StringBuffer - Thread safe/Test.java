class ThreadA extends Thread{
    StringBuffer buffstr;
    ThreadA(StringBuffer buffstr){
        this.buffstr=buffstr;
    }
    public void run(){
        String s[]={" Object "," Oriented "," Programming "};
        int i=0;
        while(i<s.length){
            s[i]=s[i].toLowerCase();
            buffstr.append(s[i]);
            i++;
        }
    }
}

class ThreadB extends Thread{
    StringBuffer buffstr;
    ThreadB(StringBuffer buffstr){
        this.buffstr=buffstr;
    }
    public void run(){
        String s[]={" In "," JAVA "};
        int i=0;
        while(i<s.length){
            s[i]=s[i].toLowerCase();
            buffstr.append(s[i]);
            i++;
        }
    }
}

class Test{
    public static void main(String[] args)throws InterruptedException{
        StringBuffer str=new StringBuffer();
        ThreadA A=new ThreadA(str);
        ThreadB B=new ThreadB(str);
        A.start();B.start();
        A.join();B.join();
        System.out.println(str);
    }
}