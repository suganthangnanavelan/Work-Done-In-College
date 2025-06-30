from django.db import models

# Create your models here.
class Players(models.Model):
	name=models.CharField(max_length=255)
	team=models.CharField(max_length=255)
	jersey_no=models.IntegerField()