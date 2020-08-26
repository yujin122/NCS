package sist;

public class test1 {

	public static void main(String[] args) {
		
		int k_score = Integer.parseInt(args[0]), e_score = Integer.parseInt(args[1]), m_score = Integer.parseInt(args[2]), j_score = Integer.parseInt(args[3]);
	    int total;
		double avg;
		
		total = k_score + e_score + m_score + j_score;
		avg = (double)total/4;
		
		System.out.println("국어점수 : " + k_score + "점");
		System.out.println("영어점수 : " + e_score + "점");
		System.out.println("수학점수 : " + m_score + "점");
		System.out.println("자바점수 : " + j_score + "점");
		System.out.println("총      점 : " + total + "점");
		System.out.printf("평      균 : %.2f점", avg );

	}

}
