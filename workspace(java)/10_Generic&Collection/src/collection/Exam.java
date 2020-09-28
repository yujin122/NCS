package collection;

import java.util.*;

public class Exam {

	public static void main(String[] args) {

		List<StudentDTO> list = new ArrayList<StudentDTO>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 수를 입력해주세요 : ");
		int count = sc.nextInt();
		
		StudentDTO dto;
		
		for(int i=0;i<count;i++) {
			dto = new StudentDTO();
			
			System.out.println((i+1) + "번쨰 학생의 학번, 이름, 학과, 주소를 입력하세요.");
			dto.setId(sc.next());
			dto.setName(sc.next());
			dto.setMajor(sc.next());
			dto.setAddr(sc.next());
			
			list.add(dto);
			System.out.println("=====================================");
		}
		
		System.out.println("학번\t이름\t학과\t주소");
		
		for(int i=0;i<list.size();i++) {
			dto = new StudentDTO();
			dto = list.get(i);
			
			System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getMajor()+"\t"+dto.getAddr());
		}
		
		sc.close();
		
		
	}

}
