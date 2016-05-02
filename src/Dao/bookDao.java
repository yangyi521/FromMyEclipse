package Dao;
import java.util.List;

import Bean.adminBean;
import Bean.bookBean;

public  abstract class bookDao {
	
		public abstract  boolean insert(bookBean book);
		public abstract  boolean remove(int ISBN);
		public abstract  boolean update(bookBean book,int ISBN);
		public abstract  bookBean select(int ISBN);
		public abstract  List<bookBean> getAll();
	}

