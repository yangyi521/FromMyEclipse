package Dao;

import java.util.List;


import Bean.MumberBean;
//������󷽷�
//�����ߣ�����3��4��   ������
public abstract class MemberMessage {
	//public abstract  boolean insert(adminBean a);
	//public abstract  boolean remove(String adminName);
	//public abstract  boolean update(adminBean a,String adminName);
	//public abstract  adminBean select(String adminName);
	//public abstract  List<adminBean> getAll();
	//��ʾ���л�Ա��Ϣ
	public  abstract  List<MumberBean> showall() ;
	//��ӻ�Ա��Ϣ
	public  abstract  boolean memberaddmsg(MumberBean a) ;
	//�޸Ļ�Ա��Ϣ
	public  abstract boolean membermodifymsg(MumberBean a);
	//��ѯ��Ա��Ϣ
	public abstract MumberBean memberquerymsg(int id);
	//ɾ����Ա��Ϣ
	public abstract boolean memberdelmsg(int  adminid);
}
