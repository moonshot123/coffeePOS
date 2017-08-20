import java.awt.Container;
import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bean.Coffee;
import dao.coffeedao;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class SellListUI extends JFrame{

	Container container = getContentPane();
	Panel pal =new Panel();
	coffeedao dao=null;
	//Vector<String> columnNames = null;
	Vector<Coffee> rowData = null;
	Object columnNames[] = {"이름","사이즈","샷","온도","가격"};
	Object sellNames[] = {"이름","판매잔수"};
	JLabel lblNewLabel_1;
	private JTable table;
	private JTable table2;
	
	public SellListUI() {
	
		dao = new coffeedao();
				
		rowData =dao.GetAllSellList();
		
		setSize(550, 400);
		setVisible(true);
		setLocation(900, 100);
		getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 26, 496, 215);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable(dao.makeArr(dao.GetAllSellList()),columnNames);
		table.setBounds(1, 27, 450, 288);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(13, 5, 469, 200);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrollPane);
		
		//scrollPane.add(table);
		
		
		//////////////////////////////////////////////
		/*
		  
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		table = new JTable(rowData, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);
		
		*/				
		//////////////////////////////////////
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 287, 534, 75);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("POS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//창닫기
				setVisible(false);
			}
		});
		btnNewButton.setBounds(51, 10, 130, 50);
		panel_1.add(btnNewButton);
		
		JButton button = new JButton("\uB9E4\uCD9C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//테이블에 전체 매출 리스트 출력
				rowData =dao.GetAllSellList();
				int sum=0;
				for(int i=0; i<rowData.size();i++){					
					sum += rowData.get(i).getPrice();
				}
				
				lblNewLabel_1.setText("오늘의 매출은 "+Integer.toString(sum)+" 입니다.");
				
			}
		});
		button.setBounds(202, 10, 130, 50);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\uBA54\uB274\uBCC4\uD310\uB9E4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//테이블에 메뉴별 판매리스트
				/*
				for(Object o:dao.makelistArr(dao.Getsellcount())){
					System.out.println(o);
				}
				*/
				rowData =dao.GetAllSellList();
				scrollPane.setVisible(false);
				table2 = new JTable(dao.makelistArr(dao.Getsellcount()),sellNames);
				
				table2.setBounds(1, 27, 450, 288);
				panel.add(table2);
				
				JScrollPane scrollPane = new JScrollPane(table2);
				scrollPane.setBounds(13, 5, 469, 200);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				panel.add(scrollPane);
				
			}
		});
		button_1.setBounds(351, 10, 130, 50);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 245, 534, 43);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(50, 0, 400, 40);
		panel_2.add(lblNewLabel_1);
		
		
				
		
	}
}
