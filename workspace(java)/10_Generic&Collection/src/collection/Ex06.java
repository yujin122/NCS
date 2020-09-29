 package collection;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Queue 인터페이스(자료구조)
 * - 인터페이스이므로 자식클래스로 객체 생성해서 사용함.
 * - 대표적인 자식클래스는 LinkedList
 * - 선입선출(FIFO : First In First Out) 구조
 */

public class Ex06 {
 
	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<String>();
		
		// 1. 큐에 저장하는 메서드 : offer
		queue.offer("100번 손님");
		queue.offer("101번 손님");
		queue.offer("102번 손님");
		queue.offer("103번 손님");
		queue.offer("104번 손님");
		queue.offer("105번 손님");
		
		// 2. 큐에 저장된 맨 처음 데이터를 가저요는 메서드 : peek()
		//	    큐에서 데이터를 제거하지 않는 메서드
		System.out.println("처음 호출한 번호 : " + queue.peek());
		System.out.println();
		
		// 3. 큐에 저장된 맨 처음 데이터를 가져오는 메서드 : poll()
		//	     큐에서 데이터를 제거하는 메서드
		
		while(!queue.isEmpty()) {
			System.out.println("호출한 번호 : " + queue.poll());
		}
	}

}
