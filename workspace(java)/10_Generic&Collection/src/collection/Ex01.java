package collection;

import java.util.ArrayList;

/*
 * 컬렉션 프레임워크
 * - 컬렉션의 사전적 의미  : 수집해서 모으다, 저장한다는 의미
 * - 자바에서 컬렉션은 데이터 추가, 수정, 삭제, 검색 등을 
 * 	  효과적으로 제공해 주는 자료 구조 관련 클래스
 * 	 => 값을 담을 수 있는 그릇을 의미함(컨테이너)
 * - 컬렉션 프레임워크
 * 	 1) 컬렉션 클래스를 표준화하여 설계해 놓은 인터페이스
 * 	 2) List 계열, Set 계열, Map 계열
 */

/*
 * 1. List 계열의 컬렉션 프레임워크의 특징
 * 	  - 자료의 순서가 보장(index) : 정렬 기능 제공.
 * 	  - 중복 데이터가 허용
 * 	  - List 인터페이스의 자식클래스로 구현
 * 		=> ArrayList(O), LinkedList(X), Vector(X)
 * 	  - 특히 DB에 저장된 데이터를 레코드 단위로 저장하거나
 * 		가져올 경우 많이 사용이 됨.
 */

public class Ex01 {

	public static void main(String[] args) {
		
		// 배열 객체 생성
		String[] str = {"홍길동", "이순신", "유관순", "이순신"};
		
		for(String k : str) {
			System.out.println("str 배열 요소 : " + k);
		}
		System.out.println();
		
		// ArrayList 객체 생성
		ArrayList<String> list = new ArrayList<String>();
		
		// 1. 데이터 추가 메서드 : add("값");
		list.add("홍길동");
		list.add("이순신");
		list.add("유관순");		// 중복 데이터
		list.add("김유신");
		list.add("김연아");
		list.add("유관순");		// 중복 데이터
		
		// 2. 데이터 크기 반환 메서드 : size()
		System.out.println("list의 크기 : " + list.size());
		System.out.println();
		
		// 3. list에 저장되어 있는 데이터를 출력하는 메서드 : get(index)
		System.out.println("세번째 인덱스 데이터 : " + list.get(3));
		System.out.println();
		
		// 전체 리스트를 출력
		for(int i =0; i<list.size();i++) {
			System.out.println("list["+i+"] : " + list.get(i));
		}	
		System.out.println();
		
		// 4. 모든 요소를 제거하는 메서드 : clear()
		/*list.clear();
		System.out.println("list의 크기 : " + list.size());*/
		
		// 5. list의 특정 요소(index)를 삭제하는 메서드 : remove()
		//	    다음 index부터 index 값이 한칸씩 당겨진다.
		list.remove(1);
		for(int i =0; i<list.size();i++) {
			System.out.println("list["+i+"] : " + list.get(i));
		}	
		System.out.println();
		
		// 6. list의 특정 index에 특정 데이터를 추가하는 메서드 : add(index, element(값))
		//	  add(index, element(값))
		//	    해당 index로 추가가 되고, 기존에 있던 데이터들은
		//	    뒤로 한 index씩 밀려난다.
		list.add(2, "세종대왕");
		System.out.println(list.toString());
	}

}
