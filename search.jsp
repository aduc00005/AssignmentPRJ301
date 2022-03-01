<%-- 
    Document   : search
    Created on : Feb 26, 2022, 9:57:35 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.DanhMuc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <%
            ArrayList<DanhMuc> LoaiSP = (ArrayList<DanhMuc>)request.getAttribute("LoaiSP");
            ArrayList<Product> Pros = (ArrayList<Product>)request.getAttribute("products");
            String maLoaiSP = (String)request.getAttribute("MaLoaiSP");
        %>
                <script>
            function submitSearchForm()
            {
                document.getElementById("searchForm").submit();
            }
            
            function deleteStudent(id)
            {
                var result = confirm("Are you sure?");
                if(result)
                {
                    window.location.href = "../product/delete?id="+id;
                }
            }
            
        </script>
    </head>
    <body>
        <form id="searchForm" method="GET" action="search"> 
            Department: <select name="MaLoaiSP" onchange="submitSearchForm();">
                <option value="all">----Chọn tất cả sản phẩm----</option>
                <% for (DanhMuc d : LoaiSP) {
                %>
                <option 
                    <%=(d.getMaLoaiSP().equalsIgnoreCase(maLoaiSP))?"selected=\"selected\"":""%>
                    value="<%=d.getMaLoaiSP()%>"><%=d.getLoaiSP()%></option>
                <%}%>
            </select> <br/>
        </form>
        <br/>
        <% if(Pros.size() >0){ %>
        <table border="1px">
            <tr>
                <td>Mã sản phẩn</td>
                <td>Tên Sản Phẩm</td>
                <td> DVT </td>
                <td>Ngày sản xuất</td>
                <td>Hạn sử dụng</td>
                <td>Kệ Hàng Số</td>
                <td> Số lượng</td>
                <td>Giá</td>
                <td></td>
            </tr>
            <% for (Product p : Pros) {
            %>
                <tr>
                    <td><%=p.getMasp()%></td>
                    <td><%=p.getTensp()%></td>
                    <td><%=p.getDVT()%></td>
                    <td><%=p.getNgaySX() %></td>
                    <td><%=p.getHanSD()%></td>
                    <td> <%=p.getKeHang() %></td>
                    <td><%=p.getSoLuong() %> </td>
                    <td> <%=p.getGiaBan() %> </td>
                    <td><a href="edit?id=<%=p.getMasp()%>">Edit</a> 
                        <a href="#" onclick="deleteStudent(<%=p.getMasp() %>);" >Delete</a></td>
                </tr>
            <%}%>
        </table>
        <%}else{%>
        No record to display.
        <%}%>
        <br/>
    </body>
</html>
