package Dao;

import java.util.List;

import Bean.ReBookBean;



public abstract class ReBookDao {
	public abstract int insert(ReBookBean a,int getId);
	public abstract  boolean remove(int reid);
	public abstract  boolean update(ReBookBean a,int reid);
	public abstract  ReBookBean select(int reid);
	public abstract  List<ReBookBean> getAll();
	
}
