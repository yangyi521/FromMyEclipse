package DaoImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import until.ODConnection;
import Bean.bookBean;
import Dao.bookDao;

public class bookDaoImpl extends bookDao{
	Connection conn=null;
    PreparedStatement pstmt=null; 
    ResultSet re=null;
	@Override
	public boolean insert(bookBean book) {
		// TODO Auto-generated method stub
		boolean flag=false;
		ODConnection odc=new ODConnection();
		conn=odc.getConnection();
		//PreparedStatement pstmt=null;
		String sql="INSERT  INTO Book(ISBN,bookname,author,Booktime,catalog,Sum)VALUES(?,?,?,?,?,?)";
		try{
			pstmt=this.conn.prepareStatement(sql);
			pstmt.setString(2, book.getBookName());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getDate());
			pstmt.setString(5,book.getCatalog());
			pstmt.setInt(1, book.getISBN());
			pstmt.setInt(6, book.getSum());
			if(pstmt.executeUpdate()>0){
				flag=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			odc.closedConnection(conn, pstmt, re);
	}
		return flag;
	}

	@Override
	public boolean remove(int ISBN) {
		// TODO Auto-generated method stub
		boolean flag=false;
		ODConnection odc=new ODConnection();
		conn=odc.getConnection();
		bookDaoImpl bo=new bookDaoImpl();
		if(bo.select(ISBN)!=null){
			 try {     
		    		String sql="delete from Book where ISBN=?";
		    		pstmt=conn.prepareStatement(sql);
		    		pstmt.setInt(1, ISBN);
		    		if(pstmt.executeUpdate()>0){
		    			flag=true;
		    		};
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					odc.closedConnection(conn, pstmt, re);
				}
		}
		return flag;
	}

	@Override
	public boolean update(bookBean book, int ISBN) {
		// TODO Auto-generated method stub
		// 更新图书信息
				boolean flag=false;
				ODConnection odc=new ODConnection();
				conn=odc.getConnection();
				//PreparedStatement pstmt=null;
				String sql="UPDATE Book SET ISBN=? ,bookname=?,author=?,Booktime=?,catalog=?, Sum=? WHERE ISBN=?";
				try{
					pstmt=this.conn.prepareStatement(sql);
					pstmt.setInt(1,book.getISBN());
					pstmt.setString(2, book.getBookName());
					pstmt.setString(3, book.getAuthor());
					pstmt.setString(4, book.getDate());
					pstmt.setString(5, book.getCatalog());
					pstmt.setInt(6,book.getSum());
					pstmt.setInt(7,ISBN);
					if(pstmt.executeUpdate()>0){
						flag=true;
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					odc.closedConnection(conn, pstmt, re);
				}

				return flag;
	}

	@Override
	public bookBean select(int ISBN) {
		// TODO Auto-generated method stub
		 bookBean book=null;
	        ODConnection odc=new ODConnection();
			conn=odc.getConnection();
	        try {          
			String sql="select * from Book where ISBN=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ISBN);
			re=pstmt.executeQuery();
			while(re.next()){
				book = new bookBean();
				book.setBookName(re.getString("bookname"));
				book.setAuthor(re.getString("author"));
				book.setDate(re.getString("Booktime"));
				book.setCatalog(re.getString("catalog"));
				book.setSum(re.getInt("sum"));
				
			}
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				odc.closedConnection(conn, pstmt, re);
			}
			return book;
		
	}

	@Override
	public List<bookBean> getAll() {
		// TODO Auto-generated method stub
        ODConnection odc=new ODConnection();
		conn=odc.getConnection();
		bookBean book=null;
		List<bookBean> bookList=new ArrayList<bookBean>();
        try {          
		String sql="select * from Book";
		pstmt=conn.prepareStatement(sql);
		re=pstmt.executeQuery();
		while(re.next()){
			book = new bookBean();
			book.setISBN(re.getInt("ISBN"));
			book.setBookName(re.getString("bookname"));
			book.setAuthor(re.getString("author"));
			book.setDate(re.getString("Booktime"));
			book.setCatalog(re.getString("catalog"));
			book.setSum(re.getInt("sum"));
			bookList.add(book);
		}
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			odc.closedConnection(conn, pstmt, re);
		}
		return bookList;
	}

}
