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
//1.设置编译码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
//2.
        String mymsg=request.getParameter("method");
//3.实例化对象MemberOperation类中实现在具体的增删改查功能
        MemberOperation msg=new MemberOperation();
//4.设置boolean型变量，用来接收方法执行结果
        boolean flag=false;
//5.调用java程序，接收表单信息，进行处理
        //对增加会员信息进行处理
        if(mymsg.equals("add")){
            //(1)创建实体
            MumberBean  addmsg=new MumberBean();
            //(2)获取组件信息
            if(addmsg.isNumeric(request.getParameter("getbook"))){
            	//addmsg.setMemberid(Integer.parseInt(request.getParameter("memberid")));//获取文本框信息并转换成整形
                addmsg.setMembername(request.getParameter("membername"));
                addmsg.setMemberemail(request.getParameter("memberemil"));
                addmsg.setTelephone(request.getParameter("telephone"));
                addmsg.setGetbook(Integer.parseInt(request.getParameter("getbook")));
                //(3)调用具体的实现方法，将返回值给flag
                flag=msg.memberaddmsg(addmsg);
                //(4)判断增加会员信息是否成功
                if(flag){
                     String str="添加成功";
                     request.setAttribute("info", str);//信息添加成功在当前页面显示“添加成功”
                     //信息增加成功，跳转到admin.jsp页面，显示所有会员信息
                      request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
                      } 
                else{
                      String str="添加失败";
                      request.setAttribute("info", str);
                      request.getRequestDispatcher("memberaddmsg.jsp").forward(request, response);
                         }
            }
            else{
            	 String str="图书借阅数量必须是数字";
                 request.setAttribute("info", str);
                 request.getRequestDispatcher("memberaddmsg.jsp").forward(request, response);
            }
            };
      //删除会员信息
            //1.判断处理事件
            if(mymsg.equals("del")){
            //2.创建实体对象
            	//MumberBean  delmsg=new MumberBean();
            	
            //3.获取组件信息
            	int delid;
            	delid=Integer.parseInt(request.getParameter("memberid"));
            //4.调用就提的实现方法并将处理结果给变量flag
            	flag=msg.memberdelmsg(delid);
            //5.判断信息删除是否成功，并作出相应的处理
            	 if(flag){
                     String str="添加成功";
                     request.setAttribute("info", str);//信息添加成功在当前页面显示“添加成功”
                     //信息增加成功，跳转到admin.jsp页面，显示所有会员信息
                      request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
                      } 
                 else{
                 	String str="删除失败";
                 	request.setAttribute("info", str);
                 	request.getRequestDispatcher("memberquerymsg.jsp").forward(request, response);
                 }
            };
      //修改会员信息
            //1.判断处理事件
            if(mymsg.equals("update")){
            //2.创建实体对象
            	MumberBean mfymsg=new MumberBean();
            	
            	if(mfymsg.isNumeric(request.getParameter("getbook"))){
            		int mfyid=(Integer.parseInt(request.getParameter("omemberid")));
            		mfymsg.setMemberid(mfyid);//获取文本框信息并转换成整形
            		mfymsg.setMembername(request.getParameter("membername"));
            		mfymsg.setMemberemail(request.getParameter("memberEmail"));
            		mfymsg.setTelephone(request.getParameter("telephone"));
            		mfymsg.setGetbook(Integer.parseInt(request.getParameter("getbook")));
                    //(3)调用具体的实现方法，将返回值给flag
                    flag=msg.membermodifymsg(mfymsg);
                    //(4)判断增加会员信息是否成功
                    if(flag){
                         String str="修改成功";
                         request.setAttribute("info", str);//信息添加成功在当前页面显示“添加成功”
                         //信息增加成功，跳转到admin.jsp页面，显示所有会员信息
                          request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
                          } 
                    else{
                          String str="修改失败";
                          request.setAttribute("info", str);
                          request.getRequestDispatcher("membermodifymsg.jsp").forward(request, response);
                             }
                }
                else{
                	 String str="图书借阅数量必须是数字";
                     request.setAttribute("info", str);
                     request.getRequestDispatcher("membermodifymsg.jsp").forward(request, response);
                }
            };
     //查询会员信息
            //1.判断处理事件
            if(mymsg.equals("select")){
            //2.创建实体对象
            MumberBean  selmsg=new MumberBean();
            //3.获取组件信息
            int memberid=(Integer.parseInt(request.getParameter("memberid")));
            //4.调用就提的实现方法并将处理结果给变量flag
            selmsg=msg.memberquerymsg(memberid);
           
            //5.判断信息删除是否成功，并作出相应的处理      
            if(selmsg!=null){
            	String str="查询成功";
            	request.setAttribute("info", selmsg);
            	request.getRequestDispatcher("quermsgsuccessful.jsp").forward(request, response);
            }
            else{
            	String str="查询失败";
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