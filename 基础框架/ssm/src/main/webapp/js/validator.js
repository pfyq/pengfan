// JavaScript Document
Validator = {
	cObj:null,
	cVld:"",
	EMPTY : /.+/,
	EMAIL : /^(.+)@(.+)$/,
	CARD :/^\d{17}(\d|x)$/,
	INT :/^(-|\+)?\d+$/,
	Validate:function(theForm){	
		try{
			var obj = theForm || event.srcElement;
			var count = obj.elements.length;
			for(var i=0;i<count;i++){
				var currObj = obj.elements[i];
				this.cObj = currObj;//	
				with(currObj){
					var vldstr = getAttribute("vld");
					var customVldstr = getAttribute("customVld");
					var msgstr = getAttribute("msg");					
					if(vldstr!=null && vldstr!=""){
						var vlds = "";
						if(vldstr!=null && vldstr!=""){
							vlds = vldstr.split(";");
						}
						var msgs = "";
						if(msgstr!=null && msgstr!=""){
							msgs = msgstr.split(";");
						}
						for(var j=0;j<vlds.length;j++){
							this.cVld = vlds[j];//
							if(vlds[j].indexOf("(") != -1){
								if(!this.vldMethodErr()){					
									return this.stop_(currObj,msgs[j]);
								}
							}else{
								if(!this.vldConstErr()){
									return this.stop_(currObj,msgs[j]);
								}
							}
						}						
					}
					if(customVldstr!=null && customVldstr!=""){					
						var customVlds = "";
						if(customVldstr!=null && customVldstr!=""){
							customVldstr.split(";");
						}
						for(var j=0;j<customVlds.length;j++){
							if(!eval(customVlds[j])){
								  return false;
							}
							//return eval(customVlds[j]);
						}
					}
				}
			}
		}
		catch(e){alert(e.description);}
		return true;
	},	
	vldConstErr:function(){
		return (eval("this."+this.cVld).test(this.delTrim(this.cObj.value)))
	},
	vldMethodErr:function(){
		return eval("this."+this.cVld);
	},	
	stop_:function(obj,msg){		
		window.alert(msg);
		obj.focus();
		return false;
	},
	delTrim:function(str){
		return str.replace(/(^\s*)|(\s*$)/g, "");
	},
	getLen:function(str){ 
		return str.length;//字符
		//return str.replace(/[^\x00-\xff]/g, "**").length;//字节		
	},	
	len:function(start,end){
		var len = this.getLen(this.cObj.value)
		if(len<start || len>end){			
			return false;
		}
		return true;
	},
	number:function(){
		if(this.cObj.value=="")
			return false;
		return !isNaN(this.delTrim(this.cObj.value));
	},
	intArea:function(min_,max_){		
		if(parseInt(this.cObj.value)<min_ || parseInt(this.cObj.value)>max_){
			return false;
		}
		return true;
	}
	
}

//验证单选项
function checkRadio(obj,type,msg){
	if(type=="1"){
		if(obj.checked==false){
			alert(msg);
			obj.focus();
			return false;
		}
	}else if(type=="n"){
		var flag = false;
		for (var tmp = 0; tmp < obj.length; tmp++)
		{ 		 
			if(obj[tmp].checked==true){
				flag = true;
			}
		}
		if(!flag){
			alert(msg);
			obj[0].focus();
			return false;	
		}
		
	}	
	return true;
}	

//验证复选项
function checkCheckBox(obj,type,msg){
	if(type=="1"){
		if(obj.checked==false){
			alert(msg);
			obj.focus();
			return false;
		}
	}else if(type=="n"){
		var flag = false;
		for (var tmp = 0; tmp < obj.length; tmp++)
		{ 		 
			if(obj[tmp].checked==true){
				flag = true;
			}
		}
		if(!flag){
			alert(msg);
			obj[0].focus();
			return false;	
		}
		
	}	
	return true;
}


//onSubmit="return Validator.Validate(this)"
//vld="EMPTY"  msg="不能为空"
//customVld="checkRadio(myform.cb,'n','x?')"
//customVld="checkCheckBox(myform.cb,'n','x?')"