package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.Washing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import fuction.InforSearch;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;

public class ModifyPrice extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyPrice frame = new ModifyPrice();
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
	public ModifyPrice() {
		setTitle("\u4FEE\u6539\u4EF7\u683C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				InforSearch is = new InforSearch();
				lblNewLabel_1.setText(String.valueOf(is.getPriceByName(comboBox.getSelectedItem().toString())));
			}
			
			
		});
		comboBox.addItem("被单");
		comboBox.addItem("被罩");
		comboBox.setBounds(183, 51, 87, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u7269\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(48, 54, 97, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5F53\u524D\u4EF7\u683C\uFF1A");
		label.setBounds(66, 97, 79, 21);
		contentPane.add(label);
		
		lblNewLabel_1 = new JLabel("");///原价
		lblNewLabel_1.setBounds(189, 97, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\u65B0\u4EF7\u683C\uFF1A");
		label_1.setBounds(66, 142, 54, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(189, 139, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");//确定按钮
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
				Session session1=sf.openSession();
				org.hibernate.Transaction tx= session1.beginTransaction();
				InforSearch is = new InforSearch();
				Washing temp = is.getWashByName(comboBox.getSelectedItem().toString());
				if(isRealNumber(textField.getText()))
				{
					temp.setPrice(Double.valueOf(textField.getText()));
					session1.update(temp);
					tx.commit();
					session1.close();
					JOptionPane.showMessageDialog(null, "修改价格成功!","提示",JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					new index().setVisible(true);
				}else
				{
					JOptionPane.showMessageDialog(null, "新价格不合法!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		button.setBounds(162, 209, 93, 23);
		contentPane.add(button);
	}
	private static boolean isMatch(String regex, String orginal){  
	    if (orginal == null || orginal.trim().equals("")) {  
	        return false;  
	    }  
	    Pattern pattern = Pattern.compile(regex);  
	    Matcher isNum = pattern.matcher(orginal);  
	    return isNum.matches();  
	}  

	public static boolean isPositiveInteger(String orginal) {  
	    return isMatch("^\\+{0,1}[1-9]\\d*", orginal);  
	}  

	public static boolean isNegativeInteger(String orginal) {  
	    return isMatch("^-[1-9]\\d*", orginal);  
	}  

	public static boolean isWholeNumber(String orginal) {  
	    return isMatch("[+-]{0,1}0", orginal) || isPositiveInteger(orginal) || isNegativeInteger(orginal);  
	}  
	  
	public static boolean isPositiveDecimal(String orginal){  
	    return isMatch("\\+{0,1}[0]\\.[1-9]*|\\+{0,1}[1-9]\\d*\\.\\d*", orginal);  
	}  
	  
	public static boolean isNegativeDecimal(String orginal){  
	    return isMatch("^-[0]\\.[1-9]*|^-[1-9]\\d*\\.\\d*", orginal);  
	}  
	  
	public static boolean isDecimal(String orginal){  
	    return isMatch("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", orginal);  
	}  
	  
	public static boolean isRealNumber(String orginal){  
	    return isWholeNumber(orginal) || isDecimal(orginal);  
	}  

}


