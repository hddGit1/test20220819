
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>省市级联查询</title>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
      $(function () {
        $.ajax({
          url : "queryProvince",
          dataType : "json",
          success : function (resp) {//{"id":1,"jiancheng":"冀","name":"河北","shenghui":"石家庄"}
                $.each(resp,function (i,n) {
                        $("#province").append("<option value="+n.id+">"+n.name+"</option>")
                })
          }
        })
        $("#province").change(function () {
            var obj = $("#province>option:selected");
            var provinceId = obj.val();
            $.ajax({
                url : "queryCity",
                data : "proid="+ provinceId,
                dataType : "json",
                success : function (resp) {
                    $("#city").empty();
                    $.each(resp,function (i,n) {
                        $("#city").append("<option value="+n.id+">"+n.name+"</option>")
                    })
                }

            })
        })
      })
    </script>
  </head>
  <body>
  <p>省市级联查询</p>
  省份名称：
  <select id="province">
    <option value="0">--请选择--</option>
  </select><br>
  城市名称：
  <select id="city">
    <option value="0">--请选择--</option>
  </select>
  </body>
</html>
