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
						re="������ѯ�޴˻�Ա��";
						break;
					case 2:
						re="�ף�û���ҵ�����Ҫ���鼮��";
						break;
					case 3:
						re="�ף��Բ���û�п���ˣ�";
						break;
					case 4:
						re="������ѯ���û��ѽ��鳬��10����������ȫ��70%���û���";
						break;
					case 5:
						re="�Բ������ʧ�ܣ�";
						break;
					case 6:
						re="�Բ��𣬼����鼮ʧ�ܣ�";
						break;
					case 7:
						re="�Բ������ӽ�������ʧ�ܣ�";
						break;
					
						
					}
					if(flagi==8){
						re="��ϲ��������ɹ���";
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
						 String st="��ӳɹ�";
				    	 request.setAttribute("info", st);
				    	 request.getRequestDispatcher("get_book_list.jsp").forward(request, response);
					 }else{
						 String st="�޸�ʧ��";
				    	 request.setAttribute("info", st);
				    	 request.getRequestDispatcher("getBookUpdate.jsp").forward(request, response);
					 }
					
				}else{
					String st="ISBN������������Ϊ�������������";
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
						 String st="ɾ���ɹ�";
				    	 request.setAttribute("info", st);
				    	 request.getRequestDispatcher("get_book_list.jsp").forward(request, response);
					 }else{
						 String st="ɾ��ʧ��";
				    	 request.setAttribute("info", st);
				    	 request.getRequestDispatcher("getBookRemove.jsp").forward(request, response);
					 }
					
				}else{
					String st="����Ϊ�������������";
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
						 String st="ɾ���ɹ�";
				    	 request.setAttribute("info", bb1);
				    	 request.getRequestDispatcher("getBookSuccess.jsp").forward(request, response);
					 }else{
						 String st="��ѯʧ��";
				    	 request.setAttribute("info", st);
				    	 request.getRequestDispatcher("getBookSelect.jsp").forward(request, response);
					 }
					
				}else{
					String st="����Ϊ�������������";
			    	 request.setAttribute("info", st);
			    	 request.getRequestDispatcher("getBookSelect.jsp").forward(request, response);
				}
			};
	}

}
