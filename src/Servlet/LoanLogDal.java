package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Borrowbooks;
import Bean.adminBean;
import DaoImpl.LoanLogDaoImpl;

public class LoanLogDal extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoanLogDal() {
		super();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			String me=request.getParameter("method");
			LoanLogDaoImpl lld=new LoanLogDaoImpl();
			int flagi=0;
			boolean flag=false;
			String re = null;
			if(me.equals("add")){
				Borrowbooks bb=new Borrowbooks();
				if(bb.isNumeric(request.getParameter("userId"))&&bb.isNumeric(request.getParameter("isbn"))){
					bb.setUserId(Integer.parseInt(request.getParameter("userId")));
					bb.setISBN(Integer.parseInt(request.getParameter("isbn")));
					bb.setUserName(request.getParameter("username"));
					bb.setBookName(request.getParameter("bookname"));
					bb.setGetDate(request.getParameter("getdate"));
					bb.setCondition(request.getParameter("condition"));
					flagi=lld.insert(bb);
					switch(flagi){
					case 1:
						re="经过查询无此会员！";
						break;
					case 2:
						re="亲，没有找到您想要的书籍！";
						break;
					case 3:
						re="亲，对不起，没有库存了！";
						break;
					case 4:
						re="经过查询该用户已借书超过10本！击败了全国70%的用户！";
						break;
					case 5:
						re="对不起，添加失败！";
						break;
					case 6:
						re="对不起，减少书籍失败！";
						break;
					case 7:
						re="对不起，增加借书数量失败！";
						break;
					
						
					}
					if(flagi==8){
						re="恭喜您，借书成功！";
						request.getRequestDispatcher("get_book_list.jsp").forward(request, response);
					}else{
						request.setAttribute("info", re);
				    	 request.getRequestDispatcher("getBookAdd.jsp").forward(request, response);
					}
				}
				
			};
			if(me.equals("update")){
				Borrowbooks bb=new Borrowbooks();
				String a=request.getParameter("userId");
				String b=request.getParameter("isbn");
				System.out.println(a+" "+b);
				if(bb.isNumeric(a)&&bb.isNumeric(b)){
					bb.setUserId(Integer.parseInt(request.getParameter("userId")));
					bb.setISBN(Integer.parseInt(request.getParameter("isbn")));
					bb.setUserName(request.getParameter("username"));
					bb.setBookName(request.getParameter("bookname"));
					bb.setGetDate(request.getParameter("getdate"));
					bb.setCondition(request.getParameter("condition"));
					bb.setgetid(Integer.parseInt(request.getParameter("getid")));
					flag=lld.update(bb, bb.getGetId());
					if(flag){
						 String st="添加成功";
				    	 request.setAttribute("info", st);
				    	 request.getRequestDispatcher("get_book_list.jsp").forward(request, response);
					 }else{
						 String st="修改失败";
				    	 request.setAttribute("info", st);
				    	 request.getRequestDispatcher("getBookUpdate.jsp").forward(request, response);
					 }
					
				}else{
					String st="ISBN和书总数不能为数字以外的类型";
			    	 request.setAttribute("info", st);
			    	 request.getRequestDispatcher("getBookUpdate.jsp").forward(request, response);
				}
			};
			
			if(me.equals("remove")){
				Borrowbooks bb=new Borrowbooks();
				if(bb.isNumeric(request.getParameter("getid"))){
					bb.setgetid(Integer.parseInt(request.getParameter("getid")));
					flag=lld.remove(bb.getGetId());
					if(flag){
						 String st="删除成功";
				    	 request.setAttribute("info", st);
				    	 request.getRequestDispatcher("get_book_list.jsp").forward(request, response);
					 }else{
						 String st="删除失败";
				    	 request.setAttribute("info", st);
				    	 request.getRequestDispatcher("getBookRemove.jsp").forward(request, response);
					 }
					
				}else{
					String st="不能为数字以外的类型";
			    	 request.setAttribute("info", st);
			    	 request.getRequestDispatcher("getBookUpdate.jsp").forward(request, response);
				}
			};
			
			if(me.equals("select")){
				Borrowbooks bb=new Borrowbooks();
				Borrowbooks bb1=new Borrowbooks();
				if(bb.isNumeric(request.getParameter("getid"))){
					bb.setgetid(Integer.parseInt(request.getParameter("getid")));
					bb1=lld.select(bb.getGetId());
					if(bb1!=null){
						 String st="删除成功";
				    	 request.setAttribute("info", bb1);
				    	 request.getRequestDispatcher("getBookSuccess.jsp").forward(request, response);
					 }else{
						 String st="查询失败";
				    	 request.setAttribute("info", st);
				    	 request.getRequestDispatcher("getBookSelect.jsp").forward(request, response);
					 }
					
				}else{
					String st="不能为数字以外的类型";
			    	 request.setAttribute("info", st);
			    	 request.getRequestDispatcher("getBookSelect.jsp").forward(request, response);
				}
			};
	}

}
