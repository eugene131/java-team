package teamproject;

import java.io.Serializable;

public class Malll implements Cloneable, Serializable{
	private int location;//¸» À§Ä¡
	private int num;//³´´ÂÁö ¾È³´´ÂÁö È®ÀÎ
	
	public Malll() {
		location = 0;
		num = 0;
	}
	
	public int getLocation() {
		return location;
	}
	
	public int getNum() {
		return num;
	}
	
	public void goStart() {
		location = 0;
	}
	
	public void setLocation(int a) {
		location += a;
		location = move();
	}
	
	public void setNum(int a) {
		num = a;
	}
	
	public void success() {
		num++;
	}
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	
	
	public int move() {//¸» ÀÌµ¿ 
		if(location == 5)	{
			location=60;
		}
		else if(location==10) {
			location=40;
		}
		else if(location == 63) {
			location-=20;
		}	//Áß¾Ó¿¡ µµÂøÇßÀ» ¶§ ²©±â
		else if(location>65) {
			location-=51;
		}
		else if(location==59) {
			location = 4;
		}
		else if(num==0){
		}
		else if(location>46) {
			num++;
		}
		if(num==0) {
			if(20<location&&location<40) {
				num++;
			}if(46<location&&location<60) {
				num++;
			}if(71<location) {
				num++;
			}
		}
		return location;
	}
	
	public int preview(int a) {
		int lc2 = location + a;
		if(lc2 == 5)	{
			lc2=60;
		}
		else if(lc2==10) {
			lc2=40;
		}
		else if(lc2 == 63) {
			lc2-=20;
		}	//Áß¾Ó¿¡ µµÂøÇßÀ» ¶§ ²©±â
		else if(lc2>65) {
			lc2-=51;
		}
		else if(lc2==59) {
			lc2 = 4;
		}

		return lc2;
	}
}
