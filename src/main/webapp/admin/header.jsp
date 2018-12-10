<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/index.jsp">蛋糕店后台</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li ><a href="${pageContext.request.contextPath}/admin/order_list">订单管理</a></li>
                <li ><a href="userList.action">客户管理</a></li>
                <li ><a href="goodList.action">商品管理</a></li>
                <li ><a href="typeList.action">类目管理</a></li>
                <li ><a href="adminRe.action">修改密码</a></li>
                <li><a href="logout.action">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
