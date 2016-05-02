package Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import Bean.Borrowbooks;
import DaoImpl.LoanLogDaoImpl;
import DaoImpl.MemberOperation;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ODConnection odc=new ODConnection();
		//System.out.println("aaaaaa");
		//Connection conn=odc.getConnection();
		//System.out.println("aaaaaa");
		LoanLogDaoImpl ld = new LoanLogDaoImpl();
		//System.out.println("aaaaaa");
		Borrowbooks bb = new Borrowbooks();
		//System.out.println("aaaaaa");
		boolean flag;
		
		System.out.println(ld.select(9).getGetId());
//		List<Borrowbooks> borrowList = new ArrayList<Borrowbooks>();
//		bb.setISBN(1);
//		bb.setUserId(2);
//		
//		bb.setUserName("小明");
//		
//		bb.setGetDate("7点");
//		bb.setCondition("已借出");
//		bb.setBookName("盗墓笔记");
//		 borrowList=ld.getAll();
		//boolean b = ld.remove(2);
		//flag=ld.remove(1);
		//int f = ld.insert(bb);
//		flag=ld.update1(bb, 2);
		 
		//System.out.println(ld.select(7)!=null);
//		MemberOperation mo=new MemberOperation();
//		int a=mo.memberquerymsg(bb.getUserId()).getGetbook();
//		System.out.println(a);
//		if (ld.select1(1)!= null) {
//			System.out.println("sss");
//		}
		
		//System.out.println( borrowList.size());
		
	}

}
