<%-- 
    Document   : password
    Created on : Mar 6, 2022, 9:47:21 PM
    Author     : Admin
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Đổi mật khẩu</title>
        <link href="../CSS/styles.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/pagger.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
        <%
            Account account = (Account) request.getAttribute("account");
        %>
    </head>
    <body>
        <div id="layoutError">
            <div id="layoutError_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-6">
                                <div class="text-center mt-4">
                                    <p>Xin Chào <%=account.getFirstName()%> <%=account.getLastName()%></p>
                                    <form action="resetpassword" method="POST">
                                        <table>
                                            <tr>
                                                <td>Nhập Mật Khẩu Mới</td>
                                                <td><input type="password" name="password"/><br/></td>
                                            </tr>
                                            <tr>
                                                <td>Nhập Lại Mật Khẩu Mới</td>
                                                <td><input type="password" name="ReEnterPassword"/><br/><br/></td>
                                            </tr>
                                        </table>
                                        <input style="margin-left: 50px" class="btn btn-primary" type="submit" value="Lưu"/>                                       
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutError_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="../js/scripts.js" type="text/javascript"></script>
    </body>
</html>
