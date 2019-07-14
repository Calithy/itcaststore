$(function(){
	$("input[name=minus]").click(function(){
		var amou = $("input[name=amount]").val();
		$("input[name=amount]").val(amou-1);
	});
	$("input[name=plus]").click(function(){
		var amou = $("input[name=amount]").val();
		$("input[name=amount]").val(amou+1);
	});
});