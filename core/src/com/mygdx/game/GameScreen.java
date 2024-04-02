package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class GameScreen implements Screen {
	private Game game;
	SpriteBatch batch;float elapsedTime = 0;int dem=0;
	float time = 0,time_qua=0;float time2 =0;
	Texture img ,img2,imgga,backgroundTexture;
	int NumWidth_ga = 7;
	int NumHeight_ga=2;
	int spacing_ga=120;
	player play;int rd=0;
	ga[] gas  =new ga[20];
	int demturn1=0;
	private Sound chickendeath;
	private Sound nhacnen;
	trung_doi_dan trung_lam,trung_luc,trung_nau,trung_do,trung_cam;
	
	
	   turn2 t2;
	
	
	Sprite backgroundSprite;
	private Music backgroundMusic;
	private BitmapFont font;
   
 
	
	// GameScreen(Game game) {
	 //       this.game = game;
	  //  }
//	private Texture resizeTexture(Texture originalTexture, int newWidth, int newHeight) {
//        int originalWidth = originalTexture.getWidth();
//        int originalHeight = originalTexture.getHeight();
//
//        float widthRatio = (float) newWidth / originalWidth;
//        float heightRatio = (float) newHeight / originalHeight;
//        
//        return new Texture(originalTexture, (int) (originalWidth * widthRatio), (int) (originalHeight * heightRatio));
//    }
	
	



	public GameScreen(Game game2) {
		this.game = game2;
		create();
		  font = new BitmapFont();
	        font.setColor(Color.WHITE); // Màu của văn bản
	        font.getData().setScale(2); // Tăng kích thước của văn bản (tuỳ chọn)
	        
	        //score = 0;
	}
	public void create () {
	    backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
	    backgroundMusic.setVolume(0.2f);
        // Loop nhạc (nếu bạn muốn nó phát liên tục)
        backgroundMusic.setLooping(true);
        // Play nhạc
        backgroundMusic.play();
		 backgroundTexture = new Texture("back3.jpg"
		 		+ ""
		 		+ "");
		 
		 
		 
//		 SpriteBatch spriteBatch = new SpriteBatch();
//		 spriteBatch.begin();
//		 spriteBatch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		 spriteBatch.end();
		 
		batch = new SpriteBatch();
		img = new Texture("phicochiendau.png");
		img2 = new Texture("dan_laze_do.png");
		imgga = new Texture("3. Gà con.png");
	   play = new player(img,img2);
	   
	   
	   
	   trung_lam=new trung_doi_dan(new Texture("Quà lam.png"),new Vector2( MathUtils.random(100, 700),800) );
	   trung_cam=new trung_doi_dan(new Texture("Quà Cam.png"),new Vector2( MathUtils.random(100, 700),800) );
	   trung_luc=new trung_doi_dan(new Texture("Quà lục.png"),new Vector2( MathUtils.random(100, 700),800) );
	   trung_do=new trung_doi_dan(new Texture("Quà đỏ.png"),new Vector2( MathUtils.random(100, 700),800) );
	   trung_nau=new trung_doi_dan(new Texture("Quà nâu.png"),new Vector2( MathUtils.random(100, 700),800) );
	   
	   
	   int i=0;
	  
	   for(int y=0;y<20;y++) {
		   
			   Vector2 position = new Vector2(0,0);

			   
			   position.x=MathUtils.random(100, 1100);
			   position.y=800;
			   
			   gas[i]=new ga(position, imgga,0.4f,"gacon-1.png","gacon-2.png","gacon-3.png");i++;
			  
		   
	   }
	   

	  
	   
	t2=new turn2(play, batch);
	t2.tao0();
	   t2.tao1(-200,520);
	   t2.tao2(1800,480 );
	   t2.tao3(-100, 100);
	   t2.tao4(1000, 100);
		t2.tao8(400,300);
		t2.tao5(100,500);
		t2.tao6(400, 400);
		t2.tao7(400, 400);
	   
	   chickendeath = Gdx.audio.newSound(Gdx.files.internal("chickendeath.mp3"));
	   
	   
	}
	
//	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		 Gdx.gl.glClearColor(0, 0, 0, 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
	
		batch.draw(backgroundTexture, 0, 0);
		time2 +=Gdx.graphics.getDeltaTime();
		if(time2>=3f) {
			play.bullets+=4;
			time2 = 0;
		}
		if(play.live==0)
			play.gameOver =true;
		
		
		time += Gdx.graphics.getDeltaTime();
		time_qua += Gdx.graphics.getDeltaTime();
		 font.draw(batch, "Bullets: " + play.bullets, 20, Gdx.graphics.getHeight() - 20);
		 font.draw(batch, "Lives: " + play.live, 20, Gdx.graphics.getHeight() - 50);
		 font.draw(batch, "Scores: " + play.score, 20, Gdx.graphics.getHeight() - 80);
		  
		play.Draw(batch);
		
		if (!play.gameOver)
		{
			if(play.score%30==0&&play.score>0) {
				play.live++;play.score++;
			}
			
			if (time>=5f)t2.xuat0();		if (time>=10f) {t2.xuat1();}	
		

			
		if(time_qua >=15f) { 
			
			  rd =rd();time_qua=0;

		}
		 if(rd==1)trung_lam.Alive=true;
		  if(rd==2)trung_luc.Alive=true;
		  if (rd==3)trung_do.Alive=true;
		  if (rd==4) trung_nau.Alive=true;
		  if(rd==5)trung_cam.Alive=true;
		  
		
		  if(trung_lam.p_trung.y <-100) {
			  trung_lam.Alive=false;
			  trung_lam.p_trung.x= MathUtils.random(100, 700) ;
			   trung_lam.p_trung.y=800;
		  }
		  
		  if(trung_nau.p_trung.y <-100) {
			  trung_nau.Alive=false;
			  trung_nau.p_trung.x= MathUtils.random(100, 700) ;
			   trung_nau.p_trung.y=800;
		  }  if(trung_do.p_trung.y <-100) {
			  trung_do.Alive=false;
			  trung_do.p_trung.x= MathUtils.random(100, 700) ;
			   trung_do.p_trung.y=800;
		
		  }  if(trung_luc.p_trung.y <-100) {
			  trung_luc.Alive=false;
			  trung_luc.p_trung.x= MathUtils.random(100, 700) ;
			   trung_luc.p_trung.y=800;
		  } if(trung_cam.p_trung.y <-100) {
				trung_cam.Alive=false;
				
				 trung_cam.p_trung.x= MathUtils.random(100, 700) ;
				   trung_cam.p_trung.y=800;
		  }
		  
		  
		  
		if(trung_lam.Alive==true)
		{
			trung_lam.Draw(batch);
			
		}
		if(play.sprite.getBoundingRectangle().overlaps(trung_lam.trung.getBoundingRectangle())) {
			play.dan = new Texture("Đạn lam.png");
			trung_lam.Alive=false;
			 trung_lam.p_trung.x= MathUtils.random(100, 700) ;
			   trung_lam.p_trung.y=800;
			
			
		}
		if(trung_nau.Alive==true)
		{
			trung_nau.Draw(batch);
			
		}
		if(play.sprite.getBoundingRectangle().overlaps(trung_nau.trung.getBoundingRectangle())) {
			play.dan = new Texture("Đạn đất.png");
			trung_nau.Alive=false;
			 trung_nau.p_trung.x= MathUtils.random(100, 700) ;
			   trung_nau.p_trung.y=800;
			
		}if(trung_do.Alive==true)
		{
			trung_do.Draw(batch);
			
		}
		if(play.sprite.getBoundingRectangle().overlaps(trung_do.trung.getBoundingRectangle())) {
			play.dan = new Texture("cau_lua.png");
			trung_do.Alive=false;
			  
			 trung_do.p_trung.x= MathUtils.random(100, 700) ;
			   trung_do.p_trung.y=800;
			  
			
		}if(trung_luc.Alive==true)
		{
			trung_luc.Draw(batch);
			
		}
		if(play.sprite.getBoundingRectangle().overlaps(trung_luc.trung.getBoundingRectangle())) {
			play.dan = new Texture("Đạn lục.png");
			trung_luc.Alive=false;
			 
			 trung_luc.p_trung.x= MathUtils.random(100, 700) ;
			   trung_luc.p_trung.y=800;
			
		}
		if(trung_cam.Alive==true)
		{
			trung_cam.Draw(batch);
			
		}
		if(play.sprite.getBoundingRectangle().overlaps(trung_cam.trung.getBoundingRectangle())) {
			play.dan = new Texture("dan_laze_do.png");
			trung_cam.Alive=false;
			
			   trung_cam.p_trung.x= MathUtils.random(100, 700) ;
			   trung_cam.p_trung.y=800;
			
		}
			
			
		if(time >=10f) t2.xuat2();
		if(time >= 20f) t2.xuat3();
		if(time>=30f) t2.xuat4();
		if(time>=40f) t2.xuat5();
		if(time>=50f) t2.xuat7();
		if(time>=60f) t2.xuat6();
		if(time>=70f) t2.xuat8();
		
        }
		else {
			
			// String gameOverText = "Game Over";
				String gameOverText =  String.valueOf(Gdx.graphics.getDeltaTime()) ;
		
		        float textX = 350; // Thay thế YourXPosition bằng vị trí X mong muốn
		        float textY = 200; // Thay thế YourYPosition bằng vị trí Y mong muốn
		        batch.draw(new TextureRegion(new Texture("gameover.jpg")), textX, textY);
		      
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public void show() {
		create();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		dispose();
		// TODO Auto-generated method stub
		
	}
	public int rd() {
		int i =MathUtils.random(1,5);
		return i;
	}
}
