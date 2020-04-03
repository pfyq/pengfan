
import qs from 'qs'

// document.write("<script src='wjyjs/util.js'></script>");

/*获取路径上的参数值*/
function getQueryString(name) {
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
  console.log(window.location.search);
  var r = window.location.search.substr(1).match(reg);
  if (r != null) return unescape(r[2]);
  return null;
}


/**
 * 处理url链接
 * @returns {string}
 */
function processUrl () {
  const url = window.location.href
  // 解决多次登录url添加重复的code与state问题
  const urlParams = qs.parse(url.split('?')[1])
  let redirectUrl = url
  if (urlParams.code && urlParams.state) {
    delete urlParams.code
    delete urlParams.state
    const query = qs.stringify(urlParams)
    if (query.length) {
      redirectUrl = `${url.split('?')[0]}?${query}`
    } else {
      redirectUrl = `${url.split('?')[0]}`
    }
  }
  return redirectUrl
}

function responseDeal(ret){
  if(ret.code == 200){
     return true;
  }else if(ret.code == 500){
      alert(ret.message);
      return false;
  }
}

export {
  getQueryString,processUrl,responseDeal
}