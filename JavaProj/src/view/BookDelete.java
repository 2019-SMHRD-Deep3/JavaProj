package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Book;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookDelete {

   private JFrame frame;
   private JTextField textField;
   private Book selectBook;
   private MemberManagementService service = new MemberManagementService();
   private JTextField textField_1;
   private JTextField textField_2;
   private JTextField textField_3;

   public BookDelete(Book selectBook) {
      this.selectBook = selectBook;
      initialize();
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setResizable(false);
      frame.setBounds(100, 100, 450, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JLabel label = new JLabel("\uB3C4\uC11C \uC0AD\uC81C");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
      label.setBounds(12, 10, 420, 21);
      frame.getContentPane().add(label);
      
      JLabel lblIsbn = new JLabel("\uC81C\uBAA9");
      lblIsbn.setHorizontalAlignment(SwingConstants.CENTER);
      lblIsbn.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
      lblIsbn.setBounds(22, 41, 113, 21);
      frame.getContentPane().add(lblIsbn);
      
      textField = new JTextField(selectBook.getTitle());
      textField.setHorizontalAlignment(SwingConstants.CENTER);
      textField.setColumns(10);
      textField.setBounds(137, 41, 270, 21);
      frame.getContentPane().add(textField);
      
      JLabel label_5 = new JLabel(Long.toString(selectBook.getIsbn()));
      label_5.setHorizontalAlignment(SwingConstants.CENTER);
      label_5.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
      label_5.setBounds(137, 103, 270, 21);
      frame.getContentPane().add(label_5);
      
      textField_1 = new JTextField(selectBook.getAuthor());
      textField_1.setHorizontalAlignment(SwingConstants.CENTER);
      textField_1.setColumns(10);
      textField_1.setBounds(137, 72, 270, 21);
      frame.getContentPane().add(textField_1);
      
      textField_2 = new JTextField(selectBook.getPublisher());
      textField_2.setHorizontalAlignment(SwingConstants.CENTER);
      textField_2.setColumns(10);
      textField_2.setBounds(137, 136, 270, 21);
      frame.getContentPane().add(textField_2);
      
      textField_3 = new JTextField(selectBook.getGenre());
      textField_3.setHorizontalAlignment(SwingConstants.CENTER);
      textField_3.setColumns(10);
      textField_3.setBounds(137, 166, 270, 21);
      frame.getContentPane().add(textField_3);
      
      JButton button = new JButton("\uC0AD\uC81C");
      button.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            String title = textField.getText();
            String author = textField_1.getText();
            long isbn = Long.parseLong(label_5.getText());
            String publisher = textField_2.getText();
            String genre = textField_3.getText();

            Book book = new Book(title, author, isbn, publisher, genre);
            boolean result = service.delBook(book);
            if (result) {
               JOptionPane.showMessageDialog(frame, "»èÁ¦ ¼º°ø");
               frame.dispose();
            } else {
               JOptionPane.showMessageDialog(frame, "»èÁ¦ ½ÇÆÐ");
            }
         }
      });
      button.setBounds(136, 216, 97, 23);
      frame.getContentPane().add(button);
      
      JButton button_1 = new JButton("\uCDE8\uC18C");
      button_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            frame.dispose();
         }
      });
      button_1.setBounds(245, 216, 97, 23);
      frame.getContentPane().add(button_1);
      
      JLabel label_1 = new JLabel("\uC791\uAC00");
      label_1.setHorizontalAlignment(SwingConstants.CENTER);
      label_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
      label_1.setBounds(22, 72, 113, 21);
      frame.getContentPane().add(label_1);
      
      JLabel label_2 = new JLabel("ISBN");
      label_2.setHorizontalAlignment(SwingConstants.CENTER);
      label_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
      label_2.setBounds(22, 103, 113, 21);
      frame.getContentPane().add(label_2);
      
      JLabel label_3 = new JLabel("\uCD9C\uD310\uC0AC");
      label_3.setHorizontalAlignment(SwingConstants.CENTER);
      label_3.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
      label_3.setBounds(22, 134, 113, 21);
      frame.getContentPane().add(label_3);
      
      JLabel label_4 = new JLabel("\uC7A5\uB974");
      label_4.setHorizontalAlignment(SwingConstants.CENTER);
      label_4.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
      label_4.setBounds(22, 164, 113, 21);
      frame.getContentPane().add(label_4);
      

   }

}