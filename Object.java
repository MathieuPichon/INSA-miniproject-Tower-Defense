import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class  Object {
    Coordinate position; 
    float dx,dy; 
    boolean active; 
    Image picture; 
    Rectangle frame; // certainly not useful since we use the coordinate class
    Rectangle limitesframe; // certainly not useful since we use the coordinate class 
    
    String object_name;
    int speed; //same comment as previously 
    
    public Object (Coordinate aposition, boolean activite, float adx, float ady, boolean actif, Image pictureObject, Rectangle aframe, Rectangle alimitesframe, int aspeed, String name ){
        position = aposition;
        dx = adx;
        dy = ady;
        active = active;
        picture = pictureObject;
        frame = aframe;
        limitesframe = alimitesframe;
        object_name = name;
        speed = aspeed;
        
    }
    
    public void draw ( long t, Graphics g){
        g.drawImage(picture,this.position.x, this.position.y, null);
    }
    
}
