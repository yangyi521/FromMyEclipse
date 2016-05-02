package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.adminBean;
import DaoImpl.adminDaoImpl;

public class adminDal extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public adminDal() {
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
		adminDaoImpl adi=new adminDaoImpl();
		boolean flag=false;
		if(me.equals("add")){
			adminBean ab=new  adminBean();
			
			if(ab.isNumeric(request.getParameter("power"))){
				
				 ab.setUserName(request.getParameter("userName"));
				 ab.setPassWrod(request.getParameter("passWrod"));
				 ab.setPower(Integer.parseInt(request.getParameter("power")));
				 flag=adi.insert(ab);
				 if(flag){
					 String st="添加成功";
			    	 request.setAttribute("info", st);
			    	 request.getRequestDispatcher("admin_list.jsp").forward(request, response);
				 }else{
					 String st="添加失败";
			    	 request.setAttribute("info", st);
			    	 request.getRequestDispatcher("adminAdd.jsp").forward(request, response);
				 }
			}else{
				 String st="权限不能为数字以外的类型";
		    	 request.setAttribute("info", st);
		    	 request.getRequestDispatcher("adminAdd.jsp").forward(request, response);
			}
			 
			
			 
		};
		if(me.equals("update")){
			adminBean ab=new  adminBean();
			String oname;
			oname=request.getParameter("ouserName");
			 ab.setUserName(request.getParameter("userName"));
			 ab.setPassWrod(request.getParameter("passWrod"));
			 ab.setPower(Integer.parseInt(request.getParameter("power")));
			 flag=adi.update(ab, oname);
			 if(flag){
				 String st="添加成功";
		    	 request.setAttribute("info", st);
		    	 request.getRequestDispatcher("admin_list.jsp").forward(request, response);
			 }else{
				 String st="修改失败";
		    	 request.setAttribute("info", st);
		    	 request.getRequestDispatcher("adminUpdate.jsp").forward(request, response);
			 }
		};
		if(me.equals("remove")){
			adminBean ab=new  adminBean();
			String oname;
			oname=request.getParameter("userName");
			if(adi.select(oname)!=null){
				flag=adi.remove(oname);
				 if(flag){
					 String st="删除成功";
			    	 request.setAttribute("info", st);
			    	 request.getRequestDispatcher("admin_list.jsp").forward(request, response);
				 }else{
					 String st="删除失败";
			    	 request.setAttribute("info", st);
			    	 request.getRequestDispatcher("adminRemove.jsp").forward(request, response);
				 }
			}else{
				 String st="无此用户";
		    	 request.setAttribute("info", st);
		    	 request.getRequestDispatcher("adminRemove.jsp").forward(request, response);
			 }
			
			 
		};
		if(me.equals("select")){
			adminBean ab=new  adminBean();
			String oname;
			oname=request.getParameter("userName");
			 ab=adi.select(oname);
			 if(ab!=null){
				 String st="查询成功";
		    	 request.setAttribute("info",ab);
		    	 request.getRequestDispatcher("adminSelectSuccseful.jsp").forward(request, response);
			 }else{
				 String st="查询失败";
		    	 request.setAttribute("info", st);
		    	 request.getRequestDispatcher("adminSelect.jsp").forward(request, response);
			 }
		};
	}

}
