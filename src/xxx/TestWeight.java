package xxx;

public class TestWeight {
	public static void main (String [] args) {
		Tool[] objs = new Tool [3];
		objs[0] =new Dog();
		objs[1]=new Plane();
		objs[2]=new Powder();
		for(int i= 0 ;i<objs.length;i++) {
			objs[i].getWeightMethod();
		}
	}

}
