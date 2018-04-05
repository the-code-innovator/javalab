import java.*;

class Book{
	String BKName;
	int BKId;
	String BKAuthor;

	Book(String name, int id, String author){
		BKName = name;
		BKId = id;
		BKAuthor = author;
	}

	void BKUpdateDetails(String name, int id, String author){
		BKName = name;
		BKId = id;
		BKAuthor = author;
	}
	void BKDisplay(){
		System.out.print("\n Book ID : " + BKId);
		System.out.print("\n Book Name : " + BKName);
		System.out.print("\n Book Author : " + BKAuthor);
	}
}

public class BookDemo{
	public static void main(String[] args){
		Book b1 = new Book("JAVA Programming", 1, "Tim Hortons");
		b1.BKDisplay();
		b1.BKUpdateDetails("JAVAScript Programming", 2, "John Hopkins");
		b1.BKDisplay();
	}
}
