package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO { //實作
	
	
	public static final String INSERT_STMT= "insert into department values (?, ?, ?)";
	public static final String FIND_BY_DEPTNO= "select * from department where deptno = ?";
	public static final String GET_ALL= "select * from department order by deptno";
	// 當此類別被JVM載入時, 驅動也就跟著載入到執行環境裡 (一次性)
	static {
		try {
			Class.forName(Util.DRIVER);
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public void save(Department department) {
		Connection con = null;//建立連線
		PreparedStatement pstmt = null;//用來送SQL指令
		
		try {
			con =DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);//下SQL指令
			pstmt.setInt(1, department.getDeptno());
			pstmt.setString(2,department.getDname());
			pstmt.setString(3,department.getLoc());
			
			pstmt.executeUpdate();
			System.out.println("成功");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			Util.closeResources(con, pstmt, null);
			//把關閉資源的code寫在Class Util裡的方法: closeResources
		}
	}

	@Override
	public void update(Department Department) {
		
	}

	@Override
	public void delete(Integer deptno) {
		
	}

	@Override
	public Department finByDeptno(Integer deptno) {
		Connection con = null;//建立連線
		PreparedStatement pstmt = null;//用來送SQL指令
		ResultSet rs =null;
		Department dept =null;
		//要先在外面宣告好，while才會把資料放入，回傳給return
		try {
			con =DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_DEPTNO);//下SQL指令
			pstmt.setInt(1,deptno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 用Dept Bean包裝查詢出來的部門資料做回傳
				dept =new Department();
//				String dname =rs.getString("dname");
//				String loc = rs.getString("loc");
				dept.setDeptno(deptno);
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			Util.closeResources(con, pstmt, rs);
			//把關閉資源的code寫在Class Util裡的方法: closeResources
		}
		return dept;
	}

	@Override
	public List<Department> getAll() {
		Connection con = null;//建立連線
		PreparedStatement pstmt = null;//用來送SQL指令
		ResultSet rs =null;
		List<Department> deptList = new ArrayList<>();
		//因為要送出多筆資料所以用ArrayList包裝
		try {
			con =DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);//下SQL指令
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 用Dept Bean包裝查詢出來的部門資料做回傳
				//在while裡面建立型別物件
				Department dept =new Department();
//				String dname =rs.getString("dname");
//				String loc = rs.getString("loc");
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				// 用集合收集著包裝好的查詢結果(部門物件)
				deptList.add(dept);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			Util.closeResources(con, pstmt, rs);
			//把關閉資源的code寫在Class Util裡的方法: closeResources
		}
		return deptList;
		
		
	}
	
	
}
