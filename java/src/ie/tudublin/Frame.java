package ie.tudublin;

import processing.core.PApplet;

public class Frame
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private float radius;
    private String text;

    public Frame(UI ui, float x, float y, float width, float height, float radius, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.radius = radius;
        this.text = text;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.strokeWeight(3);
        ui.rect(x, y, width, height,radius);
        ui.textAlign(PApplet.CENTER, PApplet.TOP);
        ui.text(text, x + width * 0.2f, y + height * 0.05f); 
    }
}