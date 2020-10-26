package sist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MemberManagement {

	
	DefaultTableModel model = new DefaultTableModel();
	JTable table;
	
	public MemberManagement() {
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 654, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
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
		jl.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
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
		
		model.addColumn("이름"); model.addColumn("나이");
		model.addColumn("체중"); model.addColumn("신장");
		model.addColumn("성별");
		
		displayAll();
		table = new JTable(model);
		JScrollPane jsp = new JScrollPane(
				table, 	
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,	
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER		
				);
		jsp.setPreferredSize(new Dimension(500, 300));
		jsp.setSize(new Dimension(500, 300));
		jpc.add(jsp);
		
		JPanel btnJp = new JPanel(new GridLayout(1,5,5,5));
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
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				name.setText(table.getValueAt(row, 0).toString());
				age.setText(table.getValueAt(row, 1).toString());
				weight.setText(table.getValueAt(row, 2).toString());
				tall.setText(table.getValueAt(row, 3).toString());
				
				if(table.getValueAt(row, 4).equals("M")) {
					male.setSelected(true);
					female.setSelected(false);
				}else {
					female.setSelected(true);
					male.setSelected(false);
				}
			}
		});
		
		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				model.setRowCount(0);
				
				String nameData = name.getText().toString();
				String ageData = age.getText().toString();
				String weightData = weight.getText().toString();
				String heightData = tall.getText().toString();
				
				String genderData = "F";
				
				if(male.isSelected()) {
					genderData = "M";
				}
				
				MemberDAO dao = new MemberDAO();
				
				int result = dao.write(nameData, ageData, weightData, heightData, genderData);
				
				if(result > 0) {
					JOptionPane.showMessageDialog(frame, "데이터 추가 성공");
				}else {
					JOptionPane.showMessageDialog(frame, "데이터 추가 실패");
				}
				
				displayAll();
				
				name.setText(null); age.setText(null); weight.setText(null);
				tall.setText(null); male.setSelected(false); female.setSelected(false);
			}
		});

		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				
				String nameData = name.getText().toString();
				
				MemberDAO dao = new MemberDAO();
				
				int result = dao.delete(nameData);
				
				if(result > 0) {
					JOptionPane.showMessageDialog(female, "데이터 삭제 성공");
					
				}else {
					JOptionPane.showMessageDialog(female, "데이터 삭제 실패");
					
				}
				
				displayAll();
				
				name.setText(null); age.setText(null); weight.setText(null);
				tall.setText(null); male.setSelected(false); female.setSelected(false);
			}
		});

		clearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				name.setText(null); age.setText(null); weight.setText(null);
				tall.setText(null); male.setSelected(false); female.setSelected(false);
			}
		});
		
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				
				String nameData = name.getText().toString();
				String ageData = age.getText().toString();
				String weightData = weight.getText().toString();
				String heightData = tall.getText().toString();
				
				String genderData = "F";
				
				if(male.isSelected()) {
					genderData = "M";
				}
				
				MemberDAO dao = new MemberDAO();
				
				int result = dao.update(nameData, ageData, weightData, heightData, genderData);
				
				if(result > 0) {
					JOptionPane.showMessageDialog(frame, "데이터 수정 성공");
				}else {
					JOptionPane.showMessageDialog(frame, "데이터 수정 실패");
				}
				
				displayAll();
			}
		});
		
	}
	
	public void displayAll() {
		
		MemberDAO dao = new MemberDAO();
		dao.listAll(model);
		
	}
	
	public static void main(String[] args) {
		new MemberManagement();

	}

}
