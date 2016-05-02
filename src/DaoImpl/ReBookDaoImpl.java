package DaoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import until.ODConnection;
import Bean.Borrowbooks;
import Bean.ReBookBean;

import Dao.ReBookDao;

public class ReBookDaoImpl extends ReBookDao {
	Connection con=null;
    PreparedStatement psmt=null; 
    ResultSet rs=null;

	@Override
	//锟斤拷锟斤拷一锟斤拷锟斤拷锟侥硷拷录
	public int insert(ReBookBean a,int getId) {
		int flag=0;
		ODConnection odc=new ODConnection();
		con=odc.getConnection();
		LoanLogDaoImpl lldi=new LoanLogDaoImpl();
		Borrowbooks bbs=new Borrowbooks();
		MemberOperation mo=new MemberOperation();
	 	bookDaoImpl bdi=new bookDaoImpl();
		if(lldi.select(getId)!=null){
		 	try {
		 		bbs=lldi.select(getId);
		 		int temp=mo.memberquerymsg( bbs.getUserId()).getGetbook()-1;
	 			System.out.println("  temp:"+  temp);
	 			String sql2= "update t_user set Getbook=?  where memberid=?";
			 	psmt = con.prepareStatement(sql2);
			 	psmt.setLong(1,temp);
			 	psmt.setInt(2, bbs.getUserId());
			 	if(psmt.executeUpdate()>0){
			 		int temp1=bdi.select(bbs.getISBN()).getSum()+1;
			 		String sql3= "UPDATE Book SET  Sum=? WHERE ISBN=?";
				 	psmt = con.prepareStatement(sql3);
				 	psmt.setLong(1,temp1);
				 	psmt.setInt(2, bbs.getISBN());
				 	if(psmt.executeUpdate() > 0){
				 		String sql1= "update db_GetBook set Condition=? where GetId=?";
					 	psmt = con.prepareStatement(sql1);
					 	psmt.setString(1,a.getConditon());
					 	psmt.setInt(2, getId);
						if(psmt.executeUpdate() > 0){
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式		
							String time=df.format(new Date());// new Date()为获取当前系统时间
						
							String sql="insert into db_ReturnBook values(?,?,?,?)";
							psmt = con.prepareStatement(sql);
						 	psmt.setLong(1,bbs.getISBN());
						 	psmt.setInt(2,  bbs.getUserId());
						 	psmt.setString(3,time);
						 	psmt.setString(4, a.getConditon());
						 	if(psmt.executeUpdate() > 0){
						 		return flag=6;//成功
						 	}else{
						 		return flag=5;//添加失败
						 	}
						}else{
							return flag=4;//修改借书单信息失败
						}
				 	}else{
				 		return flag=3;//图书信息修改失败
				 	}
			 	}else{
			 		return flag=2;//会员信息修改失败
			 	}
			 	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		}else{
			return flag=1;//无此借书单
		}
		return flag;
	}

	@Override
	//删锟斤拷锟斤拷锟酵硷拷锟侥癸拷锟杰ｏ拷锟斤拷锟酵硷拷锟斤拷reid锟脚ｏ拷删锟斤拷图锟斤拷慕锟斤拷募锟铰�
	public boolean remove(int reid) {
		// TODO Auto-generated method stub
		boolean flag=false;
		ODConnection odc=new ODConnection();
		con=odc.getConnection();
		ReBookDaoImpl re = new ReBookDaoImpl();
		 if(re.select(reid)!=null){
			 String sql="delete  from db_ReturnBook where reid=?";
			 try{
			 psmt = con.prepareStatement(sql);
			 psmt.setInt(1, reid);
			 if(psmt.executeUpdate()>0){
	    			flag=true;
	    		};
			 }catch(Exception e){
				 e.printStackTrace();
			 } 
			 
		 }
		
		   return flag;
	}

	@Override
	//锟斤拷锟铰斤拷锟斤拷图锟斤拷锟侥癸拷锟斤拷 锟斤拷锟斤拷锟酵硷拷锟侥斤拷锟介单锟脚ｏ拷执锟叫伙拷锟介功锟斤拷
	public boolean update(ReBookBean a, int reid) {
		boolean flag=false;
		ODConnection odc=new ODConnection();
		con=odc.getConnection();
		String sql="update  db_ReturnBook set ISBN=?,UserId=? ,ReturnDate=?,Condition=? where  Reid=?";
		try{
		 psmt = con.prepareStatement(sql);
		psmt.setInt(1, a.getISBN());
		psmt.setInt(2, a.getUserid());
		psmt.setString(3,a.getReturnDate());
		psmt.setString(4, a.getConditon());
		psmt.setInt(5, reid);
		System.out.println(sql);
		if(psmt.executeUpdate()>0){
			return flag = true;
		
		}
		 } catch(Exception e){
				e.printStackTrace();
			}
		return flag;
		
		
	}

	@Override
	public ReBookBean select(int reid) {
		// TODO Auto-generated method stub
		boolean flag=false;
		ODConnection odc=new ODConnection();
		con=odc.getConnection();
		ReBookBean book = new ReBookBean();
		String sql = "select * from db_ReturnBook where Reid = ?";
		try{
			 psmt = con.prepareStatement(sql);
			psmt.setInt(1, reid);
			 rs = psmt.executeQuery();
			while(rs.next()){
				book=new ReBookBean();
				book.setReid(rs.getInt("Reid"));
				book.setISBN(rs.getInt("ISBN"));
				book.setReturnDate(rs.getString("ReturnDate"));
				book.setConditon(rs.getString("Condition"));
				
				//锟酵凤拷锟斤拷菘锟斤拷锟皆�
				rs.close();
				psmt.close();
				con.close();
			}
			}catch(Exception e){
			e.printStackTrace();
		}
		return book;
		}

	@Override
	//锟斤拷锟斤拷锟斤拷械锟酵硷拷锟�
	public List<ReBookBean> getAll() {
		ODConnection odc=new ODConnection();
		con=odc.getConnection();
		List<ReBookBean> BookList=new ArrayList<ReBookBean>();
		String sql = "select * from db_ReturnBook";
		try{
			ReBookBean rbook=null;	
		 psmt = con.prepareStatement(sql);
		 rs=psmt.executeQuery();
		 while(rs.next()){
			rbook = new  ReBookBean();
			//rbook=new ReBookBean();
			rbook.setReid(rs.getInt("Reid"));
			rbook.setUserid(rs.getInt("UserId"));
			rbook.setISBN(rs.getInt("ISBN"));
			rbook.setReturnDate(rs.getString("ReturnDate"));
			rbook.setConditon(rs.getString("Condition"));
			BookList.add(rbook);
			 
		 }
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return BookList;
	}

}
