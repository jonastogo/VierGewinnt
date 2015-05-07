import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;


public class VierGPanel extends JPanel implements MouseListener{
	
	public int numberOfColumns;
	public int columnHeight;
	public ColumnOfFields[] columnsArray;
	private Window parent;
	
	private ArrayList<PanelButton> buttons = new ArrayList<PanelButton>();
	
	public VierGPanel(int numberOfColumns, Window w){
		this.parent = w;
		this.numberOfColumns = numberOfColumns;
		this.columnHeight = numberOfColumns*3/4;
		columnsArray = new ColumnOfFields[numberOfColumns];
		for(int i = 0; i < numberOfColumns; i++){
			columnsArray[i] = new ColumnOfFields(columnHeight, i);
			buttons.add(new PanelButton(10+(i*70)+5,(int) columnHeight * 70 + 30,60,40,"Spalte " + (i+1), "row" + i));
		}
		this.addMouseListener(this);
	}
	@Override
	protected void paintComponent(Graphics g_){
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		for(ColumnOfFields cOF: columnsArray){
			for(int i = 0; i < cOF.getColumn().length; i++)
			cOF.getColumn()[i].draw(g);
		}
		for(PanelButton b : this.buttons){
			b.droaw(g);
		}
		String player = "Spieler " + (this.parent.status.ordinal() + 1) + " ist an der Reihe!";
		g.setColor(Color.BLACK);
		g.drawString(player, (int) (14 + this.getBounds().getX()), (int) (this.getBounds().getY() + this.getBounds().getHeight() - g.getFontMetrics().getStringBounds(player, g).getHeight() + 13));
	}
	public int getNumberOfColumns() {
		return numberOfColumns;
	}
	public void setNumberOfColumns(int numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}
	public int getColumnHeight() {
		return columnHeight;
	}
	public void setColumnHeight(int columnHeight) {
		this.columnHeight = columnHeight;
	}
	public ColumnOfFields[] getColumnsArray() {
		return columnsArray;
	}
	public void setColumnsArray(ColumnOfFields[] columnsArray) {
		this.columnsArray = columnsArray;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		for(PanelButton b : this.buttons){
			if(b.isInMe(x,y)){
				this.parent.actionPerformed(new ActionEvent("button", ActionEvent.ACTION_PERFORMED, b.getCmd()));
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
