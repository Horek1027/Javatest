package xxx;
import javax.swing.JOptionPane;
public class TestBMI {
	public static void BMI () {
		String K = JOptionPane.showInputDialog("请输入體重(kg)：");
		String T = JOptionPane.showInputDialog("请输入身高(m)：");
		double weight = Double.parseDouble(K);
		double hight = Double.parseDouble(T);
		double bmi = weight /Math.pow(hight,2);
		System.out.println("你的體重"+weight);
		System.out.println("你的身高"+hight);
		System.out.printf("BMI= %.3f%n",bmi);

		if(bmi < 18.5) {
			System.out.println("體重過輕");
			}else if (bmi >=24) {
				System.out.println("體重過重");
			}else {
				System.out.println("體重標準");
			}
		}
	
	public static void main (String[] args){
		int K = 70;
		double T =1.7;
		double BMI =K/(T*T);
		System.out.printf("BMI= %.3f%n",BMI);
		if( BMI < 18.5) {
			System.out.println("體重過輕");
		}else if (BMI >= 24) {
			System.out.println("體重過重");
			
		}else {
			System.out.println("體重正常");
	
		}
		BMI();
	}
	
}
