package xxx;

public class HelloWorld {
	private String name;
	private int age;
	public   HelloWorld (String name,int age) {
		this.name= name;
		this.age =age;
	}
	
	
	public static void main(String[] args) {
		HelloWorld te = new HelloWorld("horek",90);
		System.out.println(te.name);
		System.out.println(te.age);

		
	}


}
