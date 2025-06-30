#include<iostream>
using namespace std;
#define SIZE 10
class Stack{
    char s[SIZE],top;
    public:
        Stack(){
            top=-1;
        }
        bool stackpush(char data){
            if(stackfull())
                return false;
            else{
                top++;
                s[top]=data;
                return true;}
        }
        bool stackpop(char &data){
            if(stackempty())
                return false;
            else{
                data=s[top];
                top--;
                return true;}
        }
        bool stacktop(char &data){
            if(stackempty())
                return false;
            else{
                data=s[top];
                return true;}
        }
        void display(){
            for(int i=top;i>=0;i--)
                cout<<s[i]<<endl;
        }
        bool stackfull(){
            if(top==SIZE-1)
                return true;
            else
                return false;
        }
        bool stackempty(){
            if(top==-1)
                return true;
            else
                return false;
        }
};


main(){
    Stack S;
    char op,data;
    cout<<"\t\t1.Push\n\t\t2.Pop\n\t\t3.Stack Top\n\t\t4.Stack Full";
    cout<<"\n\t\t5.Stack Empty\n\t\t6.Display\n\t\t7.Exit";
    do{
        cout<<"\nEnter The Option: ";
        cin>>op;
        switch(op){
        case '1':cout<<"Enter The Element: ";
               cin>>data;
               if(S.stackpush(data))
                   cout<<"Element Added to The Stack";
               else
                   cout<<"Stack Overflow";
               break;
        case '2':if(S.stackpop(data))
                   cout<<"Popped Element is "<<data;
               else
                   cout<<"Stack Underflow";
               break;
        case '3':if(S.stacktop(data))
                   cout<<"Stack Top is "<<data;
               else
                   cout<<"Stack is Empty";
               break;
        case '4':if(S.stackfull())
                   cout<<"Stack is Full";
               else
                   cout<<"Stack is Not Full";
               break;
        case '5':if(S.stackempty())
                   cout<<"Stack is Empty";
               else
                   cout<<"Stack is Not Empty";
               break;
        case '6':if(S.stackempty())
                   cout<<"Stack is Empty";
               else
                   S.display();
               break;
        case '7':cout<<"Program Ended";
               break;
        default:cout<<"Invalid Option";
                break;
        }
        cout<<endl;
    }while(op!='7');
}
