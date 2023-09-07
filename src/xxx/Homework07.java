package xxx;

import java.io.*;


public class Homework07 {
	public void readFile() {
		String str;
		int word=0;
		int line=0;
		File sample = new File ("c:\\Sample.txt");
		System.out.println("Sample.txt檔案共有"+sample.length()+"個位元組");
		try {
			FileReader fr =new FileReader("c:\\Sample.txt");
			BufferedReader br = new BufferedReader(fr);
            while ((str=br.readLine())!=null) {
                System.out.println(str);
                line++;
                word+=str.length();
            }
            System.out.println(word+"個字元");
            System.out.println(line+"列資料");
            br.close();
            fr.close();
			
		}catch(IOException e) {}
	}
	public void makeNum(){
		try {
			FileOutputStream fos = new FileOutputStream("c:\\test\\num.txt",true);
			BufferedOutputStream bos =new BufferedOutputStream(fos);
			PrintStream ps = new PrintStream(bos);
			for(int i=0;i<10;i++) {
				int ra =(int)(Math.random()*1000)+1;
				ps.print(ra+" ");
			}
			ps.print("\n");
			ps.close();
			bos.close();
			fos.close();
			System.out.println("去C曹找num");
		}catch(IOException e) {e.printStackTrace();
}
	}
	public void copyFile(File x, File y) {
		try {
			int c;
			int i=0;
			FileInputStream in = new FileInputStream(x);
			FileOutputStream out =new FileOutputStream(y);
			byte ch[] =new byte[(int)x.length()];
			while((c = in.read()) !=-1) {
				out.write(c);
				ch[i++] = (byte)c;
			}
			System.out.flush();
			
			in.close();
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	public static void main (String[]args) {
		Homework07 w1 =new Homework07();
//		w1.readFile();
//		w1.makeNum();
//		File inputFile = new File("c:\\test\\Sample.txt");
//		File outputFile = new File("c:\\test2\\out.txt");
//		w1.copyFile(inputFile, outputFile);
		
	}

}
