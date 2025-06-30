from django import forms
from .models import Staff
class Staff_form(forms.ModelForm):
    class Meta:
        model=Staff
        fields="__all__"
