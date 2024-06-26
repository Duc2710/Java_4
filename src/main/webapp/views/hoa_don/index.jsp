<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Trang màu sắc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<br><br><br>
<body class="container">
<table class="table table-border">
    <button style="background-color: mediumseagreen;">
        <a href="/BTVN_war_exploded/hoa_don/create">Thêm</a>
    </button>
    <thead>
    <tr>
        <th>ID</th>
        <th>ID nhân viên</th>
        <th>ID khách hàng</th>
        <th>Ngày mua</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ data }" var="hd" >
        <tr>
            <td>${hd.id}</td>
            <td>${ hd.idNV }</td>
            <td>${ hd.idKH }</td>
            <td>${ hd.ngayMua }</td>
            <td>${ hd.trangThai }</td>
            <td>
                <button class="btn btn-info">
                    <a href="/BTVN_war_exploded/hoa_don/edit?id=${hd.id}">Update</a>
                </button>

                <button class="btn btn-warning">
                    <a href="/BTVN_war_exploded/hoa_don/delete?id=${hd.id}">Delete</a>
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
