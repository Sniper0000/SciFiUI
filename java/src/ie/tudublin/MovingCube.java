package ie.tudublin;

public class MovingCube
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private float radius;
    private float speed;
    private float L_range;
    private float R_range;

    public MovingCube(UI ui, float x, float y, float width, float height, float radius, float L_range, float R_range, float speed)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.radius = radius;
        this.L_range = L_range;
        this.R_range = R_range;
        this.speed = speed;
    }
    
    public void render()
    {
        ui.stroke(255);
        ui.fill(255);
        ui.rect(x, y, width, height, radius);
        // Static field
        //ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        //ui.text("I am a moving circle", x, y);

    }

    public void update()
    {
        x += speed;
        if ((x > R_range - width) || (x < L_range))
        {
            speed *= -1;
        }
    }
}
