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


class DLL{
    list *Dlist; 
  public:
    DLL(){
        Dlist=NULL;
    }
    void createDLL(){
        Dlist = new list;
        Dlist->head=NULL;
        Dlist->rear=NULL;
        Dlist->count=0;
    }
    bool insertDLL(int data){
        node *predecessor,*successor;
        bool found=searchDLL(predecessor,successor,data);
        if(!found){
            node *newnode=new node;
            newnode->data=data;
            if(predecessor==NULL){
                newnode->back=NULL;
                newnode->fore=Dlist->head;
                Dlist->head=newnode;
            }
            else{
                newnode->fore=successor;
                newnode->back=predecessor;
                predecessor->fore=newnode;
            }
            if(successor==NULL)
                Dlist->rear=newnode;
            else
                successor->back=newnode;
            Dlist->count++;
            return true;
        }
        return false;
    }
    bool deleteDLL(node *deletenode){
        node *predecessor,*successor;
        if(deletenode==NULL){
            cout<<"Impossible to Delete! ";
            return false;
        }

        if(deletenode->back!=NULL){
            predecessor=deletenode->back;
            predecessor->fore=deletenode->fore;
        }
        else
            Dlist->head=deletenode->fore;
        if(deletenode->fore!=NULL){
            successor=deletenode->fore;
            successor->back=deletenode->back;
        }
        else
            Dlist->rear=deletenode->back;
        delete deletenode;
        Dlist->count--;
        return true;
    }
    bool searchDLL(node*& pPre,node*& pLoc,int target){
        bool found;
        pPre=NULL;
        pLoc=Dlist->head;
        while(pLoc!=NULL && target>pLoc->data){
            pPre=pLoc;
            pLoc=pLoc->fore;
        }
        if(pLoc==NULL)
            found=false;
        else{
            if(target==pLoc->data)
                found=true;
            else
                found=false;
        }
        return found;
    }
    bool emptyDLL(){
        if(Dlist->count==0)
            return true;
        else
            return false;
    }
    bool fullDLL(){
        node *t=new node;
        if(t==NULL)
            return true;
        else{
            delete t; 
            return false;
        }
    }
    int DLLCount(){
        return Dlist->count;
    }
    void displayHeadtoRear(){
        for(node *t=Dlist->head;t!=NULL;t=t->fore)
            cout<<t->data<<"   ";
    }
    void displayReartoHead(){
        for(node *t=Dlist->rear;t!=NULL;t=t->back)
            cout<<t->data<<"   ";
    }
    void destroyDLL(){
        node *t=Dlist->head;
        while(Dlist->head!=NULL){
            t=Dlist->head;
            Dlist->head=Dlist->head->fore;
            delete t;
        }
        Dlist->rear=NULL;
        Dlist->count=0;
    }
    int searchDLLFromHead(int target){
        node *pLoc=Dlist->head;
        int pos=1;
        while(pLoc!=NULL && target>pLoc->data){
            pos++;
            pLoc=pLoc->fore;
        }
        if(pLoc==NULL)
            return -1;
        else{
            if(target==pLoc->data)
                return pos;
            else 
                return -1;
        }
    }
    int searchDLLFromRear(int target){
        node *pLoc=Dlist->rear;
        int pos=1;
        while(pLoc!=NULL && target<pLoc->data){
            pos++;
            pLoc=pLoc->back;
        }
        if(pLoc==NULL){
            return -1;
        }
        else{
            if(target==pLoc->data)
                return pos;
            else
                return -1;
        }    
    }
};
              
main(){
    DLL D;
    D.createDLL();
    int op,data;
    cout<<"\t\t1.Insert\n\t\t2.Delete\n\t\t3.Search Position From Head";
    cout<<"\n\t\t4.Search Position From Rear\n\t\t5.Display From Head to Rear";
    cout<<"\n\t\t6.Display From Rear to Head\n\t\t7.Element Count";
    cout<<"\n\t\t8.Check Empty\n\t\t9.Check Full\n\t\t10.Exit\n";        
    do{
        cout<<"Enter The Option: ";
        cin>>op;
        switch(op){
            case 1: if(D.fullDLL())
                        cout<<"DLL is Full";
                    else{
                        cout<<"Enter The Data to be Inserted: ";
                        cin>>data;
                        if(D.insertDLL(data))
                            cout<<"Insertion Was Successful";
                        else
                            cout<<"Insertion Failed! Data Already Exists";
                    }
                    cout<<endl;
                    break; 
            case 2: if(D.emptyDLL())
                        cout<<"Not Possible! DLL is Empty";
                    else{
                        cout<<"Enter The Data to be Deleted: ";
                        cin>>data;
                        node *predecessor,*deletenode;
                        if(!D.searchDLL(predecessor,deletenode,data))
                            deletenode=NULL;
                        if(D.deleteDLL(deletenode)){
                            cout<<"Deletion Was Successful";}
                        else
                            cout<<"Data Doesn't Exist";
                    }
                    cout<<endl;
                    break; 
            case 3: cout<<"Enter The Data to be Searched: ";
                    cin>>data;
                    if((data=D.searchDLLFromHead(data))==-1)
                        cout<<"Data Not Found In DLL";
                    else
                        cout<<"Target Found at Location = "<<data<<" From Head";
                    cout<<endl;
                    break;
            case 4: cout<<"Enter The Data to be Searched: ";
                    cin>>data;
                    if((data=D.searchDLLFromRear(data))==-1)
                        cout<<"Data Not Found In DLL";
                    else
                        cout<<"Target Found at Location = "<<data<<" From Rear";
                    cout<<endl;
                    break;
            case 5: if(D.emptyDLL())
                        cout<<"DLL is Empty";
                    else
                        D.displayHeadtoRear();
                    cout<<endl;
                    break;
            case 6: if(D.emptyDLL())
                        cout<<"DLL is Empty";
                    else
                        D.displayReartoHead();
                    cout<<endl;
                    break;
            case 7: cout<<"Number of Elements in DLL: "<<D.DLLCount()<<endl;
                    break;
            case 8: if(D.emptyDLL())
                        cout<<"DLL is Empty"<<endl;
                    else
                        cout<<"DLL is Not Empty"<<endl;
                    break;
            case 9: if(D.fullDLL())
                        cout<<"DLL is Full"<<endl;
                    else
                        cout<<"DLL is Not Full"<<endl;
                    break;
            case 10:D.destroyDLL();
                    cout<<endl;
                    break;
            default:cout<<"Invalid Choice"<<endl;
        }
     }while(op!=10);  
}
