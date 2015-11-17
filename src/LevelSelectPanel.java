import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelSelectPanel extends JPanel{
	public LevelSelectPanel(){
		Dimension size = getPreferredSize();
		size.width = 150;
		size.height = 100;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Hallo Persoon"));
		
		JLabel nameLabel = new JLabel("Name: ");
		//add.nameLabel;
//		setLayout(new BorderLayout());
//		
//		GridBagConstraints gbc = new GridBagConstraints();
//		add(nameLabel, gbc);
	}
}
