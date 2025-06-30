#include<iostream>
using namespace std;
bool seqSearch(int list[],int last,int target,int& locn){
    int looker;
    bool found;
    looker=0;
    while(looker<last and target!=list[looker])
        looker++;
    locn=looker;
    if(target==list[looker])
        found=true;
    else
        found=false;
    return found;
}


main(){
    int n,target,location;
    cout<<"Enter The Number of Elements: ";
    cin>>n;
    int list[n];
    cout<<"Enter The Elements\n";
    for(int i=0;i<n;i++)
        cin>>list[i];
    cout<<"Enter The Target: ";
    cin>>target;
    if(seqSearch(list,n-1,target,location)){
      cout<<"Target Found at "<<location<<" Location";}
    else
      cout<<"Target Not Found";
    cout<<endl;
}
