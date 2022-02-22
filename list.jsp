<%-- 
    Document   : list
    Created on : Feb 22, 2022, 11:04:32 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Product> pros = (ArrayList<Product>) request.getAttribute("pros");
            Integer totalpage = (Integer) request.getAttribute("totalpage");
            Integer pageindex = (Integer) request.getAttribute("pageindex");
        %>
        <link href="CSS/pagger.css" rel="stylesheet" type="text/css"/>
        <script src="JS/pagger.js" type="text/javascript"></script>
    </head>
    <body>
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>DVT</td>
                <td>NgaySX</td>
                <td>HanSD</td>
                <td>SoLuong</td>
                <td>GiaBan</td>
                <td>GiaBan</td>
            </tr>
            <% for (Product p : pros) {
            %>
            <tr>
            <form action="Session">
                <td><input type="hidden" name="masp" value="<%=p.getMasp()%>"><%=p.getMasp()%></td>
                <td><input type="hidden" name="name" value="<%=p.getTensp()%>"><%=p.getTensp()%></td>
                <td><input type="hidden" name="DVT" value="<%=p.getDVT() %>"><%=p.getDVT() %></td>
                <td><input type="hidden" name="NgaySX" value="<%=p.getNgaySX() %>"><%=p.getNgaySX() %></td>
                <td><input type="hidden" name="HanSD" value="<%=p.getHanSD() %>"><%=p.getHanSD() %></td>
                <td><input type="hidden" name="SoLuong" value="<%=p.getSoLuong() %>"><%=p.getSoLuong() %></td>
                <td><input type="hidden" name="GiaBan" value="<%=p.getGiaBan() %>"><%=p.getGiaBan() %></td>
                <td><input type="hidden" name="GiaBan" value="<%=p.getKeHang() %>"><%=p.getKeHang() %></td>
            </form>
        </tr>
        <%}%>
    </table><br>
    <div id="pagger" class="container"> </div>
    <script>
        pagger('pagger',<%=pageindex%>,<%=totalpage%>, 5);
    </script>
    </body>
</html>
