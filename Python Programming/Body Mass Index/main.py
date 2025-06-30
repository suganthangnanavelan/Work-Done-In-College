import csv
from adviser import UnderWeight,OverWeight,Obese
from people import Person
import compare


def main():
    persons=[]
    with open('input.csv','r') as file:
        reader=csv.reader(file)
        for row in reader:
            person=Person()
            person.name=row[0]
            person.weight=float(row[1])
            person.height=float(row[2])
            persons.append(person)

    result=dict()
    for A in persons:
            for B in persons:
                if(A!=B):
                    result[(A.name,B.name)]=(compare.isHeavier(A,B),compare.isTaller(A,B))
    for i in result:print(i)

    print("\n\nBMI of All Persons")
    for person in persons:
        bmi=round(person.calcBMI(),1)
        try:
            if(bmi<18.5):raise UnderWeight(str(person)+" is under weight BMI = "+str(bmi))
            elif(bmi<24.9):print(str(person)+" is healthier BMI = "+str(bmi))
            elif(bmi<29.9):raise OverWeight(str(person)+" is over weight BMI = "+str(bmi))
            else:raise Obese(str(person)+" is obese BMI = "+str(bmi))
        except Exception as e:print(e)
    print("\n\n")
                    
if __name__=="__main__":
    main()
