package xxx;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class HomeWork04 {
    public void first(){
        int[]arr={29, 100, 39, 41, 50, 8, 66, 77, 95, 15};
        int sum =0;
        for(int i = 0; i < arr.length;i++){
            sum+=arr[i];
        }
        int avg =  sum / arr.length;
        System.out.println("此陣列的平均值:" + avg);
        System.out.print("陣列內大於平均值的元素:");
        for(int i = 0; i < arr.length;i++){
            if(arr[i] > avg){
                System.out.print(arr[i]+" ");
            }
        }
    }
    public void second(){
        String s = "Hello World" ,ans="";
        // char ch;
        // for(int i=0; i< s.length();i++){
        //     ch =s.charAt(i);
        //     ans =ch+ans;
        // }
        for (int i =s.length()-1 ; i>=0;i--){
            ans +=s.charAt(i);
        }
        System.out.println(ans);
        System.out.println(new StringBuffer("Hello World").reverse());
    }
    public void third(){
        String[] star ={"mercury","venus","earth","mars", "jupiter", "saturn", "uranus", "neptune"};
        String[] word={"a","e","i","o","u"};
        int[] ch = new int[star.length];
        int ans= 0 , count =0;
        for(int i = 0; i < star.length;i++){
             for(int j = 0; j < star[i].length();j++){
            	 switch(star[i].charAt(j)) {
            	 case 'a':
            	 case 'e':
            	 case 'i':
            	 case 'o':
            	 case 'u':
            		 ans++;
            		 break;
            	 }
             }
        }
        System.out.println(ans);
    }
    public void forth(){
        Scanner sc = new Scanner(System.in);
        int[][] person={ {25,2500},{32,800},{8,500},{19,1000},{27,1200}};
        System.out.println("你想借多少錢?");
        int money = sc.nextInt() , boss = 0;
        String no = "";
        for(int i = 0; i < person.length;i++){
            if(person[i][1] >= money){
                boss++;
                no += person[i][0]+" ";
            }
        }
        System.out.print("員工編號:"+no+"共"+boss+"人!可以借你"+money);
    }
    public void countDay(){
    	 
        int[] month1={31,28,31,30,31,30,31,31,30,31,30,31};
        int count =0;
        Scanner sc = new Scanner (System.in);
        System.out.print("請輸入年:");
        int year = sc.nextInt();
        System.out.print("請輸入月份:");
        int month = sc.nextInt();
        System.out.print("請輸入日期:");
        int day = sc.nextInt();
        GregorianCalendar cal4 =new GregorianCalendar(year,(month-1),day);
        Boolean isLeap = cal4.isLeapYear(year);
        if(isLeap) {
        	System.out.println(year+"是閏年");
        }else {
        	System.out.println(year+"不是閏年");
        }
        
        if (year % 4 != 0){
            if(day > month1[month-1]){
                System.out.println(month+"月沒有到第"+day+"天，停止運作，"+year+"不是閏年");
            }else{
                for(int i = 0;i <month -1;i++){
                    count += month1[month-1];
                }
                count += day;
                System.out.println(year+"年"+month+"月"+day+"日是該年的第"+count+"天，"+year+"年不是閏年");
            }
        }else{
            int[] month2={31,29,31,30,31,30,31,31,30,31,30,31};
            if(day > month2[month-1]){
                System.out.println(month+"月沒有到第"+day+"天，停止運作，"+year+"是閏年");
            }else{
                for(int i = 0;i <month -1;i++){
                    count += month2[month-1];
                }
                count += day;
                System.out.println(year+"年"+month+"月"+day+"日是該年的第"+count+"天，"+year+"年是閏年");
            }
        }
    }
    public void countGrade(){
        int[][] grade ={
            {10,35,40,100,90,85,75,70},
            {37,75,77,89,64,75,70,95},
            {100,70,79,90,75,70,79,90},
            {77,95,70,89,60,75,85,89},
            {98,70,89,90,75,90,89,90},
            {90,80,100,75,50,20,99,75}
        };
        int[] highestGrades =new int[grade.length];
        int[] count= new int[8];
        
        for (int i = 0; i < grade.length;i++){
            int highest =0;
            for (int j= 0; j <grade[i].length;j++){
                if(highest <= grade[i][j]){
                    highest = grade[i][j];   
                }
            }
            highestGrades[i]=highest;
            System.out.println("第"+(1+i)+"次考試最高分"+highest);
        }
        for(int i= 0 ; i <highestGrades.length;i++){
            for(int j = 0 ; j <count.length;j++){
                if(highestGrades[i]==grade[i][j]){
                    count[j]++;
                }
            }
        }
        for(int i=0; i< count.length;i++){
            System.out.println("第"+(1+i)+"號同學最高分的次數為:"+count[i]+"次");
        }
    }
    public static void main(String[] args) {
        HomeWork04 t1 = new HomeWork04();
        // t1.first();
//         t1.second();
//         t1.third();
        // t1.forth();
         t1.countDay();
//        t1.countGrade();
    }
    public void countGrade2() {
        int[][] grade = {
            {10, 35, 40, 100, 90, 85, 75, 70},
            {37, 75, 77, 89, 64, 75, 70, 95},
            {100, 70, 79, 90, 75, 70, 79, 90},
            {77, 95, 70, 89, 60, 75, 85, 89},
            {98, 70, 89, 90, 75, 90, 89, 90},
            {90, 80, 100, 75, 50, 20, 99, 75}
        };
        int[] count = new int[8];
        for (int i = 0; i < grade.length; i++) {
            int highest = Arrays.stream(grade[i]).max().orElse(0);
            //Arrays.stream是一個一維整數陣列轉換成一個 IntStream，在grade[i]中尋找最大值(.max())
            //如果找不到就回傳0>>.orElse(0);
            for (int j = 0; j < count.length; j++) {
                if (highest == grade[i][j]) {
                    count[j]++;
                }
            }
            System.out.println("第" + (i + 1) + "次考試最高分: " + highest);
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println((i + 1) + "號同學考最高分次數為: " + count[i]);
        }
    }
}
