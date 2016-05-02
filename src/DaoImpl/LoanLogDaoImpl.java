package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import until.ODConnection;
import Bean.Borrowbooks;
import Dao.ILoanLogDao;

public class LoanLogDaoImpl extends ILoanLogDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet re = null;

	// private String getdate;

	public int insert(Borrowbooks a){
		int flag=0;
		PreparedStatement ps = null;
		ODConnection odc=new ODConnection();
		conn=odc.getConnection();
		MemberOperation mo=new MemberOperation();
		bookDaoImpl bdi=new bookDaoImpl();
		if(mo.memberquerymsg(a.getUserId())!=null){
			if(bdi.select(a.getISBN())!=null){
				if(bdi.select(a.getISBN()).getSum()>0){
					if(mo.memberquerymsg(a.getUserId()).getGetbook()<10){
						String username=mo.memberquerymsg(a.getUserId()).getMembername();
						String bookname=bdi.select(a.getISBN()).getBookName();
						String time;
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						
							time=df.format(new Date());// new Date()为获取当前系统时间
						
						String sql = "insert into db_GetBook values(?,?,?,?,?,?)";
						try {
							System.out.println("time="+time+" df="+df.format(new Date()));
							ps=conn.prepareStatement(sql);
							
							ps.setInt(1, a.getISBN());
							ps.setInt(2, a.getUserId());
							ps.setString(3, username);	
							ps.setString(4, time);	
							ps.setString(5, a.getCondition());
							ps.setString(6, bookname);

							if (ps.executeUpdate() > 0) {
								int temp=bdi.select(a.getISBN()).getSum();
								temp=temp-1;
								String sql1="UPDATE Book SET Sum=? WHERE ISBN=?";
								try{
									ps=this.conn.prepareStatement(sql1);
									ps.setInt(1, temp);
									ps.setInt(2, a.getISBN());
									if(ps.executeUpdate()>0){
										int temp1=mo.memberquerymsg(a.getUserId()).getGetbook();
										temp1=temp1+1;
										String sql2="update t_user set Getbook=?  where memberid=? ";
										try {
											//5.执行sql语句
											ps=conn.prepareStatement(sql2);
											ps.setInt(1,temp1);
											ps.setInt(2,a.getUserId());
											//6.验证sql是否执行成功
											if(ps.executeUpdate()>0){
												return flag=8;//借书成功
											}else{
												return flag=7;//增加借书数量失败
											}
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}else{
										return flag=6;//减少书籍失败
									}
								}catch(Exception e){
									e.printStackTrace();
								}
							}else{
								return flag=5;//添加失败
							}
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							odc.closedConnection(conn, ps, re);
						}
					}else{
						return flag=4;//此人借书已超10本
					}
				}else{
					return flag=3;//次数无库存
				}
			}else{
				return flag=2;//查无此书
			}
		}else{
			return flag=1;//无此会员
		}
		return flag;
	}

	public boolean remove(int GetId) {
		boolean flag = false;
		ODConnection odc = new ODConnection();
		conn = odc.getConnection();
		LoanLogDaoImpl lld = new LoanLogDaoImpl();
		if (lld.select(GetId)!= null) {
			try {
				String sql = "delete from db_GetBook where GetId=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, GetId);
				if (ps.executeUpdate() > 0) {
					flag = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				odc.closedConnection(conn, ps, re);
			}
		}
		return flag;
	}
	public boolean update(Borrowbooks a, int GetId){
		boolean flag = false;
		ODConnection odc = new ODConnection();
		conn = odc.getConnection();
		String sql = "update db_GetBook set ISBN=?,UserId=?,UserName=?,GetDate=?,"
				+ "Condition=?,BookName=? where  GetId=?";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, a.getISBN());
			ps.setInt(2, a.getUserId());
			ps.setString(3, a.getUserName());
			ps.setString(4, a.getGetDate());
			ps.setString(5, a.getCondition());
			ps.setString(6, a.getBookName());
			ps.setInt(7, GetId);
			if (ps.executeUpdate() > 0) {
				return flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			odc.closedConnection(conn, ps, re);
		}

		return flag;
	}

	public  Borrowbooks select(int GetId) {
		Borrowbooks borrow = null;
		ODConnection odc = new ODConnection();
		conn = odc.getConnection();
		try {
			String sql = "select * from db_GetBook where GetId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, GetId);
			re = ps.executeQuery();
			while (re.next()) {
				borrow = new Borrowbooks();
				borrow.setgetid(re.getInt("GetId"));
				borrow.setISBN(re.getInt("ISBN"));
				borrow.setUserId(re.getInt("UserId"));
				borrow.setBookName(re.getString("BookName"));
				borrow.setUserName(re.getString("UserName"));
				borrow.setGetDate(re.getString("GetDate"));
				borrow.setCondition(re.getString("Condition"));
				
				

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borrow;
	}

	public List<Borrowbooks> getAll() {
		Borrowbooks borrow = null;
		boolean flag = false;
		ODConnection odc = new ODConnection();
		conn = odc.getConnection();
		List<Borrowbooks> borrowList = new ArrayList<Borrowbooks>();
		try {
			String sql = "select * from db_GetBook";
			ps = conn.prepareStatement(sql);
			re = ps.executeQuery();
			while (re.next()) {
				borrow = new Borrowbooks();
				borrow.setgetid(re.getInt("GetId"));
				borrow.setISBN(re.getInt("ISBN"));
				borrow.setUserId(re.getInt("UserId"));
				borrow.setGetDate(re.getString("GetDate"));
				borrow.setUserName(re.getString("UserName"));
				borrow.setCondition(re.getString("Condition"));
				borrow.setBookName(re.getString("BookName"));
				

				
				borrowList.add(borrow);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borrowList;

	}
}
