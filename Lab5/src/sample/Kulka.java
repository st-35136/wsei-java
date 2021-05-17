package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class Kulka {

    private static final double R = 10;
    protected double ySpeed;
    protected double xSpeed;
    protected double xPos;
    protected double yPos;

    protected Color color = Color.BLACK;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Kulka(){

    }

    public Kulka(double xPos, double yPos, double xSpeed, double ySpeed) {
        this.ySpeed = ySpeed;
        this.xSpeed = xSpeed;
        this.xPos = xPos;
        this.yPos = yPos;
        color = Color.WHITESMOKE;
    }

    public Kulka(double ySpeed, double xSpeed, double xPos, double yPos, Color color) {
        this.ySpeed = ySpeed;
        this.xSpeed = xSpeed;
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    public void checkBoundaryCollision(double xLeft, double yTop, double xRight, double yBottom){
        if((xPos - R <=xLeft) || (xPos + R >= xRight)){
            xSpeed=-xSpeed;
        }

        if((yPos - R <=yTop) || (yPos + R >= yBottom)){
            ySpeed=-ySpeed;
        }
    }

    public void draw(GraphicsContext gc){
        gc.setFill(getColor());
        gc.fillOval(xPos-R,yPos-R,2*R, 2*R);
        gc.restore();
    }

    public void update(){
        xPos += xSpeed;
        ySpeed+= ySpeed;
    }
}
