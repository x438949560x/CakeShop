<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html>
<html>
<head>
    <title>订单列表</title>
    <link rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">



    <jsp:include page="/admin/header.jsp"></jsp:include>

    <br>

    <ul role="tablist" class="nav nav-tabs">
        <li class="active" role="presentation"><a href="orderList.action">全部订单</a></li>
        <li  role="presentation"><a href="orderList.action?status=1">未付款</a></li>
        <li  role="presentation"><a href="orderList.action?status=2">已付款</a></li>
        <li  role="presentation"><a href="orderList.action?status=3">配送中</a></li>
        <li  role="presentation"><a href="orderList.action?status=4">已完成</a></li>
    </ul>

    <br>

    <table class="table table-bordered table-hover">

        <tr>
            <th width="5%">ID</th>
            <th width="5%">总价</th>
            <th width="15%">商品详情</th>
            <th width="20%">收货信息</th>
            <th width="10%">订单状态</th>
            <th width="10%">支付方式</th>
            <th width="10%">下单用户</th>
            <th width="10%">下单时间</th>
            <th width="10%">操作</th>
        </tr>

        <c:forEach items="${page.list}" var="order">
        <tr>
            <td><p>${order.id}</p></td>
            <td><p>${order.total}</p></td>
            <td>
                <c:forEach items="${order.item}" var="item">
                <p>${item.goodsName}(${item.price}) x ${item.amount}</p>
                </c:forEach>
            </td>
            <td>
                <p>${order.name}</p>
                <p>${order.phone}</p>
                <p>${order.address}</p>
            </td>
            <td>
                <p>
                    <c:if test="${order.status==2}"><span style="color: red;">已付款</span></c:if>
                    <c:if test="${order.status==3}"><span style="color: green;">已发货</span></c:if>
                    <c:if test="${order.status==4}"><span style="color: black;">已完成</span></c:if>
                </p>
            </td>
            <td>
                <p>
                    <c:if test="${order.paytype==1}">微信</c:if>
                    <c:if test="${order.paytype==2}">支付宝</c:if>
                    <c:if test="${order.paytype==3}">货到付款</c:if>
                </p>
            </td>
            <td><p>${order.user.username}</p></td>
            <td><p>${order.datetime}</p></td>
            <td>

                <a class="btn btn-success" href="orderDispose.action?id=12&status=0">发货</a>


                <a class="btn btn-danger" href="orderDelete.action?id=12&status=0">删除</a>
            </td>
        </tr>
        </c:forEach>


    </table>

    <br>
    <jsp:include page="/page.jsp">
        <jsp:param name="url" value="/admin/order_list" />
        <jsp:param name="param" value="status=${status}" />
    </jsp:include>
    <br>
</div>
</body>
</html>