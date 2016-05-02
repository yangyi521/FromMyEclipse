package Bean;
public class bookBean {
	private int Power;
	private String bookName; //书名
    private String author;  //图书作者
	private String date;//定义图书出版时间
	private String catalog;//定义图书简介
	private int ISBN; //定义图书的ISBN号
	private int sum;//图书总数
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getSum() {
		return sum;
	}
	
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public int getPower() {
		return Power;
	}
	public void setPower(int power) {
		Power = power;
	}
	
	public boolean isNumeric(String str){
		  for (int i = str.length();--i>=0;){   
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }
	public String toString() {
		return "\n"+"书名："+bookName+"\n\n"+"作者:"+author+"\n\n"+"出版时间："+date+
				"\n\n"+"介绍："+catalog+"\n\n"+"ISBN号："+ISBN;
	}
	
	
}
