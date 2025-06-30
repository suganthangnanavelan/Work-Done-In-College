from django.shortcuts import render
from django.http import HttpResponse
from .models import Employee,Product
from .forms import InsertEmpForm, DeleteEmpForm, InsertProFrom, UpdateProForm , ProductIdForm
# Create your views here.
def home(request):
	return render(request,'home.html')
def emplist(request):
	return render(request,'emplist.html',{'emps':Employee.objects.all().values()})

def addemp(request):
	if(request.method=='POST'):
		form=InsertEmpForm(request.POST)
		if form.is_valid():
			form.save()
			return HttpResponse("Employee Details Added Successfully")
	form=InsertEmpForm()
	return render(request,'add.html',{'form':form})

def delemp(request):
	if(request.method=='POST'):
		form=DeleteEmpForm(request.POST)
		if form.is_valid():
			try:
				empno=form.cleaned_data['emp_no']
				emp=Employee.objects.get(emp_no=empno)
				emp.delete()
				return HttpResponse("Deletion Was Successfull")
			except Employee.DoesNotExist:
				return HttpResponse("Employee Doesn't Exist")
	form=DeleteEmpForm()
	return render(request,'delemp.html',{'form':form})	

def addpro(request):
	if(request.method=='POST'):
		form=InsertProFrom(request.POST)
		if form.is_valid():
			form.save()
			return HttpResponse("Product Details Added Successfully")
	form=InsertProFrom()
	return render(request,'add.html',{'form':form})

def sold_items(request):
	if(request.method=='POST'):
		form=UpdateProForm(request.POST)
		if form.is_valid():
			try:
				pname=form.cleaned_data['name']
				qty=form.cleaned_data['qty']
				pro=Product.objects.get(pro_name=pname)
				if(pro.qty-qty>0):
					pro.qty-=qty
					return HttpResponse("Product Details Was Updated")
				return HttpResponse("Insufficient Quantity")
			except Product.DoesNotExist:
				return HttpResponse("Product Doesn't Exist")
	form=UpdateProForm()
	return render(request,'updatepro.html',{'form':form})
def stock(request):
	#not categorised
	return render(request,'prolist.html',{'pros':Product.objects.all().values()})

def product_stock(request):
	if(request.method=='POST'):
		form=ProductIdForm(request.POST)
		if form.is_valid():
			try:
				pname=form.cleaned_data['name']
				pro=Product.objects.get(pro_name=pname)
				return render(request,'prolist.html',{'pros':[pro]})
			except Product.DoesNotExist:
				return HttpResponse("Product Doesn't Exist")
	form=ProductIdForm()
	return render(request,'prosearch.html',{'form':form})



