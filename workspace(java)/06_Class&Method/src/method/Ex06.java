package method;

public class Ex06 {

	public static void change(int[] a) {	// a = [I@6477463f
		System.out.println(a);
		a[0] = 100;
		a[1] = 200;
		a[2] = 300;
	} 
	
	public static void main(String[] args) {

		// call by reference
		int[] arr = new int[3];
		arr[0]=10; arr[1]=20; arr[2]=30;
		
		System.out.println(arr);
		System.out.println("change() 메서드 호출 전...");
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr["+i+"] >>> "+arr[i]);
		} 
		System.out.println();
		
		change(arr);
		
		System.out.println("change() 메서드 호출 후...");
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr["+i+"] >>> "+arr[i]);
		}
		System.out.println();

	}

}
