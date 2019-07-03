//根据传递过来的参数name获取对应的值
function getParameter(name) {
    // 这个中文乱码没解决
    // var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    // var r = location.search.substr(1).match(reg);
    // if (r!=null) return (r[2]); return null;

    // 获取参数
    var url = window.location.search;
    // 正则筛选地址栏
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    // 匹配目标参数
    var result = url.substr(1).match(reg);
    //返回参数值
    return result ? decodeURIComponent(result[2]) : null;
}