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
	ga[] gas  =new ga[20];
	private Sound chickendeath  = Gdx.audio.newSound(Gdx.files.internal("chickendeath.mp3")); Texture tauno=new Texture("tau_no.png");Texture t= new Texture("phicochiendau.png");float elapsedTimex = 0.0f;
	player play;gathuong[] list =new gathuong[20];SpriteBatch batch;int demturn1=0,dem=0;Texture img	 = new Texture("4. Gà đặc nhiệm.png");
	float elapsedTime0 = 0, elapsedTime = 0,elapsedTime2 = 0,elapsedTime3 = 0,elapsedTime4 = 0;gathuong[] list2 =new gathuong[20]; gathuong[] list3 = new gathuong[20]; gathuong[] list4 = new gathuong[20];
	int dem2=0,dem3=0,dem4=0;
	 public turn2(player a,SpriteBatch b) {
		 play=a;batch=b;
		
		
		 
	 }
	 
     public void tao0() {
   	
   	  
      for(int i =0;i<20;i++) {
		   
		   Vector2 position = new Vector2(0,0);

		   
		   position.x=MathUtils.random(100, 1100);
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
  		
  		if (elapsedTime0 >= 1.3f && dem<14) {
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
		
			
			
			gas[i].Alive=false;
			
			//chickendeath.play();
			demturn1++;
			//break;
		}}
		
		if(play.sprite.getBoundingRectangle().overlaps(gas[i].sprite.getBoundingRectangle())) {
			// play.gameOver = true;
			//play.sprite.setTexture(tauno);
			hoi_sinh();
			
			
			gas[i].Alive=false;
			
			play.live--;
		}
		
		}

	
	}
  		
    	  return 0;
      }
      
      
      
      public int xuat1( ) {
    	  
      elapsedTime += Gdx.graphics.getDeltaTime();

  		if (elapsedTime >= 1.6f && dem<20) {
  		  list[dem].Alive=true;dem++;
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
				
				
			
				list[i].Alive=false;demturn1++;
				//break;
			}}
			
			if(play.sprite.getBoundingRectangle().overlaps(list[i].sprite.getBoundingRectangle())) {
				//play.gameOver = true;
				list[i].Alive=false;
				play.live--;
			}}}   	  
		
    	  return demturn1;
	
}
      
      public int xuat2( ) {
    	  
          elapsedTime2 += Gdx.graphics.getDeltaTime();

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
    				
    				
    			
    				list2[i].Alive=false;demturn1++;
    				//break;
    			}}
    			
    			if(play.sprite.getBoundingRectangle().overlaps(list2[i].sprite.getBoundingRectangle())) {
    				//play.gameOver = true;
    				list2[i].Alive=false;
    				play.live--;
    			}}}   	  
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
  
  					list3[i].Alive=false;demturn1++;
  					//break;
  				}}
  				
  				if(play.sprite.getBoundingRectangle().overlaps(list3[i].sprite.getBoundingRectangle())) {
  					//play.gameOver = true;
  					list3[i].Alive=false;
  					play.live--;
  				}}}   	  
  			
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
  
  					list4[i].Alive=false;demturn1++;
  					//break;
  				}}
  				
  				if(play.sprite.getBoundingRectangle().overlaps(list4[i].sprite.getBoundingRectangle())) {
  					//play.gameOver = true;
  					list4[i].Alive=false;
  					play.live--;
  				}}}   	  
  			
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
      
     
}
