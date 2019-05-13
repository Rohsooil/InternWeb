<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rlhvote/resources/css/default.css" type="text/css">
<link rel="stylesheet" href="/rlhvote/resources/css/applicationForm.css" type="text/css">
</head>
<body>
	<myTag:Header />
	<div class="banner">
		<div id="banner_txt">
			<h1>이용신청서 작성</h1>
			<h5>아래의 항목들을 작성 후 우측하단의 신청하기를 누르시면 중앙공동주택관리지원센터 담당자가 신청 내역을 확인할 수 있습니다.</h5>
		</div>
		<img width="100%" alt="no banner" src="/rlhvote/resources/images/banner.png">
	</div>
	<div class="f_box">
		<br>
		<div class="formWrap">
			<form action="/rlhvote/apply/application" accept-charset="UTF-8" method="post">
				<div>1. 아파트 정보</div>
				<hr>
				<div class="table">
					<div class="t_row">
						<div class="t_title">
							<span>아파트 명</span>
						</div>
						<div class="t_content">
							<span>
								<input type="text" name="apart_name" value="${requestScope.apart.apartName }">
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>아파트 구분</span>
						</div>
						<div class="t_content">
							<span>
								<input id="normal_apart" class="apart_type" type="radio" name="apart_type" value="일반 주택" checked="checked">
								<label for="normal_apart">
									<span class="radio_btn"></span>
									<span>일반 주택</span>
								</label>
								<input id="lh_apart" class="apart_type" type="radio" name="apart_type" value="LH 임대 주택">
								<label for="lh_apart">
									<span class="radio_btn"></span>
									<span>LH 임대 주택</span>
								</label>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>사업자 등록번호</span>
						</div>
						<div class="t_content">
							<span>
								<input type="text" id="register_num" class="numberInput" name="register_num" value="${requestScope.apart.registerNum}">
								<button onclick="authorize(event)">인증</button>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>대표자 구분</span>
						</div>
						<div class="t_content">
							<span>
								<input id="rep1" class="rep_type" type="radio" name="rep_type" value="선관위원장" checked="checked">
								<label for="rep1">
									<span class="radio_btn"></span>
									<span>선관위원장</span>
								</label>
								<input id="rep2" class="rep_type" type="radio" name="rep_type" value="입대의 회장">
								<label for="rep2">
									<span class="radio_btn"></span>
									<span>입대의 회장</span>
								</label>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>대표자 성명</span>
						</div>
						<div class="t_content">
							<span>
								<input type="text" name="rep_name" value="${requestScope.apart.repName}">
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title" style="flex: 1">
							<span>아파트 연락처 </span>
						</div>
						<div class="t_content" style="flex: 1.5">
							<span>
								<myTag:phoneInputForm type="tel" id="apart_tel" />
							</span>
						</div>
						<div class="t_title" style="flex: 1">
							<span>팩스</span>
						</div>
						<div class="t_content" style="flex: 1.5">
							<span>
								<myTag:phoneInputForm type="tel" id="apart_fax" />
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
								<input id="admin1" class="admin_type" type="radio" name="admin_type" value="선관위원장" checked="checked">
								<label for="admin1">
									<span class="radio_btn"></span>
									<span>선관위원장</span>
								</label>
								<input id="admin2" class="admin_type" type="radio" name="admin_type" value="선관위원">
								<label for="admin2">
									<span class="radio_btn"></span>
									<span>선관위원</span>
								</label>
								<input id="admin3" class="admin_type" type="radio" name="admin_type" value="관리소장">
								<label for="admin3">
									<span class="radio_btn"></span>
									<span>관리소장</span>
								</label>
								<input id="admin4" class="admin_type" type="radio" name="admin_type" value="관리소 직원">
								<label for="admin4">
									<span class="radio_btn"></span>
									<span>관리소 직원</span>
								</label>
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
								<input type="text" name="admin_rank" value="${requestScope.admin.rank}">
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title" style="flex: 1">
							<span>연락처(유선)</span>
						</div>
						<div class="t_content" style="flex: 1.5">
							<span>
								<myTag:phoneInputForm type="tel" id="admin_tel" />
							</span>
						</div>
						<div class="t_title" style="flex: 1">
							<span>연락처(무선)</span>
						</div>
						<div class="t_content" style="flex: 1.5">
							<span>
								<myTag:phoneInputForm type="phone" id="admin_phone" />
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
								<input id="vote1" class="vote_type" type="radio" name="vote_type" class="vote_type" value="동대표 선거" checked="checked">
								<label for="vote1">
									<span class="radio_btn"></span>
									<span>동대표 선거</span>
								</label>
								<input id="vote2" class="vote_type" type="radio" name="vote_type" class="vote_type" value="임원 투표">
								<label for="vote2">
									<span class="radio_btn"></span>
									<span>임원 투표</span>
								</label>
								<input id="vote3" class="vote_type" type="radio" name="vote_type" class="vote_type" value="기타 안건 투표">
								<label for="vote3">
									<span class="radio_btn"></span>
									<span>기타 안건 투표</span>
								</label>
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
								<myTag:dateSelectForm id="voteStart" />
								<span>~</span>
								<myTag:dateSelectForm id="voteEnd" />
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>투표 매체</span>
						</div>
						<div class="t_content">
							<span>
								<input type="checkbox" name="vote_media" id="pc" class="vote_media" value="pc">
								<label for="pc">
									<span class="chk_box"></span>
									<span>PC(인터넷)</span>
								</label>
								<input type="checkbox" name="vote_media" id="smartPhone" class="vote_media" value="smartPhone">
								<label for="smartPhone">
									<span class="chk_box"></span>
									<span>스마트폰(인터넷)</span>
								</label>
								<input type="checkbox" name="vote_media" id="sms" class="vote_media" value="sms">
								<label for="sms">
									<span class="chk_box"></span>
									<span>문자투표</span>
								</label>
								<input type="checkbox" name="vote_media" id="onSite" class="vote_media" value="onSite">
								<label for="onSite">
									<span class="chk_box"></span>
									<span>현장투표소</span>
								</label>
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
								<input type="hidden" id="regisNumCardPath" name="regisNumCardPath">
								<label class="fileLabel" for="regisNumCard">고유번호증(사업자등록증) 등록</label>
								<input type="file" class="fileInput" id="regisNumCard" formenctype="multipart/form-data">
								<a class="downloadFileBtn" id="regisNumCardDownload" href="#"></a>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>투표신청 근거서류(회의록 등)</span>
						</div>
						<div class="t_content">
							<span>
								<input type="hidden" id="baseDocPath" name="baseDocPath">
								<label class="fileLabel" for="baseDoc">투표신청 근거서류(회의록 등) 등록</label>
								<input type="file" class="fileInput" id="baseDoc" formenctype="multipart/form-data">
								<a class="downloadFileBtn" id="baseDocDownload" href="#"></a>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>관리소장 직인 및 배치신고 증명서</span>
						</div>
						<div class="t_content">
							<span>
								<input type="hidden" id="managerCertifyPath" name="managerCertifyPath">
								<label class="fileLabel" for="managerCertify">관리소장 직인 및 배치신고 증명서 등록</label>
								<input type="file" class="fileInput" id="managerCertify" formenctype="multipart/form-data">
								<a class="downloadFileBtn" id="managerCertifyDownload" href="#"></a>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>개인정보수집 동의서</span>
						</div>
						<div class="t_content">
							<span>
								<input type="hidden" id="persAgreementPath" name="persAgreementPath">
								<label class="fileLabel" for="persAgreement">개인정보수집 동의서 등록</label>
								<input type="file" class="fileInput" id="persAgreement" formenctype="multipart/form-data">
								<a class="downloadFileBtn" id="persAgreementDownload" href="#"></a>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>이용 협약서</span>
						</div>
						<div class="t_content">
							<span>
								<input type="hidden" id="usageAgreementPath" name="usageAgreementPath">
								<label class="fileLabel" for="usageAgreement">이용 협약서 등록</label>
								<input type="file" class="fileInput" id="usageAgreement" formenctype="multipart/form-data">
								<a class="downloadFileBtn" id="usageAgreementDownload" href="#"></a>
							</span>
						</div>
					</div>
				</div>

				<br>

				<button id="postBtn" type="button">수정하기</button>

			</form>
		</div>
	</div>
	<myTag:Footer />

	<script src="/rlhvote/resources/script/DropdownMenu.js" type="text/javascript"></script>
	<script src="/rlhvote/resources/script/module/require.js" type="text/javascript"></script>
	<script src="/rlhvote/resources/script/apply/ApplyForm.js" type="text/javascript"></script>
</body>
</html>