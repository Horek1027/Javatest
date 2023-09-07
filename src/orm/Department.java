package orm;

import java.io.Serializable;//用來同步的介面 (序列化)

public class Department implements Serializable  {//是java bean
	private Integer deptno;//使用Integer來避免空值的問題
	private String dname;
	private String loc;
	public Department() {//無參數建構子
		super();
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Department(Integer deptno, String dname, String loc) {//建構子
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Department [部門編號=" + deptno + ", 部門名稱=" + dname + ", 部門地點=" + loc + "]";
	}
	
	
	
}
