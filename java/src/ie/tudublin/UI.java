package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b1, b2, b3;
    MovingCircle mc;
    DashBoard d1, d2;
    Frame f1, f2, f3, f4, f5, f6, f7, f8;
    FrameLine l1, l2, l3, l4;
    Clock c;

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
        // button
        b1 = new Button(this, 150, 100, 100, 50, 7, "Star Map");
        b2 = new Button(this, 150, 200, 100, 50, 7, "Ship Info");
        b3 = new Button(this, 150, 300, 100, 50, 7,"News");

        //moving circle
        mc = new MovingCircle(this, width / 2, height * .75f, 50);

        // radar
        radar = new Radar(this, 1, 1700, 860, 150);
        
        // border
        //border = width * 0.05f;
        

        // dash board
        d1 = new DashBoard(this, 1, 550, 860, 150);
        d2 = new DashBoard(this, 2, 950, 860, 150);

        // frame
        f1 = new Frame(this, 50, 50, 300, 340, 7, "Control Button");
        f2 = new Frame(this, 50, 400, 300, 400, 7, "Ship Statu");
        f3 = new Frame(this, 50, 810, 300, 240, 7, "SPACE SHIP SYSTEM V1.0");
        f4 = new Frame(this, 360, 50, 1160, 600, 7, "monitor");
        f5 = new Frame(this, 360, 670, 1160, 380, 7, "Dash Board");
        f6 = new Frame(this, 1530, 50, 350, 380, 7, "Clock");
        f7 = new Frame(this, 1530, 440, 350, 210, 7, "Star Info");
        f8 = new Frame(this, 1530, 670, 350, 380, 7, "Radar");

        // line
        l1 = new FrameLine(this, 360, 660, 1880 ,660, 3, 153);

        // clock
        c = new Clock(this, 1700, 250, 150);

    }
    Radar radar;
    //float border;

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

        f1.render();
        f2.render();
        f3.render();
        f4.render();
        f5.render();
        f6.render();
        f7.render();
        f8.render();

        l1.render();

        d1.update();
        d1.render();
        d2.update();
        d2.render();


        c.render();

        //drawGrid();
    }
}

