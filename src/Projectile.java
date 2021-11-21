import acm.graphics.GImage;
import acm.graphics.GObject;

public class Projectile {
    double xPos;
    double yPos;
    int velocity;
    GImage ship;


    public Projectile(double d, double e) {
        xPos = d;
        yPos = e;
        ship = new GImage("src/Bullets/Rotated Shot.png", d, e);
    }


    //Setters for the class
    public void setXPos(int xPos) {
      this.xPos = xPos;
    }
    public void setYPos(int yPos) {
      this.yPos = yPos;
    }
    public void setVelocity(int velocity) {
      this.velocity = velocity;
    }
    //getters for the class

    public double getXPos() {
      return this.xPos;
    }
    public double getYPos() {
      return this.yPos;
    }
    public Integer getVelocity() {
      return this.velocity;
    }

    public void update() {

    }

    public void remove() {

    }

    public void hide() {
        // TODO Auto-generated method stub

    }


    public GObject getImage() {
        // TODO Auto-generated method stub
        return ship;
    }

    public double getY() {
        // TODO Auto-generated method stub
        return ship.getY();
    }
}