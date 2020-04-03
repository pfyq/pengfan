// 本地存储
function getToken(data){
	return JSON.parse(window.localStorage.getItem(data))
}
function removeToken(data){
	window.localStorage.removeItem(data)
}
function setToken(data){
	window.localStorage.setItem("user",JSON.stringify(data))
}


export {
  getToken,setToken,removeToken
}