package sist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class MemberManagement {

	private String header[] = {"이름", "나이", "체중", "신장", "성별"};
	String data[][] = {};
	
	public MemberManagement() {
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 653, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("회원 관리");
		
		JPanel jp = new JPanel(new BorderLayout());
		JPanel jpn = new JPanel(new BorderLayout());
		JPanel jpc = new JPanel();
		JPanel jps = new JPanel();
		
		JLabel jl = new JLabel("회원 관리");
		jl.setForeground(new Color(147, 112, 219));
		jl.setFont(new Font("굴림체", Font.BOLD, 30));
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setBounds(243, 28, 99, 39);
		jpn.add(jl, BorderLayout.NORTH);
		
		JPanel tallJp = new JPanel();
		JLabel tallLabel = new JLabel("신 장");
		tallJp.add(tallLabel);
		
		JTextField tall = new JTextField(15);
		tallJp.add(tall);
	
		JPanel ageJp = new JPanel();
		JLabel ageLabel = new JLabel("연 령");
		ageJp.add(ageLabel);
		
		JTextField age = new JTextField(15);
		ageJp.add(age);
		
		JPanel nameJp = new JPanel();
		JLabel nameLabel = new JLabel("이 름");
		nameJp.add(nameLabel);
		
		JTextField name = new JTextField(15);
		nameJp.add(name);
		
		JPanel weightJp = new JPanel();
		JLabel weightLabel = new JLabel("체 중");
		weightJp.add(weightLabel);
		
		JTextField weight = new JTextField(15);
		weightJp.add(weight);
		
		JPanel inputJp = new JPanel(new GridLayout(2,2));
		inputJp.add(nameJp); inputJp.add(ageJp);
		inputJp.add(tallJp); inputJp.add(weightJp);
		
		jpn.add(inputJp,BorderLayout.CENTER);
		
		JPanel genderJp = new JPanel();
		JLabel gender = new JLabel("성 별");
		gender.setHorizontalAlignment(SwingConstants.CENTER);
		gender.setBounds(111, 168, 45, 18);
		genderJp.add(gender);
		
		JRadioButton male = new JRadioButton("Male");
		male.setBounds(166, 164, 70, 27);
		genderJp.add(male);
		
		JRadioButton female = new JRadioButton("FeMale");
		female.setBounds(243, 164, 83, 27);
		genderJp.add(female);
		
		jpn.add(genderJp, BorderLayout.SOUTH);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(male); bg.add(female);
		
		JTable table = new JTable(data, header);
		JScrollPane jsp = new JScrollPane(
				table, 	
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,	
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER		
				);
		jpc.add(jsp);
		
		JPanel btnJp = new JPanel(new GridLayout(1,5,1,1));
		JButton saveBtn = new JButton("저장");
		btnJp.add(saveBtn);
		
		JButton searchBtn = new JButton("검색");
		btnJp.add(searchBtn);
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setHorizontalAlignment(SwingConstants.CENTER);
		btnJp.add(deleteBtn);
		
		JButton updateBtn = new JButton("수정");
		btnJp.add(updateBtn);
		
		JButton clearBtn = new JButton("지우기");
		btnJp.add(clearBtn);
		
		jps.add(btnJp);
		
		jp.add(jpn, BorderLayout.NORTH);
		jp.add(jpc, BorderLayout.CENTER);
		jp.add(jps, BorderLayout.SOUTH);
		
		frame.add(jp);
		
		frame.setVisible(true);		
		
	}
	
	public static void main(String[] args) {
		new MemberManagement();

	}

}
