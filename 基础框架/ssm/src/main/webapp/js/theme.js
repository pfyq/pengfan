var $top_cpic = $("#top_cpic");
var $easyuiTheme = $('#easyuiTheme');
var type = $.cookie('easyuiThemeName');
changeTheme(type);
function changeTheme(themeName) { 
	if(themeName == undefined){
		themeName = 'default';
	}
    var url = $easyuiTheme.attr('href');  
    var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';  
    $easyuiTheme.attr('href', href);  
    var $iframe = $('iframe');  
    if ($iframe.length > 0) {  
        for ( var i = 0; i < $iframe.length; i++) {  
            var ifr = $iframe[i];  
            $(ifr).contents().find('#easyuiTheme').attr('href', href);  
        }  
    }
    changeColor(themeName);
    $.cookie('easyuiThemeName', themeName, {  
        expires : 7  
    });  
}; 

function changeColor(themeName) {
    if ("default" == themeName) {
          $top_cpic.css("background", "#E0ECFF");
    } else if ("gray" == themeName) {
          $top_cpic.css("background", "#f3f3f3");
    } else if ("sunny" == themeName) {
          $top_cpic.css("background", "#817865");
    } else if ("black" == themeName){
          $top_cpic.css("background", "#3D3D3D");
    }
}

function iframeTheme(){
	type = (type == 'undefined'?'default':type);
	var url = $easyuiTheme.attr('href');  
    var href = url.substring(0, url.indexOf('themes')) + 'themes/' + type + '/easyui.css';  
	var $iframe = $('iframe');  
    if ($iframe.length > 0) {  
        for ( var i = 0; i < $iframe.length; i++) {  
            var ifr = $iframe[i];  
            $(ifr).contents().find('#easyuiTheme').attr('href', href);  
        }  
    }
}
