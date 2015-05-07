import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener {

	public final int numberOfColumns = 12;
	public JPanel contentPane;
	public JPanel buttons;
	public JButton selectColumn;
	public FieldStatus status = FieldStatus.P1;
	public VierGPanel vierGPanel;
	public boolean columnfull = false;

	public static Window instance;
	
	public static void main(String[] args) {
		Window frame = new Window("Vier Gewinnt");
		frame.setVisible(true);
	}

	public Window(String title) {
		super(title);
		instance = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(numberOfColumns * 70 + 25, numberOfColumns * 3 / 4 * 70 + 120);
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		vierGPanel = new VierGPanel(numberOfColumns, this);
		contentPane.add(vierGPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String label;
		label = e.getActionCommand();
		for (int i = 0; i < numberOfColumns; i++) {
			if (label.equals("row" + i)) {
				for (int a = (numberOfColumns*3/4)-1; a >= 0; a--) {
					if (vierGPanel.getColumnsArray()[i].getColumn()[a].getStatus() == FieldStatus.Empty) {
						if (status == FieldStatus.P1) {
							vierGPanel.getColumnsArray()[i].getColumn()[a].setStatus(FieldStatus.P1);
							vierGPanel.getColumnsArray()[i].getColumn()[a].setColor(Color.RED);
							status = FieldStatus.P2;
							columnfull = true;
							break;
						} else if (status == FieldStatus.P2) {
							vierGPanel.getColumnsArray()[i].getColumn()[a].setStatus(FieldStatus.P2);
							vierGPanel.getColumnsArray()[i].getColumn()[a].setColor(Color.GREEN);
							status = FieldStatus.P1;
							columnfull = true;
							break;
						}
					}
				}
				if(columnfull == false)
					JOptionPane.showMessageDialog(null,"Bitte wählen sie eine andere Spalte!","Spalte Voll",JOptionPane.WARNING_MESSAGE);
				columnfull = false;
				break;
			}
		}
		this.repaint();
	}
}
