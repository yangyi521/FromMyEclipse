package Bean;

public class ReBookBean {
	
	private int ISBN;
	private String	bookname;	
	private String	author;
	private String	Booktime;
	private String	catalog;
	private int	Sum;
	private int userid;
    private String returnDate;
    private String conditon;
    private int  Reid;
	public int getReid() {
		return Reid;
	}
	public void setReid(int reid) {
		Reid = reid;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getConditon() {
		return conditon;
	}
	public void setConditon(String conditon) {
		this.conditon = conditon;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBooktime() {
		return Booktime;
	}
	public void setBooktime(String booktime) {
		Booktime = booktime;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public int getSum() {
		return Sum;
	}
	public void setSum(int sum) {
		Sum = sum;
	}
	
	public boolean isNumeric(String str){
		  for (int i = str.length();--i>=0;){   
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }

}
