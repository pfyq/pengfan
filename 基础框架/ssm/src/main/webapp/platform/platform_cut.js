$(function() {
			var k_host = document.domain;
			//alert(k_host);
			var fourcx="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31010402000328";
			var fourcxhaoma="沪公网安备 31010402000328号"
			
			var fourgl="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31010402000329";
			var fourglhaoma="沪公网安备 31010402000329号"
			
			var foursungoin="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31010402000330";
			var foursungoinhaoma="沪公网安备 31010402000330号"
			
			var fourqq4009="http://www.miibeian.gov.cn/";
			var fourqq4009haoma="粤ICP备12010147号"
			
			if(k_host == "www.400cx.com") {
				$("#beianpath").attr("href", fourcx);
				$("#beianhaoma").html(fourcxhaoma);
			} else if(k_host == "www.400gl.com") {
				$("#beianpath").attr("href", fourgl);
				$("#beianhaoma").html(fourglhaoma);
			} else if(k_host == "www.sungoin.cn") {
				$("#beianpath").attr("href", foursungoin);
				$("#beianhaoma").html(foursungoinhaoma);
			} else if(k_host == "www.qq4009.cn") {
				$("#beianpath").attr("href", fourqq4009);
				$("#beianhaoma").html(fourqq4009haoma);
			}
		});

		function closeErrDiv(){
			$("#errMsgDiv").css('display','none'); 
			$("#bg").css('display','none'); 
		}
	    var checkSign = false;
	   	function checkbox() {
	   		if (checkSign==true) {
				$("#radioPass").checked="";
			 	checkSign=false;
	   		} else if(checkSign==false) {
	   			$("#radioPass").checked="checked";
			 	checkSign=true;
	    	}
	    }
        function loginSubmit() {
            if (verification()) {
                var userName = $("#userNameIpt").val();
                if(userName.indexOf("@") == -1){
                    alert("请用 工号@400号码 作为用户名登录");
                    return false;
                }
                
                /* var password = $("#password").val();
                if(password=='111111'){
                	if(userName.substring(0,4)=='boss'){
                		alert("您的密码过于简单已被系统重置，请尝试找回密码或联系客服人员");
                	}else{
                		alert("您的密码过于简单已被系统重置，请boss账号为您重置密码");
                	}
                	return false;
                } */
                
                var loginInfo = userName+" ";
                $.cookie("cloginInfo", des(des_key, loginInfo, 1), {
                    path : '/',
                    secure : false,
                    expires : 30
                });
                if (checkSign==true) {
					var userNameIpt=$("#userNameIpt").val();
					var password=$("#password").val();
					var info =userNameIpt+","+password;
					$.cookie("myUserInfo", info,{path: '/' , secure: false,expires: 30});	
				 }else{
					var inf ="";
					$.cookie("myUserInfo",inf,{path: '/' , secure: false,expires: 30});
				 }
//                 $("#password").val(hex_md5($("input[name='password']").val()));
                $("#loginForm").submit();
            }
        }
        
        function selectCode() {
            $('#Code').attr("src", "/platform/loginstickyImg?math=true&rand="+Math.random());
		}
		    
        $(function() {
        	if(""=="1"){
        		layer.alert("<font color='black'>用户名或登录密码不正确，请重新输入。您还可以：<a href='/platform/jsp/backPass/400NumCenter.jsp'>重置登录密码</a></font>");
        	}else if(""=="2"){
        		layer.alert("<font color='black'>用户名或登录密码不正确，还有3次机会。您还可以：<a href='/platform/jsp/backPass/400NumCenter.jsp'>重置登录密码</a></font>");
        	}else if(""=="3"){
        		layer.alert("<font color='black'>用户名或登录密码不正确，还有2次机会。您还可以：<a href='/platform/jsp/backPass/400NumCenter.jsp'>重置登录密码</a></font>");
        	}else if(""=="4"){
        		layer.alert("<font color='black'>用户名或登录密码不正确，还有1次机会。您还可以：<a href='/platform/jsp/backPass/400NumCenter.jsp'>重置登录密码</a></font>");
        	}else if("">="5"){
        		layer.alert("<font color='black'>登录密码出错已达上限将锁定登录3小时,请<a href='/platform/jsp/backPass/400NumCenter.jsp'>重置登录密码</a>后登录!</font>");
        	}else{
	            if (""=="simplePassword") {
	                var win = $("#cpws").window({
						title 	: "修改密码",
						closed	: true,
		    			modal	: true,
		    			width	: 450,
		    			height	: 300
					});
					win.window('open');
	            }else if(""!=""){
	                layer.alert("<font color='black'></font>");
	                return;
	            }
        	}
            if ("" != "") {
                layer.alert("<font color='black'>您已在其他地方登录！</font>");
                //return;
            }
           /* if ($.cookie("cloginInfo")) {
                var info =des(des_key,$.cookie("cloginInfo"),0); 
                info=info.split(",");
                if(info.length > 1){
	                $("#userNameIpt").val(info[1]);
                }else{
                    $("#userNameIpt").val(info[0].trim());
                }
            }*/
            var userInfoStr=null;	
			if(userInfoStr!="undefined" && userInfoStr!=null && userInfoStr!="" ){				
				var data=userInfoStr.split(",");
				$("#userNameIpt").val(data[0]);
				$("#password").val(data[1]);
				document.getElementById("radioPass").checked="checked";
// 	   			alert($("#radioPass").is(":checked"));
				checkSign=true;
			}
        });

        //变量定义
        var gLoginInfo = {};

        //清除联络中心Tab cookie
        $.cookie("admin_currentTab", null, {
            path : "/"
        });
        $.cookie("currentTab", null, {
            path : "/"
        });

function closeFormPwd() {
	$("#cpws").window('close');
} 

function submitFormPwd() {
	if($("#password2").val() == "") {
		alert("请输入原密码");
		return;
	}
	if($("#newPwd").val() == "") {
		alert("请输入新密码");
		return;
	}
	if($("#valiPwd").val() == "") {
		alert("请输入确认密码");
		return;
	}
	if ($("#password2").val() == $("#newPwd").val()) {
           alert("原密码和新密码不能一样");
           return;
    }
	var reg = /(?=.*[0-9])(?=.*[a-zA-Z])(?=([\x21-\x7e]+)[^a-zA-Z0-9]).{8,30}/;
	if(!reg.test($("#newPwd").val())) {
		alert("新密码必须包含数字，字母及特殊符号,并且在8位以上");
		return;
	}
	
	if($("#newPwd").val() != $("#valiPwd").val()) {
		alert("新密码必须和确认密码一致");
		return;
	}
	
	$.post("/platform/common/changeLoginPassword.do", {
		header_password : $("#password2").val(),
		header_newPwd : $("#newPwd").val(),
		header_valiPwd : $("#valiPwd").val()
	},function(data){
		if(data.result == "true") {
			alert("密码修改成功,请妥善保管");
			closeFormPwd();
		} else {
			alert(data.message);
		}
	});	
}   

function validatePassword(elem){
	var password = $(elem).val();
	$.post("/platform/common/validateUserPassword.do", {
		password : $("#password2").val(),
	},function(data){
		if(data == "success") {
			$("#password2Red").hide();
            $("#password2Green").show();    
		} else {
			$("#password2Red").show();
            $("#password2Green").hide();
		}
	});
}

function validateOldAndNewPass(elem,elemName){
	var password = $(elem).val();
	password=password.replace(/\s+/g, "");
	var reg = /(?=.*[0-9])(?=.*[a-zA-Z])(?=([\x21-\x7e]+)[^a-zA-Z0-9]).{8,30}/;
	if(elemName=='newPwd'){
		if(!reg.test(password)) {
			$("#newPwdRed").show();
			$("#newPwdGreen").hide();
			
			$("#newPwdRed").html('密码不符合规则');
		}else{
			$("#newPwdRed").html('');
			
			$("#newPwdRed").hide();
			$("#newPwdGreen").show()
		}
	}
	if(elemName=='valiPwd'){
		if($("#newPwd").val()!=$("#valiPwd").val()){
			$("#valiPwdRed").html('确认密码和新密码不一致');
			$("#valiPwdRed").show();
			$("#valiPwdGreen").hide();
		}else{
			$("#valiPwdRed").html('');
			$("#valiPwdRed").hide();
			$("#valiPwdGreen").show();
		}
	}
}