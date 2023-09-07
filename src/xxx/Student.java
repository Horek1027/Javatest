package xxx;

public class Student {
	int score = 60;
	public void play(int hours) {
		score -= hours;
		System.out.println("你現在的分數(起始為60):" + score);
	}
	public void study(int hours) {
		score += hours;
		System.out.println("你現在的分數(起始為60):" + score);
	}
	public static void main (String [] args) {
		Student my = new Student();
		my.play(7);
		my.study(15);
	}
}
