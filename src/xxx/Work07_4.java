package xxx;


import java.io.*;



public class Work07_4 implements Serializable{
//	private static final long serialVersionUID = 8315449942815314809L;

	public static void main(String []args) throws ClassNotFoundException {
		try {
			File data = new File ("c:\\data");
			if(!data.exists()) {
				data.mkdir();
			}
			File file = new File ("c:\\data\\Object.ser");
			AnimalNew[] a= new AnimalNew[2];
			a[0]= new Cat("hery");
			a[1]= new Dog("bob");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutput oos = new ObjectOutputStream(fos);
			for (int i=0; i<a.length;i++) {
				oos.writeObject(a[i]);
			}
			oos.close();
			fos.close();
			System.out.println("有做事");
		}catch(IOException e) {}
		
		try {
			File file = new File ("c:\\data\\Object.ser");


			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			System.out.println(file.getName()+"檔案如下");
			while(true) {
				((AnimalNew)ois.readObject()).speak();
				((AnimalNew)ois.readObject()).speak();
				System.out.println("-----------");
			}
		}catch(IOException e) {
			System.out.println("資料讀取完畢！");

		}

	
}
}
