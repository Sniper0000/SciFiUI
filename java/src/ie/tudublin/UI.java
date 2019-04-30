package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b1, b2, b3;
    MovingCube mc1, mc2, mc3, mc4, mc5;
    DashBoard d1, d2;
    Frame f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13;
    FrameLine l1, l2, l3, l4;
    Clock c;
    ShipStatu si;

    // set variable to control
    public float MCL_Range = 1300;
    public float MCR_Range = 1450;

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

        // moving cube
        mc1 = new MovingCube(this, 1300, 750, 30, 20, 7, MCL_Range, MCR_Range, 1f);
        mc2 = new MovingCube(this, 1300, 800, 30, 20, 7, MCL_Range, MCR_Range, 1.5f);
        mc3 = new MovingCube(this, 1300, 850, 30, 20, 7, MCL_Range, MCR_Range, 2);
        mc4 = new MovingCube(this, 1300, 900, 30, 20, 7, MCL_Range, MCR_Range, 2.5f);
        mc5 = new MovingCube(this, 1300, 950, 30, 20, 7, MCL_Range, MCR_Range, 3f);

        // radar
        radar = new Radar(this, 1, 1700, 860, 150);
        
        // dash board
        d1 = new DashBoard(this, 1, 550, 860, 150);
        d2 = new DashBoard(this, 2, 950, 860, 150);

        // frame(main)
        f1 = new Frame(this, 50, 50, 300, 340, 7, "Control Button");
        f2 = new Frame(this, 50, 400, 300, 400, 7, "Ship Statu");
        f3 = new Frame(this, 50, 810, 300, 240, 7, "SPACE SHIP SYSTEM V1.0");
        f4 = new Frame(this, 360, 50, 1160, 600, 7, "monitor");
        f5 = new Frame(this, 360, 670, 1160, 380, 7, "Dash Board");
        f6 = new Frame(this, 1530, 50, 350, 380, 7, "Clock");
        f7 = new Frame(this, 1530, 440, 350, 210, 7, "Star Info");
        f8 = new Frame(this, 1530, 670, 350, 380, 7, "Radar");

        // frame(ship data)
        f9 = new Frame(this, 1300, 750, 150, 20, 7, "");
        f10 = new Frame(this, 1300, 800, 150, 20, 7, "");
        f11 = new Frame(this, 1300, 850, 150, 20, 7, "");
        f12 = new Frame(this, 1300, 900, 150, 20, 7, "");
        f13 = new Frame(this, 1300, 950, 150, 20, 7, "");

        // line
        l1 = new FrameLine(this, 360, 660, 1880 ,660, 3, 153);

        // clock
        c = new Clock(this, 1700, 250, 150);

        // ship info
        si = new ShipStatu(this, 200, 550, 100, 750, 300, 750, 255, 3);

    }
    Radar radar;

    public void draw()
    {
        background(0);

        b1.render();
        b1.MouseClick();
        b2.render();
        b2.MouseClick();
        b3.render();
        b3.MouseClick();

        mc1.update();
        mc1.render();
        mc2.update();
        mc2.render();
        mc3.update();
        mc3.render();
        mc4.update();
        mc4.render();
        mc5.update();
        mc5.render();

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
        f9.render();
        f10.render();
        f11.render();
        f12.render();
        f13.render();

        l1.render();

        d1.update();
        d1.render();
        d2.update();
        d2.render();

        c.update();
        c.render();

        si.render();

    }
}

