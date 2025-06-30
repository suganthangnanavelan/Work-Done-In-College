class Savings extends Account{
    Savings(int accno,double bal){
        super(accno,bal);
    }
    void deposit(double amount){
        super.balance+=amount;
        System.out.println("Current Balance: "+super.balance);
    }  
    void withdrawal(double amount){
        super.balance-=amount;
        System.out.println("Current Balance: "+super.balance);
    }
    public String toString(){
        return super.toString(); 
    }
}