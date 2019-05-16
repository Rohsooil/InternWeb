<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags"%>
<%@ attribute name='type' required="true"%>
<%@ attribute name='id' required="true"%>
<%@ attribute name='modValue' required="false" type="com.roh.beans.TelePhone"%>

<jsp:useBean id="ArCode" class="com.roh.forms.AreaCode" scope="page" />

<input type="hidden" name="${id}" id="${id}">
<c:choose>
	<c:when test="${type=='phone' }">
		<select id="${id}Area"> 
			<c:forEach items="${ArCode.phoneArea}" var="code">
				<myTag:option value="${code}" modValue="${modValue.areaCode}" />
			</c:forEach>
		</select>
	</c:when>
	<c:when test="${type=='tel' }">
		<select id="${id}Area">
			<c:forEach items="${ArCode.telArea}" var="code">
				<myTag:option value="${code}" modValue="${modValue.areaCode}" />
			</c:forEach>
		</select>
	</c:when>
</c:choose>
<input class="numberInput" type="tel" id="${id}Country" maxlength="4" size="4" style="ime-mode: disabled;" value="${modValue.countryCode}">
<input class="numberInput" type="tel" id="${id}Individual" maxlength="4" size="4" style="ime-mode: disabled;" value="${modValue.individualCode}">