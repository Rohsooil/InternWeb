<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="myTag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rlhvote/resources/css/default.css"
	type="text/css">
</head>
<body>

	<myTag:Header />
	<div class="f_box"
		style="height: 1000px; background-color: black; color: white;">
		<h2>아파트 e투표 이용에 관한 확인 사항(필수)</h2>
		<div class="txtform">
            <p>아파트e투표를 이용하는데 필요한 기본적 확인사항을 안내하는 것이며 서비스 이용에 필요한 구체적 사항은 중앙공동주택관리지원센터(이하 지원센터)와 아파트간 체결하는 이용협약서에 명시하여야 합니다. *이용협약서(안)은 게시판 참조(고객센터-자료실)</p>
			<p class="detail">
				<br>1. 아파트e투표는 아파트의 신청에 따라 지원센터가 제공하는 서비스로 해당 투표의 관리는 아파트의 책임 하에 이루어집니다.
				<br>2. 아파트e투표는 이용신청 → 이용협약 체결 → 사용 승인의  절차를 마친 후 이용할 수 있습니다. 
				<br>3. 다음의 각 호에 해당하는 경우 사용 승인을 거절할 수 있습니다.
				<br>  가. 기술상 서비스 제공이 불가능한 경우
				<br>  나. 실명이 아니거나, 타인의 명의를 도용하여 허위로 신청하는 경우 
				<br>  다. 등록사항을 누락하거나 오기하여 신청하는 경우
				<br>  라. 악성 프로그램 및 버그를 이용하거나 시스템 취약점을 악용하는 등 부정한 방법을 서비스에 사용한 경우
				<br>  마. 지원센터가 지원하는 대상에 해당하지 않는 경우 
				<br>  바. 기타 ‘지원센터’가 서비스 제공이 불가능하거나 사회적 민감성, 업무상황 등을 고려하여 부적절하다고 판단한 경우 
				<br>4. 아파트는 투표 실시 전 투표자 명부를 작성하여야 하고, 투표자 명부 작성에 필요한 개인정보(생년월일, 휴대폰번호 등) 수집이나 잘못된 투표자 정보 등으로 인한 책임은 아파트에 있습니다.
				<br>5. 아파트는 투표 절차 및 그 결과의 정당한 효력 발생을 위해 아파트e투표를 활용하는 것이 내부 규정 등에 부합하는지 여부를 직접 확인하여야 하고, 그 위반으로 인하여 발생하는 문제에 대해서는 ‘지원센터’가 책임지지 않습니다.  
				<br>6. 투표 중 투표자 명부 수정 기능, 미투표자대상 메시지 발송내역 조회기능, 개표 권한 분할 기능 등은 사용여부를 사전에 명확히 결정하여 투표 개설 전 지원센터로 요청하여야 하며, 이들 기능의 요청으로 발생하는 문제에 대해서는 지원센터가 책임지지 않습니다.
				<br>7. 시스템을 통해 투표자에게 발송하는 문자메시지는 통신사의 사정, 기기의 종류 또는 설정(스팸처리) 등의 이유로 인해 전송이 지연되거나 실패할 수 있습니다.
				<br>8. 투표자에게 발송되는 문자메시지는 02-704-3545로 발송되며, 투표 매체에 ‘문자투표’를 사용하는 경우 1899-3545에서 추가로 발송됩니다.
				<br>9. 기본적으로 제공되는 문자메시지 수량은 SMS 기준으로 투표자 수 X 10건이며, 추가로 발송하고자 하는 경우 SMS 1건당 20원(VAT 별도)의 비용으로 충전하여야 하고, 투표 종료 후 잔여 SMS에 대한 환불은 불가합니다.
				<br>10. 투표자 1명이 2건 이상의 투표를 동시에 진행하는 경우 투표 매체 중 ‘문자투표’는 지원되지 않습니다.
				<br>11. 투표자의 투표참여 여부가 표시된 투표자 명부는 투표 종료 후에 다운로드 받을 수 있습니다.
				<br>
			</p>
		</div>
		<label>
			<input type="checkbox" name="step1" id="step1">
			<span>위 내용을 충분히 숙지하고 확인합니다</span>
		</label>
		<div style="height: 40px; display: block;"></div>
		<h2>아파트 e투표 개인정보처리방침(필수)</h2>
		<div class="txtform">
            <p>중앙공동주택관리지원센터(이하 ‘지원센터’)는「개인정보 보호법」등 관련 법령상의 개인정보보호규정을 준수하여 개인정보의 수집ㆍ보유 및 처리를 적정히 수행하고 있습니다. 
            <br>이 방침은 중앙공동주택관리지원센터에서 제공하는 아파트e투표에 적용되며, 본 처리방침은 수시로 내용이 변경될 수 있으니 정기적으로 방문하여 확인하시기 바랍니다. </p>
			<p class="detail">
				<br>
					1. 개인정보의 처리 목적 <br>
					지원센터는 대국민서비스제공, 민원처리 및 소관 업무수행 등의 목적에 필요한 범위에서 최소한의 개인정보를 수집하고 있습니다. <br>
					처리하고 있는 개인정보는 목적 이외의 용도로는 사용되지 않으며, 이용 목적이 변경되는 경우는 별도의 동의를 받는 등 필요한 조치를 이행하겠습니다. <br>
					<br>
					2. 개인정보의 처리 및 보유기간 <br>
					지원센터는 본 서비스 제공에 따른 개인정보를 아래의 기간 동안 보유하고 활용합니다. <br>
					ㅇ 아파트 관리자 계정, 아파트 투표자 등 개인정보 : 투표 종료 후 1주일 <br>
					ㅇ 아파트 정보 및 수수료 납부에 대한 정보 : 5년 (국세기본법 제85조3)<br>
					<br>
					3. 개인정보의 제3자 제공 <br>
					지원센터는 원칙적으로 정보주체의 개인정보를 수집•이용 목적으로 명시한 범위 내에서 처리하며, 다음의 경우를 제외하고는 정보주체의 사전 동의 없이는 본래의 목적 범위를 초과하여 처리하거나 제3자에게 제공하지 않습니다. <br>
					가. 정보주체로부터 별도의 동의를 받는 경우 <br>
					나. 법률에 특별한 규정이 있는 경우 <br>
					다. 정보주체 또는 법정대리인이 의사표시를 할 수 없는 상태에 있거나 주소불명 등으로 사전 동의를 받을 수 없는 경우로서 명백히 정보주체 또는 제3자의 급박한 생명, 신체, 재산의 이익을 위하여 필요하다고 인정되는 경우 <br>
					라. 통계작성 및 학술연구 등의 목적을 위하여 필요한 경우로서 특정 개인을 알아 볼 수 없는 형태로 개인정보를 제공하는 경우 <br>
					마. 개인정보를 목적 외의 용도로 이용하거나 이를 제3자에게 제공하지 아니하면 다른 법률에서 정하는 소관 업무를 수행할 수 없는 경우로서 개인정보 보호위원회의 심의•의결을 거친 경우 <br>
					바. 조약, 그 밖의 국제협정의 이행을 위하여 외국정부 또는 국제기구에 제공하기 위하여 필요한 경우<br>
					사. 범죄의 수사와 공소의 제기 및 유지를 위하여 필요한 경우 <br>
					아. 법원의 재판업무 수행을 위하여 필요한 경우 <br>
					자. 형 및 감호, 보호처분의 집행을 위하여 필요한 경우 <br>
					<br>
					4. 개인정보 처리의 위탁 <br>
					지원센터는 아파트e투표의 플랫폼 관리와 서비스 부대업무의 대행 등 “아파트” 편의 제공, 기술지원 등을 위하여 개인정보 처리업무를 위탁하고 있으며, 수탁자에 대해서는 "위•수탁기관간 계약서" 등을 통하여 관련 법규 및 지침의 준수, 정보보호 및 비밀유지, 제3자 제공 금지, 사고 시 책임부담, 위탁기간 종료 즉시 개인정보의 반납/파기 의무 등 책임에 관한 사항을 계약서 등 문서에 명시하고, 수탁자가 개인정보를 안전하게 관리하는지를 감독하고 있습니다. <br>
					- 수탁기관명 : ㈜한국전자투표 <br>
					- 위탁업무내용 : 개인정보의 기술적•관리적 보호조치, 개인정보 파기, 수수료 청구업무, 고지사항 전달, 서비스 이용에 따른 확인, 불만처리 등 민원처리, 시스템 장애처리 등 서비스 관련 안내 및 기술지원에 관한 사항 <br>
					- 위탁기간 : 협약체결일(2018.07.31.)로부터 36개월 <br>
					<br>
					5. 정보주체의 권리‧의무 및 그 행사방법 <br>
					정보주체는 지원센터에 대하여 언제든지 다음의 개인정보보호 관련 권리를 행사할 수 있습니다. <br>
					다만, 투표자 명부에 대한 권리는 아파트에 행사하여야 합니다. <br>
					- 개인정보 열람요구 <br>
					- 오류 등이 있을 경우 정정 요구 <br>
					- 삭제요구 <br>
					- 처리정지 요구 <br>
					권리행사는 지원센터에 대하여 「개인정보보호법시행규칙」 별지 제8호서식에 따라 서면, 전자우편, 모사전송(FAX) 등을 통하여 할 수 있으며, 지원센터는 이에 대하여 관련 법령에 따라 지체 없이 조치하겠습니다. <br>
					<br>
					정보주체가 개인정보의 오류 등에 대한 정정 또는 삭제를 요구한 경우에는 지원센터는 정정 또는 삭제를 완료할 때까지 당해 개인정보를 이용하거나 제공하지 않습니다. 권리행사는 정보주체의 법정대리인이나 위임을 받은 자 등 대리인을 통하여 하실 수 있습니다. 이 경우 「개인정보보호법시행규칙」별지 제11호서식에 따른 위임장을 제출하셔야 합니다. <br>
					정보주체는 지원센터가 처리하는 개인정보를 부정한 방법으로 취득하거나 열람, 제공, 사용하여서는 안됩니다. <br>
					<br>
					6. 처리하는 개인정보의 항목 및 수집방법 <br>
					가. “지원센터” 아파트e투표는 다음의 개인정보를 처리하고 있습니다. <br>
					- 아파트 관리자 성명, 직위, 연락처(유•무선), 주소 등 <br>
					- 아파트 투표자 성명, 연락처(무선) 등 <br>
					- 후보자 경력, 학력, 연령, 사진 등 선거 및 투표 실시를 위한 사항 <br>
					- 아파트 명, 대표자명, 사업자등록번호, 사무소 소재지, 연락처 <br>
					나. 아파트e투표는 다음과 같은 방법으로 개인정보를 수집합니다. <br>
					- 아파트e투표 시스템상 정보입력 <br>
					- 아파트e투표 서비스 이용신청서 및 관련 서류 접수 <br>
					<br>
					7. 개인정보의 파기 <br>
					지원센터는 원칙적으로 개인정보 처리목적이 달성된 경우에는 지체없이 해당 개인정보를 파기합니다. 다만, 다른 법률에 따라 보존하여야 하는 경우에는 그러하지 않습니다. 파기의 절차, 기한 및 방법은 다음과 같습니다. <br>
					<br>
					가. 파기절차 <br>
					- 수집된 개인정보는 보유기간 경과, 처리목적 달성 후 관련 법령 및 내부 지침에 따라 지체 없이 파기됩니다. <br>
					나. 파기기한 <br>
					- 수집된 개인정보는 개인정보의 보유기간이 경과된 경우 보유기간의 종료일부터 5일 이내에, 개인정보의 처리 목적 달성 등 그 개인정보가 불필요하게 되었을 때에는 개인정보의 처리가 불필요한 것으로 인정되는 날로부터 5일 이내에 그 개인정보를 파기합니다. <br>
					다. 파기방법 <br>
					- 전자적 파일 형태의 경우 : 복원이 불가능한 방법으로 영구 삭제 <br>
					- 기록물, 인쇄물, 서면, 그 밖의 기록매체 : 파쇄 또는 소각 <br>
					<br>
					8. 개인정보의 안전성 확보조치 <br>
					개인정보보호법 제29조에 따라 다음과 같이 안전성 확보에 필요한 기술적/관리적 및 물리적 조치를 하고 있습니다. <br>
					가. 개인정보 처리 직원의 최소화 및 교육 <br>
					개인정보를 처리하는 직원을 지정하고 담당자에 한정시켜 최소화 하여 개인정보를 관리하는 대책을 시행하고 있습니다. <br>
					나. 내부관리계획의 수립 및 시행 <br>
					개인정보의 안전한 처리를 위하여 내부관리계획을 수립하여 시행하고 있습니다. <br>
					다. 개인정보에 대한 접근 제한 <br>
					개인정보를 처리하는 데이터베이스시스템에 대한 접근권한의 부여․변경․말소를 통하여 개인정보에 대한 접근통제를 위한 필요한 조치를 하고 있으며 침입차단시스템을 이용하여 외부로부터의 무단 접근을 통제하고 있습니다. <br>
					라. 접속기록의 보관 및 위조ㆍ변조 방지 <br>
					개인정보처리시스템에 접속한 기록(웹 로그, 요약정보 등)을 최소 6개월 이상 보관․관리하고 있으며, 접속 기록이 위조ㆍ변조 및 도난, 분실되지 않도록 보안기능을 사용하고 있습니다. <br>
					마. 개인정보의 암호화 <br>
					이용자의 개인정보는 암호화 등을 통해 안전하게 관리되고 있으며, 중요한 데이터는 저장 및 전송 시 암호화하여 사용하고 있습니다. <br>
					바. 해킹 등에 대비한 기술적 대책 <br>
					해킹이나 컴퓨터 바이러스 등에 의한 개인정보 유출 및 훼손을 막기 위하여 보안프로그램을 설치하고 주기적인 갱신•점검을 하며 외부로부터 접근이 통제된 구역에 시스템을 설치하고 기술적‧물리적으로 감시 및 차단하고 있습니다. <br>
					사. 문서보안을 위한 잠금장치 사용 <br>
					개인정보가 포함된 서류, 보조저장매체 등을 잠금장치가 있는 안전한 장소에 보관하고 있습니다. <br>
					아. 비인가자에 대한 출입 통제 <br>
					개인정보를 보관하고 있는 개인정보시스템의 물리적 보관 장소를 별도로 두고 이에 대해 출입통제 절차를 수립, 운영하고 있습니다. <br>
					<br>
					9. 개인정보 침해사항의 신고 <br>
					지원센터 홈페이지 이용 중 개인정보의 유출 가능성 등 정보주체의 권익이 침해될 우려가 있는 사실을 발견하였을 경우는 홈페이지 개선의견을 통해 의견을 주시거나, 개인정보관리책임자에게 전자우편(E-mail)으로 의견을 주시면 접수 즉시 조치하여 처리결과를 통보해 드립니다. <br>
					지원센터의 자체적인 개인정보 불만처리 및 피해구제 결과에 만족하지 못하시거나 보다 자세한 도움이 필요하시면 다음의 기관으로 문의하여 주시기 바랍니다. <br>
					- 개인정보침해신고센터(한국인터넷진흥원 운영) : 118번(privacy.kisa.or.kr) <br>
					- 대검찰청 사이버범죄수사단 : 02-3480-3573(www.spo.go.kr) <br>
					- 경찰청 사이버안전국 : (국번없이) 182 (cyberbureau.police.go.kr) <br>
					<br>
					10. 개인정보 관리책임자 <br>
					지원센터는 개인정보를 보호하고 개인정보와 관련된 업무를 수행하기 위하여 다음과 같이 개인정보 관리책임자를 지정하고 있습니다. <br>
					가. 관리지원부<br>
					- 전화번호 : 031-738-5090<br>
					- 주 소 : 경기도 성남시 분당구 성남대로 54번길3, 6층 <br>
					- 이메일 : tndls0803@lh.or.kr<br>
					나. 개인정보 처리업무 수탁사 <br>
					- 담당자 : ㈜한국전자투표<br>
					- 이메일 : pjay2006@kevoting.com<br>
					- 전화번호 : 070-7791-1102<br>
				</p>
			</div>
		<label>
			<input type="checkbox" name="step2" id="step2">
			<span>위 내용을 충분히 숙지하고 확인합니다</span>
		</label>
		<a id="next" href="#" style="background-color: white">다 음</a>
	</div>
	<myTag:Footer />
	<script src="/rlhvote/resources/script/DropdownMenu.js" type="text/javascript" charset="utf-8"></script>
	<script src="/rlhvote/resources/script/CheckPolicy.js"	type="text/javascript" charset="utf-8"></script>
</body>
</html>