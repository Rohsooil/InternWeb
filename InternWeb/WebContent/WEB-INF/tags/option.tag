<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name='value' required="true"%>
<%@ attribute name='modValue' required="false"%>

<option value="${value}" <c:if test="${modValue eq value}">selected</c:if>>${value}</option>