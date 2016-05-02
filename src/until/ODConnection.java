package until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ODConnection {
	
		static Connection con;
		public ODConnection(){
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url="jdbc:sqlserver://localhost:1433; DatabaseName=BookControl";
				String user1="yangyi";
				String passworda="yangyi521";
				con=DriverManager.getConnection(url,user1,passworda);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public Connection getConnection(){
			return con;
		}	
		public void closedConnection(Connection conn,Statement pstmt,ResultSet rs){
			if(null!=rs){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		if(null!=pstmt){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null!=conn){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	}