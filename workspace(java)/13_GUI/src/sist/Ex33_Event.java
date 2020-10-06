package sist;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex33_Event {

	public static void main(String[] args) {
		JFrame jf = new JFrame("커피 자판기");

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();

		JLabel jl1 = new JLabel("원하는 커피 선택");
		jl1.setHorizontalAlignment(0);

		JRadioButton jrb1 = new JRadioButton("아메리카노(2500)");
		JRadioButton jrb2 = new JRadioButton("카페모카(3500)");
		JRadioButton jrb3 = new JRadioButton("에스프레소(2500)");
		JRadioButton jrb4 = new JRadioButton("카페라떼(4000)");

		ButtonGroup bg = new ButtonGroup();
		
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);

		jp1.add(jrb1);
		jp1.add(jrb2);
		jp1.add(jrb3);
		jp1.add(jrb4);

		JLabel jl2 = new JLabel("수량 : ");
		JTextField count = new JTextField(8);

		JLabel jl3 = new JLabel("입금액 : ");
		JTextField money = new JTextField(8);

		jp2.add(jl2);
		jp2.add(count);
		jp2.add(jl3);
		jp2.add(money);

		jp4.setLayout(new BorderLayout());
		jp4.add(jl1, BorderLayout.NORTH);
		jp4.add(jp1, BorderLayout.CENTER);
		jp4.add(jp2, BorderLayout.SOUTH);

		JTextArea jta = new JTextArea(8, 30);

		JScrollPane jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JButton jb1 = new JButton("계산");
		JButton jb2 = new JButton("종료");
		JButton jb3 = new JButton("취소");
		JButton jb4 = new JButton("새창");
		
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		jp3.add(jb4);

		jf.setLayout(new BorderLayout());
		jf.add(jp4, BorderLayout.NORTH);
		jf.add(jsp, BorderLayout.CENTER);
		jf.add(jp3, BorderLayout.SOUTH);

		//jf.setBounds(200, 200, 500, 300);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		jb1.addActionListener(new ActionListener() {
			
			/* 금액 = 단가 * 수량
			 * 총금액 = 금액 합계
			 * 공급가액 = 총금액 / 부가세율
			 * 부가세 = 총금액 – 공급가액
			 * 청구금액 = 공급가액 + 부가세
			 */
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String menu = "";
				int price = 0;
				int num = Integer.parseInt(count.getText());
				int mon = Integer.parseInt(money.getText());
				
				if(jrb1.isSelected()) {
					menu = "아메리카노";
					price = 2500;
				}else if(jrb2.isSelected()) {
					menu = "카페모카";
					price = 3500;
				}else if(jrb3.isSelected()) {
					menu = "에스프레소";
					price = 2500;
				}else if(jrb4.isSelected()) {
					menu = "카페라떼";
					price = 4000;
				}
				
				int supply = price * num;			// 공급가액
				int vat = (int)(supply*0.1f);		// 부가세
				int cupr = supply + vat;			// 총금액
				
				int coin = mon - cupr;				// 거스름돈
				
				jta.setText("커피종류 : " + menu + "\n" +
						"커피단가 : " + price + "원\n" + 
						"수량 : " + num + "\n" + 
						"공급가액 : " + supply + "원\n" + 
						"부가세액 : " + vat + "원\n" + 
						"총 금 액 : " + cupr + "원\n" + 
						"입 금 액 : " + mon + "원\n" + 
						"거스름돈 : " + coin + "원\n"
						);
				
				count.setText(""); money.setText("");
				bg.clearSelection();

			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count.setText(""); money.setText("");
				jta.setText("");
				bg.clearSelection();
			}
		});
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

}
