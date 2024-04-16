<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/BTVN_war_exploded/san_pham_CT/update?id=${spct.id}">
<div>
        <label>Mã</label>
        <input type="text" name="ma" value="${spct.ma}">
    </div>

    <div>
        <label>Kích thước</label>
        <input type="number" name="idKT" value="${spct.idKT}"/>
    </div>
    <div>
        <label>Màu sắc</label>
        <input type="number" name="idMS" value="${spct.idMS}"/>
    </div>
    <div>
        <label>Sản phẩm</label>
        <input type="number" name="idSP" value="${spct.idSP}"/>
    </div>
    <div>
        <label>Số lượng</label>
        <input type="number" name="soLuong" value="${spct.soLuong}"/>
    </div>
    <div>
        <label>Đơn giá</label>
        <input type="number" name="donGia" value="${spct.donGia}"/>
    </div>
    <div>
        <label>Trạng thái</label>
        <input type="radio" name="trangThai" value="1"
        ${spct.trangThai == 1 ? "checked" :  ""}/>
        <label>Đang hoạt động</label>
        <input type="radio" name="trangThai" value="0"
        ${spct.trangThai == 0 ? "checked" :  ""}/>
        <label>Ngừng hoạt động</label>
    </div>
    <div>
        <button>Cập nhật</button>
    </div>
    <div>
        <button>
            <a href="/BTVN_war_exploded/san_pham_CT/index">
                Quay lại
            </a>
        </button>
    </div>

</form>
</body>
</html>