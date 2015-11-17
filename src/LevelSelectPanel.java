import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelSelectPanel extends JPanel{
	
	JLabel nameLabel;
	private int paardStappen;
	public LevelSelectPanel(){
		Dimension size = getPreferredSize();
		size.width = 150;
		size.height = 100;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Hallo Sinterklaas!"));
		
		nameLabel = new JLabel("Amerigo heeft " + paardStappen + " stappen gezet!");
		//add.nameLabel;
//		setLayout(new BorderLayout());
//		
//		GridBagConstraints gbc = new GridBagConstraints();
		add(nameLabel);
	}
	public int getPaardStappen() {
		return paardStappen;
	}
	public void setPaardStappen(int paardStappen) {
		nameLabel.setText("Amerigo heeft " + paardStappen + " stappen gezet!");
		this.paardStappen = paardStappen;
	}
}
