

public class Malll {
	private int location;//말 위치
	private int tryNumber;// 모나 윷, 잡았을때 한번 더 던질 수 있도록 카운트
	private int num;//낫는지 안낫는지 확인
	private int bflocation;
	private int checkNum;
	private int midcheck;
	public Malll() {
		location = 0;
		tryNumber = 0;
		num = 0;//백도할 때 어느 방향에서 왔는지 확인
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
			//System.out.println("---");
			//quiz 실행
			int gameChanger = 0;
			
			Quiz quiz = new Quiz();			
			quiz.setVisible(true);		
			if(quiz.getGameChanger() == -1) {
				goStart();
			}else{
				location=60;
			}			
			//모 나왔을때 옆으로 가는거
		}
		else if(location==10) {
			//System.out.println("---");			
					
			// 가위바위보 실행
			rockScissorPaper rsp = new rockScissorPaper();			
			rsp.setVisible(true);		
			if(rsp.getGameChanger() == -1) {
				goStart();
			}else{
				location=40;
			}
	//		location=location+a.yutDun();
			//두번  꺽는 구간 
		}else if(location==14&&checkNum==1) {
			System.out.println("---");
			location=65;
	//		location=location+a.yutDun();
			//두번  꺽는 구간 
		}
		

		else if(location == 15) {
			//System.out.println("---");			
					
			// 가위바위보 실행
			Lots lot = new Lots();
			lot.setVisible(true);
			if(lot.getGameChanger() == -1) {
				goStart();
			}else{
				location = 15;
			}
	//		location=location+a.yutDun();
			//두번  꺽는 구간 
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
				//뽑기 실행
				Lots lot = new Lots();
				lot.setVisible(true);
				if(lot.getGameChanger() == -1) {
					goStart();
				}else{
					location = 15;
				}
			}
			else {
				location -= 51;
			}			
		}
		else if(location==59) {
			//System.out.println("---");
			location = 4;
		}
		else if(location==46) {
			//System.out.println("---");
			location=0;
		}
		else if(num==0){

			System.out.println("---");
			location-=51;
			checkNum=1;//온 방향대로 백도
		}else if (location==42&&midcheck==1) {
			location=62;
		}
		else if(location==59) {
			System.out.println("---");
			location = 4;//모 자리에서 백도
		}
		else if(location==20) {
			System.out.println("---");
			location=46;//마지막은 46으로 통일
			checkNum=1;
		}else if(location==45&&checkNum==1) {
			System.out.println("---");
			location=19;// 온 방향대로 백도
		}else if(location == 39) {
			System.out.println("---");
			location=9;//2번 모 자리에서 백도
		}else if(location==0) {
			location=46;
		}
		//else if(location == )
		/*else if(num==0){
    
			//location+=a.yutDun();
			//저런경우 없을때 던지기
		}
		else if(location>46) {
			num++;
		}
		if(num==0) {
			if(20<location&&location<40) {
				//ComplNanmall();//정석으로 돌아서 클리어
				num++;
			}if(46<location&&location<60) {
				//super.ComplNanmall();//대각선 방향으로 들어와서 클리어
				num++;
			}if(71<location) {
				//super.ComplNanmall();
				num++;//처음 모 걸린 후 크게돌아 클리어
			}
		}
		return location;
	}
	public int preview(int a) {
		int lc2 = location + a;
		if(lc2 == 5)	{
			//System.out.println("---");
			lc2=60;
			//모 나왔을때 옆으로 가는거
		}
		else if(lc2==10) {
			//System.out.println("---");
			lc2=40;
	//		location=location+a.yutDun();
			//두번  꺽는 구간 
		}
		else if(lc2 == 63) {
			//System.out.println("---");
			lc2-=20;
		//	location+=a.yutDun();
		}	//중앙에 도착했을 때 꺽기
		else if(lc2>65) {
			//System.out.println("---");
			lc2-=51;
		}
		else if(lc2==59) {
			//System.out.println("---");
			lc2 = 4;
		}else if(lc2==0) {
			lc2=46;
		}else if(lc2==45&&checkNum==1) {
		//	System.out.println("---");
			lc2=19;// 온 방향대로 백도
		}else if (lc2==42&&midcheck==1) {
			lc2=62;
		}else if(lc2 == 39) {
	//		System.out.println("---");
			lc2=9;//2번 모 자리에서 백도
		}
		/*
		 * else if(lc2==46) { //System.out.println("---"); lc2=0; }
		 */
		/*else if(num==0){
			//location+=a.yutDun();
			//저런경우 없을때 던지기
		}*/
		else if(location>46) {
			//complite
		}
		
		return lc2;
	}
}
