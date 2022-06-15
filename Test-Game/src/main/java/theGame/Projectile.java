package theGame;

import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Projectile extends GameObject {

	private Handler handler;
    //private BufferedImage projectileSprite;

	
	public Projectile(int x, int y, ID id, Handler handler, int velY, int velX, Sprites sprite) {
		super(x, y, id, sprite);
		this.handler = handler;
        //this.projectileSprite = sprite.getSubimage(4, 1, 5, 6);

		
		 //Projectile movements
///////////////////////////////////////////////////

			if(this.handler.isGoingUp()) {
				this.velY = -10;
			} 
			
			if(this.handler.isGoingDown()) {
				this.velY = 10;
			}
			
			if(this.handler.isGoingLeft()) {
				this.velX = -10;
			}
			
			if(this.handler.isGoingRight()) {
				this.velX = 10;
			}
				
///////////////////////////////////////////////////
			
	}

	@Override
	public void tick() {

		this.x += this.velX;
		this.y += this.velY;
		collision();

	}


    private void collision() {
    	
    	for(int i = 0; i < handler.object.size(); i++) {
    		GameObject tempObject = handler.object.get(i);
    		
    		if(tempObject.getID() == ID.Block) {	
    			
    			if(getBounds().intersects(tempObject.getBounds())) {
    				handler.removeObject(this);
    			}
    		}
    	}
    }
    
	@Override
	public void render(Graphics g) {
       // g.drawImage(projectileSprite, x , y, null);
		g.setColor(Color.red);
		g.drawRect(x, y, 8, 8);;

}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}
}
