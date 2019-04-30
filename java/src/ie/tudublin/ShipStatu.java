package ie.tudublin;

import processing.core.PApplet;

public class ShipStatu extends PApplet
{
    UI ui;
    private float x;
    private float y;
    private float color;
    private float no;
    private float gap;
    private float width = 250;
    private float height = 250;

    private float[] rainFall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    private String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

    float[] fa = new float[2];

    public ShipStatu(UI ui, float x, float y, float color, float no)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.color = color;
        this.no = no;
    }

    public void render()
    {
        ui.stroke(color);
        ui.fill(255);
        ui.pushMatrix();
        ui.translate(x, y);
        fa[0] = 10;
        fa[1] = 4;
        gap = width * 0.1f;
        ui.line(gap, gap, gap, height - gap);
        ui.line(gap, height - gap, width - gap, height - gap);
        for (int i = 0; i < months.length; i++) {
            float x = map(i, 0, months.length - 1, gap, width - gap);
            ui.line(x, height - gap, x, height - gap + 5);
            ui.fill(255);
        }
        for (int i = 0; i <= 150; i += 10) {
            float y = map(i, 0, 150, height - gap, gap);
            ui.line(gap - 5, y, gap, y);
        }
        for (int i = 1; i < rainFall.length; i++) {
            float x1 = map(i - 1, 0, rainFall.length - 1, gap, width - gap);
            float y1 = map(rainFall[i - 1], 0, 150, height - gap, gap);
            float x2 = map(i, 0, rainFall.length - 1, gap, width - gap);
            float y2 = map(rainFall[i], 0, 150, height - gap, gap);
            ui.line(x1, y1, x2, y2);
        }
        ui.popMatrix();
        ui.strokeWeight(no);
        ui.strokeWeight(1);
    }
}