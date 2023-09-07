package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class Hello {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	//上述是採用Class Loader方式產生Driver實體，註冊到DriverManager的 驅動程式註冊表單中

	public static final String URL = "jdbc:mysql://localhost:3306/jdbcsample?serverTimezone=Asia/Taipei";
	//設定資料庫位置(URL)
	//?serverTimezone=Asia/Taipei，MYSQL8以後需要加上伺服器時區
	public static final String USER = "root";
	public static final String PASSWORD = "1234";

	public static void main(String[] args) {
		Connection con = null;//把連線寫在try外面，可以讓try的任何區域都可以使用
		//參考變數的起始值都是null
		Statement stmt = null;//靜態傳送SQL指令的介面
		ResultSet rs = null;//用於select語法
		PreparedStatement pstmt=null; //使用動態SQL指令
		
		Scanner sc = new Scanner(System.in);
		System.out.println("要新增的編號");
		int deptno = sc.nextInt();
		System.out.println("要新增的名稱");
		String dname = sc.next();
		System.out.println("要新增的所在地");
		String loc = sc.next();
		
		sc.close();
		try {
			// 1.載入驅動
			Class.forName(DRIVER);
//			System.out.println("good");
			// 2.建立連線
			con = DriverManager.getConnection(URL, USER, PASSWORD);
//			System.out.println("Connecting");
			
			//3.送出Sql指令
			stmt =con.createStatement();//創造物件來回傳SQL指令
//			int count =stmt.executeUpdate("insert into department values(50,'人事室','南京復興')");
			//executeUpdate用於INSERT UPDATE DELETE，因為是回傳成功幾筆，所以設定int
//			rs =stmt.executeQuery("select * from department order by deptno ");
//			while(rs.next()) {//使用while遍歷每一筆資料(橫的)
//				int deptno = rs.getInt(1);// 1表示該資料直的第一欄，也可以("deptno")，來找資料
				//jdbc的索引值都是從1開始
				//要注意使用索引值時，查詢的欄位順序跟宣告的資料型態不同時就會報錯
//				String dname =rs.getString(2);//第二欄
//				String loc =rs.getString(3);//第二欄
//				
//				System.out.println("Deptno ="+deptno);
//				System.out.println("dname ="+dname);
//				System.out.println("loc ="+loc);
//				System.out.println("===============");
			
			pstmt = con.prepareStatement("insert into department values (?,?,?)");
			//上面是準備要新增的資料，?只針對SQL的值來表示
			pstmt.setInt(1, deptno);//(第一個問號,寫入的資料)
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
//	
			pstmt.executeUpdate();
//			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {//把關閉連線的code寫在finally，因為一定會執行，不關閉的話會一直占用資源
			if (rs != null) {//連線如果不是空值，寫入try，並且關閉
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}
}
