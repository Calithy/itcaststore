$(document).ready(function () {

    //大图片滚动
	    var settime;//定义定时器
	    var height = $(".slider li").height();//图片高度
	    var index = 0;//图片索引
	    var len = $(".slider li").length;
	    //图片移动方法 
	    function showimg(index) {
	        $(".slider").animate({ top: -height * index }, 700);
	        $(".num li").removeClass("on").eq(index).addClass("on");
	    }
	    //悬停事件
	    $(".slider").hover(function () {
	        clearInterval(settime);//鼠标滑入清楚定时器
	    }, function () {
	        settime = setInterval(function () {
	            showimg(index);
	            index++;
	            if (index == len) {
	                index = 0;

	            }
	        }, 2000)
	    }).trigger("mouseleave")
	    //鼠标放在小数字上
	    $(".num li").mouseover(function () { //鼠标放在数字上的方法
	        index = $(".num li").index(this); //值为选中的li的索引
	        showimg(index);
	        clearInterval(settime);
	    })
 
	})
 