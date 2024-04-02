package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * 
 */
public class turn2 {
	ga[] gas  =new ga[100];gathuong[] gas6  =new gathuong[20];gathuong[] gas7  =new gathuong[20];gathuong[] gas8  =new gathuong[20];
	private Sound chickendeath  = Gdx.audio.newSound(Gdx.files.internal("chickendeath.mp3")); Texture tauno=new Texture("tau_no.png");Texture t= new Texture("phicochiendau.png");float elapsedTimex = 0.0f;
	player play;gathuong[] list =new gathuong[20];SpriteBatch batch;int demturn1=0,dem=0;Texture img	 = new Texture("4. Gà đặc nhiệm.png");
	float elapsedTime0 = 0, elapsedTime = 0,elapsedTime2 = 0,elapsedTime3 = 0,elapsedTime4 = 0,elapsedTime5 = 0,elapsedTime6 = 0,elapsedTime7 = 0,elapsedTime8 = 0;gathuong[] list2 =new gathuong[20]; gathuong[] list3 = new gathuong[20]; gathuong[] list4 = new gathuong[20];
	gathuong[] list5 =new gathuong[20];	gathuong[] list6 =new gathuong[20];	gathuong[] list7 =new gathuong[20];	gathuong[] list8 =new gathuong[20];
	int dem2=0,dem3=0,dem4=0,dem6=0,dem5=0,dem7=0,dem8=0,dem1=0;
	
	
	 public turn2(player a,SpriteBatch b) {
		 play=a;batch=b;
		
		
		 
	 }
	 
     public void tao0() {
   	
   	  
      for(int i =0;i<100;i++) {
		   
		   Vector2 position = new Vector2(0,0);

		   
		   position.x=MathUtils.random(100, 900);
		   position.y=800;
		   
		   gas[i]=new ga(position, img,0.25f,"gacon-1.png","gacon-2.png","gacon-3.png");
		  
	   
  }
  
   	  
     }

      public void tao1(int x,int y) {
    	  for(int i=0;i<20;i++)
    	  {
    	  Vector2 position = new Vector2(x,y);		   
		 //  position.x=MathUtils.random(100, 1100);
		 //  position.y=800;
		   
		   list[i]=new gathuong(position, img,"gadacnhiem1.png","gadacnhiem2.png","gadacnhiem3.png",0.5f);
    	  
    	  }  
      }
      public void tao2(int x,int y) {
    	  for(int i=0;i<20;i++)
    	  {
    	  Vector2 position = new Vector2(x,y);		   
		 //  position.x=MathUtils.random(100, 1100);
		 //  position.y=800;
		   
		   list2[i]=new gathuong(position, img,"gadacnhiem1.png","gadacnhiem2.png","gadacnhiem3.png",0.5f);
    	  
    	  }  
      }
      
      public void tao3(int x, int y) {
    	  for(int i=0; i< 20; i++) {
    		  Vector2 position = new Vector2(x,y);	
    		  list3[i]=new gathuong(position, img,"gachauau1.png","gachauau2.png","gachauau3.png",0.6f);
    	  }
      }
      public void tao4(int x, int y) {
    	  for(int i=0; i< 20; i++) {
    		  Vector2 position = new Vector2(x,y);	
    		  list4[i]=new gathuong(position, img,"gachauau1.png","gachauau2.png","gachauau3.png",0.6f);
    	  }
      }
      public int xuat0() {
    	  elapsedTime0 += Gdx.graphics.getDeltaTime();
  		
  		if (elapsedTime0 >= 1.6f && dem<99) {
  		  gas[dem].Alive=true;dem++;
  		  elapsedTime0=0;
  		  
  		}
  		for(int i=0;i<gas.length;i++) {
			
			
			if(gas[i].Alive)
			gas[i].draw(batch);
		}
	for (int i = 0; i < gas.length; i++) {
	    if(gas[i].Alive==true)
	    gas[i].updatePosition(Gdx.graphics.getDeltaTime()/2);
	}

	
	for(int i=0;i<gas.length;i++) {
		if(gas[i].Alive) {
			   for (dan bullet : play.dans) {
			      
			   
		if(bullet.sprite_bullet.getBoundingRectangle().overlaps(gas[i].sprite.getBoundingRectangle())) {
			play.p_bullet.y=10000;
			bullet.p_bullet.y=10000;
		    play.score++;
			
			
			gas[i].Alive=false;
			
			//chickendeath.play();
			demturn1++;
			//break;
		}}
		
		if(play.sprite.getBoundingRectangle().overlaps(gas[i].sprite.getBoundingRectangle())) {
			// play.gameOver = true;
			play.sprite.setTexture(tauno);
			//hoi_sinh();
			
			
			
			
			
			play.live--;
			gas[i].Alive=false;
			play.time_dead();
		}
		
		
		}

	
	}
  		
    	  return 0;
      }
      
      
      
      public int xuat1( ) {
    	  
      elapsedTime += Gdx.graphics.getDeltaTime();

  	if(dem1%4==0&&dem1>1) { elapsedTime=-3;dem1++;}
  
  		if (elapsedTime >= 1.6f && dem1<20) {
  			
  		  list[dem1].Alive=true;dem1++;
  		  elapsedTime=0;
  		  
  		}
  	
			for(int i=0;i<list.length;i++) {
				if(list[i].Alive)
				list[i].draw(batch);
				//list[i].de_Trung(img, batch);
			}
		for (int i = 0; i < list.length; i++) {
		    if(list[i].Alive==true) {
		    list[i].updatePosition1(Gdx.graphics.getDeltaTime()/2);    
		//    list[i].update_trung(batch);
		
		    }
		}
		for(int i=0;i<list.length;i++) {
			if(list[i].Alive) {
				for (dan bullet : play.dans) {
				      
					   
					if(bullet.sprite_bullet.getBoundingRectangle().overlaps(list[i].sprite.getBoundingRectangle())) {
				play.p_bullet.y=10000;
				bullet.p_bullet.y=10000;
				play.score+=2;
			
				list[i].Alive=false;demturn1++;
				//break;
			}}
			
			if(play.sprite.getBoundingRectangle().overlaps(list[i].sprite.getBoundingRectangle())) {
				//play.gameOver = true;
				list[i].Alive=false;
				play.live--;
			}
			for(trung_ga trung : list[i].trungs)
			if(play.sprite.getBoundingRectangle().overlaps(trung.trung.getBoundingRectangle())) {
				//play.gameOver = true;
				list[i].Alive=false;
				play.live--;
			}
			
			}}   	  
		
    	  return demturn1;
	
}
      
      public int xuat2( ) {
    	  
          elapsedTime2 += Gdx.graphics.getDeltaTime();
          if(dem2%4==0&&dem2>1) { elapsedTime2=-3;dem2++;}
      		if (elapsedTime2 >= 1.6f && dem2<20) {
      		  list2[dem2].Alive=true;dem2++;
      		  elapsedTime2=0;
      		  
    }
        	  
        	  
        	  
        	  

    			for(int i=0;i<list2.length;i++) {
    				
    				
    				if(list2[i].Alive)
    				list2[i].draw(batch);
    			}
    		for (int i = 0; i < list2.length; i++) {
    		    if(list2[i].Alive==true)
    		    list2[i].updatePosition2(Gdx.graphics.getDeltaTime()/2);
    		    
    		    
    		    
    		    
    		}
    		for(int i=0;i<list2.length;i++) {
    			if(list2[i].Alive) {
    				for (dan bullet : play.dans) {
    				      
    					   
    					if(bullet.sprite_bullet.getBoundingRectangle().overlaps(list2[i].sprite.getBoundingRectangle())) {
    				play.p_bullet.y=10000;
    				bullet.p_bullet.y=10000;
    				play.score+=2;
    			
    				list2[i].Alive=false;demturn1++;
    				//break;
    			}}
    			
    			if(play.sprite.getBoundingRectangle().overlaps(list2[i].sprite.getBoundingRectangle())) {
    				//play.gameOver = true;
    				list2[i].Alive=false;
    				play.live--;
    			}
    			for(trung_ga trung : list2[i].trungs)
    				if(play.sprite.getBoundingRectangle().overlaps(trung.trung.getBoundingRectangle())) {
    					//play.gameOver = true;
    					list[i].Alive=false;
    					play.live--;
    				}
    			}}   	  
        	  return demturn1;
    	
    }
      
      public void xuat3() {
    	   elapsedTime3 += Gdx.graphics.getDeltaTime();
    	  if (elapsedTime3 >= 2.6f && dem3<20) {
      		  list3[dem3].Alive=true;dem3++;
      		  elapsedTime3=0;
      		  
      		}
    	  for(int i=0;i<list3.length;i++) {
				if(list3[i].Alive)
				list3[i].draw(batch);
			}
    	  for (int i = 0; i < list3.length; i++) {
  		    if(list3[i].Alive==true)
  		    list3[i].updatePosition4(Gdx.graphics.getDeltaTime()/2);
    	  }
    	  
  			for(int i=0;i<list3.length;i++) {
  				if(list3[i].Alive) {
  					for (dan bullet : play.dans) {
  				      
  					   
  						if(bullet.sprite_bullet.getBoundingRectangle().overlaps(list3[i].sprite.getBoundingRectangle())) {
  					play.p_bullet.y=10000;
  					bullet.p_bullet.y=10000;play.score+=2;
  					list3[i].Alive=false;demturn1++;
  					//break;
  				}}
  				
  				if(play.sprite.getBoundingRectangle().overlaps(list3[i].sprite.getBoundingRectangle())) {
  					//play.gameOver = true;
  					list3[i].Alive=false;
  					play.live--;
  				}
  				for(trung_ga trung : list3[i].trungs)
  					if(play.sprite.getBoundingRectangle().overlaps(trung.trung.getBoundingRectangle())) {
  						//play.gameOver = true;
  						list3[i].Alive=false;
  						play.live--;
  					}
  				}}   	  
  			
  	    	//  return demturn1;
    	  
      }
      
     
      
      public void xuat4() {
    	   elapsedTime4 += Gdx.graphics.getDeltaTime();
    	  if (elapsedTime4 >= 2.6f && dem4<20) {
      		  list4[dem4].Alive=true;dem4++;
      		  elapsedTime4=0;
      		  
      		}
    	  for(int i=0;i<list4.length;i++) {
				if(list4[i].Alive)
				list4[i].draw(batch);
			}
    	  for (int i = 0; i < list4.length; i++) {
  		    if(list4[i].Alive==true)
  		    list4[i].updatePosition5(Gdx.graphics.getDeltaTime()/2);
    	  }
    	  
  			for(int i=0;i<list4.length;i++) {
  				if(list4[i].Alive) {
  					for (dan bullet : play.dans) {
  				      
  					   
  						if(bullet.sprite_bullet.getBoundingRectangle().overlaps(list4[i].sprite.getBoundingRectangle())) {
  					play.p_bullet.y=10000;
  					bullet.p_bullet.y=10000;play.score+=2;
  
  					list4[i].Alive=false;demturn1++;
  					//break;
  				}}
  				
  				if(play.sprite.getBoundingRectangle().overlaps(list4[i].sprite.getBoundingRectangle())) {
  					//play.gameOver = true;
  					list4[i].Alive=false;
  					play.live--;
  				}
  				for(trung_ga trung : list4[i].trungs)
  					if(play.sprite.getBoundingRectangle().overlaps(trung.trung.getBoundingRectangle())) {
  						//play.gameOver = true;
  						list4[i].Alive=false;
  						play.live--;
  					}
  				}}   	  
  			
  	    	//  return demturn1;
    	  
      }
      
      public void hoi_sinh() {
    	  
    	  
    	 
    	  
    
    	  // Update sprite trong vòng lặp chính của game
    	 if (elapsedTimex < 1) {
    	      // Tính thời gian đã trôi qua
    		 play.sprite.setTexture(tauno);
    	      elapsedTimex += Gdx.graphics.getDeltaTime();; // Được cập nhật bằng deltaTime từ game loop

    	      // Làm mờ texture hiện tại theo tỉ lệ của thời gian đã trôi qua
    	    

    	 
    	  }else {

    	  // Sau khi chuyển đổi xong, đặt texture của sprite trở lại texture A
    	  play.sprite.setTexture(t);
    	  elapsedTimex=0;
    	  }
  
      }
      public void tao5(int x, int y) {
          for (int i = 0; i < 20; i++) {
              Vector2 position = new Vector2(x, y);
              list5[i] = new gathuong(position, img, "gamy1.png", "gamy2.png", "gamy3.png", 0.5f) {
                  float startY = position.y;
                  float speedMultiplier = 30.0f; // Điều chỉnh tốc độ di chuyển
                  float xMultiplier = 0.1f; // Hệ số đa dạng hoá biên độ zic zac

                  @Override
                  public void updatePosition(float deltaTime) {
                      super.updatePosition(deltaTime);
                      float sinValue = MathUtils.sin((position.x + position.y) * xMultiplier * 0.1f);
                      position.y = MathUtils.clamp(startY + sinValue * speedMultiplier, 0, Gdx.graphics.getHeight() - sprite.getHeight() * sprite.getScaleY());
                  }
              };
          }
      }



      public void xuat5() {
          elapsedTime5 += Gdx.graphics.getDeltaTime();
          if (elapsedTime5 >= 1.3f && dem5 < 20) {
              list5[dem5].Alive = true;
              dem5++;
              elapsedTime5 = 0;
          }
          for (int i = 0; i < list5.length; i++) {
              if (list5[i].Alive) {
                  list5[i].draw(batch);
                  list5[i].updatePosition(Gdx.graphics.getDeltaTime() / 2);
              }
          }
          for (int i = 0; i < list5.length; i++) {
              if (list5[i].Alive) {
                  for (dan bullet : play.dans) {
                      if (bullet.sprite_bullet.getBoundingRectangle().overlaps(list5[i].sprite.getBoundingRectangle())) {
                          play.p_bullet.y = 10000;
                          list5[i].Alive = false;play.score+=2;
                          demturn1++;
                      }
                  }
                  if (play.sprite.getBoundingRectangle().overlaps(list5[i].sprite.getBoundingRectangle())) {
                      list5[i].Alive = false;
                      play.live--;
                  }
              	for(trung_ga trung : list5[i].trungs)
  					if(play.sprite.getBoundingRectangle().overlaps(trung.trung.getBoundingRectangle())) {
  						//play.gameOver = true;
  						list5[i].Alive=false;
  						play.live--;
  					}
              }
          }
      }

      public void tao6(int x, int y) {
          for (int i = 0; i < 20; i++) {
              Vector2 position = new Vector2(x, y);
              gas6[i] = new gathuong(position, img,  "6. Gà phi thuyền.png", "6. Gà phi thuyền.png", "6. Gà phi thuyền.png",0.5f) {
                  float centerX = position.x;
                  float centerY = position.y;
                  float radius = 200; // Bán kính của hình tròn
                  float angle = 0; // Góc bắt đầu

                  @Override
                  public void updatePosition(float deltaTime) {
                      super.updatePosition(deltaTime);
                      float x = centerX + radius * MathUtils.cosDeg(angle);
                      float y = centerY + radius * MathUtils.sinDeg(angle);
                      position.set(x, y);
                      angle += 1; // Tăng góc dần dần để di chuyển theo hình tròn
                  }
              };
          }
      }


      public void xuat6() {
          elapsedTime6 += Gdx.graphics.getDeltaTime();
          if (elapsedTime6 >= 1.3f && dem6 < 20) {
              gas6[dem6].Alive = true;
              dem6++;
              elapsedTime6 = 0;
          }
          for (int i = 0; i < gas6.length; i++) {
              if (gas6[i].Alive) {
                  gas6[i].draw(batch);
                  gas6[i].updatePosition(Gdx.graphics.getDeltaTime() / 2);
              }
          }
          for (int i = 0; i < gas6.length; i++) {
              if (gas6[i].Alive) {
                  for (dan bullet : play.dans) {
                      if (bullet.sprite_bullet.getBoundingRectangle().overlaps(gas6[i].sprite.getBoundingRectangle())) {
                          play.p_bullet.y = 10000;play.score+=2;
                          gas6[i].Alive = false;
                          demturn1++;
                      }
                  }
                  if (play.sprite.getBoundingRectangle().overlaps(gas6[i].sprite.getBoundingRectangle())) {
                      gas6[i].Alive = false;
                      play.live--;
                  }
                	for(trung_ga trung : gas6[i].trungs)
      					if(play.sprite.getBoundingRectangle().overlaps(trung.trung.getBoundingRectangle())) {
      						//play.gameOver = true;
      						gas6[i].Alive=false;
      						play.live--;
      					}
              }
          }
      }


      public void tao7(int x, int y) {
          for (int i = 0; i < 20; i++) {
              Vector2 position = new Vector2(x, y);
              gas7[i] = new gathuong(position, img,  "gamy1.png", "gamy2.png", "gamy3.png",0.5f) {
                  float speedMultiplier = 30.0f; // Điều chỉnh tốc độ di chuyển
                  float startX = position.x;
                  float startY = position.y;
                  boolean isMovingUp = true; // Biến để kiểm tra hướng di chuyển

                  @Override
                  public void updatePosition(float deltaTime) {
                      super.updatePosition(deltaTime);
                      if (isMovingUp) {
                          position.y += speedMultiplier * deltaTime;
                      } else {
                          position.y -= speedMultiplier * deltaTime;
                      }
                      // Kiểm tra nếu đối tượng chạm biên trên hoặc biên dưới màn hình thì đổi hướng di chuyển
                      if (position.y >= Gdx.graphics.getHeight() - sprite.getHeight() || position.y <= 0) {
                          isMovingUp = !isMovingUp;
                      }
                  }
              };
          }
      }

      public void xuat7() {
          elapsedTime7 += Gdx.graphics.getDeltaTime();
          if (elapsedTime7 >= 1.3f && dem7 < 19) {
              gas7[dem7].Alive = true;
              dem7++;
              elapsedTime7 = 0;
          }
          for (int i = 0; i < gas7.length; i++) {
              if (gas7[i].Alive) {
                  gas7[i].draw(batch);
                  gas7[i].updatePosition(Gdx.graphics.getDeltaTime());
              }
          }
          for (int i = 0; i < gas7.length; i++) {
              if (gas7[i].Alive) {
                  for (dan bullet : play.dans) {
                      if (bullet.sprite_bullet.getBoundingRectangle().overlaps(gas7[i].sprite.getBoundingRectangle())) {
                          play.p_bullet.y = 10000;
                          gas7[i].Alive = false;play.score+=2;
                          demturn1++;
                      }
                  }
                  if (play.sprite.getBoundingRectangle().overlaps(gas7[i].sprite.getBoundingRectangle())) {
                      gas7[i].Alive = false;
                      play.live--;
                  }
                  for(trung_ga trung : gas7[i].trungs)
    					if(play.sprite.getBoundingRectangle().overlaps(trung.trung.getBoundingRectangle())) {
    						//play.gameOver = true;
    						gas7[i].Alive=false;
    						play.live--;
    					}
              }
          }
      }

      public void tao8(int x, int y) {
          for (int i = 0; i < 20; i++) {
              Vector2 position = new Vector2(x, y);
              gas8[i] = new gathuong(position, img,  "gamy1.png", "gamy2.png", "gamy3.png",0.5f) {
                  float speedMultiplier = 30.0f; // Điều chỉnh tốc độ di chuyển
                  float startX = position.x;
                  float startY = position.y;
                  float triangleHeight = 200.0f; // Chiều cao của tam giác
                  boolean isMovingRight = true; // Biến để kiểm tra hướng di chuyển

                  @Override
                  public void updatePosition(float deltaTime) {
                      super.updatePosition(deltaTime);
                      if (isMovingRight) {
                          position.x += speedMultiplier * deltaTime;
                      } else {
                          position.x -= speedMultiplier * deltaTime;
                      }
                      // Tính toán tọa độ y tương ứng với hình tam giác
                      position.y = startY + Math.abs((position.x - startX) / triangleHeight) * triangleHeight;

                      // Kiểm tra nếu đối tượng chạm vào biên trái hoặc biên phải màn hình thì đổi hướng di chuyển
                      if (position.x >= Gdx.graphics.getWidth() - sprite.getWidth() || position.x <= 0) {
                          isMovingRight = !isMovingRight;
                      }
                  }
              };
          }
      }

      public void xuat8() {
          elapsedTime8 += Gdx.graphics.getDeltaTime();
          if (elapsedTime8 >= 1.3f && dem8 < 20) {
              gas8[dem8].Alive = true;
              dem8++;
              elapsedTime8 = 0;
          }
          for (int i = 0; i < gas8.length; i++) {
              if (gas8[i].Alive) {
                  gas8[i].draw(batch);
                  gas8[i].updatePosition(Gdx.graphics.getDeltaTime());
              }
          }
          for (int i = 0; i < gas8.length; i++) {
              if (gas8[i].Alive) {
                  for (dan bullet : play.dans) {
                      if (bullet.sprite_bullet.getBoundingRectangle().overlaps(gas8[i].sprite.getBoundingRectangle())) {
                          play.p_bullet.y = 10000;
                          gas8[i].Alive = false;play.score+=2;
                          demturn1++;
                      }
                  }
                  if (play.sprite.getBoundingRectangle().overlaps(gas8[i].sprite.getBoundingRectangle())) {
                      gas8[i].Alive = false;
                      play.live--;
                  }
                  for(trung_ga trung : gas8[i].trungs)
    					if(play.sprite.getBoundingRectangle().overlaps(trung.trung.getBoundingRectangle())) {
    						//play.gameOver = true;
    						gas8[i].Alive=false;
    						play.live--;
    					}
              }
          }
      }
      
     
}
