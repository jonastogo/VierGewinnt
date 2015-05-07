import java.awt.Color;
import java.awt.Graphics2D;


public class PanelButton {

	private int x = 0,y = 0;
	private int width = 0, height = 0;
	private String text;
	private String cmd;
	
	public PanelButton(int x, int y, int width, int height, String text, String cmd){
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.setText(text);
		this.setCmd(cmd);
	}

	public void droaw(Graphics2D g){
		g.setColor(Color.BLACK);
		g.drawRoundRect(x,y,width,height,10,10);
		g.setColor((Window.instance.status == FieldStatus.P1 ? Color.RED : Color.GREEN));
		g.fillRoundRect(x+1,y+1, width-1, height-1,10,10);
		g.setColor(Color.WHITE);
		g.drawString(this.getText(), this.x + (int) ((this.getWidth()/2) - (g.getFontMetrics().getStringBounds(this.getText(), g).getWidth()/2)),this.y + (int) ((this.getHeight()/2) + (g.getFontMetrics().getStringBounds(this.getText(), g).getHeight()/2)));
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	public boolean isInMe(int x, int y){
		return ((x > this.x) && x <= (this.x + this.width)) && ((y > this.y) && y <= (this.y + this.height));
	}

	public String getCmd() {
		return this.cmd;
	}

	/**
	 * @param cmd the cmd to set
	 */
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	@Override
	public String toString(){
		return "[X|" + this.getX() + "][Y|" + this.getY() + "][W|" + this.getWidth() + "][H|" + this.getHeight() + "][T|" + this.getText() + "][C|" + this.getCmd() + "]";
	}
	
}
