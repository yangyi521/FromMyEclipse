package Bean;
//�����û���Ϣ���Բ���ʼ��
//�����ߣ�����3��4��----������
public class MumberBean {
	private int memberid;           //��Աid��
	private String membername;      //��Ա����
	private String memberemail;     //��Ա����
	private String telephone;       //��ϵ��ʽ���绰����
	private int getbook;            //�Խ��������
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
