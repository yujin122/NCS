package classes;

class TextBook{
	
	String title;
	String autor;
	int grade;
	
	public TextBook() { }
	
	public TextBook(String t) {
		title = t;
	}
	
	public TextBook(String t, String a) {
		title = t;
		autor = a;
	}
	
	public TextBook(String t, String a, int g) {
		title = t;
		autor = a;
		grade = g;
	}
	
	public void getBookInfo() {
		System.out.println("책 제목 : " + title);
		System.out.println("책 저자 : " + autor);
		System.out.println("학년 : " + grade);
	}
}

public class TextBook_Main {

	public static void main(String[] args) {
		
		TextBook book = new TextBook();
		
		book.title = "국어";
		book.autor = "세종대왕";
		book.grade = 1;
		
		book.getBookInfo();
		System.out.println();
		
		TextBook book1 = new TextBook("Java의 정석");
		book1.autor = "남궁성";
		book1.grade = 3;
		book1.getBookInfo();
		System.out.println();
		
		TextBook book2 = new TextBook("영어","James");
		book2.grade = 5;
		book2.getBookInfo();
		System.out.println();
		
		TextBook book3 = new TextBook("수학", "아무개", 6);
		book3.getBookInfo();
		
		
	}

}
