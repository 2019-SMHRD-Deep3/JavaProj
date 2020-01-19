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
	private String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//book001.png";
	private MemberManagementService service = new MemberManagementService();
	private Book b;

	public DFirst() {
		setBackground(new Color(240, 245, 249));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(150, 125, 300, 400);
		add(panel);
		
		ImageIcon background = new ImageIcon(imgPath);
		JLabel labelImage = new JLabel();
		labelImage.setBounds(0, 0, 300, 400);
		labelImage.setIcon(background);

		panel.setLayout(null);
		panel.add(labelImage);

		JLabel label = new JLabel("\uC81C\uBAA9");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label.setBounds(500, 150, 100, 31);
		add(label);

		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_1.setBounds(600, 150, 200, 31);
		add(label_1);

		JLabel label_2 = new JLabel("\uC791\uAC00");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_2.setBounds(500, 200, 100, 31);
		add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_3.setBounds(600, 200, 200, 31);
		add(label_3);

		JLabel label_4 = new JLabel("\uCD9C\uD310\uC0AC");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_4.setBounds(500, 250, 100, 31);
		add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_5.setBounds(600, 250, 200, 31);
		add(label_5);

		JLabel label_6 = new JLabel("\uC7A5   \uB974");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_6.setBounds(500, 300, 100, 31);
		add(label_6);

		JLabel label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_7.setBounds(600, 300, 200, 31);
		add(label_7);

	}

}
