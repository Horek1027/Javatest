package xxx;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Homework08 {

    public static void work1_1() {
        List<Object> list = new ArrayList<>();
        list.add(100);
        list.add(3.14);
        list.add(21L);
        list.add(Short.valueOf((short) 100));
        list.add(5.1);
        list.add("Kitty");
        list.add(100);
        list.add(new Object());
        list.add("Snoppy");
        list.add(new BigInteger("1000"));
        
        System.out.println("=====以下使用迭代器(Iterator)=======");
        Iterator<Object> l1 = list.iterator();
        while (l1.hasNext()) {
            System.out.println(l1.next());
        }
        System.out.println("===以下使用for=================");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("==以下使用suger====================");
        for (Object x : list) {
            System.out.println(x);
        }
        
        Iterator<Object> l2 =list.iterator();
        while(l2.hasNext()) {
        	Object data = l2.next();
        	if(!(data instanceof Number)) {
        		l2.remove();
        	}
        }
        
        System.out.println("=====以下刪除非Number的結果=====================");
        for (Object x :list) {
        	System.out.println(x);
        }
        	



    }

    public static class Train implements Comparable<Train> {
        private int number;
        private String type;
        private String start;
        private String dest;
        private double price;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getDest() {
            return dest;
        }

        public void setDest(String dest) {
            this.dest = dest;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Train() {
        }

        public Train(int number, String type, String start, String dest, double price) {
            this.number = number;
            this.type = type;
            this.start = start;
            this.dest = dest;
            this.price = price;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + number;
            result = prime * result + ((type == null) ? 0 : type.hashCode());
            result = prime * result + ((start == null) ? 0 : start.hashCode());
            result = prime * result + ((dest == null) ? 0 : dest.hashCode());
            long temp;
            temp = Double.doubleToLongBits(price);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Train other = (Train) obj;
            if (number != other.number)
                return false;
            if (type == null) {
                if (other.type != null)
                    return false;
            } else if (!type.equals(other.type))
                return false;
            if (start == null) {
                if (other.start != null)
                    return false;
            } else if (!start.equals(other.start))
                return false;
            if (dest == null) {
                if (other.dest != null)
                    return false;
            } else if (!dest.equals(other.dest))
                return false;
            if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
                return false;
            return true;
        }

        @Override
        public int compareTo(Train arg0) {
            if(this.number >arg0.number){
                return -1;
            }else if (this.number < arg0.number){
                return 1;
            }else{
                return 0;
            }
        }

        @Override
        public String toString() {
            return "車號:" + number + ", 車種:" + type + ", 起點:" + start + ", 終點:" + dest + ", 票價:" + price;
        }
    }
    public static void setPrintTrain(Set<Train> arr){//不僅能讓班次編號由大排到小印出， 還可以不重複印出Train物件
        System.out.println("以下是sugar寫法=================");
        for(Train x : arr){
            System.out.println("車號:"+x.getNumber()+",車種:"+x.type+",起點:"+x.getStart()
            +",終點:"+x.getDest()+",票價:"+x.getPrice());
        }
        System.out.println("以下是Iterator寫法=================");
        Iterator<Train>  i1 =arr.iterator();
        while(i1.hasNext())
            System.out.println(i1.next());
            //Iterator是呼叫型別的toString()方法，因此自訂的型別要使用next()時要覆寫toString()方法
            //否則只會用到Object的toString()印出記憶體位址
        System.out.println("Set家族不能用for的寫法===================");
    }
    public static void  listPrint(List<Train> arr){
         System.out.println("以下是List的sugar寫法=================");
         for(Train x : arr){
            System.out.println(x);
        }
        System.out.println("以下是List的Iterator寫法=================");
        Iterator<Train>  i1 =arr.iterator();
        while(i1.hasNext())
            System.out.println(i1.next());
        System.out.println("List用for的寫法===================");
        for(int i=0; i <arr.size();i++){
            Object obj  =arr.get(i);
            System.out.println(obj);
        }
    }
    private static class Desc implements Comparator<Train> {//能印出不重複的Train物件由車號小到大排序
        @Override
        public int compare(Train t1, Train t2) {
            // 將返回值與預設相反，使其由車號小到大排序
            return Integer.compare( t1.getNumber(),t2.getNumber());
        }
    }

    public static void main(String[] args) {
         work1_1();
   

        List<Train> trains2 =new ArrayList<Train>();
        trains2.add(new Train(202, "普悠瑪", "樹林", "花蓮", 400));
        trains2.add(new Train(1254, "區間", "屏東", "基隆", 700));
        trains2.add(new Train(118, "自強", "高雄", "台北", 500));
        trains2.add(new Train(1288, "區間", "新竹", "基隆", 400));
        trains2.add(new Train(122, "自強", "台中", "花蓮", 600));
        trains2.add(new Train(1222, "區間", "樹林", "七堵", 300));
        trains2.add(new Train(1254, "區間", "屏東", "基隆", 700));
        // Collections.sort(trains2);//讓Train物件印出時，能以班次編號由大到小印出
        // listPrint(trains2);

        Set<Train> trains =new TreeSet<Train>();
        trains.add(new Train(202, "普悠瑪", "樹林", "花蓮", 400));
        trains.add(new Train(1254, "區間", "屏東", "基隆", 700));
        trains.add(new Train(118, "自強", "高雄", "台北", 500));
        trains.add(new Train(1288, "區間", "新竹", "基隆", 400));
        trains.add(new Train(122, "自強", "台中", "花蓮", 600));
        trains.add(new Train(1222, "區間", "樹林", "七堵", 300));
        trains.add(new Train(1254, "區間", "屏東", "基隆", 700));
        // setPrintTrain(trains);//不僅能讓班次編號由大排到小印出， 還可以不重複印出Train物件
        
//        TreeSet<Train> desc1 =new TreeSet<>(new Desc());
//        desc1.addAll(trains);
//        for(Train x :desc1)
//            System.out.println(x);
    }    
}