<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name='id' required="true"%>
<%@ attribute name='value' required="true"%>
<%@ attribute name='number' required="true"%>
<%@ attribute name='modVal' required="false"%>

<c:choose>
	<c:when test="${modVal eq value}">
		<input id="${id}${number}" class="${id}" type="radio" name="${id}" value="${value}" checked="checked">
	</c:when>
	<c:otherwise>
		<input id="${id}${number}" class="${id}" type="radio" name="${id}" value="${value}">
	</c:otherwise>
</c:choose>
<label for="${id}${number}">
	<span class="radio_btn"></span>
	<span>${value}</span>
</label>