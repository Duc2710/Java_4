<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/BTVN_war_exploded/san_pham_CT/store">
    <div>
        <label>Mã</label>
        <input type="text" name="ma"/>
    </div>
    <div>
        <label>Kích thước</label>
        <input type="text" name="idKT"/>
    </div>
    <div>
        <label>Màu sắc</label>
        <input type="text" name="idMS"/>
    </div>
    <div>
        <label>Sản phẩm</label>
        <input type="text" name="idSP"/>
    </div>
    <div>
        <label>Số lượng</label>
        <input type="number" name="soLuong"/>
    </div>
    <div>
        <label>Đơn giá</label>
        <input type="number" name="donGia"/>
    </div>
    <div>
        <label>Trạng thái</label>
        <input type="radio" name="trangThai" value="1"
        ${ms.trangThai == 1 ? "checked" :  ""}/>
        <label>Đang hoạt động</label>
        <input type="radio" name="trangThai" value="0"
        ${ms.trangThai == 0 ? "checked" :  ""}/>
        <label>Ngừng hoạt động</label>
    </div>
    <div>
        <button>Thêm</button>
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