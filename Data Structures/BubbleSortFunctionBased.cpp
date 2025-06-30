#include<iostream>
using namespace std;


void bubblesort(int list[],int last){
    int current,walker;
    bool sorted;
    current=0;
    sorted=false;
    while(current<=last && sorted==false){
        walker=last;
        sorted=true;
        while(walker>current){
            if(list[walker]<list[walker-1]){
                sorted=false;
                int temp=list[walker];
                list[walker]=list[walker-1];
                list[walker-1]=temp;
            }
            walker--;
        }  
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
    bubblesort(list,last);
    cout<<"Sorted list\n";
    for(int i=0;i<n;i++)
        cout<<list[i]<<" ";
    cout<<endl;
}
