package sist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class df {

	private JFrame frame;
	private JTextField tall;
	private JTextField age;
	private JTextField name;
	private JTextField weight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					df window = new df();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public df() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel jl = new JLabel("회원 관리");
		jl.setForeground(new Color(147, 112, 219));
		jl.setFont(new Font("굴림체", Font.PLAIN, 20));
		jl.setBounds(243, 28, 99, 39);
		frame.getContentPane().add(jl);
		
		JLabel tallLabel = new JLabel("신 장");
		tallLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tallLabel.setBounds(39, 120, 45, 18);
		frame.getContentPane().add(tallLabel);
		
		tall = new JTextField();
		tall.setBounds(88, 117, 116, 24);
		frame.getContentPane().add(tall);
		tall.setColumns(10);
		
		JLabel ageLabel = new JLabel("연 령");
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ageLabel.setBounds(304, 82, 45, 18);
		frame.getContentPane().add(ageLabel);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(347, 79, 116, 24);
		frame.getContentPane().add(age);
		
		JLabel nameLabel = new JLabel("이 름");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(39, 87, 45, 18);
		frame.getContentPane().add(nameLabel);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(88, 84, 116, 24);
		frame.getContentPane().add(name);
		
		JLabel weightLabel = new JLabel("체 중");
		weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightLabel.setBounds(304, 123, 45, 18);
		frame.getContentPane().add(weightLabel);
		
		weight = new JTextField();
		weight.setColumns(10);
		weight.setBounds(347, 120, 116, 24);
		frame.getContentPane().add(weight);
		
		JLabel lblNewLabel = new JLabel("성 별");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(111, 168, 45, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton male = new JRadioButton("Male");
		male.setBounds(166, 164, 70, 27);
		frame.getContentPane().add(male);
		
		JRadioButton female = new JRadioButton("FeMale");
		female.setBounds(243, 164, 83, 27);
		frame.getContentPane().add(female);
		
		JButton saveBtn = new JButton("저장");
		saveBtn.setBounds(39, 383, 105, 27);
		frame.getContentPane().add(saveBtn);
		
		JButton searchBtn = new JButton("검색");
		searchBtn.setBounds(166, 383, 105, 27);
		frame.getContentPane().add(searchBtn);
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setHorizontalAlignment(SwingConstants.CENTER);
		deleteBtn.setBounds(297, 383, 105, 27);
		frame.getContentPane().add(deleteBtn);
		
		JButton updateBtn = new JButton("수정");
		updateBtn.setBounds(422, 383, 105, 27);
		frame.getContentPane().add(updateBtn);
		
		JButton clearBtn = new JButton("지우");
		clearBtn.setBounds(422, 344, 105, 27);
		frame.getContentPane().add(clearBtn);
	}
}
