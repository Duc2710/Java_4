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
        <a href="/BTVN_war_exploded/san_pham_CT/create">Thêm</a>
    </button>
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã</th>
        <th>Kích thước</th>
        <th>Màu sắc</th>
        <th>Sản phẩm </th>
        <th>Số lượng</th>
        <th>Đơn giá</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ data }" var="spct" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${ spct.ma }</td>
            <td>${ spct.idKT }</td>
            <td>${ spct.idMS }</td>
            <td>${ spct.idSP }</td>
            <td>${ spct.soLuong }</td>
            <td>${ spct.donGia }</td>
            <td>${ spct.trangThai }</td>
            <td>
                <button class="btn btn-info">
                    <a href="/BTVN_war_exploded/san_pham_CT/edit?ma=${spct.ma}">Update</a>
                </button>

                <button class="btn btn-warning">
                    <a href="/BTVN_war_exploded/san_pham_CT/delete?ma=${spct.ma}">Delete</a>
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
