#include <LPC214x.h>
int main()
{
unsigned int i,j,a=0x00FF0000;
PINSEL2=0x0;
IODIR1=0x00FF0000;
while(1)
{
IOSET1=a;
for(i=0;i<1000;i++)
for(j=0;j<5000;j++);
IOCLR1=a;
for(i=0;i<1000;i++)
for(j=0;j<5000;j++);
}
return 0;
}