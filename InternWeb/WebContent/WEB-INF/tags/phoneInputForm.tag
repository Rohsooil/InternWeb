<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name='type' required="true"%>
<%@ attribute name='id' required="true"%>

<input type="hidden" name="${id}" id="${id}">
<c:choose>
	<c:when test="${type=='phone' }">
		<select id="${id}Area">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="018">018</option>
			<option value="019">019</option>
			<option value="0505">0505</option>
		</select>
	</c:when>
	<c:when test="${type=='tel' }">
		<select id="${id}Area">
			<option value="02">02</option>
			<option value="031">031</option>
			<option value="032">032</option>
			<option value="033">033</option>
			<option value="041">041</option>
			<option value="042">042</option>
			<option value="043">043</option>
			<option value="044">044</option>
			<option value="051">051</option>
			<option value="052">052</option>
			<option value="053">053</option>
			<option value="054">054</option>
			<option value="055">055</option>
			<option value="061">061</option>
			<option value="062">062</option>
			<option value="063">063</option>
			<option value="064">064</option>
			<option value="070">070</option>
			<option value="0505">0505</option>
		</select>
	</c:when>
</c:choose>
<input class="numberInput" type="tel" id="${id}Country" maxlength="4" size="4" style="ime-mode: disabled;">
<input class="numberInput" type="tel" id="${id}Individual" maxlength="4" size="4" style="ime-mode: disabled;">