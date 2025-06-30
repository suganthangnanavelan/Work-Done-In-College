#include<iostream>
using namespace std;

void Sumofsubset(int *A,int *X,int s,int k,int r,int m){
	X[k]=1;
	if((s+A[k])==m){
		cout<<"[";
		for(int i=0;i<=k;i++){
			if(X[i]==1){
				cout<<A[i];
				if(i!=k)cout<<",";
			}
		}
		cout<<"]"<<endl;
	}
	else if(s+A[k]+A[k+1]<=m)
		Sumofsubset(A,X,s+A[k],k+1,r-A[k],m);
	if((s+r-A[k]>=m) and (s+A[k+1]<=m)){
		X[k]=0;
		Sumofsubset(A,X,s,k+1,r-A[k],m);
	}
}

int main(){
	int n,m,total=0;
	cout<<"Enter The Array Size: ";
	cin>>n;
	int A[n],X[n];
	cout<<"Enter The Elements: ";
	for(int i=0;i<n;i++)cin>>A[i];
	for(int i=0;i<n;i++)total+=A[i];
	cout<<"Enter Sum Value: ";
	cin>>m;
	Sumofsubset(A,X,0,0,total,m);
	return 0;
}
