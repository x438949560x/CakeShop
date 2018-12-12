<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div style='text-align:center;'>
    <a class='btn btn-info' <c:if test="${page.pageNumber==1}"> disabled </c:if>
            <c:choose>
                <c:when test="${page.pageNumber!=1 && page.sortId != 1 && page.sortId != 2}">
                    href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber=1"
                </c:when>
                <c:when test="${page.pageNumber!=1 && page.sortId == 1}">
                    href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber=1&sortId=1"
                </c:when>
                <c:when test="${page.pageNumber!=1 && page.sortId == 2}">
                    href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber=1&sortId=2"
                </c:when>
            </c:choose>>首页</a>
    <a class='btn btn-info' <c:if test="${page.pageNumber==1}"> disabled </c:if>
            <c:choose>
                <c:when test="${page.pageNumber!=1 && page.sortId != 1 && page.sortId != 2}">
                    href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber=${page.pageNumber-1}"
                </c:when>
                <c:when test="${page.pageNumber!=1 && page.sortId == 1}">
                    href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber=${page.pageNumber-1}&sortId=1"
                </c:when>
                <c:when test="${page.pageNumber!=1 && page.sortId == 2}">
                    href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber=${page.pageNumber-1}&sortId=2"
                </c:when>
            </c:choose>>上一页</a>
    <h3 style='display:inline;'>[${page.pageNumber}/${page.totalPage}]</h3>
    <h3 style='display:inline;'>[${page.totalCount}]</h3>
    <a class='btn btn-info' <c:if test="${page.totalPage==0 || page.pageNumber==page.totalPage}"> disabled </c:if> <c:choose>
            <c:when test="${page.pageNumber!=page.totalPage && page.sortId != 1 && page.sortId != 2}">
                href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber=${page.pageNumber+1}"
            </c:when>
            <c:when test="${page.pageNumber!=page.totalPage && page.sortId == 1}">
                href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber=${page.pageNumber+1}&sortId=1"
            </c:when>
            <c:when test="${page.pageNumber!=page.totalPage && page.sortId == 2}">
                 href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber=${page.pageNumber+1}&sortId=2"
            </c:when>
            </c:choose>">下一页</a>
    <a class='btn btn-info' <c:if test="${page.totalPage==0 || page.pageNumber==page.totalPage}"> disabled </c:if> <c:choose>
        <c:when test="${page.pageNumber!=page.totalPage && page.sortId != 1 && page.sortId != 2}">
            href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber=${page.totalPage}"
        </c:when>
        <c:when test="${page.pageNumber!=page.totalPage && page.sortId == 1}">
            href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber=${page.totalPage}&sortId=1"
        </c:when>
        <c:when test="${page.pageNumber!=page.totalPage && page.sortId == 2}">
            href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber=${page.totalPage}&sortId=2"
        </c:when>
    </c:choose>>尾页</a>
    <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="${pageContext.request.contextPath}${param.url}?${param.param}&pageNumber="+(this.previousSibling.value)'>GO</a>
</div>