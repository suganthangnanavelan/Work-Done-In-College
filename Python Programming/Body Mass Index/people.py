class Person:
    @property
    def name(self):return self.__name
    @name.setter
    def name(self,name):self.__name=name
    @property
    def weight(self):return self.__weight
    @weight.setter
    def weight(self,w):self.__weight=w
    @property
    def height(self):return self.__height
    @weight.setter
    def height(self,h):self.__height=h
    def calcBMI(self):
        return (self.__weight*(10**4))/(self.__height**2)
    def __str__(self):
        d=dict()
        d[self.__name]=(self.__weight,self.__height,round(self.calcBMI(),1))
        return str(d)


