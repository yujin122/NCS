package interfaces;

import java.util.Scanner;

interface Calculator{
	int add(int a, int b);
	int sub(int su1, int su2);
	double average(int[] arr);
}

class GoodCalc implements Calculator{
	
	@Override
	public int add(int a, int b) {
		return a+b;
	}
	
	@Override
	public int sub(int su1, int su2) {
		return su1-su2;
	}
	
	@Override
	public double average(int[] arr) {
		double sum=0;
		
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
		}
		
		sum/=arr.length;
		
		return sum;
	}
}
public class Calculator_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int[] arr = new int[sc.nextInt()];
		
		System.out.println("배열의 저장될 정수 값을 입력하세요");
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		
		GoodCalc calc = new GoodCalc();
		System.out.println("add() 메서드 호출 >>> " + calc.add(56, 44));
		System.out.println("sub() 메서드 호출 >>> " + calc.sub(56, 44));
		System.out.println("averange() 메서드 호출 >>> " + calc.average(arr));
		
		sc.close();
	}

}
