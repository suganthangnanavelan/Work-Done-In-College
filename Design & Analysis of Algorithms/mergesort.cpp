#include<iostream>
#include<fstream>
#include<stdlib.h>
#include<time.h>
using namespace std;

void merge(int a[],int p,int q,int r,int& count){
	int n1=q-p+1;
	int n2=r-q;
	int *l=new int[n1+1];
	int *R=new int[n2+1];
	int i,j,k;
	for(i=1;i<=n1;i++)
		l[i]=a[p+i-1];
	l[n1+1]=99999; 
	for(j=1;j<=n2;j++)
		R[j]=a[q+j];
	R[n2+1]=99999;
	i=1,j=1;
	for(k=p;k<=r;k++){
		count++;
		if(l[i]<=R[j]){
			a[k]=l[i];
			i++;
		}
		else{
			a[k]=R[j];
			j++;
		}
	}
}

void mergesort(int A[],int p,int r,int& count){
	if(p<r){
		int q=(p+r)/2;
		mergesort(A,p,q,count);
		mergesort(A,q+1,r,count);
		merge(A,p,q,r,count);
	}
}

int main(){
	int n,count=0;
	cout<<"Enter The Number of Inputs: ";
	cin>>n;
	/*ofstream fout("input.txt");
	srand((long int)clock());
	for(int i=0;i<n;i++)
		//fout<<rand()%30000<<"\t";
	fout.close();

	int a[n];
	ifstream fin("input.txt");
	for(int i=0;i<n;i++)
		fin>>a[i];
		
	//mergesort(a,0,n-1,count);
	
	ofstream mg("mergesorted.txt");
	for(int i=0;i<n;i++)
		mg<<a[i]<<"\t";
	cout<<"Number of comparisons: "<<count;*/
	return 0;
}


		

