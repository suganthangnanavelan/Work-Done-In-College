#include <iostream>
using namespace std;
struct node{
    char data;
    node *link;
};
struct Stack{
    int count;
    node *top;
};
class StackADT{
        Stack *S;
    public:
        StackADT(){
            S=NULL;
        }
        void CreateStack(){
            S=new Stack;
            S->count=0;
            S->top=NULL;
        }
        bool PushStack(char data){
            if(StackFull())
                return false;
            else{
                node *t=new node;
                t->data=data;
                t->link=S->top;
                S->top=t;
                S->count++;
                return true;
            }
        }
        bool PopStack(char& data){
            if(StackEmpty())
                return false;
            else{
                node *t=S->top;
                data=t->data;
                S->top=t->link;
                delete t;
                S->count--;
                return true;
            }
        }
        bool StackTop(char& data){
            if(StackEmpty())
                return false;
            else{
                data=S->top->data;
                return true;
            }
        }
        void Display(){
            node *temp=S->top;
            while(temp!=NULL){
                cout<<temp->data<<endl;
                temp=temp->link;
            }
        }
        bool StackFull(){
            node *t=new node;
            if(t==NULL)
                return true;
            else{
                delete t;
                return false;
            }
        }
        bool StackEmpty(){
            if(S->count==0)
                return true;
            else
                return false;
        }
        void DestroyStack(){
            node *temp;
            while(S->top!=NULL){
                temp=S->top;
                S->top=temp->link;
                delete temp;
            }
            delete S;
        }
};
int priority(char op){
    switch(op){
        case '^':return 3;
        case '*':return 2;
        case '/':return 2;
        case '+':return 1;
        case '-':return 1;
        case '(':return 0;
        default:return 0;
    }
}
string infixtopostfix(string formula){
    StackADT S;
    S.CreateStack();
    string postfix;
    char token;
    for(int i=0;formula[i]!='\0';i++){
        if(formula[i]=='(')
            S.PushStack(formula[i]);
        else if(formula[i]==')'){
            S.PopStack(token);
            while(token!='('){
                postfix.push_back(token);
                S.PopStack(token);
            }
        }
        else if(formula[i]=='+'||formula[i]=='-'||formula[i]=='*'||formula[i]=='/'||formula[i]=='^'){
            S.StackTop(token);
            while((!S.StackEmpty()) && priority(formula[i])<=priority(token)){
                S.PopStack(token);
                postfix.push_back(token);
                S.StackTop(token);
            }
            S.PushStack(formula[i]);
        }
        else
            postfix.push_back(formula[i]);
    }
    while(!S.StackEmpty()){
        S.PopStack(token);
        postfix.push_back(token);
    }
    return postfix;
}

main(){
    cout<<"Enter The Infix Expression: ";
    string infix;
    cin>>infix;
    string postfix=infixtopostfix(infix);
    cout<<"Postfix Expression: "<<postfix;
}