#include<iostream>
using namespace std;


void insertionsort(int list[],int last){
    int current,walker,hold;
    current=1;
    while(current<=last){
        hold=list[current];
        walker=current-1;
        while(walker>=0 && hold<list[walker]){
            list[walker+1]=list[walker];
            walker--;
        }
        list[walker+1]=hold;
        current++;
    }
}
        
main(){
    int n,last;
    cout<<"Enter The Number of Elements: ";
    cin>>n;
    last=n-1;
    int list[n];
    cout<<"Enter The Elements\n";
    for(int i=0;i<n;i++)
        cin>>list[i];
    insertionsort(list,last);
    cout<<"Sorted list\n";
    for(int i=0;i<n;i++)
        cout<<list[i]<<" ";
    cout<<endl;
}
