package xxx;

import java.util.Scanner;

public class HomeWork3 {
	public int getNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入數字");
		int data = sc.nextInt();
		return data;
	}

	public void getAns(int x, int y, int z) {
		if (x + y + z <= 3) {
			System.out.println(x + " " + y + " " + z);
			System.out.println("不是三角形");
		} else if (x == y && y == z) {
			System.out.println(x + " " + y + " " + z);
			System.out.println("正三角形");
		} else if (x == y || y == z || x == z) {
			System.out.println(x + " " + y + " " + z);
			System.out.println("等腰三角形");
		} else {
			System.out.println(x + " " + y + " " + z);
			System.out.println("其他三角形");
		}
	}

	public void guess() {
		Scanner sc = new Scanner(System.in);
		int ans = (int) (Math.random() * 9);
		System.out.println("0~9猜個數字:");
		int guess = sc.nextInt();
		while (ans != guess) {
			System.out.println("你猜錯了");
			System.out.println("0~9猜個數字:");
			guess = sc.nextInt();
		}
		System.out.println("恭喜猜對了");
	}

	public void lottery() {
		Scanner sc = new Scanner(System.in);
		System.out.println("阿文，你討厭哪一個數字:");
		int hate = sc.nextInt();
		int sum = 0;
		for (int i = 1; i < 50; i++) {
			if (i / 10 != hate && i % 10 != hate) {
				sum++;
				System.out.print(i + " ");

			}
		}
		System.out.println("總共有" + sum + " 個數字可以選喔!!");
		int[] arr = new int[sum];
		int count = 0;
		for (int i = 1; i < 50; i++) {
			if (i / 10 != hate && i % 10 != hate) {
				arr[count] = i;
			}
		}
		int[] target = new int[6];
		for (int i = 0; i < 6; i++) {
			int r1 = (int) (Math.random() * sum) + 1;
			target[i]=r1;
//			for (int j = 1; j <= i; j++) {
//				if (target[i] == target[j]) {
//					i--;
//				}
//			}
		}
		for(int i =0; i < target.length;i++) {
			System.out.print(target[i]+" ");
		}
	}

	public static void main(String[] args) {
		HomeWork3 tri = new HomeWork3();
//		int x = tri.getNum();
//		int y = tri.getNum();
//		int z = tri.getNum();
//		tri.getAns(x, y, z);
//		tri.guess(); 
		tri.lottery();
	}
}