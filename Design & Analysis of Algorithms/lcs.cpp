#include<iostream>
#include<stdlib.h>
#include<time.h>
using namespace std;

const int limit=50;

void rangen(char x[],char y[]){
	srand((long int)clock());
	char S[]={'A','B','C'};
	for(int i=0;i<30;i++){
		x[i]=S[rand()%3];
		y[i]=S[rand()%3];
	}
}

void lcs_length_BU(int c[limit][limit],int b[limit][limit],char x[],int m,char y[],int n,int& count){
	int i,j;
	for(j=0;j<=n;j++)c[0][j]=0;
	for(i=1;i<=m;i++)c[i][0]=0;
	for(i=1;i<=m;i++){
		for(j=1;j<=n;j++){
			count++;
			if(x[i-1]==y[j-1]){
				c[i][j]=c[i-1][j-1]+1;
				b[i][j]=-1;
			}
			else if(c[i-1][j]>=c[i][j-1]){
				c[i][j]=c[i-1][j];
				b[i][j]=0;
			}
			else{
				c[i][j]=c[i][j-1];
				b[i][j]=1;
			}
		}
	}
}

int lcs_length_TD(int c[limit][limit],int b[limit][limit],char x[],char y[],int i,int j,int& count){
	if(c[i][j]>=0)return c[i][j];
	count++;
	if(i==0 || j==0){
		c[i][j]=0;
		return c[i][j];
	}
	if(x[i-1]==y[j-1]){
		c[i][j]=lcs_length_TD(c,b,x,y,i-1,j-1,count)+1;
		b[i][j]=-1;
	}
	else{
		int t1=lcs_length_TD(c,b,x,y,i-1,j,count);
		int t2=lcs_length_TD(c,b,x,y,i,j-1,count);
		if(t1>=t2){
			c[i][j]=t1;
			b[i][j]=0;
		}
		else{
			c[i][j]=t2;
			b[i][j]=1;
		}
	}
	return c[i][j];
}

int lcs_length_DC(char x[],char y[],int i,int j,int& count){
	count++;
	if(i==0 || j==0)return 0;
	if(x[i-1]==y[j-1])return lcs_length_DC(x,y,i-1,j-1,count)+1;
	else{
		int t1=lcs_length_DC(x,y,i-1,j,count);
		int t2=lcs_length_DC(x,y,i,j-1,count);
		if(t1>=t2)return t1;
		else return t2;
	}
}

void print(char x[],int b[limit][limit],int i,int j){
	if(i==0 || j==0)return;
	if(b[i][j]==-1){
		print(x,b,i-1,j-1);
		cout<<x[i-1];
	}
	else if(b[i][j]==0)print(x,b,i-1,j);
	else print(x,b,i,j-1);
}

int main(){
	char x[limit],y[limit];
	rangen(x,y);
	int size[]={10,20,24,30,34,40};
	cout<<"Input\t\tx\t\t\ty\t\t\tLCS\t\t\tBottom Up\tTop Down\tDivide & Conquer\n";
	for(int i=0;i<6;i++){
		int count1=0,count2=0,count3=0;
		int c1[limit][limit],b1[limit][limit];
		int c2[limit][limit],b2[limit][limit];
		int m=size[i]/2;
		int n=size[i]/2;
		for(int j=0;j<=m;j++)for(int k=0;k<=n;k++)c2[j][k]=-1;
		lcs_length_BU(c1,b1,x,m,y,n,count1);
		lcs_length_TD(c2,b2,x,y,m,n,count2);
		int length=lcs_length_DC(x,y,m,n,count3);
		cout<<m+n<<"\t\t";
		for(int j=0;j<20;j++)if(j<m)cout<<x[j];else cout<<" ";
		cout<<"\t";
		for(int j=0;j<20;j++)if(j<n)cout<<y[j];else cout<<" ";
		cout<<"\t";print(x,b1,m,n);cout<<"("<<length<<")";
		for(int j=0;j<20-length;j++)cout<<" ";
		if(length<10)cout<<" ";
		cout<<count1<<"\t\t"<<count2<<"\t\t"<<count3<<endl;
	}
	return 0;
}