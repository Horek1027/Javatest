package orm;

import java.util.List;
import java.util.Scanner;

public class DeptTest {
	
	public static void main (String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("要查的編號");
//		int deptno = sc.nextInt();
//		System.out.println("要新增的名稱");
//		String dname = sc.next();
//		System.out.println("要新增的所在地");
//		String loc = sc.next();
		
//		sc.close();
		
		// 用Dept Bean包裝要新增的資料
//		Department department = new Department  (deptno, dname,loc);
		
		DepartmentDAO dao =new DepartmentDAOImpl();
//		//用介面當作資料型別，來降低相依性
////		dao.save(department)
//		Department dept =dao.finByDeptno(deptno);
//		System.out.println(dept);
		
		List<Department> deptlist =dao.getAll();
		for(Department x :deptlist) {
			System.out.println(x);
		}
	}

}
