package ie.tudublin;

public class FrameLine
{
    UI ui;
    private float x1;
    private float y1;
    private float x2;
    private float y2;    
    private int no;
    private int color;

    public FrameLine(UI ui, float x1, float y1, float x2, float y2, int no, int color)
    {
        this.ui = ui;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.no = no;
        this.color = color;
    }

    public void render()
    {
        ui.stroke(color);
        ui.strokeWeight(no);
        ui.line(x1, y1, x2, y2);
        ui.strokeWeight(1);
    }

}