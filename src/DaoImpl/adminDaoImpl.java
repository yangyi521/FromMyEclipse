package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import until.ODConnection;
import Bean.adminBean;
import Dao.adminDao;

public class adminDaoImpl extends adminDao {
	Connection conn=null;
    PreparedStatement ps=null; 
    ResultSet re=null;

	@Override
	public boolean insert(adminBean a) {
		// TODO Auto-generated method stub
		boolean flag=false;
		ODConnection odc=new ODConnection();
		conn=odc.getConnection();
		String sql="insert into admin values(?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, a.getUserName());
			ps.setString(2, a.getPassWrod());
			ps.setInt(3, a.getPower());
			if(ps.executeUpdate()>0){
				return flag=true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			odc.closedConnection(conn, ps, re);
		}
		
		return flag;
			
		

}

	@Override
	public boolean remove(String adminName) {
		// TODO Auto-generated method stub
		boolean flag=false;
		ODConnection odc=new ODConnection();
		conn=odc.getConnection();
		adminDaoImpl adi=new adminDaoImpl();
		if(adi.select(adminName)!=null){
			 try {     
		    		String sql="delete from admin where adminName=?";
		    		ps=conn.prepareStatement(sql);
		    		ps.setString(1, adminName);
		    		if(ps.executeUpdate()>0){
		    			flag=true;
		    		};
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					odc.closedConnection(conn, ps, re);
				}
		}
		return flag;
			
		
	}

	@Override
	public boolean update(adminBean a,String adminName) {
		// TODO Auto-generated method stub
		boolean flag=false;
		ODConnection odc=new ODConnection();
		conn=odc.getConnection();
		String sql="update  admin set adminName=?,PassWrod=?,Power=? where  adminName=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, a.getUserName());
			ps.setString(2, a.getPassWrod());
			ps.setInt(3, a.getPower());
			ps.setString(4,adminName);
			if(ps.executeUpdate()>0){
				return flag=true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			odc.closedConnection(conn, ps, re);
		}
		
		return flag;
	}

	@Override
	public adminBean select(String adminName) {
		// TODO Auto-generated method stub
        adminBean admin=null;
        ODConnection odc=new ODConnection();
		conn=odc.getConnection();
        try {          
		String sql="select * from admin where adminName=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, adminName);
		re=ps.executeQuery();
		while(re.next()){
			admin = new adminBean();
			admin.setUserName(re.getString("adminName"));
			admin.setPassWrod(re.getString("PassWrod"));
			admin.setPower(re.getInt("Power"));
		}
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			odc.closedConnection(conn, ps, re);
		}
		return admin;
	}

	@Override
	public List<adminBean> getAll() {
		// TODO Auto-generated method stub
        ODConnection odc=new ODConnection();
		conn=odc.getConnection();
		adminBean admin=null;
		List<adminBean> adminList=new ArrayList<adminBean>();
        try {          
		String sql="select * from admin";
		ps=conn.prepareStatement(sql);
		re=ps.executeQuery();
		while(re.next()){
			admin = new adminBean();
			admin.setUserName(re.getString("adminName"));
			admin.setPassWrod(re.getString("PassWrod"));
			admin.setPower(re.getInt("Power"));
			adminList.add(admin);
		}
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			odc.closedConnection(conn, ps, re);
		}
		return adminList;
	}
	public int login(String name,String pass){
		 int flag = 0;
		 ODConnection odc=new ODConnection();
			conn=odc.getConnection();
	        try {          
			String sql="select * from admin where adminName=? and PassWrod=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			re=ps.executeQuery();
			if(re!=null){
				while(re.next()){
					flag=re.getInt("Power");
				}
			}
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				odc.closedConnection(conn, ps, re);
			}
			
		return flag;
		
	}

}
