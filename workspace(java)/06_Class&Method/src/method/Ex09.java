package method;

import java.util.Scanner;

public class Ex09 {

	public static int tot(int x, int y, int z) {
		return x+y+z;
	}
	
	public static float averange(int avg) {
		return avg/3.0f;
	}
	
	public static String grad(float g) {
		String grade;
		if(g >=90) {
			grade = "A학점";
		}else if(g >=80) {
			grade = "B학점";
		}else if(g >=70) {
			grade = "C학점";
		}else if(g >=60) {
			grade = "D학점";
		}else {
			grade = "F학점";
		}
		
		return grade;
	}
	
	public static void output(int kor, int eng, int mat, int total, float avg, String grade) {
		System.out.println("국어점수 : " + kor+"점");
		System.out.println("영어점수 : " + eng+"점");
		System.out.println("수학점수 : " + mat+"점");
		System.out.println("총점 : " + total+"점");
		System.out.printf("평균 : %.2f점\n", avg);
		System.out.println("학점 : " + grade);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 입력 >>> ");
		int kor = sc.nextInt();
 
		System.out.print("영어 점수 입력 >>> ");
		int eng = sc.nextInt();
		
		System.out.print("수학 점수 입력 >>> ");
		int mat = sc.nextInt();
		
		// 1. 총점 메서드 호출
		int total = tot(kor,eng,mat);
		
		// 2. 평균 메서드 호출
		float avg = averange(total);
		
		// 3. 학점 메서드 호출
		String grade = grad(avg);
		
		// 4. 화면 출력
		output(kor,eng,mat,total,avg,grade);
		
		sc.close();
	}
	

}
