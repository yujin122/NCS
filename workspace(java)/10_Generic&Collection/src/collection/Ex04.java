package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("회원 수를 입력하세요. : ");
		int count = sc.nextInt();
		
		// 키보드로 회원 수 만큼 회원 정보 입력
		for(int i=0;i<count;i++) {
			MemberDTO dto = new MemberDTO();
			System.out.println((i+1) + "번째 회원의 아이디, 비밀번호, 이름, 나이, 주소를 입력하세요.");
			dto.setId(sc.next());
			dto.setPwd(sc.next());
			dto.setName(sc.next());
			dto.setAge(sc.next());
			dto.setAddress(sc.next());
			
			list.add(dto);
			System.out.println("=======================================");
		}
		
		System.out.println("아이디\t비밀번호\t이   름\t나   이\t주   소\t");
		
		// list에 있는 데이터를 화면에 출력해보자.
		for(int i = 0; i< list.size();i++) {
			MemberDTO dto = new MemberDTO();
			dto= list.get(i);
			
			System.out.println(dto.getId()+"\t"+dto.getPwd()+"\t"+dto.getName()+"\t"+dto.getAge()+"\t"+dto.getAddress());
		}
		
		sc.close();
		
	}

}
