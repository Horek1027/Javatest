package xxx;

public class cube {
	public double length;
	public void setlength(double length) throws CubeException{
		//throws 把錯誤丟給使用者
		if(length>0) {
			this.length=length;;
		}else {
			throw new CubeException("錯誤");
			//產生自製的例外物件
		}
	}
	public double getlength() {
		return length;
	}
	public double getsq() {
		return Math.pow(length, 3);
	}
	public cube() {}
	public cube(double lengthXX) {
		this.length=lengthXX;
	}

}
