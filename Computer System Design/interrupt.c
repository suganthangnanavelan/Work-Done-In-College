#include <LPC214x.h>

void delay()
{
int i,j;
for(i=0;i<4000;i++)
for(j=0;j<4000;j++){};
}

__irq void Ext_ISR(void)
{
IO1SET =0x00550000;
delay();
IO1CLR=0x00550000;
EXTINT |=0x2;
VICVectAddr=0;
}

void ext_int_init()
{
EXTMODE = 0x2;
EXTPOLAR &= ~(0x2);
PINSEL0=0x20000000;
VICIntSelect&=~(1<<15);
VICVectAddr5 =(unsigned int)Ext_ISR;
VICVectCntl5 =(1<<15)|15;
VICIntEnable=(1<<15);
}

int main(void)
{
IODIR0= 0x0;
IO1DIR= 0x00FF0000;
ext_int_init();
while(1)
{
IO1SET=0x00FF0000;
delay();
IO1CLR=0x00FF0000;
delay();
}
}




