package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class DashBoard 
{
    private UI ui;
    private float radius;
    private float start1;
    private float stop1; 
    private PVector pos;
    private float frequency;
    private float theta = 0;

    public DashBoard(UI ui, float x, float y, float radius, float start1, float stop1)
    {
        this.ui = ui;
        this.radius = radius;
        this.start1 = start1;
        this.stop1 = stop1;
        pos = new PVector(x,y);
    }

    public void render()
    {
        ui.noFill();
        ui.arc(pos.x, pos.y, radius * 2, radius * 2, start1, stop1);
        float x2 = pos.x + (float) Math.sin(theta) * radius;
        float y2 = pos.y - (float) Math.sin(theta) * radius;
        ui.line(pos.x, pos.y, x2, y2);
    }

    float timeDelta = 1.0f / 60.0f;

    public void update()
    {

        theta += PApplet.TWO_PI * timeDelta * frequency;
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
