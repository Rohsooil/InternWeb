<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name='id' required="true"%>
<%@ attribute name='value' required="true"%>
<%@ attribute name='modVal' required="false"%>

<c:choose>
	<c:when test="${modVal eq 1}">
		<input type="checkbox" name="vote_media" id="${id}" class="vote_media" value="${id}" checked="checked">
	</c:when>
	<c:otherwise>
		<input type="checkbox" name="vote_media" id="${id}" class="vote_media" value="${id}">
	</c:otherwise>
</c:choose>

<label for="${id}">
	<span class="chk_box"></span>
	<span>${value}</span>
</label>