<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/BTVN_war_exploded/hoa_don/update">
    <div>
        <label>ID nhân viên</label>
        <input type="text" name="idNV" value="${hd.idNV}" readonly/>
    </div>
    <div>
        <label>ID khách hàng</label>
        <input type="text" name="idKH" value="${hd.idKH}"/>
    </div>
    <div>
        <label>Ngày mua</label>
        <input type="text" name="ngayMua" value="${hd.ngayMua}"/>
    </div>
    <div>
        <label>Trạng thái</label>
        <input type="radio" name="trangThai" value="1"
        ${hd.trangThai == 1 ? "checked" :  ""}/>
        <label>Đang hoạt động</label>
        <input type="radio" name="trangThai" value="0"
        ${hd.trangThai == 0 ? "checked" :  ""}/>
        <label>Ngừng hoạt động</label>
    </div>
    <div>
        <button>Cập nhật</button>
    </div>
    <div>
        <button>
            <a href="/BTVN_war_exploded/hoa_don/index">
                Quay lại
            </a>
        </button>
    </div>

</form>
</body>
</html>