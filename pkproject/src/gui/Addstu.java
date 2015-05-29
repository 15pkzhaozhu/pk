package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import fuction.InforSearch;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Addstu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addstu frame = new Addstu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Addstu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setBounds(30, 21, 98, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setBounds(30, 89, 98, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		lblNewLabel_2.setBounds(30, 157, 98, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u516C\u5BD3\u53F7\uFF1A");
		lblNewLabel_3.setBounds(30, 225, 98, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5BBF\u820D\u53F7\uFF1A");
		lblNewLabel_4.setBounds(30, 293, 98, 15);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!textField.getText().matches("^\\d{9}$"))//验证9位数字
				{
					JOptionPane.showMessageDialog(null, "学号不合法!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		textField.setBounds(153, 18, 122, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(153, 86, 122, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!textField_2.getText().matches("^\\d{11}$"))//验证11位数字
				{
					JOptionPane.showMessageDialog(null, "手机号不合法!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		textField_2.setBounds(153, 154, 122, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		comboBox = new JComboBox();
		for(int i = 1; i < 12; i++ )
		{
			comboBox.addItem(i);
			
		}
		comboBox.setBounds(153, 222, 122, 21);
		contentPane.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setBounds(153, 290, 122, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InforSearch is = new InforSearch();
				is.addStuToDB(Integer.valueOf(textField.getText()), textField_1.getText(), textField_2.getText(),
						(Integer) comboBox.getSelectedItem(), textField_4.getText());
				JOptionPane.showMessageDialog(null, "保存成功!","提示",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				new index().setVisible(true);
			}
		});
		btnNewButton.setBounds(41, 349, 93, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new index().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(320, 349, 93, 23);
		contentPane.add(btnNewButton_1);
		this.setVisible(true);
		
	}
}
