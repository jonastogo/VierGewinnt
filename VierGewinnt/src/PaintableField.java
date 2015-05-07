import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class PaintableField {
	public int x,y;
	public int width = 50;
	public int height = 50;
	public Color color; 
	public FieldStatus status = FieldStatus.Empty;
	
	public PaintableField(int x, int y, Color color){
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void draw(Graphics2D g){
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
		g.setColor(color);
		g.fillOval(x+1, y+1, width-1, height-1);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public FieldStatus getStatus() {
		return status;
	}

	public void setStatus(FieldStatus status) {
		this.status = status;
	}
}
