package xxx;
import java.util.Scanner;
public class Reg {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		String tel = sc.next();
		
		String regex = "^09\\d\\d-[0-9]{6}$"; //驗證手機號碼
		String regex2 = "^[A-Z]{1}[1-2]{1}[0-9]{8}$";//身分證驗證
		String regex3 = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		//信箱驗證(簡單版)

		if(tel.matches(regex3)) {
			System.out.print("OK");
		} else {
			System.out.print("NO");
		}
	}
}
