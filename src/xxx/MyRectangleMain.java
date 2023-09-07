package xxx;

public class MyRectangleMain {
	public static void main (String [] args) {
		MyRectangle a1 = new MyRectangle();
		MyRectangle a2 = new MyRectangle(10,20);
		a1.setWidth(10);
		a1.setDepth(20);
		System.out.println("我是沒有參數:"+a1.getArea());
		System.out.println("我是有參數:"+a2.getArea());
		
		
	}
}
