from django.db import models

# Create your models here.
class Staff(models.Model):
    sid=models.IntegerField()
    sname=models.CharField(max_length=20)
    sage=models.IntegerField()
    sdept=models.CharField(max_length=20)
    def __str__(self):
        return str(self.sid)+" "+self.sname+" "+str(self.sage)+" "+sdept
