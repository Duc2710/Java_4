<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/BTVN_war_exploded/kich_thuoc/update">
    <div>
        <label>Mã</label>
        <input type="text" name="ma" value="${ kt.ma }" readonly/>
    </div>
    <div>
        <label>Tên</label>
        <input type="text" name="ten" value="${kt.ten}"/>
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
            <a href="/BTVN_war_exploded/kich_thuoc/index">
                Quay lại
            </a>
        </button>
    </div>

</form>
</body>
</html>