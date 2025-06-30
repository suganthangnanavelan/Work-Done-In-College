class UnderWeight(Exception):
    def __init__(self,msg):self.msg=msg
    def __str__(self):return self.msg

class OverWeight(Exception):
    def __init__(self,msg):self.msg=msg
    def __str__(self):return self.msg

class Obese(Exception):
    def __init__(self,msg):self.msg=msg
    def __str__(self):return self.msg
