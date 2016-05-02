package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.adminBean;
import Bean.bookBean;
import DaoImpl.bookDaoImpl;


public class bookDal extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String me=request.getParameter("method");
		bookDaoImpl bdi=new bookDaoImpl();
		boolean flag=false;
		if(me.equals("insert")){
			bookBean ab=new  bookBean();
			if(ab.isNumeric(request.getParameter("ISBN"))&&ab.isNumeric(request.getParameter("sum"))){
				
				 ab.setBookName(request.getParameter("bookName"));
				 ab.setAuthor(request.getParameter("author"));
				 ab.setDate(request.getParameter("date"));
				 ab.setCatalog(request.getParameter("catalog"));
				 ab.setISBN(Integer.parseInt(request.getParameter("ISBN")));
				 ab.setSum(Integer.parseInt(request.getParameter("sum")));
				 flag=bdi.insert(ab);
				 if(flag){
					 String st="添加成功";
			    	 request.setAttribute("info", st);
			    	 request.getRequestDispatcher("book_list.jsp").forward(request, response);
				 }else{
					 String st="添加失败";
			    	 request.setAttribute("info", st);
			    	 request.getRequestDispatcher("bookinsert.jsp").forward(request, response);
				 }
			}else{
				 String st="ISBN和书总数不能为数字以外的类型";
		    	 request.setAttribute("info", st);
		    	 request.getRequestDispatcher("bookinsert.jsp").forward(request, response);
			}
			 
			
			 
		};
		if(me.equals("update")){
			bookBean ab=new  bookBean();
			int oldISBN;
			oldISBN=Integer.parseInt(request.getParameter("oISBN"));
			ab.setISBN(Integer.parseInt(request.getParameter("ISBN")));
			ab.setBookName(request.getParameter("bookName"));
			 ab.setAuthor(request.getParameter("author"));
			 ab.setDate(request.getParameter("date"));
			 ab.setCatalog(request.getParameter("catalog"));
			 ab.setSum(Integer.parseInt(request.getParameter("sum")));
			 flag=bdi.update(ab, oldISBN);
			 if(flag){
				 String st="添加成功";
		    	 request.setAttribute("info", st);
		    	 request.getRequestDispatcher("book_list.jsp").forward(request, response);
			 }else{
				 String st="修改失败";
		    	 request.setAttribute("info", st);
		    	 request.getRequestDispatcher("bookupdate.jsp").forward(request, response);
			 }
		};
		if(me.equals("remove")){
			bookBean ab=new bookBean();
			int oname;
			oname=Integer.parseInt(request.getParameter("ISBN"));
			ab.setISBN(Integer.parseInt(request.getParameter("ISBN")));
			 flag=bdi.remove(oname);
			 if(flag){
				 String st="删除成功";
		    	 request.setAttribute("info", st);
		    	 request.getRequestDispatcher("book_list.jsp").forward(request, response);
			 }else{
				 String st="删除失败";
		    	 request.setAttribute("info", st);
		    	 request.getRequestDispatcher("bookremove.jsp").forward(request, response);
			 }
		};
		if(me.equals("select")){
			bookBean ab=new  bookBean();
			int oname;
			oname=Integer.parseInt(request.getParameter("ISBN"));
			 ab=bdi.select(oname);
			 
			 if(ab!=null){
				 ab.setISBN(oname);
				 String st="查询成功";
		    	 request.setAttribute("info",ab);
		    	 request.getRequestDispatcher("bookSelectSuccseful.jsp").forward(request, response);
			 }else{
				 String st="删除失败";
		    	 request.setAttribute("info", st);
		    	 request.getRequestDispatcher("bookselect.jsp").forward(request, response);
			 }
		};
	}

}
