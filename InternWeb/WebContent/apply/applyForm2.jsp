<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<h1>이용신청서 작성</h1>
			<h5>아래의 항목들을 작성 후 우측하단의 신청하기를 누르시면 중앙공동주택관리지원센터 담당자가 신청 내역을 확인할 수 있습니다.</h5>
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
								<input type="text" name="apart_name">
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>아파트 구분</span>
						</div>
						<div class="t_content">
							<span>
								<myTag:radioBtn value="일반 주택" id="apart" number="1"/>
								<myTag:radioBtn value="LH 임대 주택" id="apart" number="2"/>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>사업자 등록번호</span>
						</div>
						<div class="t_content">
							<span>
								<input type="text" id="register_num" class="numberInput" name="register_num">
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
								<myTag:radioBtn value="선관위원장" id="rep" number="1"/>
								<myTag:radioBtn value="입대의 회장" id="rep" number="2"/>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>대표자 성명</span>
						</div>
						<div class="t_content">
							<span>
								<input type="text" name="rep_name">
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
								<input type="text" name="apart_address">
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
								<myTag:radioBtn value="선관위원장" id="admin" number="1"/>
								<myTag:radioBtn value="선관위원" id="admin" number="2"/>
								<myTag:radioBtn value="관리소장" id="admin" number="3"/>
								<myTag:radioBtn value="관리소 직원" id="admin" number="4"/>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title" style="flex: 1">
							<span>관리자 성명</span>
						</div>
						<div class="t_content" style="flex: 1.5">
							<span>
								<input type="text" name="admin_name">
							</span>
						</div>
						<div class="t_title" style="flex: 1">
							<span>직위</span>
						</div>
						<div class="t_content" style="flex: 1.5">
							<span>
								<input type="text" name="admin_position">
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
								<input type="text" id="admin_mail_id"> @ <input type="text" id="admin_mail_domain">
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
								<input type="text" name="vote_title" id="vote_title">
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>투표 유형</span>
						</div>
						<div class="t_content">
							<span>
								<myTag:radioBtn value="동대표 선거" id="vote" number="1"/>
								<myTag:radioBtn value="임원 투표" id="vote" number="2"/>
								<myTag:radioBtn value="기타 안건 투표" id="vote" number="3"/>
							</span>
						</div>
					</div>
					<div class="t_row">
						<div class="t_title">
							<span>예상 투표자 수</span>
						</div>
						<div class="t_content">
							<span>
								<input type="text" class="numberInput" name="vote_estimate" id="vote_estimate">
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
								<input type="file" class="fileInput" id="regisNumCard">
								<a class="downloadFileBtn" id="regisNumCardDownload"></a>
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
								<input type="file" class="fileInput" id="baseDoc">
								<a class="downloadFileBtn" id="baseDocDownload"></a>
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
								<input type="file" class="fileInput" id="managerCertify">
								<a class="downloadFileBtn" id="managerCertifyDownload"></a>
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
								<input type="file" class="fileInput" id="persAgreement">
								<a class="downloadFileBtn" id="persAgreementDownload"></a>
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
								<input type="file" class="fileInput" id="usageAgreement">
								<a class="downloadFileBtn" id="usageAgreementDownload"></a>
							</span>
						</div>
					</div>
				</div>

				<br>
				<button id="postBtn" type="button">신청하기</button>

			</form>
		</div>
	</div>
	<myTag:Footer />
	
	<script src="/rhvote/resources/script/DropdownMenu.js" type="text/javascript"></script>
	<script src="/rhvote/resources/script/apply/ApplyForm.js" type="module"></script>
</body>
</html>