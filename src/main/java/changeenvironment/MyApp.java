package changeenvironment;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Taskbar;
import java.net.URL;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyApp {

	static JLabel labelBanco = new JLabel("Banco de dados");
	static JLabel labelBancoDesc = new JLabel("meu banco");
	
	static JLabel labelCliente = new JLabel("Cliente AV");
	static JLabel labelClienteDesc = new JLabel("Descricao cliente");

	static JLabel labelBancoVS = new JLabel("Banco de dados VS");
	static JLabel labelBancoVSDesc = new JLabel("Banco de dados VS");
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Change Environment");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addControls(frame);
		configfields(frame);
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

	private static void configfields(JFrame frame) {
		
		labelBancoDesc.setText("Novo banco de dados");
        labelClienteDesc.setText("Cliente PROD");
        labelBancoVSDesc.setText("VisualSore 2025");
		frame.revalidate();
		frame.repaint();
	}

	private static void addControls(JFrame frame) {
		
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		labelBanco = new JLabel("Banco de dados");
		labelBancoDesc = new JLabel("meu banco");
		
		labelCliente = new JLabel("Cliente AV");
		labelClienteDesc = new JLabel("Descricao cliente");

		labelBancoVS = new JLabel("Banco de dados VS");
		labelBancoVSDesc = new JLabel("Banco de dados VS");

		labelBanco.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelBanco.setFont(new Font("Arial", Font.BOLD, 14));
		labelBancoDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelBancoDesc.setFont(new Font("Arial", Font.PLAIN, 12));
		
		labelCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelCliente.setFont(new Font("Arial", Font.BOLD, 14));
		labelClienteDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelClienteDesc.setFont(new Font("Arial", Font.PLAIN, 12));
		
		labelBancoVS.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelBancoVS.setFont(new Font("Arial", Font.BOLD, 14));
		labelBancoVSDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelBancoVSDesc.setFont(new Font("Arial", Font.PLAIN, 12));
		
		frame.add(Box.createVerticalStrut(20));
		JPanel linha1 = createLinha();
		linha1.add(labelBanco);
		linha1.add(Box.createHorizontalStrut(40));
		linha1.add(labelBancoDesc);
        frame.add(linha1);
        frame.add(Box.createVerticalStrut(15));
        
        JPanel linha2 = createLinha();
        linha2.add(labelCliente);
        linha2.add(Box.createHorizontalStrut(40));
        linha2.add(labelClienteDesc);
        frame.add(linha2);
        frame.add(Box.createVerticalStrut(15));
        
        JPanel linha3 = createLinha();
        linha3.add(labelBancoVS);
        linha3.add(Box.createHorizontalStrut(40));
        linha3.add(labelBancoVSDesc);
        frame.add(linha3);
        frame.add(Box.createVerticalStrut(15));
        
        frame.add(Box.createVerticalGlue());
	}
	
	private static JPanel createLinha() {
		JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setOpaque(false);
        
        int altura =15;
        Dimension tamanhoMaximo = new Dimension(Integer.MAX_VALUE, altura);
        panel.setMaximumSize(tamanhoMaximo);
        panel.setPreferredSize(new Dimension(400, altura));  // opcional: largura preferida
        panel.setMinimumSize(new Dimension(200, altura));
        
        return panel;
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
