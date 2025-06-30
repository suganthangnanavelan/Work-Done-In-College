#include<iostream>
#define HSIZE 5
using namespace std;
struct node{
    int data;
    node* link;
};
struct list{
    int count;
    node* head;
};
class HTable{
         list *Slist[HSIZE];
    public:
         HTable(){
             for(int i=0;i<HSIZE;i++){
                 Slist[i]=new list;
                 Slist[i]->count=0;
                 Slist[i]->head=NULL;
             }
         }
         void insert(int data){
             node* pnew=new node;
             pnew->data=data;
             int rem=data%HSIZE;
             pnew->link=Slist[rem]->head;
             Slist[rem]->head=pnew;
             Slist[rem]->count++;
         }
         void Search(int data){
             int rem=data%HSIZE;
             node *t=Slist[rem]->head;
             while(t!=NULL){
                 if(t->data==data){
                     cout<<"Element Found";
                     return;
                 }
                 t=t->link;
             }
             cout<<"Element Not Found";
         }
         void Display(){
             for(int i=0;i<HSIZE;i++){
                 node *t=Slist[i]->head;
                 while(t!=NULL){
                     cout<<t->data<<endl;
                     t=t->link;
                 }
              }
          }
          void Delete(int data){
              int rem=data%HSIZE;
              node *t1=Slist[rem]->head;
              node *t2=NULL;
              while(t1!=NULL){
                  if(t1->data!=data){
                      t2=t1;
                      t1=t1->link;
                  }
                  else 
                      break;
              }
              if(t1==NULL)
                  cout<<"Element Not Found";
              else{
                  if(t2==NULL){
                      Slist[rem]->head=t1->link;
                      delete t1;
                  }
                  else{
                      t2->link=t1->link;
                      delete t1;
                  }
                  Slist[rem]->count--;}
          }
};
main(){
    HTable H;
    char op;
    int data;
    cout<<"\t\t1.Insert\n\t\t2.Search\n\t\t3.Delete\n\t\t4.Display\n\t\t5.Exit\n";
    do{
        cout<<"Enter The Option: ";
        cin>>op;
        switch(op){
            case '1':{cout<<"Enter The Data: ";
                      cin>>data;
                      H.insert(data);
                      break;
                     }
            case '2':{cout<<"Enter The Data: ";
                      cin>>data;
                      H.Search(data);
                      break;
                     }
            case '3':{cout<<"Enter The Data: ";
                      cin>>data;
                      H.Delete(data);
                      break;
                     }
            case '4':{H.Display();
                      break;
                     }
            case '5':{cout<<"Program Ended";break;}
            default:cout<<"Invalid Choice";
       }
       cout<<endl;
    }while(op!='5');
}
