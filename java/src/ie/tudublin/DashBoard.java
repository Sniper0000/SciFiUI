package ie.tudublin;

import processing.core.PVector;

public class DashBoard 
{
    UI ui;
    private float x;
    private float y;
    private float radius;
    private float start1;
    private float stop1; 
    private PVector pos;
    private float theta = 0;

    public DashBoard(UI ui, float x, float y, float radius, float start1, float stop1)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.start1 = start1;
        this.stop1 = stop1;
        pos = new PVector(x,y);
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.arc(pos.x, pos.y, radius * 2, radius * 2, start1, stop1);
        float x2 = pos.x + (float) Math.sin(theta) * radius;
        float y2 = pos.y + (float) Math.sin(theta) * radius;
        ui.line(pos.x, pos.y, x2, y2);
    }


}
