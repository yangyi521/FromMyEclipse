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
       //���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//���ڽ��մ��ݵķ���
		String stri = request.getParameter("method");
		//ʵ��������ʵ����ɾ����
		ReBookDaoImpl re = new ReBookDaoImpl();
		//���ò������ͱ��������ڽ��շ���ִ�еĽ����
		boolean flag = false;
		//����java���򣬽��ձ�����Ϣ�����д���
		
		
		
		
		
		//ʵ�����ӵĹ���
		if(stri.equals("add")){    //add �� form�� action ��ֵ
			//1 ����ʵ��ReBookBean�Ķ���
			ReBookBean reb = new ReBookBean();
			int flagi=0;
		//��ȡ�齨��Ϣ
			if(reb.isNumeric(request.getParameter("getid"))){
				int a=Integer.parseInt(request.getParameter("getid"));
				reb.setConditon(request.getParameter("condition"));
				//���þ���ķ���������ֵ��flag
				flagi = re.insert(reb,a);
				String re1 ="���ʧ��";
				//�ж����ӻ�Ա��Ϣ�Ƿ�ɹ�
				switch(flagi){
				case 1:
					re1="�޴˽��鵥";
					break;
				case 2:
					re1="��Ա��Ϣ�޸�ʧ��";
					break;
				case 3:
					re1="ͼ����Ϣ�޸�ʧ��";
					break;
				case 4:
					re1="�޸Ľ��鵥��Ϣʧ��";
					break;
				case 5:
					re1="���ʧ��";
					break;
				case 6:
					re1="��ӳɹ�";
					break;
				case 7:
					re1="�Բ������ӽ�������ʧ�ܣ�";
					break;
				
					
				}
				if(flagi==6){
					request.getRequestDispatcher("ReturnBookList.jsp").forward(request, response);	
				}else{
					request.setAttribute("info", re1);
			    	 request.getRequestDispatcher("ReturnBookListAdd.jsp").forward(request, response);
				}
				}else{
					String str = "ͼ�����������������";
					request.setAttribute("info", str);
					request.getRequestDispatcher("ReturnBookListAdd.jsp").forward(request,response);
					
					
				}
			}
			
			
			
		
		
		
		
		
		//ɾ���������
		//1�жϴ����¼�
		if(stri.equals("delete")){
			ReBookBean dreb = new ReBookBean();
			int delreid= Integer.parseInt(request.getParameter("reid"));//��ȡ�ı����е�����
			//reb.setReid(Integer.parseInt(request.getParameter("reid")));
		//����ʵ�ֵĴ�������������ֵ�����������flag
			 flag = re.remove(delreid);
			//�жϻ�Ա�Ƿ���ӳɹ�
			if(flag){
				String str = "ɾ���ɹ�";
				request.setAttribute("info",str);
				//��ʾ��ӳɹ�����Ϣ
				 request.getRequestDispatcher("ReturnBookList.jsp").forward(request, response);	
				}else{
					String str="ɾ��ʧ��";
                    request.setAttribute("info", str);
                    request.getRequestDispatcher("delete.jsp").forward(request, response);	
   }
		}
			
			
			
			
			
			
			
			
			
			//�޸Ļ�Ա��Ϣ
			if(stri.equals("update")){
				//����ʵ�����
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
					String str="�޸ĳɹ�";
					request.setAttribute("info", str);
					
					request.getRequestDispatcher("ReturnBookList.jsp").forward(request, response);
                } 
				else {
					
					  String str="�޸�ʧ��";
                      request.setAttribute("info", str);
                      request.getRequestDispatcher("update.jsp").forward(request, response);	
				}
			   
				}  else{
	             	 String str="ͼ�������������������";
	                  request.setAttribute("info", str);
	                  request.getRequestDispatcher("update.jsp").forward(request, response);
	             };
				
			
      }
		  
		
		
		
		
		
		
		
		
		
		//��ѯ��Ա��Ϣ
		if(stri.equals("query")){
			ReBookBean qreb = new ReBookBean();	
			int urerid=(Integer.parseInt(request.getParameter("reid")));
			qreb = re.select(urerid);
			//�ж���Ϣ�Ƿ�ɾ���ɹ���������Ӧ�Ĵ���
			if(qreb!=null){
				request.setAttribute("info", qreb);
            	request.getRequestDispatcher("ReturnBookListSuccessful.jsp").forward(request, response);	
				}
			else{
				String str="��ѯʧ��";
            	request.setAttribute("info", str);
            	request.getRequestDispatcher("query.jsp").forward(request, response);
				
				
			}
			
		}
		
}
					
			
}	
			
			
			
		
		



