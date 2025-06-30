from django.shortcuts import render
from django.template import loader
from .models import Players
from django.http import HttpResponse
# Create your views here.
def team1(req):
	return render(req,'RCB.html')
def team2(req):
	return render(req,'CSK.html')
def allplayers(req):
	players=Players.objects.all()
	template=loader.get_template('allplayers.html')
	context={
		"allplayers":players
	}
	return HttpResponse(template.render(context,req,))