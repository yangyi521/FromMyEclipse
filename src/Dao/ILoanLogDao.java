package Dao;
//鍊熶功绾綍鎺ュ彛
import java.util.List;

import Bean.Borrowbooks;

public abstract class  ILoanLogDao {
	
	
	 public abstract int insert(Borrowbooks a);//鎻掑叆
	 public abstract boolean remove(int GetId);     //鍒犻櫎
	 public abstract boolean update(Borrowbooks a,int GetId);    //鏇存柊
	 public abstract Borrowbooks select(int GetId);     //閫夋嫨
	 public abstract List getAll();      //鑾峰彇鎵�湁淇℃伅
	
}
	