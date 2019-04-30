package ie.tudublin;

import processing.core.PApplet;

public class Clock extends PApplet
{
    UI ui;
    private float x;
    private float y;
    private float radius;
    private float[] time = new float[3]; // use array to store time: second, minute, hour
    private float[] timeFloat = new float[2];

    public Clock(UI ui, float x, float y, float radius)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void render()
    {
        time[0] = second();
        time[1] = minute();
        time[2] = hour();
        timeFloat[0] = (float) (minute() + time[0] / 60.0); // current minute
        timeFloat[1] = (float) (hour() + time[1] / 60.0); // current hour

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
                ui.line(120, 0, 130, 0);
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

    public void hourPointer()
    {
        // hour pointer
        // 12 hours -> 360 degree, 1 hour -> 30 degree
        ui.pushMatrix();
        ui.translate(x, y);
        float angleHour = radians(270);
        if((timeFloat[1] >= 3 && timeFloat[1] <= 12) || (timeFloat[1] >= 15 && timeFloat[1] <= 24))
        {
            angleHour = radians(30 * (timeFloat[1] - 3));
        }
        else
        {
            angleHour = radians(30 * (timeFloat[1] - 1) + 300);
        }
        ui.rotate(angleHour);
        ui.stroke(255);
        ui.strokeWeight(7);
        ui.line(-10, 0, 50, 0);
        ui.popMatrix();
    }

    public void minutePointer()
    {
        // minute pointer
        // 60 minutes -> 360 degree, 1 minute -> 6 degree
        ui.pushMatrix();
        ui.translate(x, y);
        float angleMinute = radians(270);
        if((timeFloat[0] >= 0 && timeFloat[0] <= 15))
        {
            angleMinute = radians(270 + 6 * timeFloat[0]);
        }
        else
        {
            angleMinute = radians(6 * (timeFloat[0] - 15));
        }
        ui.rotate(angleMinute);
        ui.stroke(255);
        ui.strokeWeight(5);
        ui.line(-10, 0, 70, 0);
        ui.popMatrix();
    }

    public void secondPointer()
    {
        // second pointer
        // 60 seconds -> 360 degree, 1 second -> 6 degree
        ui.pushMatrix();
        ui.translate(x, y);
        float angleSecond = radians(270);
        if ((time[0] >= 0 && time[0] <= 15)) {
            angleSecond = radians(270 + 6 * time[0]);
        } else {
            angleSecond = radians(6 * (time[0] - 15));
        }
        ui.rotate(angleSecond);
        ui.stroke(255, 0, 0);
        ui.strokeWeight(3);
        ui.line(-15, 0, 90, 0);
        ui.fill(255, 0, 0);
        ui.ellipse(115, 0, 10, 10);
        ui.stroke(255);
        ui.popMatrix();
    }
}