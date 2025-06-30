#include<iostream>
#include<fstream>

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

void quicksort(int A[],int p,int r,int& count){
	if(p<r){
		int q;
		q=partition(A,p,r,count);
		quicksort(A,p,q-1,count);
		quicksort(A,q+1,r,count);
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
	
	quicksort(a,0,n-1,count);
	
	ofstream mg("output.txt");
	for(int i=0;i<n;i++)
		mg<<a[i]<<"\t";
	cout<<"Number of comparisons: "<<count<<endl;

	return 0;
}
