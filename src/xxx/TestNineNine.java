package xxx;

public class TestNineNine {
	public static void print99fw() { 
		//int j =1 ;如果把j打在這裡，那while執行完後會變10，
		//後面i=2時，J一樣是10，就不會打印出資料
		for(int i = 1; i <10 ;i++) {
			int j = 1;
			while (j <10) {
				System.out.print(i +"*"+j+"="+ i*j+"\t");
				j++;
			}
			System.out.println();
		}
	}
	public static void print99fd() {
		for(int i =1;i<10;i++) {
			int j =1;
			do {
				System.out.print(i +"*"+j+"="+ i*j+"\t");
				j++;
				}while(j<10);
			System.out.println();
			}
	}
	public static void print99wd(){
		int i = 1;
		while (i < 10) {
			int j = 1;
			do {
				System.out.print(i +"*"+j+"="+ i*j+"\t");
				j++;
				}while(j<10);
			i++;
			System.out.println();
			}
		}
	
	public static void main (String [] args) {
		print99fw();
		System.out.println("=====================================");
		print99wd();
		System.out.println("=====================================");
		print99fd();
		}

	
}


