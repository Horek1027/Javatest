package orm;

import java.util.List;

public interface DepartmentDAO { //介面
	void save(Department Department); //Department class就包含了所有屬性
	void update(Department Department);
	void delete(Integer deptno);//使用where，利用編號當刪除條件
	
	
	Department  finByDeptno(Integer deptno);//回傳一筆部門資料
	List<Department> getAll();//list 可以自動排序(用於多筆資料查詢)
}
