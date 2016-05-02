package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ReBookBean;
import DaoImpl.ReBookDaoImpl;

public class ReturnBook extends HttpServlet {

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
/***	public void doGet(HttpServletRequest request, HttpServletResponse response)
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
***/
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
       //设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//用于接收传递的方法
		String stri = request.getParameter("method");
		//实例化对象，实现增删查找
		ReBookDaoImpl re = new ReBookDaoImpl();
		//设置布尔类型变量，用于接收方法执行的结果、
		boolean flag = false;
		//调用java程序，接收表单的信息，进行处理
		
		
		
		
		
		//实现增加的功能
		if(stri.equals("add")){    //add 是 form表单 action 的值
			//1 创建实体ReBookBean的对象
			ReBookBean reb = new ReBookBean();
			int flagi=0;
		//获取组建信息
			if(reb.isNumeric(request.getParameter("getid"))){
				int a=Integer.parseInt(request.getParameter("getid"));
				reb.setConditon(request.getParameter("condition"));
				//调用具体的方法将返回值给flag
				flagi = re.insert(reb,a);
				String re1 ="添加失败";
				//判断增加会员信息是否成功
				switch(flagi){
				case 1:
					re1="无此借书单";
					break;
				case 2:
					re1="会员信息修改失败";
					break;
				case 3:
					re1="图书信息修改失败";
					break;
				case 4:
					re1="修改借书单信息失败";
					break;
				case 5:
					re1="添加失败";
					break;
				case 6:
					re1="添加成功";
					break;
				case 7:
					re1="对不起，增加借书数量失败！";
					break;
				
					
				}
				if(flagi==6){
					request.getRequestDispatcher("ReturnBookList.jsp").forward(request, response);	
				}else{
					request.setAttribute("info", re1);
			    	 request.getRequestDispatcher("ReturnBookListAdd.jsp").forward(request, response);
				}
				}else{
					String str = "图书借阅量必须是数字";
					request.setAttribute("info", str);
					request.getRequestDispatcher("ReturnBookListAdd.jsp").forward(request,response);
					
					
				}
			}
			
			
			
		
		
		
		
		
		//删除借出处理
		//1判断处理事件
		if(stri.equals("delete")){
			ReBookBean dreb = new ReBookBean();
			int delreid= Integer.parseInt(request.getParameter("reid"));//获取文本框中的内容
			//reb.setReid(Integer.parseInt(request.getParameter("reid")));
		//调用实现的处理方法并将返回值结果赋给变量flag
			 flag = re.remove(delreid);
			//判断会员是否添加成功
			if(flag){
				String str = "删除成功";
				request.setAttribute("info",str);
				//显示添加成功的消息
				 request.getRequestDispatcher("ReturnBookList.jsp").forward(request, response);	
				}else{
					String str="删除失败";
                    request.setAttribute("info", str);
                    request.getRequestDispatcher("delete.jsp").forward(request, response);	
   }
		}
			
			
			
			
			
			
			
			
			
			//修改会员信息
			if(stri.equals("update")){
				//创建实体对象
				ReBookBean ureb = new ReBookBean();
				//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
				if(ureb.isNumeric(request.getParameter("reid"))){
				int oldreid = Integer.parseInt(request.getParameter("reid"));
				//System.out.println(request.getParameter("reid"));
				ureb.setReid(Integer.parseInt(request.getParameter("reid")));
				ureb.setISBN(Integer.parseInt(request.getParameter("isbn")));;
				ureb.setUserid(Integer.parseInt(request.getParameter("userid")));	
				ureb.setReturnDate(request.getParameter("returntime")); 
				ureb.setConditon( request.getParameter("condition"));
				//String condition = request.getParameter("condition");
				flag = re.update(ureb,oldreid);
				if(flag){
					String str="修改成功";
					request.setAttribute("info", str);
					
					request.getRequestDispatcher("ReturnBookList.jsp").forward(request, response);
                } 
				else {
					
					  String str="修改失败";
                      request.setAttribute("info", str);
                      request.getRequestDispatcher("update.jsp").forward(request, response);	
				}
			   
				}  else{
	             	 String str="图书借阅数量必须是数字";
	                  request.setAttribute("info", str);
	                  request.getRequestDispatcher("update.jsp").forward(request, response);
	             };
				
			
      }
		  
		
		
		
		
		
		
		
		
		
		//查询会员信息
		if(stri.equals("query")){
			ReBookBean qreb = new ReBookBean();	
			int urerid=(Integer.parseInt(request.getParameter("reid")));
			qreb = re.select(urerid);
			//判断信息是否删除成功，并做相应的处理
			if(qreb!=null){
				request.setAttribute("info", qreb);
            	request.getRequestDispatcher("ReturnBookListSuccessful.jsp").forward(request, response);	
				}
			else{
				String str="查询失败";
            	request.setAttribute("info", str);
            	request.getRequestDispatcher("query.jsp").forward(request, response);
				
				
			}
			
		}
		
}
					
			
}	
			
			
			
		
		



