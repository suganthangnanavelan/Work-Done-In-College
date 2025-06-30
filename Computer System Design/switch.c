#include <LPC214x.h>
void delay()
{
int i,j;
for(i=0;i<1000;i++)
for(j=0;j<1000;j++);
}

int main()
{
PINSEL0=0x0;
PINSEL2=0x0;
IODIR0=0x0;
IODIR1=0x00FF0000;
while(1)
{
if(IOPIN0 & 0x00004000)
{
IOSET1=0x00AA0000;
delay();
IOCLR1=0x00AA0000;
delay();
}
else
{
IOSET1=0x00550000;
delay();
IOCLR1=0x00550000;
delay();
}
}
return 0;
}