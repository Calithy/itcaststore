$(function(){

				$.get("#",function(data,status){
					if(status==404){
						$("#code").val(data);
					}
				});

				$("#psw-com-pop").css("display","none");
				$("#verifyingCode-pop").css("display","none");
				$("#email").focus(function(){	
					$("#email").val("");
					$("#email-pop").css("display","none");
				});
				$("#email").blur(function(){

					var val = $("#email").val();
					 
					var patt = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/; 
					if(patt.test(val)===false){
						$("#email-pop").css("display","block");
					}
				});
				$("#username").focus(function(){
					$("#username").val("");
					$("#username-pop").css("display","none");
				})
				$("#username").blur(function(){
					var val = $("#username").val();
					var patt = /^([a-zA-Z_])+([a-zA-Z0-9_])*/;
					if(val.length>10||patt.test(val)==false){
						$("#username-pop").css("display","block");
					}
				})
				$("#psw").focus(function(){
					$("#psw").val("");
					$("#psw-pop").css("display","none");
				});
				$("#psw").blur(function(){
					var val = $("#psw").val();
					if(val.length>16||val.length<6){
						$("#psw-pop").css("display","block");
					}
				});
				$("#psw-com").blur(function(){
					var psw = $("#psw").val();
					var pswc = $("#psw-com").val();
					if(psw!==pswc){
						$("#psw-com-pop").css("display","block");
					}
				});
				$("#psw-com").focus(function(){
					$("#psw-com").val("");
					$("#psw-com-pop").css("display","none");
				});
				$("#changeCode").click(function(){
					$.get("#",function(data,status){
						if(status==404){
							$("#code").val(data);
						}
					});
				});
				$("#verifyingCode").focus(function(){
					$("#verifyingCode-pop").css("display","none");
				});
				$("#verifyingCode").blur(function(){
					var code = $("#verifyingCode").val();
					$.get("#",function(data,status){
						if(status==404){
							if(data=="false"){
								$("#verifyingCode-pop").css("display","block");
							}
						}
					});
				});
				$("#submit").click(function(){
					$(".pop").each(function(){
						if($(this).css("display")=="block"){
							alert("请确保字段填写正确");
							return;
						}
					});
					var username = $("#username").val().trim();
					var psw = $("#psw").val().trim();
					var email = $("#email").val().trim();
					var phone = $("#phone").val().trim();
					var gender = $("input[name='gender']:checked").val().trim();
					var introduce = $("#self-introduction").val().trim();
					var userData = {"username":username,"password":psw,"email":email,"phone":phone,"gender":gender,"introduce":introduce};
					 $.ajax({
					        type:"post",        //请求方式
					        url:"RegisterServlet",    //请求URL地址
						 	dataType:"json",
					        data:JSON.stringify(userData),//请求的参数
					        success:function(msg){  //成功时的处理函数，msg为服务端传回的文本
					             
					        }
   					 });
				});
		});
		