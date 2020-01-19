package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Book;

public class DFirst extends JPanel {
//	private String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//book001.jpg";
//	private String imgPath2 = this.getClass().getResource(".").getPath() + "..//..//img//book002.jpg";
	private MemberManagementService service = new MemberManagementService();
	private Book b;

	public DFirst() {
		setBackground(new Color(240, 245, 249));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\SM013\\git\\JavaProjRepository\\JavaProj\\img\\book001.jpg"));
		lblNewLabel.setBounds(202, 202, 252, 358);
		add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\SM013\\git\\JavaProjRepository\\JavaProj\\img\\book002.jpg"));
		label.setBounds(681, 220, 229, 340);
		add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Readers Pick!!!");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(360, 42, 355, 59);
		add(lblNewLabel_1);
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//book001.jpg";
		
		
	}
}
