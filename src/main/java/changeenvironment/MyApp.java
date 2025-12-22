package changeenvironment;

import java.awt.Image;
import java.awt.Taskbar;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyApp {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Change Environment");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new JLabel("Your environment", JLabel.CENTER));
		frame.setSize(400, 300);

		try {
			URL url = MyApp.class.getResource("/images/engrenagem.png"); // caminho que está funcionando!

			if (url != null) {
				Image iconImage = new ImageIcon(url).getImage();

				frame.setIconImage(iconImage);
				setTaskbarIcon(iconImage);
			} else {
				System.err.println("Ícone não encontrado!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}

		frame.setVisible(true);
	}

	/**
	 * set the task bar icon, but its works only java 9+*/
	private static void setTaskbarIcon(Image iconImage) {
		
		try {			
			if (Taskbar.isTaskbarSupported()) {
				Taskbar taskbar = Taskbar.getTaskbar();
				if (taskbar.isSupported(Taskbar.Feature.ICON_IMAGE)) {
					taskbar.setIconImage(iconImage);
				}
			}
		}catch(Throwable t) {
			System.err.println("Ícone não encontrado!");			
		}
		

	}

}
