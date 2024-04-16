<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Trang sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<br><br><br>
<body class="container">
<table class="table table-border">
    <button style="background-color: mediumseagreen;">
        <a href="/BTVN_war_exploded/san_pham/create">Thêm</a>
    </button>
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="sp" >
        <tr>
            <td>${ sp.id }</td>
            <td>${ sp.ma }</td>
            <td>${ sp.ten }</td>
            <td>${ sp.trangThai }</td>
            <td>
                <button class="btn btn-info">
                    <a href="/BTVN_war_exploded/san_pham/edit?id=${sp.id}">Update</a>
                </button>

                <button class="btn btn-warning">
                    <a href="/BTVN_war_exploded/san_pham/delete?id=${sp.id}">Delete</a>
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
