<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap-select.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/simpleCart.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
    <script type="text/javascript" src="js/bootstrap-select.min.js"></script>
</head>
<body>


<jsp:include page="/header.jsp">
    <jsp:param name="flag" value="2"/>
</jsp:include>

<!--products-->
<div class="products">
    <div class="container">
        <h2><c:choose><c:when test="${empty t}">全部系列</c:when><c:otherwise>${t.name}</c:otherwise></c:choose></h2>
        <div class="line"></div>
        <div class="sort-container">
            <div class="sort-content">
                <select id="pid" onchange="goodsPriceSort(${t.id},${page.pageNumber})" class="selectpicker" title="价格排序">
                    <option style='display: none'></option>
                    <option value="1">价格从低到高</option>
                    <option value="2">价格从高到低</option>
                </select>
            </div>
        </div>
        <div class="col-md-12 product-model-sec">
            <c:forEach items="${page.list}" var="g">
            <div class="product-grid">
                <a href="${pageContext.request.contextPath}/goods_detail?id=${g.id}">
                    <div class="more-product"><span> </span></div>
                    <div class="product-img b-link-stripe b-animate-go  thickbox">
                        <img src="${pageContext.request.contextPath}${g.cover}" class="img-responsive" alt="${g.name}" width="240" height="240">
                        <div class="b-wrapper">
                            <h4 class="b-animate b-from-left  b-delay03">
                                <button>查看详情</button>
                            </h4>
                        </div>
                    </div>
                </a>
                <div class="product-info simpleCart_shelfItem">
                    <div class="product-info-cust prt_name">
                        <h4>${g.name}</h4>
                        <span class="item_price">¥ ${g.price}</span>
                        <input type="button" class="item_add items" value="加入购物车" onclick="buy(${g.id})">
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
            </c:forEach>
            <div class="clearfix"> </div>
        </div>
        <div>
            <jsp:include page="/page.jsp">
                <jsp:param name="url" value="/goods_list" />
                <jsp:param name="param" value="id=${id}" />
            </jsp:include>
        </div>
    </div>
</div>
<!--//products-->






<jsp:include page="/footer.jsp"></jsp:include>


</body>
</html>
