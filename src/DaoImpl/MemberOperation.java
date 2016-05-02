package DaoImpl;
//MemberOperation�� ʵ�־�����ɾ�Ĳ鹦��
//�����ߣ�����3��4��  ----   ������
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
//��ʾ���л�Ա��Ϣ	
	@Override
	public List<MumberBean> showall() {
		// TODO Auto-generated method stub
		MumberBean  show=null;
		List<MumberBean> showList=new ArrayList<MumberBean>();
		//1.�������ݿ����Ӷ���
		ODConnection  odc=new ODConnection();
		//2.�������ݿ�
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
 
//��ӻ�Ա��Ϣ
	@Override
	public boolean memberaddmsg(MumberBean a) {
		// TODO Auto-generated method stub
		boolean flag=false;
		//1.�������ݿ����Ӷ���
		ODConnection   odc=new ODConnection ();
		//2.�������ݿ�
		conn=odc.getConnection();
		//3.����sql��������ݿ�t_user���г����Ա��Ϣ(��Ա�ţ����������䣬�绰���Խ��������)
		String sql="insert into t_user values(?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//4.ִ��sql��䣬�����û���Ϣ��ӽ����ݱ���
			pstmt.setString(1, a.getMembername());
			pstmt.setString(2,a.getMemberemail());
			pstmt.setString(3, a.getTelephone());
			pstmt.setInt(4, a.getGetbook());
			//5.�ж������Ƿ���ӳɹ�
			if(pstmt.executeUpdate()>0){
				return flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			odc.closedConnection(conn,pstmt,rs);//6.�ͷ���Դ
		}
		return false;
	}
 
//ɾ����Ա��Ϣ
	public boolean memberdelmsg(int  adminid) {
		// TODO Auto-generated method stub
		boolean flog=false;
		//1.ʵ�������󣬵���getConnection()������ʵ�����ݿ�����
		ODConnection   call=new  ODConnection ();
		conn=call.getConnection();
		//2.����sql���ɾ����Ӧ��Ա��Ϣ������ִ�ж���ִ��sql���
		String sql="delete from t_user where memberid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,adminid);
			//3.��֤sql����Ƿ�ִ�гɹ�
			if(pstmt.executeUpdate()>0){
				flog=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			call.closedConnection(conn, pstmt, rs);//4�ͷ���Դ
		}
		return flog;
	}
//�޸Ļ�Ա��Ϣ
	@Override
	public boolean membermodifymsg(MumberBean a) {
		// TODO Auto-generated method stub
		boolean flog=false;
		//1.�������Ӷ���
		ODConnection   call2=new  ODConnection ();
		//2.ͨ�����÷���ʵ������
		conn=call2.getConnection();
		//3.sql���ʵ�����ݸ���
		String sql="update t_user set membername=?,memberEmail=?,telephone=?,Getbook=?  where memberid=? ";
		//4.����ִ�ж���
		try {
			//5.ִ��sql���
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(5, a.getMemberid());
			pstmt.setString(1, a.getMembername());
			pstmt.setString(2, a.getMemberemail());
			pstmt.setString(3, a.getTelephone());
			pstmt.setInt(4,a.getGetbook());
			//6.��֤sql�Ƿ�ִ�гɹ�
			if(pstmt.executeUpdate()>0){
				return flog=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			call2.closedConnection(conn, pstmt, rs);//7.�ͷ���Դ
		}
		return flog;

	}
//��ѯ��Ա��Ϣ
	@Override
	public MumberBean memberquerymsg(int id) {
		// TODO Auto-generated method stub
		MumberBean admin=null;
		//boolean flag=false;
		//1.�������Ӷ���
		ODConnection   call3=new ODConnection();
		//2.�������ݿ�
		conn=call3.getConnection();
		//3.sql����ѯ��Ա��Ϣ
		String sql="select * from t_user where memberid=?";
		//4.����ִ�ж���
		try {
			//5.ִ��sql���MumberBean
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();//���ز�ѯ�����
			//6.��֤sql���ִ�н��
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
			call3.closedConnection(conn, pstmt, rs);//7.�ͷ���Դ
		}
		return admin;
	}

	

	
}
