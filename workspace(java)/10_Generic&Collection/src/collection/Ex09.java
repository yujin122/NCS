package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 3. Map 계열 컬렉션 프레임워크 특징
 * 	  - key와 value를 한 쌍으로 해서 데이터를 저장하고,
 * 		검색하는 기능을 제공.
 * 	  - key는 중복 불가, value는 중복 가능.
 * 	  - Map 인터페이스의 자식 클래스로 구현
 * 		=> HashMap(O), HashTable(O), Properties(가끔), TreeMap(X)
 */

public class Ex09 {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 데이터를 저장하는 메서드 : put(key, val)
		// 이름을 키로 저장, 점수를 값으로 저장
		map.put("홍길동", 95);
		map.put("유관순", 90);
		map.put("세종대왕", 100);
		map.put("김유신", 88);
		map.put("김연아", 80);
		
		// 2. 저장된 데이터를 검색(가져오는)하는 메서드 : get(key)
		//	  get 메서드를 호출하면 키에 해당하는 value 값을 반환
		System.out.println("김유신 점수 : "  + map.get("김유신") + "점");
		System.out.println();
		
		System.out.print("검색할 이름을 입력하세요 : ");
		String searchName = sc.next();
		
		if(map.containsKey(searchName)) {
			System.out.println(searchName + "님의 점수 : " + map.get(searchName) + "점");
		}else {
			System.out.println("해당 이름이 존재하지 않습니다.");
		}
		System.out.println();
		
		// 3. Map의 전체 내용을 출력하는 메서드 : keySet()
		for(String k : map.keySet()) {
			System.out.println(k + "님의 점수 : " + map.get(k) + "점");
		}
		
		
		sc.close();
	}

}
