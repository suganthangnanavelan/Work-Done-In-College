package pkcontact;

public class Contact{
    public String name;
    public String mobileno;
    public Contact(String name,String mobileno) {
        this.name=name;
        this.mobileno=mobileno;
    }
    public String toString(){
        return "[Contact Name: "+name+", Mobile No: "+mobileno+"]";
    }
}