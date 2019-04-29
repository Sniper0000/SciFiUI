package ie.tudublin;

import processing.core.PApplet;

public class Clock extends PApplet
{
    UI ui;
    private float x;
    private float y;
    private int radius;
    private int second;
    private int minute;
    private int hour;
    private float sc;
    private float mn;
    private float hr;


    public Clock(UI ui, float x, float y, int radius)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void render()
    {
        second = second();
        minute = minute();
        hour = hour();
        String Second = second + "";
        String Minute = minute + "";
        String Hour = hour + "";
        if (second < 10) {
            Second = "0" + second;
        }
        if (minute < 10) {
            Minute = "0" + minute;
        }
        if (hour < 10) {
            Hour = "0" + hour;
        }
        String currentTime = Hour + ":" + Minute + ":" + Second;
        ui.text(currentTime, x, y);
        String currentDate = day() + "/" + month() + "/" + year();
        ui.text(currentDate, x, y + 20);
        ui.noFill();
        ui.stroke(255);
        ui.strokeWeight(3);
        ui.arc(x, y, radius * 2, radius * 2, PI + HALF_PI, PI + HALF_PI + sc);
        ui.arc(x, y, (radius - 10) * 2, (radius - 10) * 2, PI + HALF_PI, PI + HALF_PI + mn);
        ui.arc(x, y, (radius - 20) * 2, (radius - 20) * 2, PI + HALF_PI, PI + HALF_PI + hr);
        ui.strokeWeight(1);
    }

    float time = 1.0f / 60.0f;

    public void update()
    {
        sc = map(second, 0, 60, 0, 360) * time;
        mn = map(minute, 0, 60, 0, 360) * time;
        hr = map(hour, 0, 24, 0, 360) * time;
    }
}