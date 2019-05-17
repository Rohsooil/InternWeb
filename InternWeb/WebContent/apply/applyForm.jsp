<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rhvote/resources/css/default.css" type="text/css">
<link rel="stylesheet" href="/rhvote/resources/css/applicationForm.css" type="text/css">

</head>
<body>
	<myTag:Header />
	<div class="banner">
		<div id="banner_txt">
			<c:choose>
				<c:when test="${requestScope.vote eq null}">
					<h1>이용신청서 작성</h1>
					<h5>아래의 항목들을 작성 후 우측하단의 신청하기를 누르시면 중앙공동주택관리지원센터 담당자가 신청 내역을 확인할 수 있습니다.</h5>
				</c:when>
				<c:otherwise>
					<h1>이용신청서 수정</h1>
					<h5>이용신청서 내용을 수정하신 후 우측 하단의 수정완료를 누르시면 수정 내용이 적용됩니다.</h5>
				</c:otherwise>
			</c:choose>
		</div>
		<img width="100%" alt="no banner" src="/rhvote/resources/images/banner.png">
	</div>
	<div class="f_box">
		<br>
		<div class="formWrap">
			<form id="sendForm" accept-charset="UTF-8" method="post" enctype="application/x-www-form-urlencoded">
				<div>1. 아파트 정보</div>
				<hr>
				<div class="table">
					<div class="t_row">
						<div class="t_title">
							<span>아파트 명</span>
						</div>
						<div class="t_content">
							<span>
								<input type="text" name="apart_name" value="${requestScope.apart.name }">
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>아파트 구분</span>
						</div>
						<div class="t_content">
							<span>
								<myTag:radioBtn value="일반 주택" id="apart_type" number="1" modVal="${requestScope.apart.type }" />
								<myTag:radioBtn value="LH 임대 주택" id="apart_type" number="2" modVal="${requestScope.apart.type }" />
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>사업자 등록번호</span>
						</div>
						<div class="t_content">
							<span>
								<input type="text" id="apart_registerNum" class="numberInput" name="apart_registerNum" value="${requestScope.apart.registerNum}">
								<c:if test="${requestScope.apart.registerNum eq null}">
									<button id="authBtn">인증</button>
								</c:if>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>대표자 구분</span>
						</div>
						<div class="t_content">
							<span>
								<myTag:radioBtn value="선관위원장" id="apart_repType" number="1" modVal="${requestScope.apart.repType }" />
								<myTag:radioBtn value="입대의 회장" id="apart_repType" number="2" modVal="${requestScope.apart.repType }" />
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>대표자 성명</span>
						</div>
						<div class="t_content">
							<span>
								<input type="text" name="apart_repName" value="${requestScope.apart.repName}">
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title" style="flex: 1">
							<span>아파트 연락처 </span>
						</div>
						<div class="t_content" style="flex: 1.5">
							<span>
								<myTag:phoneInputForm type="tel" id="apart_tel" modValue="${requestScope.apart.tel }" />
							</span>
						</div>
						<div class="t_title" style="flex: 1">
							<span>팩스</span>
						</div>
						<div class="t_content" style="flex: 1.5">
							<span>
								<myTag:phoneInputForm type="tel" id="apart_fax" modValue="${requestScope.apart.fax }" />
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>아파트 소재지</span>
						</div>
						<div class="t_content">
							<span>
								<input type="text" name="apart_address" value="${requestScope.apart.address}">
							</span>
						</div>
					</div>
				</div>
				<br>

				<div>2. 관리자 정보</div>
				<hr>
				<div class="table">
					<div class="t_row">
						<div class="t_title">
							<span>관리자 구분</span>
						</div>
						<div class="t_content">
							<span>
								<myTag:radioBtn value="선관위원장" id="admin_type" number="1" modVal="${requestScope.admin.type }" />
								<myTag:radioBtn value="선관위원" id="admin_type" number="2" modVal="${requestScope.admin.type }" />
								<myTag:radioBtn value="관리소장" id="admin_type" number="3" modVal="${requestScope.admin.type }" />
								<myTag:radioBtn value="관리소 직원" id="admin_type" number="4" modVal="${requestScope.admin.type }" />
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title" style="flex: 1">
							<span>관리자 성명</span>
						</div>
						<div class="t_content" style="flex: 1.5">
							<span>
								<input type="text" name="admin_name" value="${requestScope.admin.name}">
							</span>
						</div>
						<div class="t_title" style="flex: 1">
							<span>직위</span>
						</div>
						<div class="t_content" style="flex: 1.5">
							<span>
								<input type="text" name="admin_position" value="${requestScope.admin.position}">
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title" style="flex: 1">
							<span>연락처(유선)</span>
						</div>
						<div class="t_content" style="flex: 1.5">
							<span>
								<myTag:phoneInputForm type="tel" id="admin_tel" modValue="${requestScope.admin.tel }" />
							</span>
						</div>
						<div class="t_title" style="flex: 1">
							<span>연락처(무선)</span>
						</div>
						<div class="t_content" style="flex: 1.5">
							<span>
								<myTag:phoneInputForm type="phone" id="admin_phone" modValue="${requestScope.admin.phone }" />
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>이메일 주소</span>
						</div>
						<div class="t_content">
							<span>
								<input type="hidden" id="admin_email" name="admin_email">
								<input type="text" id="admin_mail_id" value="${requestScope.admin.email.identifier}">
								@
								<input type="text" id="admin_mail_domain" value="${requestScope.admin.email.domain}">
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
							</span>
						</div>
					</div>
				</div>
				<br>

				<div>3. 투표 정보</div>
				<hr>
				<div class="table">
					<div class="t_row">
						<div class="t_title">
							<span>투표 제목</span>
						</div>
						<div class="t_content">
							<span>
								<input type="text" name="vote_title" id="vote_title" value="${requestScope.vote.title}">
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>투표 유형</span>
						</div>
						<div class="t_content">
							<span>
								<myTag:radioBtn value="동대표 선거" id="vote_type" number="1" modVal="${requestScope.vote.type }" />
								<myTag:radioBtn value="임원 투표" id="vote_type" number="2" modVal="${requestScope.vote.type }" />
								<myTag:radioBtn value="기타 안건 투표" id="vote_type" number="3" modVal="${requestScope.vote.type }" />
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>예상 투표자 수</span>
						</div>
						<div class="t_content">
							<span>
								<input type="text" class="numberInput" name="vote_estimate" id="vote_estimate" value="${requestScope.vote.estimate}">
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>투표 기간</span>
						</div>
						<div class="t_content">
							<span>
								<myTag:dateSelectForm id="vote_start" modValue="${requestScope.vote.startDate}" />
								<span>~</span>
								<myTag:dateSelectForm id="vote_end" modValue="${requestScope.vote.endDate}" />
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>투표 매체</span>
						</div>
						<div class="t_content">
							<span>
								<myTag:checkBox value="PC(인터넷)" id="pc" modVal="${requestScope.voteMedia.pc}" />
								<myTag:checkBox value="스마트폰(인터넷)" id="smartPhone" modVal="${requestScope.voteMedia.smartPhone}" />
								<myTag:checkBox value="문자투표" id="sms" modVal="${requestScope.voteMedia.sms}" />
								<myTag:checkBox value="현장투표소" id="onSite" modVal="${requestScope.voteMedia.onSite}" />
							</span>
						</div>
					</div>
				</div>
				<br>

				<div>4. 첨부 서류</div>
				<hr>
				<div class="table">
					<div class="t_row">
						<div class="t_title">
							<span>고유번호증(사업자등록증)</span>
						</div>
						<div class="t_content">
							<span>
								<input type="hidden" id="regisNumCardPath" name="file_regisNumCard" value="${requestScope.file.regisNumCard}">
								<label class="fileLabel" for="regisNumCard">고유번호증(사업자등록증) 등록</label>
								<input type="file" class="fileInput" id="regisNumCard">
								<a class="downloadFileBtn" id="regisNumCardDownload">${fn:split(requestScope.file.regisNumCard,"-")[1]}</a>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>투표신청 근거서류(회의록 등)</span>
						</div>
						<div class="t_content">
							<span>
								<input type="hidden" id="baseDocPath" name="file_baseDoc" value="${requestScope.file.baseDoc}">
								<label class="fileLabel" for="baseDoc">투표신청 근거서류(회의록 등) 등록</label>
								<input type="file" class="fileInput" id="baseDoc">
								<a class="downloadFileBtn" id="baseDocDownload">${fn:split(requestScope.file.baseDoc,"-")[1]}</a>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>관리소장 직인 및 배치신고 증명서</span>
						</div>
						<div class="t_content">
							<span>
								<input type="hidden" id="managerCertifyPath" name="file_managerCertify" value="${requestScope.file.managerCertify}">
								<label class="fileLabel" for="managerCertify">관리소장 직인 및 배치신고 증명서 등록</label>
								<input type="file" class="fileInput" id="managerCertify">
								<a class="downloadFileBtn" id="managerCertifyDownload">${fn:split(requestScope.file.managerCertify,"-")[1]}</a>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>개인정보수집 동의서</span>
						</div>
						<div class="t_content">
							<span>
								<input type="hidden" id="persAgreementPath" name="file_persAgreement" value="${requestScope.file.persAgreement}">
								<label class="fileLabel" for="persAgreement">개인정보수집 동의서 등록</label>
								<input type="file" class="fileInput" id="persAgreement">
								<a class="downloadFileBtn" id="persAgreementDownload">${fn:split(requestScope.file.persAgreement,"-")[1]}</a>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>이용 협약서</span>
						</div>
						<div class="t_content">
							<span>
								<input type="hidden" id="usageAgreementPath" name="file_usageAgreement" value="${requestScope.file.usageAgreement}">
								<label class="fileLabel" for="usageAgreement">이용 협약서 등록</label>
								<input type="file" class="fileInput" id="usageAgreement">
								<a class="downloadFileBtn" id="usageAgreementDownload">${fn:split(requestScope.file.usageAgreement,"-")[1]}</a>
							</span>
						</div>
					</div>
				</div>

				<br>

				<button id="postBtn" type="button">
					<c:choose>
						<c:when test="${requestScope.vote eq null}">신청하기</c:when>
						<c:otherwise>수정하기</c:otherwise>
					</c:choose>
				</button>

			</form>
		</div>
	</div>
	<myTag:Footer />

	<script src="/rhvote/resources/script/DropdownMenu.js" type="text/javascript"></script>
	<script src="/rhvote/resources/script/apply/ApplyForm.js" type="module"></script>

</body>
</html>