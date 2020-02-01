from django.contrib import admin
# 在admin中注册模型
from . import models

# Register your models here.
admin.site.register(models.User)