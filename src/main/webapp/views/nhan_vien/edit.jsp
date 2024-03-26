<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/BTVN_war_exploded/nhan_vien/update">
    <div>
        <label>Tên</label>
        <input type="text" name="ten" value="${nv.ten}" readonly/>
    </div>
    <div>
        <label>Mã</label>
        <input type="text" name="ma" value="${ nv.ma }"/>
    </div>
    <div>
        <label>Tên đăng nhập</label>
        <input type="text" name="tenDN" value="${ nv.tenDN }"/>
    </div>
    <div>
        <label>Mật khẩu</label>
        <input type="text" name="MK" value="${ nv.MK }"/>
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
            <a href="/BTVN_war_exploded/nhan_vien/index">
                Quay lại
            </a>
        </button>
    </div>

</form>
</body>
</html>