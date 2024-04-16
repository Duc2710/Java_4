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
        <a href="/BTVN_war_exploded/hoa_don_CT/create">Thêm</a>
    </button>
    <thead>
    <tr>
        <th>ID</th>
        <th>ID hóa đơn</th>
        <th>ID sản phẩm</th>
        <th>Số lượng</th>
        <th>Đơn giá</th>
        <th>Thời gian</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ data }" var="hdct">
        <tr>
            <td>${hdct.id}</td>
            <td>${ hdct.idHD }</td>
            <td>${ hdct.idSPCT }</td>
            <td>${ hdct.soLuong }</td>
            <td>${ hdct.donGia }</td>
            <td>${ hdct.thoiGian }</td>
            <td>${ hdct.trangThai }</td>
            <td>
                <button class="btn btn-info">
                    <a href="/BTVN_war_exploded/hoa_don_CT/edit?id=${hdct.id}">Update</a>
                </button>

                <button class="btn btn-warning">
                    <a href="/BTVN_war_exploded/hoa_don_CT/delete?id=${hdct.id}">Delete</a>
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