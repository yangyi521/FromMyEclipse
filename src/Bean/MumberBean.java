package Bean;
//定义用户信息属性并初始化
//开发者：开发3班4组----刘婷婷
public class MumberBean {
	private int memberid;           //会员id号
	private String membername;      //会员姓名
	private String memberemail;     //会员邮箱
	private String telephone;       //联系方式—电话号码
	private int getbook;            //以借书的数量
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMemberemail() {
		return memberemail;
	}
	public void setMemberemail(String memberemail) {
		this.memberemail = memberemail;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getGetbook() {
		return getbook;
	}
	public void setGetbook(int getbook) {
		this.getbook = getbook;
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
