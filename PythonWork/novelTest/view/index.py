from django.http import HttpResponse
from django.shortcuts import render
# from utils.mysql_DBUtils import mysql

# 《星辰变》章节列表
def main(request):
    # sql = "SELECT id,title FROM fx_goods LIMIT 10;"
    # result = mysql.getAll(sql)
    # result = json.dumps(result, cls=MyEncoder, ensure_ascii=False, indent=4)
    # result = json.loads(result)
    result = {"id":1,"title":"你好"}
    context = {'novel_list': result}
    return render(request, 'novel_list.html',  context)