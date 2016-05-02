package Dao;

import java.util.List;


import Bean.MumberBean;
//定义抽象方法
//开发者：开发3班4组   刘婷婷
public abstract class MemberMessage {
	//public abstract  boolean insert(adminBean a);
	//public abstract  boolean remove(String adminName);
	//public abstract  boolean update(adminBean a,String adminName);
	//public abstract  adminBean select(String adminName);
	//public abstract  List<adminBean> getAll();
	//显示所有会员信息
	public  abstract  List<MumberBean> showall() ;
	//添加会员信息
	public  abstract  boolean memberaddmsg(MumberBean a) ;
	//修改会员信息
	public  abstract boolean membermodifymsg(MumberBean a);
	//查询会员信息
	public abstract MumberBean memberquerymsg(int id);
	//删除会员信息
	public abstract boolean memberdelmsg(int  adminid);
}
