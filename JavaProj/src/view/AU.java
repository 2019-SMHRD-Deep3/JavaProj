package view;

import javax.swing.JPanel;

import controller.MemberManagementService;
import model.Member;
import java.awt.Color;

public class AU extends JPanel {	// ȸ������ �� �ڽ��� ������ Ȯ�θ� ���� (���̵�, �н�����, �̸�, �ֹι�ȣ, �ּ�, ����ó)
	
	private MemberManagementService service = new MemberManagementService();
	/**
	 * Create the panel.
	 */
	public AU(Member loginUser) {
		setBackground(Color.WHITE);

	}

}
