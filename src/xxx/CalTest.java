package xxx;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalTest {
//	請設計三個類別Calculator.java，CalException.java與CalTest.java，在Calculator.java裡有個自訂
//	方法為powerXY(int x, int y)，功能是會計算x的y次方並回傳結果。 CalTest.java執行後，使用者可
//	以輸入x與y的值，請加入例外處理機制，讓程式能解決以下狀況：
//	1. x與y同時為0，(產生自訂的CalException例外物件)
//	2. y為負值，而導致x的y次方結果不為整數
//	3. x與y皆正確情況下，會顯示運算後結果

	public static void main(String[] args) {
		
		while(true) {
			int x, y;
			Scanner sc = new Scanner(System.in);// 輸入的介面
			while (true) {
				System.out.println("請輸入x的值");
				try {
					x = sc.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("輸入格式不正確");
					sc.next();
				}
			}

			while (true) {
				System.out.println("請輸入y的值");
				try {
					y = sc.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("輸入格式不正確");
					sc.next();
				}
			}

			Calculator c1 = new Calculator();
			try {
				System.out.println(x + "的" + y + "次方等於" + c1.power(x, y)); 
				break;// 例外處理
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			} catch (CalException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		
	}
}
