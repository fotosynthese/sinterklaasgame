import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	JButton startButton;
	private int behaaldeSterren = 0;
	private int recordStappen = 0;
	JLabel levelLabel;
	BufferedImage legeWortel;
	BufferedImage volleWortel;
	BufferedImage startButtonImg;
	JLabel sterrenLabel;
	JLabel wortelLabel1;
	JLabel wortelLabel2;
	JLabel wortelLabel3;
	
	
	public ButtonPanel(String level){
		try {
			legeWortel = ImageIO.read(getClass().getResourceAsStream("/legeWortel.png"));
			volleWortel = ImageIO.read(getClass().getResourceAsStream("/wortel.png"));
			startButtonImg = ImageIO.read(getClass().getResourceAsStream("/startBtn.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		wortelLabel1 = new JLabel(new ImageIcon(legeWortel));
		wortelLabel2 = new JLabel(new ImageIcon(legeWortel));
		wortelLabel3 = new JLabel(new ImageIcon(legeWortel));
		//wortelLabel1.setIcon(new ImageIcon(volleWortel));
		Dimension size = getPreferredSize();
		//Color.BLACK;
		size.width = 300;
		size.height = 100;
		setPreferredSize(size);
		Color myRandomTurqoise = new Color(255, 255, 100);
		setBackground(myRandomTurqoise);  
		setBorder(BorderFactory.createTitledBorder("Level " + level));
		
		levelLabel = new JLabel("Stappen: " +recordStappen);
		sterrenLabel = new JLabel("Aantal sterren: " + behaaldeSterren);
		
		startButton = new JButton(new ImageIcon(startButtonImg));
		startButton.setMargin(new Insets(-3,-3,-3,-3));
		//startButton.addActionListener();
		startButton.setActionCommand(level);
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//// First colum //////////////////////
		//gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 1;
		gbc.weighty = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(wortelLabel1, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(wortelLabel2, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(wortelLabel3, gbc);
		
		gbc.weightx = 10;
		gbc.gridx = 1;
		gbc.gridy = 1;		
		add(levelLabel, gbc);
			
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(startButton, gbc);

	}
//	public void paintComponent(Graphics g){
//		setBackground(Color.ORANGE); 
//		g.drawImage(legeWortel, 20, 20, null);
//		g.drawImage(legeWortel, 80, 20, null);
//	}
	public int getBehaaldeSterren() {
		//levelLabel.setText("Behaalde sterren: " + behaaldeSterren);
		return behaaldeSterren;

	}

	public void setBehaaldeSterren(int behaaldeSterren) {
		levelLabel.setText("Stappen: " +behaaldeSterren);
		switch(behaaldeSterren){
		case 1:
			wortelLabel1.setIcon(new ImageIcon(volleWortel));	
			break;
		case 2:
			wortelLabel1.setIcon(new ImageIcon(volleWortel));
			wortelLabel2.setIcon(new ImageIcon(volleWortel));
			break;
		case 3:
			wortelLabel1.setIcon(new ImageIcon(volleWortel));
			wortelLabel2.setIcon(new ImageIcon(volleWortel));
			wortelLabel3.setIcon(new ImageIcon(volleWortel));	
		}
		this.behaaldeSterren = behaaldeSterren;
	}
	public int getRecordStappen() {
		return recordStappen;
	}
	public void setRecordStappen(int recordStappen) {
		levelLabel.setText("Stappen: " +recordStappen);
		if (recordStappen > this.recordStappen){
			this.recordStappen = recordStappen;			
		}
	}
}
