package sist;

/*
 * 1
 * 2	3
 * 4	5	6
 * 7	8	9	10
 * 11	12	13	14	15
 */
public class Exam_06 {

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		
		int count = 1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<=i;j++) {
				arr[i][j] = count;
				count +=1;
			}
		}
		
		/*for(int i=0;i<arr.length;i++) {
			for(int j=0;j<=i;j++) {
				System.out.printf("%2d\t",arr[i][j]);
			}
			System.out.println();
		}*/
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				String value = (arr[i][j]==0)?"":""+arr[i][j];
				System.out.print(value+"\t");
			}
			System.out.println();
		}

	}

}
