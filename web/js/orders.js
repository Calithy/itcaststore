$(function(){
	$("#delete").click(function(){
		var isDelete = confirm("确定删除该订单吗？");
		if(isDelete==true){
			
		}else{
			window.location.reload();
		}
	});
});