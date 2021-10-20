package LIbrary;

public class BookVo {

	//필드변수만들기
	private String b_id;
	private String b_title;
	private String b_author;
	private String b_publisher;
	private int b_price;
	
	public BookVo() {
		
		
	}
	public BookVo(String b_id,String b_title,String b_author,String b_publisher,int b_price) {
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_author = b_author;
		this.b_publisher = b_publisher;
		this.b_price = b_price;
	}
	public String getB_id() {
		return this.b_id ;
	} 
	public String getB_title() {
		return this.b_title;
	}
	public String getB_author() {
		return this.b_author;
	}
	public String getB_publisher() {
		return this.b_publisher;
	}

	@Override
	public String toString() {
		return "BookVo [b_id=" + b_id + ", b_title=" + b_title + ", b_author=" + b_author + ", b_publisher="
				+ b_publisher + ", b_price=" + b_price + "]";
	}
	
}
