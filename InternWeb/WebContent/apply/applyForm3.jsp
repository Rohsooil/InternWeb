<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rlhvote/resources/css/default.css"
	type="text/css">
</head>
<body>
	<myTag:Header />
	<div class="f_box" style="height: 1400px;">
		<div style="height: 100px; background-color: black; color: white">
			이용신청서 작성
		</div>
		<form action="/rlhvote/apply/application" accept-charset="UTF-8" method="post">
			<div>1. 아파트 정보</div>
			<table>
				<tr>
					<th>아파트 명</th>
					<td><input type="text" name="apart_name" value="${requestScope.apart.apartName }"></td>
				</tr>
				<tr>
					<th>아파트 구분</th>
					<td>
						<label>
							<input class="apart_type" type="radio" name="apart_type" value="1" checked="checked">
							<span>일반 주택</span>
						</label>
						<label>
							<input class="apart_type" type="radio" name="apart_type" value="2">
							<span>LH 임대 주택</span>
						</label>
					</td>
				</tr>
				<tr>
					<th>사업자 등록번호</th>
					<td>
						<input type="text" id="register_num" class="numberInput" name="register_num" value="${requestScope.apart.registerNum}">
						<button onclick="authorize(event)">인증</button>
					</td>
				</tr>
				<tr>
					<th>대표자 구분</th>
					<td>
						<label>
							<input class="rep_type" type="radio" name="rep_type" value="1" checked="checked">
							<span>선관위원장</span>
						</label>
						<label>
							<input class="rep_type" type="radio" name="rep_type" value="2">
							<span>입대의 회장</span>
						</label>
					</td>
				</tr>
				<tr>
					<th>대표자 성명</th>
					<td><input type="text" name="rep_name" value="${requestScope.apart.repName}"></td>
				</tr>
				<tr>
					<th>아파트 연락처</th>
					<td><myTag:phoneInputForm type="tel" id="apart_tel"/></td>
					<th>팩스</th>
					<td><myTag:phoneInputForm type="tel" id="apart_fax"/></td>
				</tr>
				<tr>
					<th>아파트 소재지</th>
					<td><input type="text" name="apart_address" value="${requestScope.apart.address}"></td>
				</tr>
			</table>
			<hr>
			<div>2. 관리자 정보</div>
			<table>
				<tr>
					<th>관리자 구분</th>
					<td>
						<label>
							<input class="admin_type" type="radio" name="admin_type" value="1" checked="checked">
							<span>선관위원장</span>
						</label>
						<label>
							<input class="admin_type" type="radio" name="admin_type" value="2">
							<span>선관위원</span>
						</label>
						<label>
							<input class="admin_type" type="radio" name="admin_type" value="3">
							<span>관리소장</span>
						</label>
						<label>
							<input class="admin_type" type="radio" name="admin_type" value="4">
							<span>관리소 직원</span>
						</label>
					</td>
				</tr>
				<tr>
					<th>관리자 성명</th>
					<td><input type="text" name="admin_name" value="${requestScope.admin.name}"></td>
					<th>직위</th>
					<td><input type="text" name="admin_rank" value="${requestScope.admin.rank}"></td>
				</tr>
				<tr>
					<th>연락처(유선)</th>
					<td><myTag:phoneInputForm type="tel" id="admin_tel"/></td>
					<th>연락처(무선)</th>
					<td><myTag:phoneInputForm type="phone" id="admin_phone"/></td>
				</tr>
				<tr>
					<th>이메일 주소</th>
					<td>
						<input type="hidden" id="admin_email" name="admin_email">
                        <input  type="text" id="admin_mail_id">@<input type="text" id="admin_mail_domain">
                        <select>
                        	<option value="direct">직접입력</option>
                        	<option value="paran.com">파란</option>
                        	<option value="naver.com">네이버</option>
                        	<option value="hanmail.net">한메일(다음)</option>
                        	<option value="nate.com">네이트</option>
                        	<option value="empal.com">엠파스</option>
                        	<option value="gmail.com">구글</option>
                        	<option value="yahoo.com">야후</option>
                        </select> 
                     </td>
				</tr>
			</table>
			<hr>
			<div>3. 투표 정보</div>
			<table>
				<tr>
					<th>투표 제목</th>
					<td><input type="text" name="vote_title" id="vote_title" value="${requestScope.vote.title}"></td>
				</tr>
				<tr>
					<th>투표 유형</th>
					<td>
						<label>
							<input class="vote_type" type="radio" name="vote_type" class="vote_type" value="1" checked="checked">
							<span>동대표 선거</span>
						</label>
						<label>
							<input class="vote_type" type="radio" name="vote_type" class="vote_type" value="2">
							<span>임원 투표</span>
						</label>
						<label>
							<input class="vote_type" type="radio" name="vote_type" class="vote_type" value="3">
							<span>기타 안건 투표</span>
						</label>
					</td>
				</tr>
				<tr>
					<th>예상 투표자 수</th>
					<td><input type="text" class="numberInput" name="vote_estimate" id="vote_estimate" value="${requestScope.vote.estimate}"></td>
				</tr>
				<tr>
					<th>투표 기간</th>
					<td>
						<myTag:dateSelectForm id="voteBegin"/>
						<span>~</span>
						<myTag:dateSelectForm id="voteEnd"/>
					</td>
				</tr>
				<tr>
					<th>투표 매체</th>
					<td>
						<label>
							<input type="checkbox" name="vote_media" class="vote_media" value="1">
							<span>PC(인터넷)</span>
						</label>
						<label>
							<input type="checkbox" name="vote_media" class="vote_media" value="2">
							<span>스마트폰(인터넷)</span>
						</label>
						<label>
							<input type="checkbox" name="vote_media" class="vote_media" value="3">
							<span>문자투표</span>
						</label>
						<label>
							<input type="checkbox" name="vote_media" class="vote_media" value="4">
							<span>현장투표소</span>
						</label>
					</td>
				</tr>
			</table>
			<hr>
			<div>4. 첨부 서류</div>
			<table>
				<tr>
					<th>고유번호증(사업자등록증)</th>
					<td>
						<input type="hidden" id="regisNumCardPath" name="regisNumCardPath">
						<label class="fileLabel" for="regisNumCard">고유번호증(사업자등록증) 등록</label>
						<input type="file" class="fileInput" id="regisNumCard" formenctype="multipart/form-data" oninput="sendFile(event,this)">
						<a id="regisNumCardDownload" onclick="downloadFile(event)" href="#"></a>
					</td>
				</tr>
				<tr>
					<th>투표신청 근거서류(회의록 등)</th>
					<td>
						<input type="hidden" id="baseDocPath" name="baseDocPath">
						<label class="fileLabel" for="baseDoc">투표신청 근거서류(회의록 등) 등록</label>
						<input type="file" class="fileInput" id="baseDoc" formenctype="multipart/form-data" oninput="sendFile(event,this)">
						<a id="baseDocDownload" onclick="downloadFile(event)" href="#"></a>
					</td>
				</tr>
				<tr>
					<th>관리소장 직인 및 배치신고 증명서</th>
					<td>
						<input type="hidden" id="managerCertifyPath" name="managerCertifyPath">
						<label class="fileLabel" for="managerCertify">관리소장 직인 및 배치신고 증명서 등록</label>
						<input type="file" class="fileInput" id="managerCertify" formenctype="multipart/form-data" oninput="sendFile(event,this)">
						<a id="managerCertifyDownload" onclick="downloadFile(event)" href="#"></a>
					</td>
				</tr>
				<tr>
					<th>개인정보수집 동의서</th>
					<td>
						<input type="hidden" id="persAgreementPath" name="persAgreementPath">
						<label class="fileLabel" for="persAgreement">개인정보수집 동의서 등록</label>
						<input type="file" class="fileInput" id="persAgreement" formenctype="multipart/form-data" oninput="sendFile(event,this)">
						<a id="persAgreementDownload" onclick="downloadFile(event)" href="#"></a>
					</td>
				</tr>
				<tr>
					<th>이용 협약서</th>
					<td>
						<input type="hidden" id="usageAgreementPath" name="usageAgreementPath">
						<label class="fileLabel" for="usageAgreement">이용 협약서 등록</label>
						<input type="file" class="fileInput" id="usageAgreement" formenctype="multipart/form-data" oninput="sendFile(event,this)">
						<a id="usageAgreementDownload" onclick="downloadFile(event)" href="#"></a>
					</td>
				</tr>
			</table>
			<hr>
			<br>
			<c:choose>
				<c:when test="${param.id eq null}">
					<button type="button" onclick="saveForm()">신청하기</button>
				</c:when>
				<c:otherwise>
					<button type="button" onclick="modifyForm(${param.id})">수정하기</button>
				</c:otherwise>
			</c:choose>
		</form>
	</div>
	<myTag:Footer />
	<c:if test="${param.id ne null}">
		<c:set var="vote_media" value="${requestScope.vote.media[0]}"/>
		<c:forEach var="media" items="${requestScope.vote.media}" begin="1">
			<c:set var="vote_media" value="${vote_media},${media}"/>
		</c:forEach>
		<c:set var="start_day" value="${requestScope.vote.startDay}"/>
		<c:set var="end_day" value="${requestScope.vote.endDay}"/>
		<script type="text/javascript">
			(function(){
				
				
				insertRadioType("apart_type", ${requestScope.apart.apartType});
				insertRadioType("rep_type", ${requestScope.apart.repType});
				insertRadioType("admin_type", ${requestScope.admin.type});
				insertRadioType("vote_type", ${requestScope.apart.apartType});
				
				insertVoteMedia();
				insertAdminEmail();
				
				insertTelNum("apart_tel","${requestScope.apart.tel}");
				insertTelNum("apart_fax","${requestScope.apart.fax}");
				insertTelNum("admin_tel","${requestScope.admin.tel}");
				insertTelNum("admin_phone","${requestScope.admin.phone}");
				
				insertDate("voteBegin","${start_day.year}",${start_day.month},${start_day.day},"${start_day.hour}","${start_day.minute}");
				insertDate("voteEnd","${end_day.year}",${end_day.month},${end_day.day},"${end_day.hour}","${end_day.minute}");
				
				
				insertFilePath("regisNumCard",String.raw`${requestScope.file.regisNumCardPath}`);
				insertFilePath("baseDoc",String.raw`${requestScope.file.baseDocPath}`);
				insertFilePath("managerCertify",String.raw`${requestScope.file.managerCertifyPath}`);
				insertFilePath("persAgreement",String.raw`${requestScope.file.persAgreementPath}`);
				insertFilePath("usageAgreement",String.raw`${requestScope.file.usageAgreementPath}`);
			})();
			
			function insertRadioType(className, type){
				var apart_type = document.getElementsByClassName(className);
				Array.prototype.forEach.call(apart_type, (element) => {
					if(element.value == type){
						element.checked = "checked";
					}
				})
			}
			
			function insertVoteMedia(){
				var vote_meida = document.getElementsByName("vote_media");
				var media_arr = [${vote_media}];
				Array.prototype.forEach.call(vote_meida, element => {
					if(media_arr.includes(element.value*=1)){
						element.checked = "checked";
					}
				})
			}
			
			function insertTelNum(id, number){
				document.getElementById(id+"1").value = number.split("-")[0];
				document.getElementById(id+"2").value = number.split("-")[1];
				document.getElementById(id+"3").value = number.split("-")[2];
			}
			
			function insertAdminEmail(){
				var admin_mail = "${requestScope.admin.email}";
				var mail_id = admin_mail.split("@")[0];
				var mail_domain = admin_mail.split("@")[1];
				
				document.getElementById("admin_mail_id").value = mail_id;
				document.getElementById("admin_mail_domain").value = mail_domain;
			}
			
			function insertDate(id, year, month, day, hour, min){
				document.getElementById(id+"Year").value = year;
				document.getElementById(id+"Month").value = month;
				document.getElementById(id+"Day").value = day;
				document.getElementById(id+"Hour").value = hour;
				document.getElementById(id+"Min").value = min;
			}
			
			function insertFilePath(id, fileName){
				var realFileName = fileName.replace(id+"\\", "");
				realFileName = realFileName.split("-")[1];
				document.getElementById(id+"Path").value = fileName;
				document.getElementById(id+"Download").innerHTML = realFileName;
				
			}
		</script>
	</c:if>
	<script src="/rlhvote/resources/script/DropdownMenu.js" type="text/javascript"></script>
	<script src="/rlhvote/resources/script/module/require.js" type="text/javascript"></script>
	<script src="/rlhvote/resources/script/Validate.js" type="text/javascript"></script>
	<script src="/rlhvote/resources/script/SendForm.js" type="text/javascript"></script>
</body>
</html>