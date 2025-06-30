from django import forms
from .models import Employee,Product
class InsertEmpForm(forms.ModelForm):
	class Meta:
		model=Employee
		fields='__all__'
class DeleteEmpForm(forms.Form):
	emp_no=forms.IntegerField()
class InsertProFrom(forms.ModelForm):
	class Meta:
		model=Product
		fields='__all__'
class UpdateProForm(forms.Form):
	name=forms.CharField(max_length=25)
	qty=forms.IntegerField()
class ProductIdForm(forms.Form):
	name=forms.CharField(max_length=25)
