package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import model.*;
import fuction.InforSearch;
import fuction.Payment;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;



public class index extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JTable table;
	private int s = 0;
	private JLabel lblNewLabel_4;
	private JTextField textField;
	private JLabel label_2;
	private JComboBox comboBox_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
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
	public index() {
		setTitle("index");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u5F55\u5165\u4E2A\u4EBA\u4FE1\u606F");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Addstu();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(51, 35, 146, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");//添加按钮
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InforSearch is = new InforSearch();
				is.addStudentwash((Integer)comboBox.getSelectedItem(),(Integer)comboBox_1.getSelectedItem(), (Integer)comboBox_2.getSelectedItem());
				Vector vt0 = new Vector();
				vt0.add((Integer)comboBox.getSelectedItem());
				vt0.add(is.getPriceByName("被罩"));
				vt0.add((Integer)comboBox_1.getSelectedItem());
				vt0.add(is.getPriceByName("被单"));
				vt0.add((Integer)comboBox_2.getSelectedItem());
				((DefaultTableModel)table.getModel()).addRow(vt0);
				JOptionPane.showMessageDialog(null, "添加成功!","提示",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnNewButton_1.setBounds(53, 330, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setBounds(29, 198, 69, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u88AB\u5355\u6570\u91CF\uFF1A");
		lblNewLabel_1.setBounds(29, 236, 69, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u88AB\u7F69\u6570\u91CF\uFF1A");
		label.setBounds(29, 277, 69, 15);
		contentPane.add(label);
		
		comboBox = new JComboBox();//学号
		InforSearch is = new InforSearch();
		for(int i = 0; i < is.getAllStudent().size(); i++ )
		{
			Student temp = (Student)(is.getAllStudent().get(i));
			comboBox.addItem(temp.getStuId());
		}
		comboBox.setBounds(105, 195, 92, 21);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();//床单数
		for(int i = 0; i < 12; i++ )
		{
			comboBox_1.addItem(i);
		}
		comboBox_1.setBounds(105, 233, 92, 21);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox();//被罩数
		for(int i = 0; i < 12; i++ )
		{
			comboBox_2.addItem(i);
		}
		comboBox_2.setBounds(105, 274, 92, 21);
		contentPane.add(comboBox_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(224, 35, 367, 318);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
			    if((table.getValueAt(table.getSelectedRow(), 0)) != null){
				     s = (Integer) table.getValueAt(table.getSelectedRow(), 0);
			    }
		    }
	    });
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u88AB\u7F69\u4EE3\u6D17\u5355\u4EF7", "\u88AB\u7F69\u6570\u91CF", "\u88AB\u5355\u4EE3\u6D17\u5355\u4EF7", "\u88AB\u5355\u6570\u91CF"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(102);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		Vector  vt;
		for(int i = 0; i < is.getAllStudentwash().size(); i++){
			vt = new Vector();
			vt.add(((StudentWash)is.getAllStudentwash().get(i)).getStuId());
			vt.add(is.getPriceByName("被罩"));
			vt.add(((StudentWash)is.getAllStudentwash().get(i)).getDannum());
			vt.add(is.getPriceByName("被单"));
			vt.add(((StudentWash)is.getAllStudentwash().get(i)).getZhaonum());
			((DefaultTableModel)table.getModel()).addRow(vt); 
		}
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("\u5355\u4F53\u7ED3\u8D26");//单体结账
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(s==0)
				{
					JOptionPane.showMessageDialog(null, "请选中一行再进行单体结账！","提示",JOptionPane.INFORMATION_MESSAGE);
				}else
				{
					Payment p = new Payment();
					InforSearch is = new InforSearch();
					lblNewLabel_4.setText(String.valueOf(p.paySingle(s)));
					is.deletelStudentwashByID(s);
					((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow()); 
					JOptionPane.showMessageDialog(null, "单体结账成功！","提示",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnNewButton_2.setBounds(388, 360, 135, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u6309\u5BBF\u820D\u7ED3\u8D26");///俺宿舍结账
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Payment p= new Payment();
				label_2.setText(String.valueOf((p.payDorminary((Integer)comboBox_3.getSelectedItem(), textField.getText()))));
				InforSearch is = new InforSearch();
				is.delete((Integer)comboBox_3.getSelectedItem(), textField.getText());
				JOptionPane.showMessageDialog(null, "宿舍结账成功！","提示",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				new index().setVisible(true);
				
				
			}
		});
		btnNewButton_3.setBounds(663, 330, 135, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("\u516C\u5BD3\u53F7\uFF1A");
		lblNewLabel_2.setBounds(601, 198, 69, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BBF\u820D\u540D\uFF1A");
		lblNewLabel_3.setBounds(601, 254, 69, 15);
		contentPane.add(lblNewLabel_3);
		
		comboBox_3 = new JComboBox();//公寓号
		for(int i = 1; i < 12; i++ )
		{
			comboBox_3.addItem(i);
			
		}
		comboBox_3.setBounds(691, 195, 69, 21);
		contentPane.add(comboBox_3);
		
		lblNewLabel_4 = new JLabel("");//单体钱
		lblNewLabel_4.setBounds(412, 411, 80, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel label_1 = new JLabel("\u5143");
		label_1.setBounds(498, 411, 54, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();//宿舍号
		textField.setBounds(694, 251, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		label_2 = new JLabel("");//宿舍钱
		label_2.setBounds(680, 379, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5143");
		label_3.setBounds(761, 379, 54, 15);
		contentPane.add(label_3);
		
		JLabel lblNewLabel_5 = new JLabel("\u6CE8\uFF1A\u82E5\u53F3\u8FB9\u8868\u683C\u5DF2\u7ECF\u6DFB\u52A0\u8FC7\u67D0\u5B66\u53F7\u8BB0\u5F55\uFF0C\u9700\u5C06\u5176\u7ED3\u8D26\u540E\u518D\u5BF9\u8BE5\u5B66\u53F7\u6DFB\u52A0\u8BB0\u5F55");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 9));
		lblNewLabel_5.setBounds(10, 343, 312, 59);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("\u4FEE\u6539\u5355\u4EF7");//修改单价
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ModifyPrice().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setBounds(53, 90, 129, 23);
		contentPane.add(btnNewButton_4);
	}
}
