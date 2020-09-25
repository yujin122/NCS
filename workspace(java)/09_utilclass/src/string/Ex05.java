package string;

import java.util.StringTokenizer;

/*
 * StringTokenizer 클래스
 * - 특수 문자를 기준문자(delimiter)으로 문자열을 잘라 주는 클래스(파싱).
 * - 기준문자로 분리된 문자열을 토큰(token)이라고 함
 * - 웹에서 전화번호를 하이픈(-) 기준으로 앞자리, 중간자리, 끝자리 형식으로 구분해서 
 * 	  번호 추출 시 사용
 * 	 (주민번호, 핸드폰 번호 등등)
 */

public class Ex05 {

	public static void main(String[] args) {

		String query = "id=hong&pwd=1234&age=27";
		StringTokenizer st = new StringTokenizer(query,"&");
		
		int count = st.countTokens();
		
		System.out.println("토큰 수 : " + count);
		
	/*	for(int i=0;i<count;i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}*/
		
		//hasMoreTokens() : 리턴할 다음 토큰이 있는지 학인
		//					있으면 true 없으면 false 값 반환
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		}

}
