<%--
  Created by IntelliJ IDEA.
  User: 听音乐的酒
  Date: 2018/11/15
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>A跨域请求</title>
    <script src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                $.get({
                    url:"http://localhost:8888/JSONP-B/jsonServlet",
                    /*dataType:"jsonp",                       //指定入服务器返回的数据类型
                    jsonpCallback :"callback",             //指定回调函数名称*/
                    success:function (data) {
                        var  result = JSON.stringify(data);
                        $("#show").text(result);
                    }
                    })
                })
            })
    </script>
  </head>
  <body>
        A跨域请求
        <input type="button" id="btn" value="A发送跨域请求">
        <div id="show">

        </div>
        <img src="http://localhost:8888/JSONP-B/img/01.jpg">
  </body>
</html>
