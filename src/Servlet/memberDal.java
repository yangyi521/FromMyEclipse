package Servlet;
//
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.MumberBean;

import DaoImpl.MemberOperation;

public class memberDal extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public memberDal() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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
//1.���ñ�����
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
//2.
        String mymsg=request.getParameter("method");
//3.ʵ��������MemberOperation����ʵ���ھ������ɾ�Ĳ鹦��
        MemberOperation msg=new MemberOperation();
//4.����boolean�ͱ������������շ���ִ�н��
        boolean flag=false;
//5.����java���򣬽��ձ���Ϣ�����д���
        //�����ӻ�Ա��Ϣ���д���
        if(mymsg.equals("add")){
            //(1)����ʵ��
            MumberBean  addmsg=new MumberBean();
            //(2)��ȡ�����Ϣ
            if(addmsg.isNumeric(request.getParameter("getbook"))){
            	//addmsg.setMemberid(Integer.parseInt(request.getParameter("memberid")));//��ȡ�ı�����Ϣ��ת��������
                addmsg.setMembername(request.getParameter("membername"));
                addmsg.setMemberemail(request.getParameter("memberemil"));
                addmsg.setTelephone(request.getParameter("telephone"));
                addmsg.setGetbook(Integer.parseInt(request.getParameter("getbook")));
                //(3)���þ����ʵ�ַ�����������ֵ��flag
                flag=msg.memberaddmsg(addmsg);
                //(4)�ж����ӻ�Ա��Ϣ�Ƿ�ɹ�
                if(flag){
                     String str="��ӳɹ�";
                     request.setAttribute("info", str);//��Ϣ��ӳɹ��ڵ�ǰҳ����ʾ����ӳɹ���
                     //��Ϣ���ӳɹ�����ת��admin.jspҳ�棬��ʾ���л�Ա��Ϣ
                      request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
                      } 
                else{
                      String str="���ʧ��";
                      request.setAttribute("info", str);
                      request.getRequestDispatcher("memberaddmsg.jsp").forward(request, response);
                         }
            }
            else{
            	 String str="ͼ�������������������";
                 request.setAttribute("info", str);
                 request.getRequestDispatcher("memberaddmsg.jsp").forward(request, response);
            }
            };
      //ɾ����Ա��Ϣ
            //1.�жϴ����¼�
            if(mymsg.equals("del")){
            //2.����ʵ�����
            	//MumberBean  delmsg=new MumberBean();
            	
            //3.��ȡ�����Ϣ
            	int delid;
            	delid=Integer.parseInt(request.getParameter("memberid"));
            //4.���þ����ʵ�ַ�������������������flag
            	flag=msg.memberdelmsg(delid);
            //5.�ж���Ϣɾ���Ƿ�ɹ�����������Ӧ�Ĵ���
            	 if(flag){
                     String str="��ӳɹ�";
                     request.setAttribute("info", str);//��Ϣ��ӳɹ��ڵ�ǰҳ����ʾ����ӳɹ���
                     //��Ϣ���ӳɹ�����ת��admin.jspҳ�棬��ʾ���л�Ա��Ϣ
                      request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
                      } 
                 else{
                 	String str="ɾ��ʧ��";
                 	request.setAttribute("info", str);
                 	request.getRequestDispatcher("memberquerymsg.jsp").forward(request, response);
                 }
            };
      //�޸Ļ�Ա��Ϣ
            //1.�жϴ����¼�
            if(mymsg.equals("update")){
            //2.����ʵ�����
            	MumberBean mfymsg=new MumberBean();
            	
            	if(mfymsg.isNumeric(request.getParameter("getbook"))){
            		int mfyid=(Integer.parseInt(request.getParameter("omemberid")));
            		mfymsg.setMemberid(mfyid);//��ȡ�ı�����Ϣ��ת��������
            		mfymsg.setMembername(request.getParameter("membername"));
            		mfymsg.setMemberemail(request.getParameter("memberEmail"));
            		mfymsg.setTelephone(request.getParameter("telephone"));
            		mfymsg.setGetbook(Integer.parseInt(request.getParameter("getbook")));
                    //(3)���þ����ʵ�ַ�����������ֵ��flag
                    flag=msg.membermodifymsg(mfymsg);
                    //(4)�ж����ӻ�Ա��Ϣ�Ƿ�ɹ�
                    if(flag){
                         String str="�޸ĳɹ�";
                         request.setAttribute("info", str);//��Ϣ��ӳɹ��ڵ�ǰҳ����ʾ����ӳɹ���
                         //��Ϣ���ӳɹ�����ת��admin.jspҳ�棬��ʾ���л�Ա��Ϣ
                          request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
                          } 
                    else{
                          String str="�޸�ʧ��";
                          request.setAttribute("info", str);
                          request.getRequestDispatcher("membermodifymsg.jsp").forward(request, response);
                             }
                }
                else{
                	 String str="ͼ�������������������";
                     request.setAttribute("info", str);
                     request.getRequestDispatcher("membermodifymsg.jsp").forward(request, response);
                }
            };
     //��ѯ��Ա��Ϣ
            //1.�жϴ����¼�
            if(mymsg.equals("select")){
            //2.����ʵ�����
            MumberBean  selmsg=new MumberBean();
            //3.��ȡ�����Ϣ
            int memberid=(Integer.parseInt(request.getParameter("memberid")));
            //4.���þ����ʵ�ַ�������������������flag
            selmsg=msg.memberquerymsg(memberid);
           
            //5.�ж���Ϣɾ���Ƿ�ɹ�����������Ӧ�Ĵ���      
            if(selmsg!=null){
            	String str="��ѯ�ɹ�";
            	request.setAttribute("info", selmsg);
            	request.getRequestDispatcher("quermsgsuccessful.jsp").forward(request, response);
            }
            else{
            	String str="��ѯʧ��";
            	request.setAttribute("info", str);
            	request.getRequestDispatcher("memberquerymsg.jsp").forward(request, response);
            }
            };
   }

/**
* Initialization of the servlet. <br>
*
* @throws ServletException if an error occurs
*/
    public void init() throws ServletException {
        // Put your code here
        }

}