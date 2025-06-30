from django.db import models

# Create your models here.
class Employee(models.Model):
	emp_name=models.CharField(max_length=25)
	emp_no=models.IntegerField()
	choices=(
		('Man','Manager'),
		('Sup','Supervisor'),
		('Sel','Seller'),
		('Cas','Cashier'),
		('Cel','Cleaner'),
		('Sec','Security'),
	)
	designation=models.CharField(max_length=20,choices=choices)
	mobileno=models.IntegerField()

class Product(models.Model):
	pro_name=models.CharField(max_length=25)
	category=models.CharField(max_length=20)
	qty=models.IntegerField(default=0)
	mrp=models.DecimalField(decimal_places=2,max_digits=8,default=0)
	discount=models.IntegerField(default=0)