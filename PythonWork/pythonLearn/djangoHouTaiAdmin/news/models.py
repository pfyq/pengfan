from django.db import models

# Create your models here.
class News(models.Model):
    title = models.CharField(u'标题', max_length=256)
    content = models.TextField(u'内容')

    create_date = models.DateTimeField(u'发表时间', auto_now_add=True, editable=True)
    update_time = models.DateTimeField(u'更新时间', auto_now=True, null=True)

    def __str__(self):
        return self.title