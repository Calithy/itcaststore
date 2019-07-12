
$(function(){
         $("#loginbutton").click(function(){
            var u_name = $("#username").val();
            var pwd = $("#password").val();
            var userDate = {"username":u_name,"password":pwd};
            $.ajax({
                type:"post",        //请求方式
                url:"LoginServlet",    //请求URL地址
                dataType:"json",
                data:JSON.stringify(userDate),//请求的参数
                success:function(msg){
                    //成功时的处理函数，msg为服务端传回的文本
                },
         })
         });
    /**
     * JSON执行完成后执行
     */
    $(document).ajaxComplete(function(event, xhr, settings){
            console.log("complete");
            var url = xhr.getResponseHeader("redirectUrl");
            var enable = xhr.getResponseHeader("enableRedirect");
            if((enable == "true") && (url != "")){
                var win = window;
                while (win != win.top){
                    win = win.top;
                }
                win.location.href = url;
            }
    });
});
