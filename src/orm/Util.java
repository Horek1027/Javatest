package orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {//1.載入driver 2.建立連線 3.送出SQL指令，都會由連線池套件完成
	//打在java黨裡面其實很危險
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	//上述是採用Class Loader方式產生Driver實體，註冊到DriverManager的 驅動程式註冊表單中

	public static final String URL = "jdbc:mysql://localhost:3306/jdbcsample?serverTimezone=Asia/Taipei";
	//設定資料庫位置(URL)
	//?serverTimezone=Asia/Taipei，MYSQL8以後需要加上伺服器時區
	public static final String USER = "root";
	public static final String PASSWORD = "1234";
	
	public static void closeResources	(Connection con ,PreparedStatement pstmt, ResultSet rs) {
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
