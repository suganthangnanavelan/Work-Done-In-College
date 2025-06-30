#include<iostream>
#include<fstream>
using namespace std;

void buildmaxheap(int A[],int& length,int& heapsize,int& count);
void maxheapify(int A[],int& heapsize,int i,int& count);

void heapsort(int A[],int length,int heapsize,int& count){
	buildmaxheap(A,length,heapsize,count);
	for(int i=length-1;i>=1;i--){
		swap(A[0],A[i]);
		heapsize--;
		maxheapify(A,heapsize,0,count);
	}
}

void buildmaxheap(int A[],int& length,int& heapsize,int& count){
	heapsize=length;
	for(int i=length/2-1;i>=0;i--)
		maxheapify(A,heapsize,i,count);
}

void maxheapify(int A[],int& heapsize,int i,int& count){
	int largest;
	int l=2*i+1;
	int r=2*i+2;
	count++;
	if(l<heapsize && A[l]>A[i])
		largest=l;
	else
		largest=i;
	count++;
	if(r<heapsize && A[r]>A[largest])
		largest=r;
	if(largest!=i){
		swap(A[i],A[largest]);
		maxheapify(A,heapsize,largest,count);
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
	
	heapsort(a,n,n,count);
	
	ofstream mg("heapsorted.txt");
	for(int i=0;i<n;i++)
		mg<<a[i]<<"\t";
	cout<<"Number of comparisons: "<<count<<endl;

	return 0;
}
