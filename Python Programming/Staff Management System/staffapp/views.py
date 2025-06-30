from django.shortcuts import render
from django.http import HttpResponse,HttpResponseRedirect
from .models import Staff
from .forms import Staff_form
# Create your views here.
def search(request,n,d):
    try:
        a=Staff.objects.get(sname=n,sdept=d)
    except:
        return HttpResponse('Staff Not Found')
    return render(request,'display.html',context={'t':a})
def insert_view(request):
    form=Staff_form()
    if request.method=="POST":
        form=Staff_form(request.POST)
        if form.is_valid():
            form.save()
            return HttpResponse('<center><h1>Inserted Successfully</h1></center>')
    return render(request,'insert.html',context={'form':form})
def update_view(request,t):
    a=Staff.objects.get(sid=t)
    form=Staff_form(instance=a)
    if request.method=="POST":
        form=staff_form(request.POST,instance=a)
        if form.is_valid():
            form.save()
            return HttpResponse('<center><h1>Updated Successfully</h1></center>')
    return render(request,'update.html',context={'staff':form})
def delete_view(request,t):
    a=Staff.objects.get(sid=t)
    a.delete()
    return HttpResponse('<center><h1>Deleted Successfully</h1></center>')
