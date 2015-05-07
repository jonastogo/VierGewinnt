import java.awt.Color;


public class ColumnOfFields {
	public int cheight;
	public int row;
	public PaintableField[] column;
	
	public ColumnOfFields(int cheight , int row){
		this.cheight = cheight;
		this.row = row;
		column = new PaintableField[cheight];
		for(int i = 0; i < cheight; i++){
			column[i] = new PaintableField(20+row*70, 20+i*70, Color.WHITE);
		}
	}

	public int getCheight() {
		return cheight;
	}

	public void setCheight(int cheight) {
		this.cheight = cheight;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public PaintableField[] getColumn() {
		return column;
	}

	public void setColumn(PaintableField[] column) {
		this.column = column;
	}
}
