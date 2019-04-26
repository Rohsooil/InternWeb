<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="myTag" tagdir="/WEB-INF/tags"%>
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
		<form action="/rlhvote/apply/application" method="post">
			<div>1. 아파트 정보</div>
			<table>
				<tr>
					<th>아파트 명</th>
					<td><input type="text" name="apart_name"></td>
				</tr>
				<tr>
					<th>아파트 구분</th>
					<td>
						<label>
							<input type="radio" name="apart_type" value="1">
							<span>일반 주택</span>
						</label>
						<label>
							<input type="radio" name="apart_type" value="2">
							<span>LH 임대 주택</span>
						</label>
					</td>
				</tr>
				<tr>
					<th>사업자 등록번호</th>
					<td>
						<input type="text" class="numberInput" name="register_num">
						<button>인증</button>
					</td>
				</tr>
				<tr>
					<th>대표자 구분</th>
					<td>
						<label>
							<input type="radio" name="rep_type" value="1">
							<span>선관위원장</span>
						</label>
						<label>
							<input type="radio" name="rep_type" value="2">
							<span>입대의 회장</span>
						</label>
					</td>
				</tr>
				<tr>
					<th>대표자 성명</th>
					<td><input type="text" name="rep_name"></td>
				</tr>
				<tr>
					<th>아파트 연락처</th>
					<td><myTag:phoneInputForm type="tel" id="apart_tel"/></td>
					<th>팩스</th>
					<td><myTag:phoneInputForm type="tel" id="apart_fax"/></td>
				</tr>
				<tr>
					<th>아파트 소재지</th>
					<td><input type="text" name="apart_address"></td>
				</tr>
			</table>
			<hr>
			<div>2. 관리자 정보</div>
			<table>
				<tr>
					<th>관리자 구분</th>
					<td>
						<label>
							<input type="radio" name="admin_type" value="1">
							<span>선관위원장</span>
						</label>
						<label>
							<input type="radio" name="admin_type" value="2">
							<span>선관위원</span>
						</label>
						<label>
							<input type="radio" name="admin_type" value="3">
							<span>관리소장</span>
						</label>
						<label>
							<input type="radio" name="admin_type" value="4">
							<span>관리소 직원</span>
						</label>
					</td>
				</tr>
				<tr>
					<th>관리자 성명</th>
					<td><input type="text" name="admin_name"></td>
					<th>직위</th>
					<td><input type="text" name="admin_rank"></td>
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
					<td><input type="text" name="vote_title" id="vote_title"></td>
				</tr>
				<tr>
					<th>투표 유형</th>
					<td>
						<label>
							<input type="radio" name="vote_type" class="vote_type" value="1">
							<span>동대표 선거</span>
						</label>
						<label>
							<input type="radio" name="vote_type" class="vote_type" value="2">
							<span>임원 투표</span>
						</label>
						<label>
							<input type="radio" name="vote_type" class="vote_type" value="3">
							<span>기타 안건 투표</span>
						</label>
					</td>
				</tr>
				<tr>
					<th>예상 투표자 수</th>
					<td><input type="text" class="numberInput" name="vote_estimate" id="vote_estimate" ></td>
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
						<input type="file" id="regisNumCard" formenctype="multipart/form-data" oninput="sendFile(event,this)">
					</td>
				</tr>
				<tr>
					<th>투표신청 근거서류(회의록 등)</th>
					<td>
						<input type="hidden" id="baseDocPath" name="baseDocPath">
						<input type="file" id="baseDoc" formenctype="multipart/form-data" oninput="sendFile(event,this)">
					</td>
				</tr>
				<tr>
					<th>관리소장 직인 및 배치신고 증명서</th>
					<td>
						<input type="hidden" id="managerCertifyPath" name="managerCertifyPath">
						<input type="file" id="managerCertify" formenctype="multipart/form-data" oninput="sendFile(event,this)">
					</td>
				</tr>
				<tr>
					<th>개인정보수집 동의서</th>
					<td>
						<input type="hidden" id="persAgreementPath" name="persAgreementPath">
						<input type="file" id="persAgreement" formenctype="multipart/form-data" oninput="sendFile(event,this)">
					</td>
				</tr>
				<tr>
					<th>이용 협약서</th>
					<td>
						<input type="hidden" id="usageAgreementPath" name="usageAgreementPath">
						<input type="file" id="usageAgreement" formenctype="multipart/form-data" oninput="sendFile(event,this)">
					</td>
				</tr>
			</table>
			<hr>
			<br>
			<button type="button" onclick="saveForm()">신청하기</button>
		</form>
	</div>
	<myTag:Footer />
	<script src="/rlhvote/resources/script/DropdownMenu.js" type="text/javascript"></script>
	<script src="/rlhvote/resources/script/ValidateNumber.js" type="text/javascript"></script>
	<script src="/rlhvote/resources/script/applyFormValidate.js" type="text/javascript"></script>
</body>
</html>