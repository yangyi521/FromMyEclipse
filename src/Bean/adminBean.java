package Bean;

public class adminBean {
	private String UserName;
	private String PassWrod;
	private int Power;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWrod() {
		return PassWrod;
	}
	public void setPassWrod(String passWrod) {
		PassWrod = passWrod;
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
	
}
