package method;

import java.util.Scanner;

public class Exam_01 {

	public static void input(String[] name, int[] id, String[] det,String[] call, Scanner sc) {
		
		for(int i = 0; i<name.length;i++) {
			System.out.println(":::::"+(i+1)+"번째 학생 정보 입력:::::");
			System.out.print("이름을 입력하세요 : ");
			name[i] = sc.next();
			
			System.out.print("학번을 입력하세요 : ");
			id[i] = sc.nextInt();
			
			System.out.print("학과을 입력하세요 : ");
			det[i] = sc.next();
			
			System.out.print("전화번호를 입력하세요 : ");
			call[i] = sc.next();
			System.out.println();
		}
	}
	
	public static void output(String[] name, int[] id, String[] det,String[] call) {
		for(int i=0; i<name.length;i++) {
			System.out.println(":::::"+(i+1)+"번째 학생 정보:::::");
			System.out.println("이름 : " + name[i]);
			System.out.println("학번 : " + id[i]);
			System.out.println("학과 : " + det[i]);
			System.out.println("전화번호 : " + call[i]);
			System.out.println();
		}
	}
	
	public static void search(String[] name, int[] id, String[] det,String[] call, Scanner sc) {
		
		boolean tf=false;
		System.out.print("학번을 입력하세요 : ");
		int id_S = sc.nextInt();
		System.out.println();
		
		for(int i = 0;i<id.length;i++) {
			if(id[i] == id_S) {
				System.out.print("이름 : " + name[i]);
				System.out.print("\t학번 : " + id[i]);
				System.out.print("\t학과 : " + det[i]);
				System.out.print("\t전화번호 : " + call[i]);
				System.out.println();
				tf=true;
			}
		}
		
		if(tf==false) {
			System.out.println("해당 학번이 존재하지 않습니다.");
		}
		
	}
	
	public static void update( int[] id, String[] det,String[] call, Scanner sc) {
		
		boolean tf=false;
		
		System.out.print("학번을 입력하세요 : ");
		int id_S = sc.nextInt();
		System.out.println();
		
		String u_det="";
		String u_call="";
		
		for(int i = 0;i<id.length;i++) {
			if(id[i] == id_S) {
				System.out.print("수정할 학과를 입력하세요 : ");
				u_det = sc.next();
				System.out.print("수정할 전화번호를 입력하세요 : ");
				u_call = sc.next();
				
				det[i] = u_det;
				call[i] = u_call;
				
				System.out.println("수정을 완료하였습니다.");
				tf=true;
			}
		}
		
		if(tf==false) {
			System.out.println("해당 학번이 존재하지 않습니다.");
		}
	}
	
	public static void close(Scanner sc) {
		
		System.out.print("프로그램을 종료하시겠습니까?(Y/N) :");
		String e = sc.next();
		
		if(e.equalsIgnoreCase("Y")) {
			System.out.println("수고하셨습니다.");
			sc.close();
			
			System.exit(0); // 시스템을 종료시키는 명령어
		}
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		System.out.print("학생 수를 입력하세요 : ");
		int size = sc.nextInt();
		String[] name = new String[size];
		int[] id=new int[size];
		String[] det = new String[size];
		String[] call = new String[size];
		
		int menu;
		
		while(true) {
			System.out.println();
			System.out.println("**** 메뉴 ****");
			System.out.println("1. 학생등록");
			System.out.println("2. 전체출력");
			System.out.println("3. 학생조회");
			System.out.println("4. 정보수정");
			System.out.println("5. 프로그램 종료");
			
			System.out.print("번호를 선택해주세요 : ");
			menu = sc.nextInt();
			System.out.println();
			
			if(menu == 1) {
				input(name,id,det,call,sc);
			}else if(menu == 2) {
				output(name,id,det,call);
			}else if(menu == 3) {
				search(name,id,det,call,sc);
			}else if(menu == 4) {
				update(id,det,call,sc);
			}else if(menu == 5) {
				close(sc);
			}else {
				System.out.println("학생관리 프로그램에 없는 메뉴입니다.");
			}
		}
	}

}
