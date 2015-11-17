import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	JButton startButton;
	private int behaaldeSterren = 0;
	JLabel levelLabel;
	
	public ButtonPanel(String level){
		Dimension size = getPreferredSize();
		//Color.BLACK;
		size.width = 300;
		size.height = 100;
		setPreferredSize(size);
		setBackground(Color.ORANGE);  
		setBorder(BorderFactory.createTitledBorder("Level " + level));
		
		levelLabel = new JLabel("Behaalde sterren: " + behaaldeSterren);
		
		startButton = new JButton("START!");
		//startButton.addActionListener();
		startButton.setActionCommand(level);
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//// First colum //////////////////////
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		add(levelLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(startButton, gbc);
	}

	public int getBehaaldeSterren() {
		//levelLabel.setText("Behaalde sterren: " + behaaldeSterren);
		return behaaldeSterren;

	}

	public void setBehaaldeSterren(int behaaldeSterren) {
		levelLabel.setText("Behaalde sterren: " + behaaldeSterren);
		this.behaaldeSterren = behaaldeSterren;
	}
}
