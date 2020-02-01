  $(function(){
    $.ajaxSetup ({
        cache: false, //关闭AJAX缓存
        async:true, //同步请求
        contentType:"application/x-www-form-urlencoded;charset=utf-8",  
        complete:function(XMLHttpRequest,textStatus){
            var curWwwPath = window.document.location.href;
            var pathName = window.document.location.pathname;
            var pos = curWwwPath.indexOf(pathName);
            var localhostPath = curWwwPath.substring(0,pos);
            var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
            if(XMLHttpRequest.status == 401){
                // alert("由于您长时间未操作,登录已失效,请重新登录");
                parent.location.href = localhostPath+"/login/lg";
            }
        },
        error : function (xhr,status,error){
          var curWwwPath = window.document.location.href;
          var pathName = window.document.location.pathname;
          var pos = curWwwPath.indexOf(pathName);
          var localhostPath = curWwwPath.substring(0,pos);
          var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
          if(xhr.status == 401){
            alert("由于您长时间未操作,登录已失效,请重新登录");
            parent.location.href = localhostPath+projectName+"/login/lg";
          }
        }  
    });
  }); 
