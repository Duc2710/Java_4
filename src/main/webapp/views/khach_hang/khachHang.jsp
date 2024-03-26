<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Trang khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<br><br><br>
<body class="container">
<table class="table table-border">
    <button style="background-color: mediumseagreen;">
        <a href="/BTVN_war_exploded/khach_hang/create">Thêm</a>
    </button>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Mã khách hàng</th>
        <th>SDT</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ data }" var="kh" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${ kh.ten }</td>
            <td>${ kh.ma }</td>
            <td>${ kh.SDT }</td>
            <td>${ kh.trangThai }</td>
            <td>
                <button class="btn btn-info">
                    <a href="/BTVN_war_exploded/khach_hang/edit?ma=${kh.ma}">Update</a>
                </button>

                <button class="btn btn-warning">
                    <a href="/BTVN_war_exploded/khach_hang/delete?ma=${kh.ma}">Delete</a>
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
