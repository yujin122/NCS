package sist;

/*
 * 1	6	11	16	21
 * 2	7	12	17	22	
 * 3	8	13	18	23	
 * 4	9	14	19	24
 * 5	10	15	20	25
 * 
 * - 2차원배열(5행5열)
 */

public class Exam_05 {

	public static void main(String[] args) {
int[][] arr = new int[5][5];
		
		int count = 1;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[j][i]+=count;
				count+=1;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
