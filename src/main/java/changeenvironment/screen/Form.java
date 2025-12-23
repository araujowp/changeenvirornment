package changeenvironment.screen;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public interface Form {

	void addControls(JFrame frame);

	void configControls(JFrame frame);

	JFrame getFrame();

	static JLabel createLabel(String text) {
		JLabel myLabel = new JLabel(text);
		myLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		myLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		return myLabel;
	}
	
	static JLabel createLabelTitle(String text) {
		JLabel myLabel = createLabel(text);
		myLabel.setFont(new Font("Arial", Font.BOLD, 14));
		return myLabel;
	}

	static JPanel addLine() {
		return addLine(15);
	}

	static JPanel addLine(int height) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setOpaque(false);
		
		Dimension tamanhoMaximo = new Dimension(Integer.MAX_VALUE, height);
		panel.setMaximumSize(tamanhoMaximo);
		panel.setPreferredSize(new Dimension(400, height));
		panel.setMinimumSize(new Dimension(200, height));

		return panel;
	}

}
