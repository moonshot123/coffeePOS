import java.awt.Container;
import java.awt.Panel;

import javax.swing.JFrame;

import dao.coffeedao;
import javax.swing.JPanel;
import javax.swing.JTable;

import bean.Stock;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;

public class InventoryUI extends JFrame {
	
	Container container = getContentPane();
	Panel pal =new Panel();
	coffeedao dao = new coffeedao();
	Stock stock = new Stock();
	private JTable table;
	Object columnNames[] = {"원두","우유","시럽","딸기","망고","녹차","홍차","초코"};
	int num;
	String stockname;
	private JTextField textField;
	JLabel lblNewLabel;
	public InventoryUI(){
		num=0;//초기화
		stock = dao.getstock();// 서버에서 데이터 받기
		
		setSize(550, 700);
		setVisible(true);
		setLocation(900, 100);
		getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 534, 198);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable(dao.makestocklistArr(stock),columnNames);
		table.setBounds(39, 25, 450, 150);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(39, 57, 450, 120);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("\uC7AC\uACE0\uD604\uD669");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1.setBounds(39, 26, 100, 20);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 202, 534, 341);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("\uC6D0\uB450");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				stockname="원두";
				lblNewLabel.setText(stockname+"를 주문하실건가요? 수량을 입력하세요.");
			}
		});
		btnNewButton.setBounds(30, 61, 100, 60);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC6B0\uC720");
		btnNewButton_1.setBounds(153, 61, 100, 60);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				stockname="우유";
				lblNewLabel.setText(stockname+"를 주문하실건가요? 수량을 입력하세요.");
			}
		});
		
		JButton btnNewButton_2 = new JButton("\uC2DC\uB7FD");
		btnNewButton_2.setBounds(276, 60, 100, 60);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				stockname="시럽";
				lblNewLabel.setText(stockname+"을 주문하실건가요? 수량을 입력하세요.");
			}
		});
		
		JButton btnNewButton_3 = new JButton("\uB538\uAE30");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockname="딸기";
				lblNewLabel.setText(stockname+"를 주문하실건가요? 수량을 입력하세요.");
			}
		});
		btnNewButton_3.setBounds(399, 60, 100, 60);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\uB9DD\uACE0");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockname="망고";
				lblNewLabel.setText(stockname+"를 주문하실건가요? 수량을 입력하세요.");
			}
		});
		btnNewButton_4.setBounds(30, 149, 100, 60);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\uB179\uCC28");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockname="녹차";
				lblNewLabel.setText(stockname+"를 주문하실건가요? 수량을 입력하세요.");
			}
		});
		btnNewButton_5.setBounds(153, 149, 100, 60);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\uD64D\uCC28");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockname="홍차";
				lblNewLabel.setText(stockname+"를 주문하실건가요? 수량을 입력하세요.");
			
			}
		});
		btnNewButton_6.setBounds(276, 149, 100, 60);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("\uCD08\uCF54");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockname="초코";
				lblNewLabel.setText(stockname+"를 주문하실건가요? 수량을 입력하세요.");
			}
		});
		btnNewButton_7.setBounds(399, 149, 100, 60);
		panel_1.add(btnNewButton_7);
		
		JLabel lblNewLabel_2 = new JLabel("\uBB3C\uD488\uC8FC\uBB38");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setBounds(30, 30, 100, 20);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC8FC\uBB38\uC218\uB7C9\uC785\uB825 :");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3.setBounds(30, 237, 100, 20);
		panel_1.add(lblNewLabel_3);
		
		textField = new JTextField();		
		textField.setBounds(137, 237, 116, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel.setBounds(30, 275, 450, 30);
		panel_1.add(lblNewLabel);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 541, 534, 120);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_8 = new JButton("POS");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_8.setBounds(26, 23, 100, 50);
		panel_3.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("\uC8FC\uBB38");//주문
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
								
				if(stockname.equals("원두")){// 주문하기
					stock.setWondu(stock.getWondu()+(Integer.parseInt(textField.getText())));
				}else if (stockname.equals("우유")){
					stock.setMilk(stock.getMilk()+(Integer.parseInt(textField.getText())));					
				}else if (stockname.equals("시럽")){
					stock.setSirup(stock.getSirup()+(Integer.parseInt(textField.getText())));
				}else if (stockname.equals("딸기")){
					stock.setBerry(stock.getBerry()+(Integer.parseInt(textField.getText())));
				}else if (stockname.equals("망고")){
					stock.setMango(stock.getMango()+(Integer.parseInt(textField.getText())));
				}else if (stockname.equals("녹차")){
					stock.setGreen(stock.getGreen()+(Integer.parseInt(textField.getText())));
				}else if (stockname.equals("홍차")){
					stock.setBlack(stock.getBlack()+(Integer.parseInt(textField.getText())));
				}else if (stockname.equals("초코")){
					stock.setChoco(stock.getChoco()+(Integer.parseInt(textField.getText())));
				}
				System.out.println(stock);
				dao.stockorder(stock);
				stockname="";
				//Integer.parseInt(textField.getText());//입력값 숫자로변환
				textField.setText("");
				lblNewLabel.setText("");
				JOptionPane.showMessageDialog(null, "주문이 성공하였습니다.");
			}
		});
		btnNewButton_9.setBounds(156, 23, 100, 50);
		panel_3.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("\uD310\uB9E4\uD604\uD669");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SellListUI();
			}
		});
		btnNewButton_10.setBounds(281, 23, 100, 50);
		panel_3.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("\uCD08\uAE30\uD654");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stock=dao.getstock();
				
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 534, 198);
				getContentPane().add(panel);
				panel.setLayout(null);
				
				table = new JTable(dao.makestocklistArr(stock),columnNames);
				table.setBounds(39, 25, 450, 150);
				panel.add(table);
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(39, 57, 450, 120);
				panel.add(scrollPane);
								
			}
		});
		btnNewButton_11.setBounds(409, 23, 100, 50);
		panel_3.add(btnNewButton_11);
			
	}
}
