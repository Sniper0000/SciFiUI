package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b1,b2,b3;
    MovingCircle mc;
    DashBoard d;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        //size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(P3D); 
        fullScreen();
    }

    public void setup()
    {
        b1 = new Button(this, 50, 50, 100, 50, "Star Map");
        b2 = new Button(this, 50, 150, 100, 50, "Ship Info");
        b3 = new Button(this, 50, 250, 100, 50, "");
        mc = new MovingCircle(this, width / 2, height * .75f, 50);
        radar = new Radar(this, 1, width * 8 / 9, height * 4 / 5, 150);
        border = width * 0.05f;
        d = new DashBoard(this, width / 2, height * 8 / 9, 200, PI, TWO_PI);
    }

    Radar radar;
    float border;

    /*private void drawGrid()
    {
        textAlign(CENTER, CENTER);
        for(int i = -10; i <= 10; i ++)
        {
            float x = map(i, -10, 10, border, width - border);
            float y = map(i, -10, 10, border, height - border);
            stroke(0, 0, 255);
            line(x, border, x, height - border);
            fill(255);
            text(i, x, border / 2);
            stroke(0, 0, 255);
            line(border, y, width - border, y);
            fill(255);
            text(i, border / 2, y);
        }
    }*/

    public void draw()
    {
        background(0);
        b1.render();
        b2.render();
        b3.render();

        mc.update();
        mc.render();

        radar.update();
        radar.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }

        d.render();
        //drawGrid();
    }
}

