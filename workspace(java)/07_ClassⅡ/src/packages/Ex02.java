package packages;

import java.util.Scanner;

import model.MemberDTO;

public class Ex02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 1. 회원 수를 키보드로 입력 받으면 객체배열의 크기가 정해짐
		System.out.print("회원 수를 입력하세요. : ");
		MemberDTO[] dtos = new MemberDTO[sc.nextInt()];
		
		// 2. 반복문을 통해서 회원 수 만큼 회원 정보를 키보드로 입력 받자
		for(int i=0;i<dtos.length;i++) {
			dtos[i]=new MemberDTO();
			
			System.out.println("==========================================");
			System.out.print((i+1)+"번째 회원 아이디를 입력해주세요. : ");
			dtos[i].setId(sc.next());
			System.out.print((i+1)+"번째 회원 비밀번호를 입력해주세요. : ");
			dtos[i].setPwd(sc.next());
			System.out.print((i+1)+"번째 회원 이름을 입력해주세요. : ");
			dtos[i].setName(sc.next());
			System.out.print((i+1)+"번째 회원 나이를 입력해주세요. : ");
			dtos[i].setAge(sc.next());
			System.out.print((i+1)+"번째 회원 주소를 입력해주세요. : ");
			dtos[i].setAddress(sc.next());	
			System.out.println();
		}		
		
		for(int i = 0; i<dtos.length;i++) {
			System.out.println("아이디/t비밀번호/t이름/t나이/t주소");
			System.out.println(dtos[i].getId()+"\t"+dtos[i].getPwd()+"\t"+dtos[i].getName()+"\t"
			+dtos[i].getAge()+"\t"+dtos[i].getAddress());
			System.out.println("==========================================================");
		}
		
		sc.close();

	}

}
