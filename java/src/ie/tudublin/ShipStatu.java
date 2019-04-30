package ie.tudublin;

import java.util.ArrayList;

import processing.core.PVector;

public class ShipStatu
{
    UI ui;
    private int x1;
    private int x2;
    private int x3;
    private int y1;
    private int y2;
    private int y3;
    private int color;
    private int no;

    public ShipStatu(UI ui, int x1, int y1, int x2, int y2, int x3, int y3, int color, int no)
    {
        this.ui = ui;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.color = color;
        this.no = no;
    }

    public void render()
    {
        ui.stroke(color);
        ui.noFill();
        ui.strokeWeight(no);
        ui.triangle(x1, y1, x2, y2, x3, y3);
        //ui.noStroke();
        ui.line(x1, y1, x1, y1 + (y2 - y1 + 40) / 2);
        ui.line(x2, y2, x1, y1 + (y2 - y1 + 40) / 2);
        ui.line(x3, y3, x1, y1 + (y2 - y1 + 40) / 2);
        ui.strokeWeight(1);
    }
}