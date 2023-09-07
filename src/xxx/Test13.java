package xxx;

public class Test13 {
	public static void getRandomArray(int[][] x) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				int r1 = (int) (Math.random() * 31);
				x[i][j] = r1;
				System.out.print(x[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("===================");
	}
	public int[][] getRandomArray2(){
		int[][] data = new int[3][3];
		for(int i=0; i<data.length;i++) {
			for(int j=0; j<data[i].length;j++) {
				int r1 = (int) (Math.random() * 31);
				data[i][j] = r1;
			}
		}
		return data;
	}

	public static void main(String[] args) {
		Test13 tra =new Test13();
//		int x[][]=tra.getRandomArray2();
		int x[][] = new int[3][3];
		int y[][] = new int[3][3];
		int z[][] = new int[3][3];
		getRandomArray(x);
		getRandomArray(y);
		for (int i = 0; i < z.length; i++) {
			for (int j = 0; j < z[i].length; j++) {
				z[i][j] = x[i][j] + y[i][j];
				System.out.print(z[i][j] + " ");
			}
			System.out.println("");
		}

	}
}
