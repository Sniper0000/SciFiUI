package ie.tudublin;

import processing.core.PApplet;

public class Clock extends PApplet
{
    UI ui;
    private float x;
    private float y;
    private float radius;
    private float second;
    private float minute;
    private float hour;
    private float sc;
    private float mn;
    private float hr;

    public Clock(UI ui, float x, float y, float radius)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void render()
    {
        ui.ellipseMode(CENTER);
        ui.stroke(255);
        ui.strokeWeight(10);
        ui.fill(0);
        ui.ellipse(x, y, radius * 2, radius * 2);

        for(int i = 1 ; i <= 60 ; i ++)
        {
            ui.pushMatrix();
            ui.translate(x, y);
            ui.rotate(radians(i * 6));
            if(i % 5 == 0)
            {
                ui.strokeWeight(3);
                ui.line(110, 0, 130, 0);
            }
            else
            {
                ui.strokeWeight(1);
                ui.line(125, 0, 130, 0);
            }
            ui.popMatrix();
        }
        ui.textSize(25);
        ui.fill(255);
        ui.stroke(255);
        ui.strokeWeight(1);
        ui.text(12, 1700, 345); // 12 o'clock
        ui.text(3, 1800, 435); // 3 o'clock
        ui.text(6, 1700, 525); // 6 o'clock
        ui.text(9, 1600, 435); // 9 o'clock
        ui.textSize(10);
    }

}