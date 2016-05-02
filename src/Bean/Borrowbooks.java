package Bean;

public class  Borrowbooks {
	 private int GetId;    //鍊熶功鍗曞彿   
     private int UserId;  //浼氬憳id
     private int ISBN;    //涔﹀彿ISBN
     private String UserName;  //浼氬憳濮撳悕
     private String BookName;   //鍥句功鍚嶅瓧
     private String GetDate;    //鍊熶功鏃堕棿
     //鍊熶功鏃堕棿鍖呭惈鏃讹紝姝ゆ椂瀵瑰簲鐨凧AVA绫讳娇鐢⊿tring
     private String Condition;     //鐘舵�
     
     
     //get  set   鏂规硶
     public int getGetId(){
    	 return GetId;
     }
     public void setgetid(int GetId){
    	 this.GetId=GetId;
     }
     public int getUserId(){
    	 return UserId;
     }
     public void setUserId(int UserId){
    	 this.UserId=UserId;
     }
     public int getISBN(){
    	 return ISBN;
     }
     public void setISBN(int ISBN){
    	 this.ISBN=ISBN;
     }
     public String getUserName(){
    	 return UserName;
     }
     public void setUserName(String UserName){
         this.UserName=UserName;    	 
     }
     public String getBookName(){
    	 return BookName;
     }
     public void setBookName(String BookName){
    	 this.BookName=BookName;
     }
     public String getGetDate(){
    	 return GetDate;
     }
     public void setGetDate(String GetDate){
    	 this.GetDate=GetDate;
     }
    
     public String getCondition(){
    	 return Condition;
     }
     public void setCondition(String Condition){
    	 this.Condition=Condition;
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
