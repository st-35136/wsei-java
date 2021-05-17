package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class Rugby extends Kulka{
    private final double rx;
    private final double ry;

    protected double omega;
    protected double rot;

    protected Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rugby(double xPos, double yPos, double xSpeed, double ySpeed, double omega, double rx, double ry){
        super(xPos,yPos,xSpeed,ySpeed);
        this.ry=ry;
        this.rx=rx;
        this.omega = omega;
    }

    public Rugby(double xPos, double yPos, double xSpeed, double ySpeed, double rx, double ry, Color color){
        super(xPos,yPos,xSpeed,ySpeed);
        this.ry=ry;
        this.rx=rx;
        this.color = color;
    }


    @Override
    public void draw(GraphicsContext gc){
        gc.save();
        gc.setFill(getColor());
        gc.setTransform(new Affine(new Rotate(rot, xPos, yPos)));
        gc.fillOval(xPos - rx, yPos - ry, 2*rx, 2*ry);
        gc.restore();
    }

    @Override
    public void update(){
        super.update();
        rot+=omega;
        System.out.printf("rotation: %f\n", rot);
    }
}
