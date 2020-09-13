<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
[
<c:forEach var="a" items="${list }" varStatus="status">
<c:if test="${not status.first }">,</c:if>
{"num":${a.num }, "writer":${a.writer }, "title":${a.title }, "w_date":${a.w_date }, "content":${a.content }
}
</c:forEach>
]