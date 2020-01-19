package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.MemberManagementService;
import model.Book;
import model.Member;
import oracle.net.aso.p;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BU extends JPanel { // 도서명부
   private JTextField textField;
   private JScrollPane scrollPane;
   private MemberManagementService service = new MemberManagementService();
   private JTable table;
   private DefaultTableModel defaultTableModel = new DefaultTableModel();

   /**
    * Create the panel.
    */
   public BU(Member loginUser) {
      setBackground(new Color(240, 245, 249));
      setLayout(null);

      scrollPane = new JScrollPane();
      scrollPane.setBounds(200, 100, 1014, 490);
      add(scrollPane);

      String[] columnNames = { "제목", "작가", "ISBN", "출판사", "장르" };

      ArrayList<Book> list = service.bookLookup(loginUser.getId());
//      System.out.println(list == null);
      Object[][] data = new Object[list.size()][5];

      for (int i = 0; i < list.size(); i++) {
         Book b = list.get(i);
         data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublisher(), b.getGenre() };
      }
      table = new JTable(data, columnNames);
      scrollPane.setViewportView(table);

      defaultTableModel.setDataVector(data, columnNames); // 데이터를 가져오는 모델을 만듦.
      table = new JTable(defaultTableModel); // 데이터를 가진 변수 생성.
      scrollPane.setViewportView(table); // 화면에 데이터 보여줌

      String CBmenu_1[] = { " ", "제목", "작가", "출판사" };
      // 콤보박스 (메뉴)
      JComboBox comboBox = new JComboBox(CBmenu_1);
      comboBox.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

      comboBox.setBounds(200, 38, 170, 29);
      add(comboBox);

      textField = new JTextField();
      textField.setColumns(10);
      textField.setBounds(382, 38, 315, 29);
      add(textField);

      JButton button_1 = new JButton("\uAC80\uC0C9");
      button_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
      button_1.setBackground(new Color(201, 214, 222));
      button_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int j = comboBox.getSelectedIndex();
            if (j == 1) {
               ArrayList<Book> list = service.findTitle(textField.getText());
               
               Object[][] data = new Object[list.size()][5];

               for (int i = 0; i < list.size(); i++) {
                  Book b = list.get(i);
                  data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublisher(), b.getGenre() };
               }

               defaultTableModel.setDataVector(data, columnNames);
            }else if (j == 2) {
                    ArrayList<Book> list = service.findAuthor(textField.getText());
               
               Object[][] data = new Object[list.size()][5];

               for (int i = 0; i < list.size(); i++) {
                  Book b = list.get(i);
                  data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublisher(), b.getGenre() };
               }

               defaultTableModel.setDataVector(data, columnNames);
               
            }else if (j == 3) {
                    ArrayList<Book> list = service.findPublisher(textField.getText());
               
               Object[][] data = new Object[list.size()][5];

               for (int i = 0; i < list.size(); i++) {
                  Book b = list.get(i);
                  data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublisher(), b.getGenre() };
               }

               defaultTableModel.setDataVector(data, columnNames);
               
            }
            
         }
      });
      button_1.setBounds(709, 38, 136, 29);
      add(button_1);
  

      JButton button = new JButton("\uCD08\uAE30\uD654");
      button.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
      button.setBackground(new Color(201, 214, 222));
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) { //초기화
         }
      });
      button.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            ArrayList<Book> list = service.bookLookup(loginUser.getId());

            Object[][] data = new Object[list.size()][5];

            for (int i = 0; i < list.size(); i++) {
               Book b = list.get(i);
               data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublisher(), b.getGenre() };
            }

            defaultTableModel.setDataVector(data, columnNames);
         }
      });
      button.setBounds(57, 223, 97, 23);
      add(button);

   }
}