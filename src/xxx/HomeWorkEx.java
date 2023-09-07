package xxx;

abstract class Pen {
	protected String brand;
	protected double price;
	// 抽象方法
	public abstract void write();
	
	public void setPrice(int price) {
		this.price=price;
	}
	public void getPrice() {
		System.out.println("定價為"+price);
	}
}

// 自訂的筆類別(子類別)
class Pencil extends Pen {
	public Pencil() {}
	public Pencil (String brandxx ,int pricexx) {
		this.brand=brandxx;
		this.price=pricexx;
	}
	// 定義抽象類別的動作
	public void write() {
		System.out.println("削鉛筆再寫");
	}
	public void getPrice() {
		System.out.println("鉛筆實際售價:"+(price*0.8));
	}
}
class InkBrush extends Pen {
	public InkBrush() {}
	public InkBrush (String brandxx ,int pricexx) {
		this.brand=brandxx;
		this.price=pricexx;
	}
	// 定義抽象類別的動作
	public void write() {
		System.out.println("沾墨汁再寫");
	}
	public void getPrice() {
		System.out.println("毛筆實際售價:"+(price*0.9));
	}
}
public class HomeWorkEx {
	public static void main (String [] args) {
		Pencil p1 =new Pencil("sony",100);
		p1.getPrice();
		p1.write();
		InkBrush i1 = new InkBrush("Toshiba",100);
		i1.getPrice();
		i1.write();
	}

}
