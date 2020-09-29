package collection;

import java.util.*;

public class Ex02 {

	public static void main(String[] args) {
		 
		// 다형성으로 객체 생성
		List<String> list = new ArrayList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five"); 
		
		// 자바의 컬렉션 프레임워크에서 컬렉션에 저장 되어있는 요소들을
		// 읽어오는 방법을 표준화 해놓은 객체가 Iterator 객체이다.
		Iterator<String> it = list.iterator();
		
		// hasNext() : 읽어올 요소가 있는지 확인하는 메서드 - boolean형
		while(it.hasNext()) {
			System.out.println("list 요소 : " + it.next());
		}
	}

}
