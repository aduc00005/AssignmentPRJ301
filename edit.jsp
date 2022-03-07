<%-- 
    Document   : edit
    Created on : Mar 1, 2022, 9:56:14 PM
    Author     : Admin
--%>

<%@page import="model.NguonHang"%>
<%@page import="model.DanhMuc"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ProductForAdmin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title> Chỉnh sửa thông tin sản phẩm </title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="../CSS/styles.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
        <%
            ProductForAdmin p = (ProductForAdmin) request.getAttribute("product");
            ArrayList<DanhMuc> LoaiSP = (ArrayList<DanhMuc>) request.getAttribute("LoaiSP");
            ArrayList<NguonHang> Nguon = (ArrayList<NguonHang>) request.getAttribute("nguon");
        %>
    </head>
    <body>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="../index.html">Tác Vụ</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="../login.html">Đăng Xuất</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Báo cáo dữ liệu</div>
                            <a class="nav-link" href="../index.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dữ liệu sản phẩm
                            </a>
                            <div class="sb-sidenav-menu-heading">Sản phẩm</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Sản phẩm
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="search">Sản phẩm</a>
                                    <a class="nav-link" href="insert">Thêm sản phẩm</a>
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
                                Pages
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Authentication
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="../login.html">Login</a>
                                            <a class="nav-link" href="../register.html">Register</a>
                                            <a class="nav-link" href="../password.html">Forgot Password</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Error
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="401.html">401 Page</a>
                                            <a class="nav-link" href="404.html">404 Page</a>
                                            <a class="nav-link" href="500.html">500 Page</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Addons</div>
                            <a class="nav-link" href="charts.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Charts
                            </a>
                            <a class="nav-link" href="tables.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Tables
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Quản lý sản phẩm</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="../index.html">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Quản lý sản phẩm</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                Chỉnh sửa thông tin sản phẩm
                            </div>
                            <div>
                                <form action="edit" method="POST">
                                    <table>
                                        <tr>
                                            <td>Mã sản phẩm:</td>
                                            <td><%=p.getMasp()%> <input type="hidden" name="masp" value="<%=p.getMasp()%>"/><br/></td>
                                        </tr>
                                        <tr>
                                            <td>tên sản phẩm:</td>
                                            <td><input type="name" name="tensp" value="<%=p.getTensp()%>"/> <br/></td>
                                        </tr>
                                        <tr>
                                            <td>DVT:</td>
                                            <td><input type="text" name="DVT" value="<%=p.getDVT()%>"/> <br/></td>
                                        </tr>
                                        <tr>
                                            <td>Ngày sản xuất:</td>
                                            <td><input type="date" name="NgaySX" value="<%=p.getNgaySX()%>"/> <br/></td>
                                        </tr>
                                        <tr>
                                            <td>Hạn Sử Dụng:</td>
                                            <td><input type="date" name="HanSD" value="<%=p.getHanSD()%>"/> <br/></td>
                                        </tr>
                                        <tr>
                                            <td>Số Lượng:</td>
                                            <td><input type="text" name="SoLuong" value="<%=p.getSoLuong()%>"/> <br/></td>
                                        </tr>
                                        <tr>
                                            <td>Giá Nhập:</td>
                                            <td><input type="text" name="GiaNhap" value="<%=p.getGiaNhap()%>"/><br/></td>
                                        </tr>
                                        <tr>
                                            <td>Giá Bán:</td>
                                            <td><input type="text" name="GiaBan" value="<%=p.getGiaBan()%>"/><br/></td>
                                        </tr>
                                        <tr>
                                            <td>Kệ Hàng Số:</td>
                                            <td><input type="text" name="KeHang" value="<%=p.getKeHang()%>"/><br/></td>
                                        </tr>
                                        <tr>
                                            <td>Mã Nguồn Hàng:</td>
                                            <td><select name="maNH">
                                                    <%for (NguonHang n : Nguon) {
                                                    %>
                                                    <option <%=(p.getNguon().getMaNguonHang().equals(n.getMaNguonHang()))? "selected=\"selected\"":""%>
                                                        value="<%=n.getMaNguonHang()%>"><%=n.getTenCuaHang()%></option>
                                                    <%}%>
                                                    <option value="orther"> Khác </option>
                                                </select><br/></td>
                                        </tr>
                                        
                                        <div id="NH1">
                                        <tr>
                                            <td>Mã nguồn Hàng Mới:</td>
                                            <td><input type="text" name="maNHM"/><br/></td>
                                        </tr>
                                        <tr>
                                            <td>tên Cửa Hàng:</td>
                                            <td><input type="text" name="TenCuaHang"/><br/></td>
                                        </tr>
                                        <tr>
                                            <td>Địa chỉ:</td>
                                            <td><input type="text" name="DiaChi"><br/></td>
                                        </tr>
                                        <tr>
                                            <td>SĐT:</td>
                                            <td><input type="text" name="sdt"><br></td>
                                        </tr>
                                        </div>
                                        <tr>
                                            <td>Loại Sản Phẩm:</td>
                                            <td><select name="MaLoaiSP">
                                                    <% for (DanhMuc ls : LoaiSP) {
                                                    %>
                                                    <option <%=(p.getLoaiSp().getMaLoaiSP().equals(ls.getMaLoaiSP()))?"selected=\"selected\"":""%>
                                                        value="<%=ls.getMaLoaiSP()%>"><%=ls.getLoaiSP()%></option>
                                                    <%}%>
                                                    <option value="orther"> Khác </option>
                                                </select> <br/></td>
                                        </tr>
                                        <tr>
                                            <td>Mã Loại sản phẩm mới:</td>
                                            <td><input type="text" name="MaLoaiSPM"/><br/></td>
                                        </tr>
                                        <tr>
                                            <td>Loại sản phẩm:</td>
                                            <td><input type="text" name="LoaiSP"/><br/></td>
                                        </tr>
                                        <tr>
                                            <td><input type="submit" value="Lưu"/></td>
                                            <td></td>
                                        </tr>
                                    </table>
                                </form>
                            </div>
                        </div>
                </main>

                <footer class="py-4 bg-light mt-auto">
                </footer>
            </div>
        </div>
    </div>
    <script src="../js/datatables-simple-demo.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="../js/scripts.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
</body>
</html>