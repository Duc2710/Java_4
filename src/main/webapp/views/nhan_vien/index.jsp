<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Trang nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<br><br><br>
<body class="container">
<table class="table table-border">
    <button style="background-color: mediumseagreen;">
        <a href="/BTVN_war_exploded/nhan_vien/create">Thêm</a>
    </button>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Mã</th>
        <th>Tên đăng nhập</th>
        <th>Mật khẩu</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ data }" var="nv" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${ nv.ten }</td>
            <td>${ nv.ma}</td>
            <td>${ nv.tenDN }</td>
            <td>${ nv.MK }</td>
            <td>${ nv.trangThai }</td>
            <td>
                <button class="btn btn-info">
                    <a href="/BTVN_war_exploded/nhan_vien/edit?ma=${nv.ma}">Update</a>
                </button>

                <button class="btn btn-warning">
                    <a href="/BTVN_war_exploded/nhan_vien/delete?ma=${nv.ma}">Delete</a>
                </button>
            </td>

        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
<style>
    a {
        color: black;
        text-decoration: none;
    }

    a:hover {
        color: yellow;
    }
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</html>
