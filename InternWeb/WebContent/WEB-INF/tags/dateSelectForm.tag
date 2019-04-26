<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ attribute name="id" required="false" %>

<jsp:useBean id="now" class="com.roh.beans.NowDate" scope="page" />

<span id="${id}"> 
	<input type="hidden" id="${id+='Date'}" name="${id+='Date'}">
	<select id="${id+='Year'}">
		<c:forEach begin="0" end="1" varStatus="i">
			<option value="${now.year+i.index}">${now.year+i.index}</option>
		</c:forEach>
	</select>
	<span>년</span>
	<select id="${id+='Month'}">
		<c:forEach begin="1" end="12" varStatus="i">
			<c:choose>
				<c:when test="${now.month eq i.index }">
					<option value="${i.index}" selected="selected">${i.index}</option>
				</c:when>
				<c:otherwise>
					<option value="${i.index}">${i.index}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
	<span>월</span>
	<select id="${id+='Day'}">
		<c:forEach begin="1" end="${now.lastDayOfMonth}" varStatus="i">
			<c:choose>
				<c:when test="${now.day eq i.index }">
					<option value="${i.index}" selected="selected">${i.index}</option>
				</c:when>
				<c:otherwise>
					<option value="${i.index}">${i.index}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
	<span>일</span>
	<select id="${id+='Hour'}">
		<c:forEach begin="0" end="23" varStatus="i">
			<option value="<fmt:formatNumber value="${i.index }" pattern="00"/>"><fmt:formatNumber value="${i.index }" pattern="00"/></option>
		</c:forEach>
	</select>
	<span>시</span>
	<select id="${id+='Min'}">
		<c:forEach begin="0" end="11" varStatus="i">
			<option value="<fmt:formatNumber value="${i.index*5 }" pattern="00"/>"><fmt:formatNumber value="${i.index*5 }" pattern="00"/></option>
		</c:forEach>
	</select>
	<span>분</span>
</span>