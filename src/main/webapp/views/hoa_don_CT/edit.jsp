<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/BTVN_war_exploded/hoa_don_CT/update">
    <div>
        <label>ID hóa đơn</label>
        <input type="text" name="idHD" value="${ idHD.idHD }"/>
    </div>
    <div>
        <label>ID sản phẩm</label>
        <input type="text" name="idSPCT" value="${idHD.idSPCT}"/>
    </div>
    <div>
        <label>Số lượng</label>
        <input type="number" name="soLuong" value="${idHD.soLuong}"/>
    </div>
    <div>
        <label>Đơn giá</label>
        <input type="number" name="donGia" value="${idHD.donGia}"/>
    </div>
    <div>
        <label>Trạng thái</label>
        <input type="radio" name="trangThai" value="1"
        ${idHD.trangThai == 1 ? "checked" :  ""}/>
        <label>Đang hoạt động</label>
        <input type="radio" name="trangThai" value="0"
        ${idHD.trangThai == 0 ? "checked" :  ""}/>
        <label>Ngừng hoạt động</label>
    </div>
    <div>
        <button>Cập nhật</button>
    </div>
    <div>
        <button>
            <a href="/BTVN_war_exploded/hoa_don_CT/hoaDonCT">
                Quay lại
            </a>
        </button>
    </div>

</form>
</body>
</html>