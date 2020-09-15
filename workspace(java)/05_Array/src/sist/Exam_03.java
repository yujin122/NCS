package sist;

import java.util.*;

public class Exam_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 수를 입력하세요. : ");
		int size = sc.nextInt();
		
		String[] name = new String[size];
		int[] kor = new int[size];
		int[] eng = new int[size];
		int[] mat = new int[size];
		
		for(int i=0;i<size;i++) {
			System.out.print("이름 입력 : ");
			name[i] = sc.next();
			System.out.print("국어점수 입력 : ");
			kor[i] = sc.nextInt();
			System.out.print("영어점수 입력 : ");
			eng[i] = sc.nextInt();
			System.out.print("수학점수 입력 : ");
			mat[i] = sc.nextInt();			
		}
		
		int total[] = new int[size];
		float avg[] =new float[size];
		
		for(int i = 0;i < size;i++) {
			total[i] = kor[i]+eng[i]+mat[i];
			avg[i]= total[i]/3.0f;
		}
		
		 int[] rank = new int[size];
		
		String[] grade = new String[size];
		for(int i = 0;i<size;i++) {
			if(avg[i]>=90) {
				grade[i] = "A학점";
			}else if(avg[i]>=80) {
				grade[i] = "B학점";
			}else if(avg[i]>=70) {
				grade[i] = "C학점";
			}else if(avg[i]>=60) {
				grade[i] = "D학점";
			}else{
				grade[i] = "F학점";
			}
			 rank[i] = 1;
		}
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(total[i]<total[j]) {
					rank[i]++;
				}
			}
		}
		
		/*String[] rank=new String[size];
		int[] sort = new int[size];
		int temp;
		
		for(int i = 0;i<size;i++) {
			sort[i]=total[i];
		}
		
		for(int i = size;i >0;i--) {
			for(int j = 1;j<size;j++) {
				if(sort[j-1]<sort[j]) {
					temp = sort[j-1];
					sort[j-1]=sort[j];
					sort[j]=temp;
				}
			}
		}
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(sort[i] == total[j]) {
					rank[j] = (i+1)+"등";
				}
			}
		}*/
		
		
		
		for(int i=0;i<size;i++) {
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.printf("이름 : %s\t총점 : %d점\t평균 : %.2f점\t학점 : %s\t순위 : %d등\n",name[i],total[i],avg[i],grade[i],rank[i]);
		}
		
		sc.close();
	}

}
