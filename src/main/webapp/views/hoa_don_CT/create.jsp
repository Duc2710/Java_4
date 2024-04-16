<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/BTVN_war_exploded/hoa_don_CT/store">
    <div>
        <label>ID hóa đơn</label>
        <input type="number" name="idHD" value="${hdct.idHD}"/>
    </div>
    <div>
        <label>ID sản phẩm</label>
        <input type="number" name="idSPCT" value="${hdct.idSPCT}"/>
    </div>
    <div>
        <label>Số lượng</label>
        <input type="number" name="soLuong" value="${hdct.soLuong}"/>
    </div>
    <div>
        <label>Đơn giá</label>
        <input type="number" name="donGia" value="${hdct.donGia}"/>
    </div>
    <div>
        <label>Thời gian</label>
        <input type="datetime-local" name="thoiGian" value="${hdct.thoiGian}"/>
    </div>
    <div>
        <label>Trạng thái</label>
        <input type="radio" name="trangThai" value="1"/>
        <label>Đang hoạt động</label>
        <input type="radio" name="trangThai" value="0"/>
        <label>Ngừng hoạt động</label>
    </div>
    <div>
        <button>Thêm</button>
    </div>
    <div>
        <button>
            <a href="/BTVN_war_exploded/hoa_don_CT/index">
                Quay lại
            </a>
        </button>
    </div>
</form>
</body>
</html>