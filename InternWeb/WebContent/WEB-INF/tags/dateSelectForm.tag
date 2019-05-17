<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags"%>

<%@ attribute name="id" required="true"%>
<%@ attribute name="modValue" required="false" type="com.roh.forms.Date"%>

<jsp:useBean id="now" class="com.roh.forms.Date" scope="page" />
<jsp:useBean id="String" class="java.lang.String" scope="page" />

<c:choose>
	<c:when test="${modValue ne null}">
		<c:set var="date" value="${modValue}" />
	</c:when>
	<c:otherwise>
		<c:set var="date" value="${now}" />
	</c:otherwise>
</c:choose>

<span id="${id}">
	<input type="hidden" id="${id}Date" name="${id}Date">
	<select id="${id}Year">
		<c:forEach begin="0" end="1" varStatus="i">
			<myTag:option value="${now.year+i.index}" modValue="${modValue.year}" />
		</c:forEach>
	</select>
	<span>년</span>
	<select id="${id}Month">
		<c:forEach begin="1" end="12" varStatus="i">
			<myTag:option value="${String.format('%02d',i.index)}" modValue="${String.format('%02d',date.month)}" />
		</c:forEach>
	</select>
	<span>월</span>
	<select id="${id}Day">
		<c:forEach begin="1" end="${date.lastDayOfMonth}" varStatus="i">
			<myTag:option value="${String.format('%02d',i.index)}" modValue="${String.format('%02d',date.day)}" />
		</c:forEach>
	</select>
	<span>일</span>
	<select id="${id}Hour">
		<c:forEach begin="0" end="23" varStatus="i">
			<myTag:option value="${String.format('%02d',i.index)}" modValue="${String.format('%02d',date.hour)}" />
		</c:forEach>
	</select>
	<span>시</span>
	<select id="${id}Min">
		<c:forEach begin="0" end="11" varStatus="i">
			<myTag:option value="${String.format('%02d',i.index*5)}" modValue="${String.format('%02d',date.min)}" />
		</c:forEach>
	</select>
	<span>분</span>
</span>