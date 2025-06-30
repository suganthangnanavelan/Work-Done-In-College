from django.db import models

# Create your models here.
class Music(models.Model):
	name=models.CharField(max_length=255)
	mobileno=models.IntegerField()
	email=models.CharField(max_length=255)
	type=models.CharField(max_length=255)
	instrument=models.CharField(max_length=255)


class Concert(models.Model):
	place=models.CharField(max_length=255)
	duration=models.CharField(max_length=255)
	awards=models.IntegerField()
	title=models.CharField(max_length=255)
