from django.shortcuts import render
from django.http import HttpResponse
from django.template import loader
from .models import Music,Concert
# Create your views here.
def home(request):
	return render(request,'home.html')
def register(request):
	print("Enter Applicant's Details")
	n=input("Name: ")
	m=int(input("MobileNo: "))
	e=input("Email Id: ")
	t=input("Applied for Singer/Instrumentalist :")
	i=input("Instrument: ")
	Music(name=n,mobileno=m,email=e,type=t,instrument=i).save()
	print("Enter Music Programme")
	p=input("Place: ")
	d=input("Duration: ")
	n=int(input("No of Awards: "))
	t=input("Title: ")
	Concert(place=p,duration=d,awards=n,title=t).save()
	return render(request,'register.html')

def view(request):
	music=Music.objects.all().values()
	concert=Concert.objects.all().values()
	template=loader.get_template('view.html')
	context={
		"m":music,
		"c":concert,
	}
	return HttpResponse(template.render(context,request,))

def report(request):
	with open("applicants.txt",'w') as f:
		f.write("Applicant Details\n")
		for i in Music.objects.all().values():f.write(str(i)+"\n")
		f.write("Applicant's Concert Details\n")
		for i in Concert.objects.all().values():f.write(str(i)+"\n")
	return HttpResponse("Report Has Been Generated")

def message(request):
	music=Music.objects.all().values()[len(Music.objects.all())-1]
	concert=Concert.objects.all().values()[len(Concert.objects.all())-1]
	template=loader.get_template('message.html')
	context={
		"m":music,
		"c":concert,
	}
	return HttpResponse(template.render(context,request,))