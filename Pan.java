else if(player2 == true) {
				if(e.getSource() == btn[i] && ch2[i] == true && throwY == true) { //버튼(칸)이 눌렸음 && 칸에 말 존재 && 윷 던져진 상태
					
					if(mall==1 && bfmv2[0]==0) {
						if(afmv2[0]==46 || afmv2[0]==60 || afmv2[0]==40|| afmv2[0]==15|| afmv2[0]==43) {
							image[afmv2[0]].setIcon(Y1bgexist);
						}
						else image[afmv2[0]].setIcon(Y1exist);
						
						P2[0].setLocation(p2rd.get(num2)); //1번 말 이동한 위치 저장

						System.out.println("Ch2[46]" + ch2[46]);
						System.out.println("location : " + P2[0].getLocation());
					}
					else if(mall==2 && bfmv2[1]==0) {
						if(afmv2[1]==46 || afmv2[1]==60 || afmv2[1]==40|| afmv2[1]==15|| afmv2[1]==43) {
							image[afmv2[1]].setIcon(Y2bgexist);
						}
						else image[afmv2[1]].setIcon(Y2exist);
						
						P2[1].setLocation(p2rd.get(num2));

						System.out.println("Ch2[46]" + ch2[46]);
						System.out.println("location : " + P2[1].getLocation());
					}
					else if(mall==3 && bfmv2[2]==0) {
						if(afmv2[2]==46 || afmv2[2]==60 || afmv2[2]==40|| afmv2[2]==15|| afmv2[2]==43) {
							image[afmv2[2]].setIcon(Y3bgexist);
						}
						else image[afmv2[2]].setIcon(Y3exist);
						
						P2[2].setLocation(p2rd.get(num2));

						System.out.println("Ch2[46]" + ch2[46]);
						System.out.println("location : " + P2[2].getLocation());
					}
					else if(mall==4 && bfmv2[3]==0) {
						if(afmv2[3]==46 || afmv2[3]==60 || afmv2[3]==40|| afmv2[3]==15|| afmv2[3]==43) {
							image[afmv2[3]].setIcon(Y4bgexist);
						}
						else image[afmv2[3]].setIcon(Y4exist);
						
						P2[3].setLocation(p2rd.get(num2));
						System.out.println("Ch2[46]" + ch2[46]);
						System.out.println("location : " + P2[3].getLocation());
					}
					else for(int j = 0; j<4; j++) { // 업기
						loc = P2[j].getLocation() + p2rd.get(num2);
						
						if(loc == 5)	{
								loc=60;
						}
						else if(loc==10) {
							//System.out.println("---");			
								loc=40;
						}else if(loc==14&&checkNum2[j]==1) {
							System.out.println("---");
							loc=65;
					//		location=location+a.yutDun();
							//두번  꺽는 구간 
						}
						

						else if(loc == 63) {
							//System.out.println("---");
							loc-=20;
							midcheck2[j]=1;
						//	location+=a.yutDun();
						}	//중앙에 도착했을 때 꺽기
						else if(loc>65) {

							//System.out.println("---");
							if(loc == 66) {
								//뽑기 실행
								loc = 15;
							}
							else if(loc>66){
								loc -= 51;
							}		
							checkNum2[j]=1;
						}
						else if(loc==59) {
							//System.out.println("---");
							loc = 4;
						}
						else if(loc==46) {
							//System.out.println("---");
							loc=0;
						}
						else if (loc==42&&midcheck2[j]==1) {
							loc=62;
						}
						else if(loc==59) {
							System.out.println("---");
							loc = 4;//모 자리에서 백도
						}
						else if(loc==20) {
							System.out.println("---");
							loc=46;//마지막은 46으로 통일
							checkNum2[j]=1;
						}else if(loc==45&&checkNum2[j]==1) {
							System.out.println("---");
							loc=19;// 온 방향대로 백도
						}else if(loc == 39) {
							System.out.println("---");
							loc=9;//2번 모 자리에서 백도
						}
						
						if(((P2[j].getLocation() + p2rd.get(num2)>20 && P2[j].getLocation() + p2rd.get(num2)<40) || (P2[j].getLocation() + p2rd.get(num2)>46 && P2[j].getLocation() + p2rd.get(num2)<60))){
							if(j==0 && P2[mall-1].getLocation() + p2rd.get(num2) == loc) {
								yellowMall1Button.setEnabled(false);
								P2[0].success();
								P2[0].setLocation(p2rd.get(num2));
							}
							else if(j==1 && P2[mall-1].getLocation() + p2rd.get(num2) == loc) {
								yellowMall2Button.setEnabled(false);
								P2[1].success();
								P2[1].setLocation(p2rd.get(num2));
							}
							else if(j==2 && P2[mall-1].getLocation() + p2rd.get(num2) == loc) {
								yellowMall3Button.setEnabled(false);
								P2[2].success();
								P2[2].setLocation(p2rd.get(num2));
							}
							else if(j==3 && P2[mall-1].getLocation() + p2rd.get(num2) == loc) {
								yellowMall4Button.setEnabled(false);
								P2[3].success();
								P2[3].setLocation(p2rd.get(num2));
							}
						}
						
						System.out.println("i ; " + i + "  P2[j].getLocation() + p2rd ; " + loc);
						if(i == loc) {
							if(loc==46 || loc==60 || loc==40|| loc==15|| loc==43) {
								if(j==0) {
									image[loc].setIcon(Y1bgexist);
								}
								else if(j==1) image[loc].setIcon(Y2bgexist);
								else if(j==2) image[loc].setIcon(Y3bgexist);
								else if(j==3) image[loc].setIcon(Y4bgexist);
							}
							else{
								if(j==0) image[loc].setIcon(Y1exist);
								else if(j==1) image[loc].setIcon(Y2exist);
								else if(j==2) image[loc].setIcon(Y3exist);
								else if(j==3) image[loc].setIcon(Y4exist);
							}
							P2[j].setLocation(p2rd.get(num2)); //1번 말 이동한 위치 저장
							System.out.println("location : " + P2[j].getLocation());
						}
					}
					if((ch2[1] == true) && (i==1)) {
						loc = P2[mall-1].getLocation() + p2rd.get(num2);
						if((loc>20 && loc<40) || (loc>46 && loc<60)) {
							ch2[1] = false;
							image[1].setIcon(btn2);
						}
					}
			
					if(i==60||i==5) {// 게임 넣는 것
						
						  Quiz quiz = new Quiz();
						  quiz.setVisible(true);
						  if(quiz.getGameChanger() ==-1)
						  { 
							  for(int j=0; j<4; j++) { 
							  if(i == P2[j].getLocation()) {
						  P2[j].goStart(); checkNum2[j]=0; midcheck2[j]=0; 
						  
							  } 
						  
							  }
						  
						  ch2[i]=false; }
						  
						 			}else if(i==10||i==40) {
						rockScissorPaper rsp = new rockScissorPaper();			
						rsp.setVisible(true);		
						if(rsp.getGameChanger() == -1) {
							
							for(int j=0; j<4; j++) {
								if(i == P2[j].getLocation()) {
									P2[j].goStart();
									checkNum2[j]=0;
									midcheck2[j]=0;
								}
							}
							ch2[i]=false;
						}
						
					}else if(i==15||i==66) {
						
							//뽑기 실행
							Lots lot = new Lots();
							lot.setVisible(true);
							if(lot.getGameChanger() == -1) {
								for(int j=0; j<4; j++) {
									if(i == P2[j].getLocation()) {
										P2[j].goStart();
										checkNum2[j]=0;
										midcheck2[j]=0;
									}
								}
								ch2[i]=false;
							}
						
					}
					
					if(ch1[i]==true) {
						for(int j=0; j<4; j++) {
							if(i == P1[j].getLocation()) {
								P1[j].goStart();
							}
						}
						
						JOptionPane.showMessageDialog(null, "You catch the Player1's mal", "Catch", JOptionPane.INFORMATION_MESSAGE);
						ch1[i]=false;
						chance2 =true;
					}
					
					for(int j = 0; j<71; j++) {
						if(ch1[j] == false && ch2[j] == false) { //말이 없는 칸을 찾아서 버튼 변경
							if(j==46 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(btn1);
							}
							else image[j].setIcon(btn2);
						}
					}
					p2rd.remove(num2);
					System.out.println(p2rd.size());
					
					for(int k=0; k<4; k++) {
						if(P1[k].getLocation() != 0) mallLabel[k].setVisible(false);
						if(P1[k].getLocation() == 0) mallLabel[k].setVisible(true);
						if(P2[k].getLocation() != 0) mallLabel2[k].setVisible(false);
						if(P2[k].getLocation() == 0) mallLabel2[k].setVisible(true);
					}
