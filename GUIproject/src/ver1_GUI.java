import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JButton;

import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.JPanel;

import java.awt.Component;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JScrollBar;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;

public class ver1_GUI {

	private JFrame frame;
	private JTextField Mem_Address;
	private JTextField Mem_value;
	private JTextField PSWH;
	private JTextField PSWL;
	private JTextField PC;
	private JTextField B;
	private JTextField C;
	private JTextField D;
	private JTextField E;
	private JTextField H;
	private JTextField L;
	private JTextField SP;
	private JTextField IR;
	private JTextField S;
	private JTextField Z;
	private JTextField AC;
	private JTextField P;
	private JTextField C_flag;
	
	Microprocessor up;
	Memory memory;
	private JTextField FLAG;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ver1_GUI window = new ver1_GUI();
					window.frame.setVisible(true);
					UIManager.setLookAndFeel(
	                        UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ver1_GUI() {

		  //String filename = (args.length > 0) ? args[0] : "asm/test.asm";
          //String datafilename = (args.length > 1) ? args[1] : "asm/testdata.asm";
          //Parser asmParser = new Parser(filename,true,"asm");
          //Parser dataParser = new Parser(datafilename,true,"data");

          up = new Microprocessor();

		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(UIManager.getColor("Button.background"));
		frame.setBounds(0, 0, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel tools_panel = new JPanel();
		tools_panel.setBounds(0, 0, 1201, 33);
		tools_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frame.getContentPane().add(tools_panel);
		
		
		
		JButton close = new JButton();
		close.setBounds(547, 5, 39, 25);
		
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ess) {
				  
			}
		});
		close.setToolTipText("Stop");
		try
		{
			Image imgs = ImageIO.read(getClass().getResource("stop1.png"));
			close.setIcon(new ImageIcon(imgs));
		}
		catch  (IOException ex) {}
		tools_panel.setLayout(null);
		close.setBorder(null);
		tools_panel.add(close);
		try
		{
			Image imgs = ImageIO.read(getClass().getResource("prev.png"));
		}
		catch  (IOException ex) {}
		try
		{
			Image imgs = ImageIO.read(getClass().getResource("next.png"));
		}
		catch  (IOException ex) {}
		
		JScrollPane Message_scrollPane = new JScrollPane();
		Message_scrollPane.setBounds(0, 500, 1200, 199);
		Message_scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frame.getContentPane().add(Message_scrollPane);
		
		final JTextArea ErrorMessages = new JTextArea();
		ErrorMessages.setText("Error Pane!\n");
		ErrorMessages.setEditable(false);
		Message_scrollPane.setViewportView(ErrorMessages);
		
		JPanel Memory_panel = new JPanel();
		Memory_panel.setBounds(0, 32, 239, 466);
		Memory_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frame.getContentPane().add(Memory_panel);
		Memory_panel.setLayout(null);
		
		JLabel lblMemory = new JLabel("MEMORY");
		lblMemory.setBounds(81, 12, 70, 15);
		Memory_panel.add(lblMemory);
		
		Mem_Address = new JTextField();
		Mem_Address.setBounds(113, 62, 70, 25);
		Mem_Address.setToolTipText("Memory location");
		Mem_Address.setText("0000");
		Mem_Address.setEditable(false);
		Mem_Address.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Mem_Address.setBackground(UIManager.getColor("Button.highlight"));
		Memory_panel.add(Mem_Address);
		Mem_Address.setColumns(10);
		
		Mem_value = new JTextField();
		Mem_value.setBounds(113, 129, 70, 25);
		Mem_value.setToolTipText("Edit new value and click update");
		Mem_value.setText("0000");
		Mem_value.setEditable(false);
		Mem_value.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Mem_value.setBackground(UIManager.getColor("Button.highlight"));
		Memory_panel.add(Mem_value);
		Mem_value.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(32, 67, 70, 15);
		Memory_panel.add(lblLocation);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(32, 134, 70, 15);
		Memory_panel.add(lblValue);
		
		JPanel Reg_panel = new JPanel();
		Reg_panel.setBounds(996, 32, 204, 232);
		Reg_panel.setToolTipText("Current register status");
		Reg_panel.setBackground(UIManager.getColor("Button.background"));
		Reg_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frame.getContentPane().add(Reg_panel);
		Reg_panel.setLayout(null);
		
		JLabel lblRegisters = new JLabel("REGISTERS");
		lblRegisters.setBounds(63, 0, 90, 29);
		Reg_panel.add(lblRegisters);
		
		JLabel Psw_lbl = new JLabel("PSW");
		Psw_lbl.setBounds(43, 41, 38, 20);
		Reg_panel.add(Psw_lbl);
		
		JLabel Bc_lbl = new JLabel("BC");
		Bc_lbl.setBounds(43, 62, 38, 20);
		Reg_panel.add(Bc_lbl);
		
		JLabel De_lbl = new JLabel("DE");
		De_lbl.setBounds(43, 82, 38, 20);
		Reg_panel.add(De_lbl);
		
		JLabel Hl_lbl = new JLabel("HL");
		Hl_lbl.setBounds(43, 104, 38, 20);
		Reg_panel.add(Hl_lbl);
		
		JLabel Sp_lbl = new JLabel("SP");
		Sp_lbl.setBounds(43, 123, 38, 20);
		Reg_panel.add(Sp_lbl);
		
		JLabel Ir_lbl = new JLabel("IR");
		Ir_lbl.setBounds(43, 164, 38, 20);
		Reg_panel.add(Ir_lbl);
		
		JLabel PC_lbl = new JLabel("PC");
		PC_lbl.setBounds(43, 143, 38, 20);
		Reg_panel.add(PC_lbl);
		
		PSWH = new JTextField();
		PSWH.setBackground(UIManager.getColor("Button.background"));
		PSWH.setBorder(new EmptyBorder(0, 0, 0, 0));
		PSWH.setText("00");
		PSWH.setEditable(false);
		PSWH.setBounds(99, 42, 29, 19);
		Reg_panel.add(PSWH);
		PSWH.setColumns(10);
		
		PSWL = new JTextField();
		PSWL.setBackground(UIManager.getColor("Button.background"));
		PSWL.setBorder(new EmptyBorder(0, 0, 0, 0));
		PSWL.setText("00");
		PSWL.setEditable(false);
		PSWL.setColumns(10);
		PSWL.setBounds(140, 42, 29, 19);
		Reg_panel.add(PSWL);
		
		B = new JTextField();
		B.setBackground(UIManager.getColor("Button.background"));
		B.setBorder(new EmptyBorder(0, 0, 0, 0));
		B.setText("00");
		B.setEditable(false);
		B.setColumns(10);
		B.setBounds(99, 63, 29, 19);
		Reg_panel.add(B);
		
		C = new JTextField();
		C.setBorder(new EmptyBorder(0, 0, 0, 0));
		C.setBackground(UIManager.getColor("Button.background"));
		C.setText("00");
		C.setEditable(false);
		C.setColumns(10);
		C.setBounds(140, 63, 29, 19);
		Reg_panel.add(C);
		
		D = new JTextField();
		D.setBackground(UIManager.getColor("Button.background"));
		D.setBorder(new EmptyBorder(0, 0, 0, 0));
		D.setText("00");
		D.setEditable(false);
		D.setColumns(10);
		D.setBounds(99, 83, 29, 19);
		Reg_panel.add(D);
		
		E = new JTextField();
		E.setBorder(new EmptyBorder(0, 0, 0, 0));
		E.setBackground(UIManager.getColor("Button.background"));
		E.setText("00");
		E.setEditable(false);
		E.setColumns(10);
		E.setBounds(140, 83, 28, 19);
		Reg_panel.add(E);
		
		H = new JTextField();
		H.setBorder(new EmptyBorder(0, 0, 0, 0));
		H.setBackground(UIManager.getColor("Button.background"));
		H.setText("00");
		H.setEditable(false);
		H.setColumns(10);
		H.setBounds(99, 105, 29, 19);
		Reg_panel.add(H);
		
		L = new JTextField();
		L.setBorder(new EmptyBorder(0, 0, 0, 0));
		L.setBackground(UIManager.getColor("Button.background"));
		L.setText("00");
		L.setEditable(false);
		L.setColumns(10);
		L.setBounds(140, 105, 29, 19);
		Reg_panel.add(L);
		
		SP = new JTextField();
		SP.setBackground(UIManager.getColor("Button.background"));
		SP.setBorder(new EmptyBorder(0, 0, 0, 0));
		SP.setText("00");
		SP.setEditable(false);
		SP.setColumns(10);
		SP.setBounds(99, 124, 70, 19);
		Reg_panel.add(SP);
		
		IR = new JTextField();
		IR.setBackground(UIManager.getColor("Button.background"));
		IR.setBorder(new EmptyBorder(0, 0, 0, 0));
		IR.setText("00");
		IR.setEditable(false);
		IR.setColumns(10);
		IR.setBounds(99, 165, 29, 19);
		Reg_panel.add(IR);
		
		PC = new JTextField();
		PC.setBounds(99, 144, 70, 19);
		Reg_panel.add(PC);
		PC.setBorder(new EmptyBorder(0, 0, 0, 0));
		PC.setBackground(UIManager.getColor("Button.background"));
		PC.setText("00");
		PC.setEditable(false);
		PC.setColumns(10);
		
		FLAG = new JTextField();
		FLAG.setHorizontalAlignment(SwingConstants.CENTER);
		FLAG.setEditable(false);
		FLAG.setColumns(10);
		FLAG.setBorder(new EmptyBorder(0, 0, 0, 0));
		FLAG.setBackground(UIManager.getColor("Button.background"));
		FLAG.setBounds(43, 196, 124, 19);
		Reg_panel.add(FLAG);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(244, 32, 750, 466);
		frame.getContentPane().add(tabbedPane);
		
		JScrollPane opcode_scrollPane = new JScrollPane();
		tabbedPane.addTab("OP-Code", null, opcode_scrollPane, null);
		
		final JTextArea Opcode = new JTextArea();
		Opcode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Opcode.setText("");
			}
		});
		//Opcode.setText("Op-Code text");
		opcode_scrollPane.setViewportView(Opcode);
		
		JScrollPane Hex_scrollPane = new JScrollPane();
		tabbedPane.addTab("HEX", null, Hex_scrollPane, null);
		
		final JTextArea Hex = new JTextArea();
		Hex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hex.setText("");
			}
		});
		Hex.setText("HEX code");
		Hex_scrollPane.setViewportView(Hex);
		
		
		
		JButton SingleStep = new JButton();
		SingleStep.setBounds(447, 5, 39, 25);
		tools_panel.add(SingleStep);
		SingleStep.setBorder(null);
		SingleStep.setToolTipText("Single Step");
		try
		{
			Image imgs = ImageIO.read(getClass().getResource("SS1.png"));
			SingleStep.setIcon(new ImageIcon(imgs));
		}
		catch  (IOException ex) {}

		
		JButton execute = new JButton();
		execute.setBounds(496, 5, 39, 25);
		tools_panel.add(execute);
		execute.setToolTipText("Execute");
		execute.setBorder(null);
		try
		{
			Image imgs = ImageIO.read(getClass().getResource("exec2.png"));
			execute.setIcon(new ImageIcon(imgs));
			
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBackground(UIManager.getColor("Button.background"));
			panel.setBounds(996, 259, 205, 239);
			frame.getContentPane().add(panel);
			
			JLabel label = new JLabel("PPI");
			label.setBounds(81, 12, 43, 15);
			panel.add(label);
			
			JLabel label_1 = new JLabel("Port A");
			label_1.setBounds(32, 59, 51, 15);
			panel.add(label_1);
			
			JLabel label_2 = new JLabel("Port B");
			label_2.setBounds(32, 101, 51, 15);
			panel.add(label_2);
			
			JLabel label_3 = new JLabel("Port C");
			label_3.setBounds(32, 148, 51, 15);
			panel.add(label_3);
			
			textField = new JTextField();
			textField.setEditable(false);
			textField.setColumns(10);
			textField.setBounds(101, 55, 70, 19);
			panel.add(textField);
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setColumns(10);
			textField_1.setBounds(101, 102, 70, 19);
			panel.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setColumns(10);
			textField_2.setBounds(101, 144, 70, 19);
			panel.add(textField_2);
			
			JButton button = new JButton("Update");
			button.setBounds(42, 184, 117, 25);
			panel.add(button);
		}
		catch  (IOException ex) {}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		SingleStep.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				try {

					 if(!up.active){
						 memory = new Memory(65536);    
				          Connector.connect(up,memory);
				            
						Parser asmParser = new Parser(Opcode.getText(),false,"asm");
						memory.load(new Register16(0x8000),asmParser.value());
						//memory.print(new Register16(0x8000), 10);
						
			            String output = new String();
			            for ( int val: asmParser.value())
			            	output += new Register8(val).hex()+" ";
			            Hex.setText(output);
			            
			            ErrorMessages.setText( ErrorMessages.getText()+"Build Successful!\n");
			            
		
			            memory.start();
					}
						 
						 
						 up.startonce(new Register16(0x8000),false,false);
			            	PSWH.setText( up.register[7].hex());
			            	PSWL.setText( up.flag.hex() );
			            	
			            	PC.setText( up.pc.hex());
			            	SP.setText( up.sp.hex());
			            	IR.setText( up.ir.hex());
			            	
			            	B.setText( up.register[0].hex());
			            	C.setText( up.register[1].hex());
			            	D.setText( up.register[2].hex());
			            
			            	E.setText( up.register[3].hex());
			            	H.setText( up.register[4].hex());
			            	L.setText( up.register[5].hex());
			            	
			            	FLAG.setText( up.flag.value());
			            	
			            up.release();
			            // up.print(true);
		            
					} catch (IOException ee){
						 ErrorMessages.setText(ErrorMessages.getText()+ee.getMessage()+"\n");
					} catch (ParseException ee){
						 ErrorMessages.setText(ErrorMessages.getText()+ee.getMessage()+"\n");
					}
				 catch (InterruptedException ee){
					 ErrorMessages.setText(ErrorMessages.getText()+ee.getMessage()+"\n");
				}

			}
		});
		
		
		
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				up.active = false;
			}
		});
		
		execute.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
	            	
	            	

				try {

	           
	            	
					 if(!up.active){
						 memory = new Memory(65536);    
				          Connector.connect(up,memory);
				            
						Parser asmParser = new Parser(Opcode.getText(),false,"asm");
						memory.load(new Register16(0x8000),asmParser.value());
						//memory.print(new Register16(0x8000), 10);
						
			            String output = new String();
			            for ( int val: asmParser.value())
			            	output += new Register8(val).hex()+" ";
			            Hex.setText(output);
			            
			            ErrorMessages.setText( ErrorMessages.getText()+"Build Successful!\n");
			            
		
			            memory.start();
					}
						 
						 do {
						 up.startonce(new Register16(0x8000),false,false);
			            	PSWH.setText( up.register[7].hex());
			            	PSWL.setText( up.flag.hex() );
			            	
			            	PC.setText( up.pc.hex());
			            	SP.setText( up.sp.hex());
			            	IR.setText( up.ir.hex());
			            	
			            	B.setText( up.register[0].hex());
			            	C.setText( up.register[1].hex());
			            	D.setText( up.register[2].hex());
			            
			            	E.setText( up.register[3].hex());
			            	H.setText( up.register[4].hex());
			            	L.setText( up.register[5].hex());
			            	
			            	FLAG.setText( up.flag.value());
						 } while (up.active);
			            up.release();
			            // up.print(true);
		            
					} catch (IOException ee){
						 ErrorMessages.setText(ErrorMessages.getText()+ee.getMessage()+"\n");
					} catch (ParseException ee){
						 ErrorMessages.setText(ErrorMessages.getText()+ee.getMessage()+"\n");
					}
				 catch (InterruptedException ee){
					 ErrorMessages.setText(ErrorMessages.getText()+ee.getMessage()+"\n");
				}
	           
	            	

	            	
	            	
	            
	            
	            	
	       
			}
		});

	}
}
