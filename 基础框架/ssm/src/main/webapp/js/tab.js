var $tree_user=$('#tree_user');
var $tree_plate=$('#tree_plate');
var $tree_member=$('#tree_member');
// var $tree_school=$('#tree_school');
var $tree_video=$('#tree_video');
// var $tree_question=$('#tree_question');
// var $tree_paper=$('#tree_paper');
var $tree_article=$('#tree_article');
// var $tree_information=$('#tree_information');
var $tb_tab=$('#tb_tab');
var url=null;
//给#tree_generate添加点击事件
$tree_user.tree({
	url : '../tree?r='+Math.random(),
	queryParams: {"id":"tree_user"},
	onLoadSuccess:function(node,data){
	},
	onClick:function(node){
		setParentParam(node.id);
		url='../html/'+node.id+'.html?r='+Math.random();
		updTab(url,node.text);
	}
});

$tree_plate.tree({
    url : '../tree?r='+Math.random(),
    queryParams: {"id":"tree_plate"},
    onLoadSuccess:function(node,data){
    },
    onClick:function(node){
        setParentParam(node.id);
        url='../html/'+node.id+'.html?r='+Math.random();
        updTab(url,node.text);
    }
});

$tree_member.tree({
    url : '../tree?r='+Math.random(),
    queryParams: {"id":"tree_member"},
    onLoadSuccess:function(node,data){
    },
    onClick:function(node){
        setParentParam(node.id);
        url='../html/'+node.id+'.html?r='+Math.random();
        updTab(url,node.text);
    }
});

// $tree_school.tree({
// 	url : '../tree?r='+Math.random(),
// 	queryParams: {"id":"tree_school"},
// 	onLoadSuccess:function(node,data){
// 	},
// 	onClick:function(node){
// 		setParentParam(node.id);
// 		url='../html/'+node.id+'.html?r='+Math.random();
// 		updTab(url,node.text);
// 	}
// });
//
$tree_video.tree({
	url : '../tree?r='+Math.random(),
	queryParams: {"id":"tree_video"},
	onLoadSuccess:function(node,data){
	},
	onClick:function(node){
		setParentParam(node.id);
		url='../html/'+node.id+'.html?r='+Math.random();
		updTab(url,node.text);
	}
});
//
// $tree_question.tree({
// 	url : '../tree?r='+Math.random(),
// 	queryParams: {"id":"tree_question"},
// 	onLoadSuccess:function(node,data){
// 	},
// 	onClick:function(node){
// 		setParentParam(node.id);
// 		url='../html/'+node.id+'.html?r='+Math.random();
// 		updTab(url,node.text);
// 	}
// });
//
// $tree_paper.tree({
// 	url : '../tree?r='+Math.random(),
// 	queryParams: {"id":"tree_paper"},
// 	onLoadSuccess:function(node,data){
// 	},
// 	onClick:function(node){
// 		setParentParam(node.id);
// 		url='../html/'+node.id+'.html?r='+Math.random();
// 		updTab(url,node.text);
// 	}
// });
//
$tree_article.tree({
	url : '../tree?r='+Math.random(),
	queryParams: {"id":"tree_article"},
	onLoadSuccess:function(node,data){
	},
	onClick:function(node){
		setParentParam(node.id);
		url='../html/'+node.id+'.html?r='+Math.random();
		updTab(url,node.text);
	}
});

// $tree_information.tree({
// 	url : '../tree?r='+Math.random(),
// 	queryParams: {"id":"tree_information"},
// 	onLoadSuccess:function(node,data){
// 	},
// 	onClick:function(node){
// 		setParentParam(node.id);
// 		url='../html/'+node.id+'.html?r='+Math.random();
// 		updTab(url,node.text);
// 	}
// });

function updTab(url,text){
	if(url == null){
		return;
	}
	var selTab = $tb_tab.tabs('getSelected');
	$tb_tab.tabs('update', { 
		tab: selTab, 
		options: { 
			title  : text,
			content:createFrame(url) 
		} 
	});
}

/*tab添加事件*/
$('#tb_tab').tabs({
	onContextMenu : function(e, title, index) {//e是点击对象
		e.preventDefault();//阻止默认设置。
		currentTabIndex = index;
		if(index > 0){
			$('#mm').menu('show', {//显示被默认为隐藏的菜单mm
				left : e.pageX,//设置菜单显示的位置
				top : e.pageY
				//获取点击位置的坐标，在页面中的位置
			});
		}
	}
});

//获取iframe
function createFrame(url){ 
	return "<iframe src="+url+" style='width:100%;height:100%;border:0px;'></iframe>";
}

//菜单关闭tab
function menuHandlerHold(item) {
	if (item.name == 1) {
		//alert(currentTabIndex);
		if (currentTabIndex != -1) {
			$('#tb_tab').tabs('close', currentTabIndex);
			//alert(item.name);
		}
	}
	if(item.name==3||item.name==2){
		closeAll(item.name);
	}

}

//关闭所有tab
function closeAll(j) {
	//var currEngName = engName;
	//engName = undefined;
	$(".tabs li").each(function(index, obj) {  
		//获取所有可关闭的选项卡     在中间会有一个选中选项卡的过程,就好像有两个线程一样。
		var tab = $(".tabs-closable", this).text();
		//alert(currentTabIndex+">>"+$(obj).find("span:eq(0)").text());
		if(j==2&&index!=currentTabIndex){
			$(".easyui-tabs").tabs('close', tab);
		}else if(j==3){
			$(".easyui-tabs").tabs('close', tab); 
		}
		if(j == 2 && index == currentTabIndex){
			//engName = currEngName;
			// tabOpen($(obj).find("span:eq(0)").text());
			$('#tb_tab').tabs('select',$(obj).find("span:eq(0)").text());
		}
	});
}  		
