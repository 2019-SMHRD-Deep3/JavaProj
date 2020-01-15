package view;

import javax.swing.JPanel;

import controller.MemberManagementService;
import model.Member;

public class AU extends JPanel {	// 회원정보 중 자신의 데이터 확인만 가능 (아이디, 패스워드, 이름, 주민번호, 주소, 연락처)
	
	private MemberManagementService service = new MemberManagementService();
	/**
	 * Create the panel.
	 */
	public AU(Member loginUser) {

	}

}
