package changeenvironment.screen;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import changeenvironment.TipoBancoDados;
import changeenvironment.file.ReadConf;

public class Home implements Form {

	private int height;
	private int with;

	public Home(int with, int height) {
		this.with = with;
		this.height = height;		
	}
	
	JLabel labelBanco = Form.createLabelTitle("Banco de dados");
	JLabel labelBancoDesc = Form.createLabel("meu banco");
	
	JLabel labelCliente = Form.createLabelTitle("Cliente AV");
	JLabel labelClienteDesc = Form.createLabel("Descricao cliente");

	JLabel labelEnvironment = Form.createLabelTitle("Ambiente");
	JLabel labelEnvironmentDesc = Form.createLabel("Ambiente descrição");

	JLabel labelBancoVS = Form.createLabelTitle("Banco de dados VS");
	JLabel labelBancoVSDesc = Form.createLabel("Banco de dados VS");
	
	@Override
	public void addControls(JFrame frame) {
		
		frame.add(Box.createVerticalStrut(20));
		JPanel linha1 = Form.addLine();
		linha1.add(labelBanco);
		linha1.add(Box.createHorizontalStrut(40));
		linha1.add(labelBancoDesc);
        frame.add(linha1);
        //frame.add(Box.createVerticalStrut(15));
        
        JPanel linha2 = Form.addLine();
        linha2.add(labelCliente);
        linha2.add(Box.createHorizontalStrut(40));
        linha2.add(labelClienteDesc);
        frame.add(linha2);
        //frame.add(Box.createVerticalStrut(15));
        
        JPanel linha3 = Form.addLine();
        linha3.add(labelEnvironment);
        linha3.add(Box.createHorizontalStrut(40));
        linha3.add(labelEnvironmentDesc);
        frame.add(linha3);
        //frame.add(Box.createVerticalStrut(15));
        
        JPanel linha4 = Form.addLine();
        linha4.add(labelBancoVS);
        linha4.add(Box.createHorizontalStrut(40));
        linha4.add(labelBancoVSDesc);
        frame.add(linha4);
        //frame.add(Box.createVerticalStrut(15));
        
        frame.add(Box.createVerticalGlue());
	}

	@Override
	public void configControls(JFrame frame) {
		byte bankNumber;
		
		ReadConf readConf = new ReadConf("C:/visualmix/config/vm_av_adm.conf");
		bankNumber = Byte.valueOf(readConf.getTag("DEFAULT.TIPOCONEXAO"));
		labelBancoDesc.setText(TipoBancoDados.getById(bankNumber).name());
		
        labelClienteDesc.setText(readConf.getTag("CLIENTE"));

        labelEnvironmentDesc.setText(readConf.getTag("AMBIENTE"));
        
        readConf = new ReadConf("C:/visualmix/config/VM_VisualStore_Adm.conf");
        bankNumber = Byte.valueOf(readConf.getTag("DEFAULT.TIPOCONEXAO"));
        labelBancoVSDesc.setText(TipoBancoDados.getById(bankNumber).name());
		frame.revalidate();
		frame.repaint();
	}

	@Override
	public JFrame getFrame() {
		
		JFrame frame = new JFrame("Change Environment");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		addControls(frame);
		configControls(frame);
		frame.setSize(with, height);
		return frame;
	}

}
