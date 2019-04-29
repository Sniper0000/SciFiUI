package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class DashBoard 
{
    UI ui;
    private float radius;
    private PVector pos;
    private float frequency;
    private float theta = 0;

    public DashBoard(UI ui, float frequency, float x, float y, float radius)
    {
        this.ui = ui;
        this.frequency = frequency;
        this.radius = radius;
        pos = new PVector(x,y);
    }

    public void render()
    {
        ui.noFill();
        ui.strokeWeight(3);
        ui.ellipse(pos.x, pos.y, radius * 2, radius * 2);
        float x2 = pos.x + (float) Math.sin(theta) * radius;
        float y2 = pos.y - (float) Math.cos(theta) * radius;
        ui.line(pos.x, pos.y, x2, y2);
        ui.strokeWeight(1);
    }

    float timeDelta = 1.0f / 60.0f;

    public void update()
    {

        theta += PApplet.PI * timeDelta * frequency;
    }

    /**
     * @return the radius
     */
    public float getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    /**
     * @return the frequency
     */
    public float getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

}
