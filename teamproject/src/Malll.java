
import java.io.Serializable;


public class Malll implements Cloneable, Serializable {
	private int location;//말 위치
	private int tryNumber;// 모나 윷, 잡았을 때 한번 더 던질 수 있도록 카운트
	private int num;//낫는지 아닌지 확인
	private int bflocation;
	private int checkNum;
	private int midcheck;
	public Malll() {
		location = 0;
		tryNumber = 0;
		num = 0;
		bflocation=0;
		checkNum=0;
		midcheck=0;
	}
	
	public int getTryNumber() {
		return tryNumber;
	}
	public int getLocation() {
		return location;
	}
	public int getNum() {
		return num;
	}
	public int getcheckNum() {
		return checkNum;
	}
	public void setTryNumber(int a) {
		tryNumber = a;
	}
	public void goStart() {
		location = 0;
		checkNum=0;
		midcheck=0;
	}
	public void setLocation(int a) {
		location += a;
		location = move();
	}
	public void setNum(int a) {
		num = a;
	}public void setcheckNum(int a) {
		checkNum = a;
	}
	public int move() {//말 이동
		if(location == 5)	{
			
		
				location=60;
				//모 나왔을 때 옆으로 가는거
			
		}
		else if(location==10) {
			//System.out.println("---");			
					
			
				location=40;
				//두번 꺽는 구간
			} else if (location == 14 && checkNum == 1) {
				System.out.println("---");
				location = 65;
				//두번 꺽는 구간
			}
		

		else if(location == 63) {
			//System.out.println("---");
			location-=20;
			midcheck=1;
		//	location+=a.yutDun();
		}	//중앙에 도착했을 때 꺽기
		else if(location>65) {

			//System.out.println("---");
			if(location == 66) {
				location = 15;
			}
			else {
				location -= 51;
			}		
			checkNum=1;
		}
		else if(location==59) {
			//System.out.println("---");
			location = 4;
		}
		else if (location==42&&midcheck==1) {
			location=62;
		}
		else if(location==59) {
			System.out.println("---");
			location = 4;
		}
		else if(location==20) {
			System.out.println("---");
			location=46;
			checkNum=1;
		}else if(location==45&&checkNum==1) {
			System.out.println("---");
			location=19;
		}else if(location == 39) {
			System.out.println("---");
			location=9;
		}else if(location==0) {
			location=46;
		}
		//else if(location == )
		else if(num==0){
    
			//location+=a.yutDun();
			
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
	public void success() {
		num++;
	}
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
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

		}	
		else if(lc2>65) {
			
			lc2-=51;
		}
		else if(lc2==59) {
			
			lc2 = 4;
		}else if(lc2==0) {
			lc2=46;
		}else if(lc2==20) {
			lc2=46;
		}
		else if(lc2==45&&checkNum==1) {
		
			lc2=19;
		}else if (lc2==42&&midcheck==1) {
			lc2=62;
		}else if(lc2 == 39) {
	//		System.out.println("---");
			lc2=9;
		}
		
		 
		else if(num==0){
			//location+=a.yutDun();
			
		}
		else if(location>46) {
			//complite
		}
		
		return lc2;
	}
}