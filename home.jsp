<%-- 
    Document   : home
    Created on : Mar 16, 2022, 12:16:09 PM
    Author     : Admin
--%>

<%@page import="model.Data"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title> Trang chủ </title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="../CSS/styles.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/pagger.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <%
            ArrayList<Product> productMaxQ = (ArrayList<Product>) request.getAttribute("productMaxQ");
            ArrayList<Product> productLowQ = (ArrayList<Product>) request.getAttribute("productLowQ");
            ArrayList<Product> productHHSD = (ArrayList<Product>) request.getAttribute("productHHSD");
            ArrayList<Product> productTKLN = (ArrayList<Product>) request.getAttribute("productTKLN");
            ArrayList<Data> dat = (ArrayList<Data>) request.getAttribute("data");
        %>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="home">Tác Vụ</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form action="../action/search" class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input name="text"  class="form-control" type="text" placeholder="Tìm kiếm..." aria-label="Tìm kiếm..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="submit"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="../account/resetpassword">Đổi Mật Khẩu</a></li>
                        <li><a class="dropdown-item" href="../loginn.html">Đăng xuất</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Biểu đồ</div>
                            <a class="nav-link" href="home">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Báo cáo dữ liệu
                            </a>
                            <div class="sb-sidenav-menu-heading">Sản phẩm</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Sản phẩm
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="../product/search">Danh sách sản phẩm</a>
                                    <a class="nav-link" href="../product/insert">Thêm sản phẩm</a>
                                </nav>
                            </div>

                            <div class="sb-sidenav-menu-heading"> Nguồn Hàng</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Nguồn Hàng
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="../nguon/search">Danh sách nguồn hàng</a>
                                    <a class="nav-link" href="../nguon/insert">Thêm nguồn hàng</a>
                                </nav>
                            </div>

                            <div class="sb-sidenav-menu-heading"> Các Loại sản phẩm </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Các Loại sản phẩm trong cửa hàng
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="../loaisp/search">Danh sách Các Loại sản phẩm</a>
                                    <a class="nav-link" href="../loaisp/insert">Thêm Loại sản phẩm</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Trang
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Tài Khoản
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="../loginn.html">Đăng nhập</a>
                                            <a class="nav-link" href="../register.html">Đăng Xuất</a>
                                            <a class="nav-link" href="../password.html">Quên Mật Khẩu</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                        </div>
                    </div>

                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Sản phẩm</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dữ liệu về sản phẩm</li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-6 col-md-6">
                                <div class="left"><h4>Sản phẩm còn với số lượng lớn</h4>
                                    <button class="btn btn-primary"   onclick="showmore(event)"><div id="more1"> Xem thêm </div> <div style="display: none" id="hide1"> Ẩn bớt</div></button>
                                    <% if (productMaxQ.size() > 0) { %>
                                    <div id="table1" style="display: none"><br>
                                        <table class="tableshow">
                                            <thead>
                                                <tr>
                                                    <th>Mã sản phẩn</th>
                                                    <th>Tên Sản Phẩm</th>
                                                    <th> DVT </th>
                                                    <th>Ngày sản xuất</th>
                                                    <th>Hạn sử dụng</th>
                                                    <th>Ngày Nhập Kho</th>
                                                    <th>Kệ Hàng Số</th>
                                                    <th> Số lượng</th>
                                                    <th>Giá</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% for (Product p : productMaxQ) {
                                                %>
                                                <tr>
                                                    <td><%=p.getMasp()%></td>
                                                    <td><%=p.getTensp()%></td>
                                                    <td><%=p.getDVT()%></td>
                                                    <td><%=p.getNgaySX()%></td>
                                                    <td><%=p.getHanSD()%></td>
                                                    <td><%=p.getNgayNhapKho()%></td>
                                                    <td><%=p.getKeHang()%></td>
                                                    <td><%=p.getSoLuong()%> </td>
                                                    <td><%=p.getGiaBan()%> </td>
                                                </tr>
                                                <%}%>
                                            </tbody>
                                        </table>
                                        <%} else {%>
                                        Hiện không có sản phẩm nào!
                                        <%}%>
                                        <br/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-6 col-md-6">
                                <div class="left"><h4>Sản phẩm có số lượng ít</h4>
                                    <button class="btn btn-primary"   onclick="showmore2(event)"><div id="more2"> Xem thêm </div> <div style="display: none" id="hide2"> Ẩn bớt</div></button>
                                    <% if (productLowQ.size() > 0) { %>
                                    <div id="table2" style="display: none"><br>
                                        <table class="tableshow">
                                            <thead>
                                                <tr>
                                                    <th>Mã sản phẩn</th>
                                                    <th>Tên Sản Phẩm</th>
                                                    <th> DVT </th>
                                                    <th>Ngày sản xuất</th>
                                                    <th>Hạn sử dụng</th>
                                                    <th>Ngày nhập kho</th>
                                                    <th>Kệ Hàng Số</th>
                                                    <th> Số lượng</th>
                                                    <th>Giá</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% for (Product p : productLowQ) {
                                                %>
                                                <tr>
                                                    <td><%=p.getMasp()%></td>
                                                    <td><%=p.getTensp()%></td>
                                                    <td><%=p.getDVT()%></td>
                                                    <td><%=p.getNgaySX()%></td>
                                                    <td><%=p.getHanSD()%></td>
                                                    <td><%=p.getNgayNhapKho()%></td>
                                                    <td><%=p.getKeHang()%></td>
                                                    <td><%=p.getSoLuong()%> </td>
                                                    <td><%=p.getGiaBan()%> </td>
                                                </tr>
                                                <%}%>
                                            </tbody>
                                        </table>
                                        <%} else {%>
                                        Hiện không có sản phẩm nào!
                                        <%}%>
                                        <br/>
                                    </div>
                                </div>
                            </div>
                        </div> <br>
                        <div class="row">
                            <div class="col-xl-6 col-md-6">
                                <div class="left"><h4>Sản phẩm đã quá hạn sử dụng</h4>
                                    <button class="btn btn-primary"   onclick="showmore3(event)"><div id="more3"> Xem thêm </div> <div style="display: none" id="hide3"> Ẩn bớt</div></button>
                                    <% if (productHHSD.size() > 0) { %>
                                    <div id="table3" style="display: none"><br>
                                        <table class="tableshow">
                                            <thead>
                                                <tr>
                                                    <th>Mã sản phẩn</th>
                                                    <th>Tên Sản Phẩm</th>
                                                    <th> DVT </th>
                                                    <th>Ngày sản xuất</th>
                                                    <th>Hạn sử dụng</th>
                                                    <th>Ngày nhập kho</th>
                                                    <th>Kệ Hàng Số</th>
                                                    <th> Số lượng</th>
                                                    <th>Giá</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% for (Product p : productHHSD) {
                                                %>
                                                <tr>
                                                    <td><%=p.getMasp()%></td>
                                                    <td><%=p.getTensp()%></td>
                                                    <td><%=p.getDVT()%></td>
                                                    <td><%=p.getNgaySX()%></td>
                                                    <td><%=p.getHanSD()%></td>
                                                    <td><%=p.getNgayNhapKho()%></td>
                                                    <td><%=p.getKeHang()%></td>
                                                    <td><%=p.getSoLuong()%> </td>
                                                    <td><%=p.getGiaBan()%> </td>
                                                    <td><a href="edit?id=<%=p.getMasp()%>"><img style="width: 20px" src="../img/edit.png" alt=""/></a> 
                                                        <a href="#" onclick="deleteProduct(<%=p.getMasp()%>);" ><img style="width: 20px" src="../img/delete.png" alt=""/></a></td>
                                                </tr>
                                                <%}%>
                                            </tbody>
                                        </table>
                                        <%} else {%>
                                        Hiện không có sản phẩm nào!
                                        <%}%>
                                        <br/>
                                    </div>
                                </div>
                            </div>

                            <div class="col-xl-6 col-md-6">
                                <div class="left"><h4>Sản phẩm đã tồn kho lâu</h4>
                                    <button class="btn btn-primary" onclick="showmore4(event)"><div id="more"> Xem thêm </div> <div style="display: none" id="hide"> Ẩn bớt</div></button>
                                    <% if (productTKLN.size() > 0) { %>
                                    <div id="table4" style="display: none"><br>
                                        <table class="tableshow">
                                            <thead>
                                                <tr>
                                                    <th>Mã sản phẩn</th>
                                                    <th>Tên Sản Phẩm</th>
                                                    <th> DVT </th>
                                                    <th>Ngày sản xuất</th>
                                                    <th>Hạn sử dụng</th>
                                                    <th>Ngày nhập kho</th>
                                                    <th>Kệ Hàng Số</th>
                                                    <th> Số lượng</th>
                                                    <th>Giá</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% for (Product p : productTKLN) {
                                                %>
                                                <tr>
                                                    <td><%=p.getMasp()%></td>
                                                    <td><%=p.getTensp()%></td>
                                                    <td><%=p.getDVT()%></td>
                                                    <td><%=p.getNgaySX()%></td>
                                                    <td><%=p.getHanSD()%></td>
                                                    <td><%=p.getNgayNhapKho()%></td>
                                                    <td><%=p.getKeHang()%></td>
                                                    <td><%=p.getSoLuong()%> </td>
                                                    <td><%=p.getGiaBan()%> </td>
                                                </tr>
                                                <%}%>
                                            </tbody>
                                        </table>
                                        <%} else {%>
                                        Hiện không có sản phẩm nào!
                                        <%}%>
                                        <br/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><br>
                    <div class="row">
                        <div class="col-xl-6">
                            <div id="myChart" style="width:100%; max-width:600px; height:500px;"></div>
                        </div>
                        <div class="col-xl-6">
                            <div
                                id="myChart2" style="width:100%; max-width:600px; height:500px;">
                            </div>
                        </div>
                    </div>
                    <footer class="py-4 bg-light mt-auto">
                        <div class="container-fluid px-4">
                            <div class="d-flex align-items-center justify-content-between small">
                                <div class="text-muted">Liên Hệ SDT: 0989373658 <br>
                                    Văn phòng phẩm Lan Anh, TDP Kiên Quyết,Phường Dương Nội, Quận Hà Đông, Hà Nội 
                                </div>
                            </div>
                        </div>
                    </footer>
            </div>
        </div>
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="../js/scripts.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="../js/datatables-simple-demo.js" type="text/javascript"></script>
    <script src="../js/pagger.js" type="text/javascript"></script>

</body>
</html>
