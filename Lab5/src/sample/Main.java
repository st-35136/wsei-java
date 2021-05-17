package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import java.awt.*;
import java.sql.Time;
import java.util.Random;

public class Main extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private static final double MARGIN = 50;
    private static final double ARENAWIDTH = WIDTH - MARGIN*2;
    private static final double ARENAHEIGHT = HEIGHT - MARGIN*2;
    private static final double ARENAX1 = MARGIN;
    private static final double ARENAY1 = MARGIN;
    private static final double ARENAX2 = ARENAX1 + ARENAWIDTH;
    private static final double ARENAY2 = ARENAY1 + ARENAHEIGHT;

    private static final double R = 10;
    private static final int LICZBAKULEK = 10;
    private Kulka[] kulki = new Kulka[LICZBAKULEK];


    @Override
    public void start(Stage primaryStage) throws Exception{
        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline t = new Timeline(new KeyFrame(Duration.millis(100), e -> run(gc)));
        t.setCycleCount(Timeline.INDEFINITE);

        primaryStage.setTitle("Kulki !");

        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.show();



        this.initKule();
        this.run(gc);
    }

    private void initKule(){
        Random lott = new Random();
        for(int i = 0; i < LICZBAKULEK; i++){
            if(i%2==0){
                kulki[i] = new Kulka(
                        lott.nextDouble() * ARENAWIDTH+ARENAX1,
                        lott.nextDouble() * ARENAHEIGHT+ARENAY1,
                        5+lott.nextDouble() * 20,
                        5+lott.nextDouble() *20,
                        Color.BLACK
                );
            }
            else{
                kulki[i] = new Rugby(
                        lott.nextDouble() * ARENAWIDTH+ARENAX1,
                        lott.nextDouble() * ARENAHEIGHT+ARENAY1,
                        5+lott.nextDouble() * 20,
                        5+lott.nextDouble() *20,
                        10,
                        15,
                        Color.WHITESMOKE
                );
            }
        }
    }

    private void run(GraphicsContext gc) {
        gc.setFill(Color.YELLOW);
        gc.fillRect(ARENAX1, ARENAY1, ARENAWIDTH, ARENAHEIGHT);

        for(int i = 0; i < LICZBAKULEK; i++){
            kulki[i].checkBoundaryCollision(ARENAX1,ARENAY1,ARENAX2,ARENAY2);
            kulki[i].update();
            kulki[i].draw(gc);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
