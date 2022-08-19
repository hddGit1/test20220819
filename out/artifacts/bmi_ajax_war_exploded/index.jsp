
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>bmi-ajax练习</title>
    <style type="text/css">
      div{
        width: 300px;
        height: 120px;
        background: aqua;
      }
    </style>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
      $(function () {
        $("#btn").click(function () {
          $.ajax({
            url : "bbb",
            data :"name=" +$("#name").val()+"&weight="+$("#weight").val()+"&height="+$("#height").val(),
            success : function (resp) {
              $("#div").html(resp)
            }
          })
        })
      })
    </script>
  </head>
  <body>
  <p>全局刷新计算bmi</p>
  姓名：<input type="text" id="name"><br>
  体重（公斤）: <input type="text" id="weight"><br>
  身高（米）：<input type="text" id="height"><br>
    <input type="button" id="btn" value="提交"><br>
    结果：<div id="div"></div>
  </form>
  </body>
</html>
