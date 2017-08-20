import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import bean.Coffee;
import bean.Stock;
import dao.coffeedao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ButtonGroup;

//재고창을 만들면 완전히 다른걸 만들어야 한다. 그래서 그걸 어떻게 만들지 고민해봐야될듯
//일단 메인에서 만들어 줘야 함 입력데이터는 여기서 전부 받아서 서버로 어넣어주는 ㅈ쪽으로 만들자
public class MainUI {
	Vector<Coffee> list =new Vector<Coffee>();
	Coffee coffee = null; 
	Stock stock =null;
	coffeedao dao = null;
	JLabel lblNewLabel_1;
	String menu="";
	int count=0;
	boolean flag_size=false;//한번이라도 클릭하면 true
	boolean flag_shot=false;
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainUI() {
		
		initialize();
		
	}
	
	public void initialize() {
		
		coffee = new Coffee();
		dao = new coffeedao();
		stock = new Stock();
		stock = dao.getstock();	//서버에서 재고 데이터 넣어주기	
		System.out.println(stock); // 재고 데이터 확인
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(0, 0, 784, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("에스프레소");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				count++;
				if(count > 1){
					stock.setWondu(stock.getWondu()+1);
				}
				stock.setWondu(stock.getWondu()-1); // 원두재고 관리				
				showlabel("에스프레소",3000);
				
			}
		});
		btnNewButton.setBounds(50, 37, 100, 70);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("아메리카노");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setWondu(stock.getWondu()+1);
				}
				
				stock.setWondu(stock.getWondu()-1);
				showlabel("아메리카노",4000);
			}
		});
		btnNewButton_1.setBounds(200, 37, 100, 70);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("카페라떼");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setWondu(stock.getWondu()+1);
					stock.setMilk(stock.getMilk()+1);
				}
				stock.setWondu(stock.getWondu()-1);
				stock.setMilk(stock.getMilk()-1);//우유관리
				showlabel("카페라떼",4500);
			}
		});
		btnNewButton_2.setBounds(350, 37, 100, 70);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uBC14\uB2D0\uB77C\uB77C\uB5BC");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setWondu(stock.getWondu()+1);
					stock.setMilk(stock.getMilk()+1);
					stock.setSirup(stock.getSirup()+1);
				}
				stock.setWondu(stock.getWondu()-1);
				stock.setMilk(stock.getMilk()-1);
				stock.setSirup(stock.getSirup()-1);
				showlabel("바닐라라떼",4600);
			}
		});
		btnNewButton_3.setBounds(500, 37, 100, 70);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\uADF8\uB9B0\uD2F0\uB77C\uB5BC");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setWondu(stock.getWondu()+1);
					stock.setMilk(stock.getMilk()+1);
					stock.setSirup(stock.getSirup()+1);
				}
				stock.setWondu(stock.getWondu()-1);
				stock.setMilk(stock.getMilk()-1);
				stock.setSirup(stock.getSirup()-1);
				showlabel("그린티라떼",4800);
			}
		});
		btnNewButton_4.setBounds(650, 37, 100, 70);
		panel.add(btnNewButton_4);
		
		JButton button = new JButton("\uCE74\uD478\uCE58\uB178");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setWondu(stock.getWondu()+1);
					stock.setMilk(stock.getMilk()+1);
					stock.setSirup(stock.getSirup()+1);
				}
				stock.setWondu(stock.getWondu()-1);
				stock.setMilk(stock.getMilk()-1);
				stock.setSirup(stock.getSirup()-1);
				showlabel("카푸치노",4900);
			}
		});
		button.setBounds(50, 148, 100, 70);
		panel.add(button);
		
		JButton button_1 = new JButton("\uB3CC\uCCB4\uB77C\uB5BC");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setWondu(stock.getWondu()+1);
					stock.setMilk(stock.getMilk()+1);
					stock.setSirup(stock.getSirup()+1);
				}
				stock.setWondu(stock.getWondu()-1);
				stock.setMilk(stock.getMilk()-1);
				stock.setSirup(stock.getSirup()-1);
				showlabel("돌체라떼",5100);
			}
		});
		button_1.setBounds(200, 148, 100, 70);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\uCE74\uD398\uBAA8\uCE74");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setWondu(stock.getWondu()+1);
					stock.setMilk(stock.getMilk()+1);
					stock.setChoco(stock.getChoco()+1);
					stock.setSirup(stock.getSirup()+1);
				}
				stock.setWondu(stock.getWondu()-1);
				stock.setMilk(stock.getMilk()-1);
				stock.setChoco(stock.getChoco()-1);
				stock.setSirup(stock.getSirup()-1);
				showlabel("카페모카",4300);
			}
		});
		button_2.setBounds(350, 148, 100, 70);
		panel.add(button_2);
		
		JButton button_3 = new JButton("\uD504\uB77C\uD504\uCE58\uB178");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setWondu(stock.getWondu()+1);
					stock.setMilk(stock.getMilk()+1);
					stock.setChoco(stock.getChoco()+1);
					stock.setSirup(stock.getSirup()+1);
				}
				stock.setWondu(stock.getWondu()-1);
				stock.setMilk(stock.getMilk()-1);
				stock.setChoco(stock.getChoco()-1);
				stock.setSirup(stock.getSirup()-1);
				showlabel("프라프치노",4700);
			}
		});
		button_3.setBounds(500, 148, 100, 70);
		panel.add(button_3);
		
		JButton button_4 = new JButton("\uB538\uAE30\uC2A4\uBB34\uB514");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setBerry(stock.getBerry()+1);
					stock.setMilk(stock.getMilk()+1);
					stock.setSirup(stock.getSirup()+1);
				}
				stock.setBerry(stock.getBerry()-1);
				stock.setMilk(stock.getMilk()-1);
				stock.setSirup(stock.getSirup()-1);
				showlabel("딸기스무디",5000);
			}
		});
		button_4.setBounds(650, 148, 100, 70);
		panel.add(button_4);
		
		JButton button_5 = new JButton("\uB9DD\uACE0\uC2A4\uBB34\uB514");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setMilk(stock.getMilk()+1);
					stock.setMango(stock.getMango()+1);
					stock.setSirup(stock.getSirup()+1);
				}
				stock.setMilk(stock.getMilk()-1);
				stock.setMango(stock.getMango()-1);
				stock.setSirup(stock.getSirup()-1);
				showlabel("망고스무디",5000);
			}
		});
		button_5.setBounds(50, 266, 100, 70);
		panel.add(button_5);
		
		JButton button_6 = new JButton("\uD56B\uCD08\uCF54");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setMilk(stock.getMilk()+1);
					stock.setChoco(stock.getChoco()+1);
					stock.setSirup(stock.getSirup()+1);
				}
				stock.setChoco(stock.getChoco()-1);
				stock.setMilk(stock.getMilk()-1);
				stock.setSirup(stock.getSirup()-1);
				showlabel("핫초코",3000);
			}
		});
		button_6.setBounds(200, 266, 100, 70);
		panel.add(button_6);
		
		JButton button_7 = new JButton("\uBE14\uB799\uD2F0");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setBlack(stock.getBlack()+1);
				}
				stock.setBlack(stock.getBlack()-1);
				showlabel("블랙티",4000);
			}
		});
		button_7.setBounds(350, 266, 100, 70);
		panel.add(button_7);
		
		JButton button_8 = new JButton("\uBC84\uBE14\uD2F0");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setBlack(stock.getBlack()+1);
					stock.setMilk(stock.getMilk()+1);
					stock.setSirup(stock.getSirup()+1);
				}			
				stock.setMilk(stock.getMilk()-1);
				stock.setBlack(stock.getBlack()-1);
				stock.setSirup(stock.getSirup()-1);
				showlabel("버블티",4000);
			}
		});
		button_8.setBounds(500, 266, 100, 70);
		panel.add(button_8);
		
		JButton button_9 = new JButton("\uADF8\uB9B0\uD2F0");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count > 1){
					stock.setGreen(stock.getGreen()+1);
				}
				stock.setGreen(stock.getGreen()-1);
				showlabel("그린티",4000);
			}
		});
				
		button_9.setBounds(650, 266, 100, 70);
		panel.add(button_9);		
		//버튼
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 396, 784, 115);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("  ICE");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				coffee.setTemp("ICE");
				showlabel(coffee.getName(),coffee.getPrice());
				
				
			}
		});
		rdbtnNewRadioButton.setBounds(145, 42, 60, 26);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnHot = new JRadioButton("  HOT");
		buttonGroup.add(rdbtnHot);
		rdbtnHot.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				coffee.setTemp("HOT");
				showlabel(coffee.getName(),coffee.getPrice());
				
			}
		});
		rdbtnHot.setBounds(209, 42, 121, 26);
		panel_1.add(rdbtnHot);
		
		JRadioButton rdbtnSmall = new JRadioButton("  SMALL");
		buttonGroup_1.add(rdbtnSmall);
		rdbtnSmall.addActionListener(new ActionListener() {
				
			public void actionPerformed(ActionEvent e) {
									
				clicksize(coffee.getSize(),"SMALL",flag_size);
				coffee.setSize("SMALL");
				showlabel(coffee.getName(),coffee.getPrice());
				flag_size=true;
				
			}
		});
		rdbtnSmall.setBounds(469, 42, 80, 26);
		panel_1.add(rdbtnSmall);
		
		JRadioButton rdbtnTall = new JRadioButton("  TALL");
		buttonGroup_1.add(rdbtnTall);
		rdbtnTall.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
			clicksize(coffee.getSize(),"TALL",flag_size);
			coffee.setSize("TALL");
			showlabel(coffee.getName(),coffee.getPrice());
			flag_size=true;
				
			}
		});
		rdbtnTall.setBounds(561, 42, 80, 26);
		panel_1.add(rdbtnTall);
		
		JRadioButton rdbtnLarge = new JRadioButton("  LARGE");
		buttonGroup_1.add(rdbtnLarge);
		rdbtnLarge.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				clicksize(coffee.getSize(),"LARGE",flag_size);
				coffee.setSize("LARGE");
				showlabel(coffee.getName(),coffee.getPrice());
				flag_size=true;
				
			}
		});
		rdbtnLarge.setBounds(644, 42, 121, 26);
		panel_1.add(rdbtnLarge);
		
		JLabel lblNewLabel = new JLabel("HOT / ICE");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(59, 45, 99, 18);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("\uC74C\uB8CC \uC0AC\uC774\uC988");
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(373, 45, 99, 18);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\uC0F7\uCD94\uAC00");
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBounds(59, 86, 99, 18);
		panel_1.add(label_1);
		
		JRadioButton rdbtnYes = new JRadioButton("  YES");
		buttonGroup_2.add(rdbtnYes);
		rdbtnYes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				clickshot(coffee.getShot(), "샷추가", flag_shot);
				coffee.setShot("샷추가");
				showlabel(coffee.getName(),coffee.getPrice());
				flag_shot= true;
				
				/*
				count_shot++;
				if(count_shot > 1){
					coffee.setPrice(coffee.getPrice()-500);
					stock.setWondu(stock.getWondu()+1);
				}
				
				coffee.setPrice(coffee.getPrice()+500);
				coffee.setShot("샷추가");
				stock.setWondu(stock.getWondu()-1);*/
				
			}
		});
		rdbtnYes.setBounds(145, 83, 60, 26);
		panel_1.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("  NO");
		buttonGroup_2.add(rdbtnNo);
		rdbtnNo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(coffee.getShot()==("샷추가")){
					coffee.setPrice(coffee.getPrice()-500);
				}
				
				coffee.setShot("NO샷");
				showlabel(coffee.getName(),coffee.getPrice());
			}
		});
		rdbtnNo.setBounds(209, 83, 121, 26);
		panel_1.add(rdbtnNo);
		//라디오버튼
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 512, 784, 217);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setText("\uCEE4\uD53C");
		
		lblNewLabel_1.setBounds(81, 40, 618, 26);
		panel_2.add(lblNewLabel_1);
		//스트링에 문자열을 넣고 액션이 나올떄마다 스트링에 값을 넣어주고 마지막으로 값을 넣어준다.
		lblNewLabel_1.setText(menu);
				
		
		JButton btnNewButton_5 = new JButton("\uACB0\uC81C");//결제 누르면 서버로 입력
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count=0;
				
				if(checkOrder() == 0){
					checkOrder();
										
					dao.coffeeadd(coffee);//판매정보 데이터에 저장
					System.out.println(coffee);
					//재고줄어들게
					dao.stockorder(stock);//재고 서버에 저장
					System.out.println(stock);
					buttonGroup.clearSelection();
					buttonGroup_1.clearSelection();
					buttonGroup_2.clearSelection();
					lblNewLabel_1.setText("");
					JOptionPane.showMessageDialog(null, "결제 되었습니다");
					//재고가 자동관리 메소드
					coffee.setName(null);
					coffee.setShot(null);
					coffee.setSize(null);
					coffee.setTemp(null);
					coffee.setPrice(0);
					flag_size=false;
					flag_shot=false;
				}else{
					buttonGroup.clearSelection();
					buttonGroup_1.clearSelection();
					buttonGroup_2.clearSelection();
					lblNewLabel_1.setText("");
					coffee.setName(null);
					coffee.setShot(null);
					coffee.setSize(null);
					coffee.setTemp(null);
					coffee.setPrice(0);
					JOptionPane.showMessageDialog(null, "재료가 떨어졌습니다.재료를 주문하세요.");
					flag_size=false;
					flag_shot=false;
				}
			
			}
		});
		btnNewButton_5.setBounds(598, 121, 123, 38);
		panel_2.add(btnNewButton_5);
		
		JButton button_10 = new JButton("\uC120\uD0DD\uCDE8\uC18C");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count=0;
				flag_shot=false;
				flag_size=false;
				coffee.setName(null);
				coffee.setShot(null);
				coffee.setSize(null);
				coffee.setTemp(null);
				coffee.setPrice(0);
				lblNewLabel_1.setText("");
				// 버튼 초기화
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
				buttonGroup_2.clearSelection(); 
				System.out.println(coffee);
				JOptionPane.showMessageDialog(null, "선택취소되었습니다.");
				
			}
		});
		button_10.setBounds(431, 121, 123, 38);
		panel_2.add(button_10);
		
		JButton button_11 = new JButton("\uD310\uB9E4\uBCF4\uAE30");//판매확인
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new SellListUI();
				System.out.println(dao.GetAllSellList());								
				
			}
		});
		button_11.setBounds(57, 121, 123, 38);
		panel_2.add(button_11);
		
		JButton btnNewButton_6 = new JButton("\uC7AC\uACE0\uAD00\uB9AC");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InventoryUI();
				
			}
		});
		btnNewButton_6.setBounds(192, 121, 123, 38);
		panel_2.add(btnNewButton_6);
	}
	
	
	
	public void showlabel(String name, int price){//판매 데이터 입력
		
		coffee.setName(name);
		coffee.setPrice(price);
				
		if(coffee.getName() != null && coffee.getPrice() != 0 ){
			menu = coffee.getName()+ " / " + coffee.getPrice();
			
			if(coffee.getShot() != null){
				menu = menu+ " / " +coffee.getShot();
			}
			
			if(coffee.getSize() != null){
				menu = menu+ " / " +coffee.getSize();
			}
			
			if(coffee.getTemp() != null){
				menu = menu+ " / " +coffee.getTemp();
			}
		}		
		lblNewLabel_1.setText(menu);
		
		
		
	}//showlabel

	
	//주문할때 재고 확인 하는 메소드
	public int checkOrder(){
		int result=0;
		if(	stock.getWondu() == -1 || 
			stock.getMilk() == -1 || 
			stock.getSirup() == -1 ||
			stock.getBerry() == -1 ||
			stock.getMango() == -1 ||
			stock.getGreen() == -1 ||
			stock.getBlack() == -1 ||
			stock.getChoco() == -1
		){
			result=-1;	
		}	
			return result;
	}//checkOrder
	
	
	public void clicksize(String befor_size,String size,boolean flag_size){// 사이즈관련된 클릭정보관리 메소드
		
		if(flag_size){
			//두번째 이상
			switch (size) {
			
			case "SMALL":
				switch (befor_size) {
				case "SMALL":
					
					break;
				case "TALL":
					coffee.setPrice(coffee.getPrice()-500);
					break;
				case "LARGE":
					coffee.setPrice(coffee.getPrice()-1000);
					break;
				default:
					break;
				}				
				break;
				
			case "TALL":
				switch (befor_size) {
				case "SMALL":
					coffee.setPrice(coffee.getPrice()+500);
					break;
				case "TALL":
					
					break;
				case "LARGE":
					coffee.setPrice(coffee.getPrice()-500);
					break;
				default:
					break;
				}
				break;
				
			case "LARGE":
				switch (befor_size) {
				case "SMALL":
					coffee.setPrice(coffee.getPrice()+1000);
					break;
				case "TALL":
					coffee.setPrice(coffee.getPrice()+500);
					break;
				case "LARGE":
					break;
				default:
					break;
				}
				break;
				
			default:
				break;
			}
			
		}else{
			//처음누를떄
			switch (size) {
			
			case "SMALL":
				
				break;
			case "TALL":
				coffee.setPrice(coffee.getPrice()+500);
				break;
			case "LARGE":
				coffee.setPrice(coffee.getPrice()+1000);
				break;	
				
			default:
				break;
			}
			
		}
		
	}//clicksize
	
	
	
	
	public void clickshot(String befor_shot,String shot,boolean flag_shot){//샷관련된 버튼관리
		if(flag_shot){
			//두번이상
			switch (shot) {
			case "샷추가":
				switch (befor_shot) {
				case "샷추가":
					
					break;
				case "NO샷":
					coffee.setPrice(coffee.getPrice()+500);
					break;		
				default:
					break;
				}
				break;
				
			case "NO샷":
				switch (befor_shot) {
				case "샷추가":
					coffee.setPrice(coffee.getPrice()-500);
					break;
				case "NO샷":
					break;		
				default:
					break;
				}
				break;		
			default:
				break;
			}
		}else {
			//한번누를때
			switch (shot) {
			case "샷추가":
				coffee.setPrice(coffee.getPrice()+500);
				break;
			case "NO샷":
				break;		
			default:
				break;
			}
		}	
	}//clickshot
	
	
	
	
	
}
