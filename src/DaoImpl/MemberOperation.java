package DaoImpl;
//MemberOperation类 实现具体增删改查功能
//开发者：开发3班4组  ----   刘婷婷
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import until.ODConnection;



import Bean.MumberBean;
import Dao.MemberMessage;

public class MemberOperation extends MemberMessage {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	private String adminName;
//显示所有会员信息	
	@Override
	public List<MumberBean> showall() {
		// TODO Auto-generated method stub
		MumberBean  show=null;
		List<MumberBean> showList=new ArrayList<MumberBean>();
		//1.创建数据库链接对象
		ODConnection  odc=new ODConnection();
		//2.连接数据库
		conn=odc.getConnection();
		String sql="select * from t_user";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				show=new MumberBean();
				show.setMemberid(rs.getInt("memberid"));
				show.setMembername(rs.getString("membername"));
				show.setMemberemail(rs.getString("memberemail"));
				show.setTelephone(rs.getString("telephone"));
				show.setGetbook(rs.getInt("getbook"));	
				showList.add(show);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return showList;
	}
 
//添加会员信息
	@Override
	public boolean memberaddmsg(MumberBean a) {
		// TODO Auto-generated method stub
		boolean flag=false;
		//1.创建数据库链接对象
		ODConnection   odc=new ODConnection ();
		//2.连接数据库
		conn=odc.getConnection();
		//3.创建sql语句向数据库t_user表中出入会员信息(会员号，姓名，邮箱，电话，以借书的数量)
		String sql="insert into t_user values(?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//4.执行sql语句，讲新用户信息添加进数据表中
			pstmt.setString(1, a.getMembername());
			pstmt.setString(2,a.getMemberemail());
			pstmt.setString(3, a.getTelephone());
			pstmt.setInt(4, a.getGetbook());
			//5.判断数据是否添加成功
			if(pstmt.executeUpdate()>0){
				return flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			odc.closedConnection(conn,pstmt,rs);//6.释放资源
		}
		return false;
	}
 
//删除会员信息
	public boolean memberdelmsg(int  adminid) {
		// TODO Auto-generated method stub
		boolean flog=false;
		//1.实例化对象，调用getConnection()方法，实现数据库连接
		ODConnection   call=new  ODConnection ();
		conn=call.getConnection();
		//2.创建sql语句删除相应会员信息，创建执行对象，执行sql语句
		String sql="delete from t_user where memberid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,adminid);
			//3.验证sql语句是否执行成功
			if(pstmt.executeUpdate()>0){
				flog=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			call.closedConnection(conn, pstmt, rs);//4释放资源
		}
		return flog;
	}
//修改会员信息
	@Override
	public boolean membermodifymsg(MumberBean a) {
		// TODO Auto-generated method stub
		boolean flog=false;
		//1.创建连接对象
		ODConnection   call2=new  ODConnection ();
		//2.通过调用方法实现连接
		conn=call2.getConnection();
		//3.sql语句实现数据更新
		String sql="update t_user set membername=?,memberEmail=?,telephone=?,Getbook=?  where memberid=? ";
		//4.创建执行对象
		try {
			//5.执行sql语句
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(5, a.getMemberid());
			pstmt.setString(1, a.getMembername());
			pstmt.setString(2, a.getMemberemail());
			pstmt.setString(3, a.getTelephone());
			pstmt.setInt(4,a.getGetbook());
			//6.验证sql是否执行成功
			if(pstmt.executeUpdate()>0){
				return flog=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			call2.closedConnection(conn, pstmt, rs);//7.释放资源
		}
		return flog;

	}
//查询会员信息
	@Override
	public MumberBean memberquerymsg(int id) {
		// TODO Auto-generated method stub
		MumberBean admin=null;
		//boolean flag=false;
		//1.创建连接对象
		ODConnection   call3=new ODConnection();
		//2.连接数据库
		conn=call3.getConnection();
		//3.sql语句查询会员信息
		String sql="select * from t_user where memberid=?";
		//4.创建执行对象
		try {
			//5.执行sql语句MumberBean
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();//返回查询结果集
			//6.验证sql语句执行结果
			while(rs.next()){
				admin=new MumberBean();
				admin.setMemberid(rs.getInt("memberid"));
				admin.setMembername(rs.getString("membername"));
				admin.setMemberemail(rs.getString("memberEmail"));
				admin.setTelephone(rs.getString("telephone"));
				admin.setGetbook(rs.getInt("getbook"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			call3.closedConnection(conn, pstmt, rs);//7.释放资源
		}
		return admin;
	}

	

	
}
