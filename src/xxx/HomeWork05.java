package xxx;

import java.util.Scanner;

public class HomeWork05 {
	public void starSquare(int width ,int height) {
		String star ="";
		for(int i=0; i<height;i++) {
			for(int j=0; j<width;j++) {
				star+="*";
			}
			star+="\n";
		}
		System.out.println(star);
	}
	public void randAvg() {
		int num=0;
		String word="";
		for(int i=0; i<10;i++) {
			int ra =(int) (Math.random()*100);
			word+=ra+" ";
			num+=ra;
		}
		int avg = num /10;
		System.out.println(word);
		System.out.println(avg);	
	}
	public  int maxElement(int x[][]) {
		int big=0;
		for (int i=0;i <x.length;i++) {
			for(int j=0; j <x[i].length;j++) {
				if (big < x[i][j]) {
					big =x[i][j];
				}
			}
		}
		return big;
	}
	public  double maxElement(double x[][]) {
		double big=0;
		for (int i=0;i <x.length;i++) {
			for(int j=0; j <x[i].length;j++) {
				if (big < x[i][j]) {
					big =x[i][j];
				}
			}
		}
		return big;
	}

	public static void main (String []args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("請輸入寬與高:");
//		int width= sc.nextInt();
//		int height = sc.nextInt();
		HomeWork05 a1 = new HomeWork05();
//		a1.starSquare(width,height);
//		a1.randAvg();
		int[][]arr={{1,6,3},{9,5,2}};
		double[][] arr2={{10.56,26.55,73.55},{95.55,58.33,90.876}};
		System.out.println(a1.maxElement(arr2));
	}

}
