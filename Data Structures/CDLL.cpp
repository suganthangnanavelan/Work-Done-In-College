#include<iostream>
using namespace std;
struct node{
    int data;
    node *back;
    node *fore;
};


struct list{
    int count;
    node *head;
    node *rear;
};


class CDLL{
    list *CDlist; 
  public:
    CDLL(){
        CDlist=NULL;
    }
    void createCDLL(){
        CDlist = new list;
        CDlist->head=NULL;
        CDlist->rear=NULL;
        CDlist->count=0;
    }
    bool insertCDLL(int data){
        node *predecessor,*successor;
        bool found=searchCDLL(predecessor,successor,data);
        if(!found){
            node *newnode=new node;
            newnode->data=data;
            if(predecessor==NULL){
                if(emptyCDLL()){
                     CDlist->head=newnode;
                     CDlist->rear=newnode;
                }
                else{
                    CDlist->head->back=newnode;
                    CDlist->rear->fore=newnode;
                }
                newnode->back=CDlist->rear;
                newnode->fore=CDlist->head;
                CDlist->head=newnode;
            }
            else{
                newnode->fore=successor;
                newnode->back=predecessor;
                predecessor->fore=newnode;
                if(successor==CDlist->head)
                    CDlist->rear=newnode;
                successor->back=newnode;
            }
            CDlist->count++;
            return true;
        }
        return false;
    }
    bool deleteCDLL(int data){
        node *predecessor,*deletenode;
        bool found=searchCDLL(predecessor,deletenode,data);
        if(found){
            if(CDlist->count==1)
                CDlist->head=CDlist->rear=NULL;
            else{
                if(predecessor!=NULL){
                    predecessor->fore=deletenode->fore;
                    deletenode->fore->back=predecessor;
                    if(deletenode==CDlist->rear)
                        CDlist->rear=predecessor;
                }
                else{
                    CDlist->head=deletenode->fore;
                    deletenode->fore->back=deletenode->back;
                    CDlist->rear->fore=deletenode->fore;
                    }
            }
            delete deletenode;
            CDlist->count--;
            return true;
        }
        return false;
    }
    bool searchCDLL(node*& pPre,node*& pLoc,int target){
        bool found;
        pPre=NULL;
        pLoc=CDlist->head;
        if(emptyCDLL())
            return false;
        if(pLoc->data==target)
            return true;
        if(target<pLoc->data)
            return false;
        pPre=pLoc;
        pLoc=pLoc->fore;
        while(pLoc!=CDlist->head && target>pLoc->data){
            pPre=pLoc;
            pLoc=pLoc->fore;
        }
        if(pLoc==CDlist->head)
            found=false;
        else{
            if(target==pLoc->data)
                found=true;
            else
                found=false;
        }
        return found;
    }
    bool emptyCDLL(){
        if(CDlist->count==0)
            return true;
        else
            return false;
    }
    bool fullCDLL(){
        node *t=new node;
        if(t==NULL)
            return true;
        else{
            delete t; 
            return false;
        }
    }
    int CDLLCount(){
        return CDlist->count;
    }
    void displayHeadtoRear(){
        node *t=CDlist->head;
        if(t!=NULL){
            do{
                cout<<t->data<<"   ";
                t=t->fore;
            }while(t!=CDlist->head);
        }
    }
    void displayReartoHead(){
        node *t=CDlist->rear;
        if(t!=NULL){
            do{
                cout<<t->data<<"   ";
                t=t->back;
            }while(t!=CDlist->rear);
        }
    }
    void destroyCDLL(){
        node *t;
        while(CDlist->count!=0){
            t=CDlist->head;
            CDlist->head=CDlist->head->fore;
            delete t;
            CDlist->count--;
        }
        CDlist->head=NULL;
        CDlist->rear=NULL;
    }
    int searchCDLLFromHead(int target){
        node *pLoc=CDlist->head;
        int pos=1;
        if(emptyCDLL())
            return -1;
        if(target==pLoc->data)
            return pos;
        pLoc=pLoc->fore;
        pos++;
        while(pLoc!=CDlist->head && target>pLoc->data){
            pos++;
            pLoc=pLoc->fore;
        }
        if(target==pLoc->data)
            return pos;
        else
            return -1;
    }
    int searchCDLLFromRear(int target){
        node *pLoc=CDlist->rear;
        int pos=1;
        if(emptyCDLL())
            return -1;
        if(target==pLoc->data)
            return pos;
        pLoc=pLoc->back;
        pos++;
        while(pLoc!=CDlist->rear && target<pLoc->data){
            pos++;
            pLoc=pLoc->back;
        }
        if(target==pLoc->data)
            return pos;
        else
            return -1;
    }
};
              
main(){
    CDLL CD;
    CD.createCDLL();
    int op,data;
    cout<<"\t\t1.Insert\n\t\t2.Delete\n\t\t3.Search Position From Head";
    cout<<"\n\t\t4.Search Position From Rear\n\t\t5.Display From Head to Rear";
    cout<<"\n\t\t6.Display From Rear to Head\n\t\t7.Element Count";
    cout<<"\n\t\t8.Check Empty\n\t\t9.Check Full\n\t\t10.Exit\n";        
    do{
        cout<<"Enter The Option: ";
        cin>>op;
        switch(op){
            case 1: if(CD.fullCDLL())
                        cout<<"CDLL is Full";
                    else{
                        cout<<"Enter The Data to be Inserted: ";
                        cin>>data;
                        if(CD.insertCDLL(data))
                            cout<<"Insertion Was Successful";
                        else
                            cout<<"Insertion Failed! Data Already Exists";
                    }
                    cout<<endl;
                    break; 
            case 2: if(CD.emptyCDLL())
                        cout<<"Not Possible! CDLL is Empty";
                    else{
                        cout<<"Enter The Data to be Deleted: ";
                        cin>>data;
                        if(CD.deleteCDLL(data)){
                            cout<<"Deletion Was Successful";}
                        else
                            cout<<"Impossible to Delete! Data Doesn't Exist";
                    }
                    cout<<endl;
                    break; 
            case 3: cout<<"Enter The Data to be Searched: ";
                    cin>>data;
                    if((data=CD.searchCDLLFromHead(data))==-1)
                        cout<<"Data Not Found In CDLL";
                    else
                        cout<<"Target Found at Location = "<<data<<" From Head";
                    cout<<endl;
                    break;
            case 4: cout<<"Enter The Data to be Searched: ";
                    cin>>data;
                    if((data=CD.searchCDLLFromRear(data))==-1)
                        cout<<"Data Not Found In CDLL";
                    else
                        cout<<"Target Found at Location = "<<data<<" From Rear";
                    cout<<endl;
                    break;
            case 5: if(CD.emptyCDLL())
                        cout<<"CDLL is Empty";
                    else
                        CD.displayHeadtoRear();
                    cout<<endl;
                    break;
            case 6: if(CD.emptyCDLL())
                        cout<<"CDLL is Empty";
                    else
                        CD.displayReartoHead();
                    cout<<endl;
                    break;
            case 7: cout<<"Number of Elements in CDLL: "<<CD.CDLLCount()<<endl;
                    break;
            case 8: if(CD.emptyCDLL())
                        cout<<"CDLL is Empty"<<endl;
                    else
                        cout<<"CDLL is Not Empty"<<endl;
                    break;
            case 9: if(CD.fullCDLL())
                        cout<<"CDLL is Full"<<endl;
                    else
                        cout<<"CDLL is Not Full"<<endl;
                    break;
            case 10:CD.destroyCDLL();
                    cout<<endl;
                    break;
            default:cout<<"Invalid Choice"<<endl;
        }
     }while(op!=10);  
}
