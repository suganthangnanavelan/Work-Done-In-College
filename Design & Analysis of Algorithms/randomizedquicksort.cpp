#include<iostream>
#include<fstream>
#include<stdlib.h>

using namespace std;

int partition(int A[],int p,int r,int& count){
	int x=A[r];
	int i=p-1;
	for(int j=p;j<r;j++){
		count++;
		if(A[j]<=x){
			i++;
			swap(A[i],A[j]);
	
	}
	}
	swap(A[i+1],A[r]);
	return i+1;
}

int randomizedpartition(int A[],int p,int r,int& count){
	int i=rand()%(r-p+1)+p;
	swap(A[r],A[i]);
	return partition(A,p,r,count);
}

void randomizedquicksort(int A[],int p,int r,int& count){
	if(p<r){
		int q=randomizedpartition(A,p,r,count);
		randomizedquicksort(A,p,q-1,count);
		randomizedquicksort(A,q+1,r,count);
	}
}

int main(){
	int n,count=0;
	cout<<"Enter The Number of Inputs: ";
	cin>>n;
	int a[n];
	ifstream fin("input.txt");
	for(int i=0;i<n;i++)
		fin>>a[i];
	
	randomizedquicksort(a,0,n-1,count);
	
	ofstream mg("output.txt");
	for(int i=0;i<n;i++)
		mg<<a[i]<<"\t";
	cout<<"Number of comparisons: "<<count<<endl;

	return 0;
}	
