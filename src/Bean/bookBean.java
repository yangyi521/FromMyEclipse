package Bean;
public class bookBean {
	private int Power;
	private String bookName; //����
    private String author;  //ͼ������
	private String date;//����ͼ�����ʱ��
	private String catalog;//����ͼ����
	private int ISBN; //����ͼ���ISBN��
	private int sum;//ͼ������
	
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
		return "\n"+"������"+bookName+"\n\n"+"����:"+author+"\n\n"+"����ʱ�䣺"+date+
				"\n\n"+"���ܣ�"+catalog+"\n\n"+"ISBN�ţ�"+ISBN;
	}
	
	
}
