#include <LPC214x.h>
unsigned long i;
void delay(unsigned int count)
{
unsigned int i,j;
for(i=0;i<=count;i++)
for(j=0;j<=89;j++);
}
int main()
{
int a=200;
IO1DIR=0x000F0000;
i=0x00080000;
while(a)
{
IO1SET=i;
delay(10000);
IO1CLR=0x000F0000;
i=i>>1;
if(i==0x00008000)
{i=0x00080000;}
a--;
}
}