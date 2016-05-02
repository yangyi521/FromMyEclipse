package Dao;

import java.util.List;

import Bean.adminBean;

public abstract class adminDao {
	public abstract  boolean insert(adminBean a);
	public abstract  boolean remove(String adminName);
	public abstract  boolean update(adminBean a,String adminName);
	public abstract  adminBean select(String adminName);
	public abstract  List<adminBean> getAll();
}
