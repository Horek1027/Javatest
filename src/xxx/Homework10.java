package xxx;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Homework10 {
	public static void work1() {

		Set<Integer> num = new HashSet<Integer>();
		while (num.size() < 5) {
			int ra = (int) (Math.random() * 100) + 1;
			num.add(ra);
		}
		for (Integer x : num) {
			boolean ans = true;
			if(x ==2 || x ==3) {
				ans=true;
			}else {
				int sqrt =(int) Math.floor(Math.sqrt(x));
				for(int i =2 ;i <= sqrt ;i++ ) {
					if(x % i == 0) {
						ans =false;
					}
				}
			}
			if(ans) {
				System.out.println(x + "是質數");
			}else {
				System.out.println(x + "不是質數");
			}
		}
	}
	public static void work2() {
		String reg = "^[0-9]{1,}$";
		String reg2 = "^[1-3]{1}$";
		System.out.println("請輸入數字:");
		//test.matches(reg)
		Scanner sc = new Scanner(System.in);
		String test = sc.next();

			while(true) {
				if(!test.matches(reg)) {
					System.out.println("格式輸入錯誤");
					System.out.println("請重新輸入");
					sc.next();
					}else {
						break;
					}
			}
			
			System.out.println("要格式化成(1)千分位(2)百分位(3)科學記號");
			String test2 = sc.next();
			while(true) {
				if(!test2.matches(reg2)) {
					System.out.println("只能輸入1~3，請重新輸入:");
				}else {
					break;
				}
			}
		
	
	}
	public static void work3() {
		Scanner sc = new Scanner(System.in);
		String reg = "^[0-9]{4}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}$";
		System.out.println("請輸入日期(年月日，例如:20110131)");

		String data = sc.next();
		while(true) {
			if(!data.matches(reg)) {
				System.out.println("格式輸入錯誤請重新輸入:");
				System.out.println("請輸入日期(年月日，例如:20110131)");
				data=sc.next();
			}else {
				break;
			}
		}
		
		System.out.println("請輸入要格式化成(1)年/月/日(2)月/日/年(3)日/月/年:");
		int data2 = sc.nextInt();
		while(true) {
			try {
				Date test = new SimpleDateFormat("yyyyMMdd").parse(data);
				DateFormat d;
				if(data2==1) {
					d = new SimpleDateFormat("yyyy/MM/dd");
					System.out.println(d.format(test));
					break;
				}else if(data2==2) {
					d = new SimpleDateFormat("MM/dd/yyyy");
					System.out.println(d.format(test));
					break;
				}else if(data2 ==3) {
					d = new SimpleDateFormat("dd/MM/yyyy");
					System.out.println(d.format(test));
					break;
				}else {
					System.out.println("格式錯誤請重新輸入");
					System.out.println("請輸入要格式化成(1)年/月/日(2)月/日/年(3)日/月/年:");
					data2 =sc.nextInt();
				}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}

	public static void main(String[] args) {
//		String data = "19911027";
//		DateFormat d;
//		try {
//			Date date = new SimpleDateFormat("yyyyMMdd").parse(data);
//			d = new SimpleDateFormat("yyyy/MM/dd");
//			System.out.println(d.format(date));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		work3();
	}

}
