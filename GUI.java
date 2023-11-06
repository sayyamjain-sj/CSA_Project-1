import java.awt.EventQueue;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.Dimension;

public class GUI extends JFrame {     
	
	private JTextField PC;
	private JTextField IR;
	private JTextField GPR0; 
	private JTextField GPR1;
	private JTextField GPR2;
	private JTextField GPR3;
	private JTextField IXR1;
	private JTextField IXR2;
	private JTextField IXR3;
	private JTextField MAR;                         
	private JTextField MBR;
	private JTextField halt;
	private JTextField Run;
	private JTextField textField;
	private JTextField textField1;
	
	
	static int pc;
	static int mar;
	static int mbr; 
	static int ir;
	private JPanel frame;
	static int memoryStart;
	private JTextField Input_text;
	static int[] gpr =new int[4];
	static int[] ixr =new int[4];
	static int[] memory=new int[4096];
	private static final long serialVersionUID = 1L;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 525);
		frame = new JPanel();
		frame.setAutoscrolls(true);
		frame.setPreferredSize(new Dimension(100, 100));
		frame.setSize(new Dimension(500, 100));
		frame.setSize(1000, 1000);
		frame.setBorder(new EmptyBorder(10, 5, 5, 5));

		setContentPane(frame);
		frame.setLayout(null);
		
		JLabel MARLabel = new JLabel("MAR");                       //MAR Label created
		MARLabel.setBounds(693, 38, 52, 26);
		frame.add(MARLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MBR");                  //MBR Label created
		lblNewLabel_1.setBounds(693, 76, 45, 14);
		frame.add(lblNewLabel_1);
		
		
		Input_text = new JTextField();
		Input_text.setBounds(119, 431, 298, 26);
		frame.add(Input_text);
		Input_text.setColumns(10);
		
		JButton MAR_load = new JButton("LOAD");                     
		MAR_load.setBounds(732, 41, 92, 21);
		MAR_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String st = Input_text.getText();
			MAR.setText(st);
			mar=Integer.parseInt(st,2);                           //Converting string into integer using parse
			}
		});
		frame.add(MAR_load);
		
		JButton MBR_load = new JButton("LOAD");                    
		MBR_load.setBounds(732, 73, 92, 21);
		MBR_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st1=Input_text.getText();
				MBR.setText(st1);
				mbr=Integer.parseInt(st1,2);                     //Converting string into integer using parse
			}
		});
		frame.add(MBR_load);
		
		JButton btnNewButton = new JButton("LOAD");             //Creating the new Load button in simulator
		btnNewButton.setBounds(637, 362, 108, 20);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			mbr=memory[Integer.parseInt(MAR.getText(),2)];
			int mbl=16-Integer.toBinaryString(mbr).length();
			String mbx="";
			for(int i=0;i<mbl;i++)
			{
				mbx=mbx+"0";
			}
			mbx=mbx+Integer.toBinaryString(mbr);
			MBR.setText(mbx);
			}
		});
		frame.add(btnNewButton);
		
		MAR = new JTextField();                          //Assigning the MAR value to the text field
		MAR.setBounds(517, 41, 166, 20);
		frame.add(MAR);
		MAR.setColumns(10);
		
		MBR = new JTextField();                          //Assigning the MBR value to the text field
		MBR.setBounds(517, 73, 166, 20);
		frame.add(MBR);
		MBR.setColumns(10);
		
		JButton PC_Load = new JButton("LOAD");
		PC_Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st6 = Input_text.getText();
				PC.setText(st6);
				pc=Integer.parseInt(st6,2);
			}
		});
		PC_Load.setBounds(732, 13, 92, 23);
		frame.add(PC_Load);
		
		JLabel lblNewLabel = new JLabel("PC");                //Creating the PC label
		lblNewLabel.setBounds(693, 15, 52, 18);
		frame.add(lblNewLabel);
		
		PC = new JTextField();                          //Assigning the PC value to the text field
		PC.setBounds(517, 10, 166, 20);
		frame.add(PC);
		PC.setColumns(10);
		
		IR = new JTextField();                         //Assigning the IR value to the text field
		IR.setBounds(517, 114, 166, 20);
		frame.add(IR);
		IR.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("IR");             //Creating the IR labeL
		lblNewLabel_2.setBounds(693, 117, 60, 14);
		frame.add(lblNewLabel_2);
		
		textField = new JTextField();         
		textField.setBounds(592, 156, 84, 20);
		frame.add(textField);
		textField.setColumns(10);
		
		textField1 = new JTextField();
		textField1.setBounds(637, 192, 38, 20);
		frame.add(textField1);
		textField1.setColumns(10);
		
		GPR0 = new JTextField();                     //Assigning the GPR0 value to the text field
		GPR0.setBounds(82, 14, 254, 20);
		frame.add(GPR0);
		GPR0.setColumns(10);
		 
		GPR1 = new JTextField();                     //Assigning the GPR1 value to the text field
		GPR1.setBounds(82, 55, 254, 20);
		frame.add(GPR1);
		GPR1.setColumns(10);
		
		GPR2 = new JTextField();                     //Assigning the GPR2 value to the text field
		GPR2.setBounds(82, 95, 254, 20);
		frame.add(GPR2);
		GPR2.setColumns(10);
		
		GPR3 = new JTextField();                     //Assigning the GPR3 value to the text field
		GPR3.setBounds(82, 137, 254, 20);
		frame.add(GPR3);
		GPR3.setColumns(10);
		
		IXR1= new JTextField();                     //Assigning the IXR1 value to the text field
		IXR1.setBounds(82, 174, 254, 20);
		frame.add(IXR1);
		IXR1.setColumns(10);
		
		IXR2= new JTextField();                    //Assigning the IXR2 value to the text field
		IXR2.setBounds(82, 217, 254, 20);
		frame.add(IXR2);
		IXR2.setColumns(10);
		
		IXR3 = new JTextField();                    //Assigning the IXR3 value to the text field
		IXR3.setBounds(82, 258, 254, 20);
		frame.add(IXR3);
		IXR3.setColumns(10);
		
		JButton GPR0_Ld = new JButton("LOAD");
		GPR0_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st1 = Input_text.getText();
				GPR0.setText(st1);
				gpr[0]=Integer.parseInt(st1,2);
			}
		});
		GPR0_Ld.setBounds(349, 13, 68, 23);
		frame.add(GPR0_Ld);
		
		JButton GPR1_Ld = new JButton("LOAD");                  //Assigning the load operation on GPR1 field
		GPR1_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st2 = Input_text.getText();
				GPR1.setText(st2);
				gpr[1]=Integer.parseInt(st2,2);              //Converting string into integer using parse
			}
		});
		GPR1_Ld.setBounds(346, 54, 71, 23);
		frame.add(GPR1_Ld);
		
		JButton GPR2_Ld = new JButton("LOAD");                 //Assigning the load operation on GPR2 field
		GPR2_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st3 = Input_text.getText();
				GPR2.setText(st3);
				gpr[2]=Integer.parseInt(st3,2);               //Converting string into integer using parse
			}
		});
		GPR2_Ld.setBounds(349, 94, 68, 23);
		frame.add(GPR2_Ld);
		
		JButton GPR3_Ld = new JButton("LOAD");                  //Assigning the load operation on GPR3 field
		GPR3_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st4 = Input_text.getText();
				GPR3.setText(st4);
				gpr[3]=Integer.parseInt(st4,2);                //Converting string into integer using parse
			}
		});
		GPR3_Ld.setBounds(349, 136, 68, 23);
		frame.add(GPR3_Ld);
		
		JButton IXR1_Ld = new JButton("LOAD");                  //Assigning the load operation on IXR1 field
		IXR1_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st4 = Input_text.getText();
				IXR1.setText(st4);
				ixr[1]=Integer.parseInt(st4,2);               //Converting string into integer using parse
			}
		});
		IXR1_Ld.setBounds(349, 173, 68, 23);
		frame.add(IXR1_Ld);
		
		JButton IXR2_Load = new JButton("LOAD");               //Assigning the load operation on IXR2 field
		IXR2_Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st5 = Input_text.getText();
				IXR2.setText(st5);
				ixr[2]=Integer.parseInt(st5,2);              //Converting string into integer using parse
			}
		});
		IXR2_Load.setBounds(349, 216, 68, 23);
		frame.add(IXR2_Load);
		
		JButton IXR3_Ld = new JButton("LOAD");                //Assigning the load operation on IXR3 field
		IXR3_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st7 = Input_text.getText();
				IXR3.setText(st7);
				ixr[3]=Integer.parseInt(st7,2);             //Converting string into integer using parse
			}
		});
		IXR3_Ld.setBounds(349, 257, 68, 23);
		frame.add(IXR3_Ld);
		
		JLabel lblNewLabel_3 = new JLabel("R0");              //Creating a R0 label
		lblNewLabel_3.setBounds(27, 15, 45, 14);
		frame.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("R1");              //Creating a R1 label
		lblNewLabel_4.setBounds(27, 58, 49, 14);
		frame.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("R2");              //Creating a R2 label
		lblNewLabel_5.setBounds(27, 98, 49, 14);
		frame.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("R3");              //Creating a R3 label
		lblNewLabel_6.setBounds(27, 140, 49, 14);
		frame.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("IXR 1");              //Creating a IXR1 label
		lblNewLabel_7.setBounds(27, 177, 49, 14);
		frame.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("IXR 2");              //Creating a register IXR2 label
		lblNewLabel_8.setBounds(27, 220, 49, 14);
		frame.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("IXR 3");              //Creating a IXR3 label 
		lblNewLabel_9.setBounds(27, 261, 49, 14);
		frame.add(lblNewLabel_9);
		
		JButton btnNewButton_9 = new JButton("Store");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mar=Integer.parseInt(MAR.getText(),2);
				mbr=Integer.parseInt(MBR.getText(),2);
				memory[mar]=mbr;
			}
		});
		btnNewButton_9.setBounds(483, 361, 67, 23);
		frame.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("St+");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_10.setBounds(560, 361, 67, 23);
		frame.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("IPL");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc=3596;
				pc=Integer.parseInt(PC.getText(),2);
				int pcl=16-Integer.toBinaryString(pc).length();
				String pcx="";
				for(int i=0;i<pcl;i++)
				{
					pcx=pcx+"0";
				}
				pcx=pcx+Integer.toBinaryString(pc);
				PC.setText(pcx);
				GPR0.setText("0000000000000000");                      //Initializing the default values to zero into all fields
				GPR1.setText("0000000000000000");
				GPR2.setText("0000000000000000");
				GPR3.setText("0000000000000000");
				IXR1.setText("0000000000000000");
				IXR2.setText("0000000000000000");
				IXR3.setText("0000000000000000");
				MAR.setText("0000000000000000");
				MBR.setText("0000000000000000");
				IR.setText("0000000000000000");
				File f= new File("C:\\Users\\prana\\Downloads\\CSA_ProjectTeam\\CSA_ProjectTeam\\input.txt");              //Providing the location of the input file 
				try {
				Scanner s=new Scanner(f);
				while(s.hasNextLine())
				{
					String s1=s.nextLine();
					String[] sa=s1.split(" ");
					memory[Integer.parseInt(sa[0],16)]=Integer.parseInt(sa[1],16);	
				}
				s.close();
				}
				catch(Exception ex)
				{
					System.out.println("Exception occured in input file"+ex);
				}
			}
		});
		btnNewButton_11.setBounds(757, 361, 56, 23);
		frame.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("SS");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pcl=16-Integer.toBinaryString(pc).length();
				String pcx="";
				for(int i=0;i<pcl;i++)
				{
					pcx=pcx+"0";
				}
				pcx=pcx+Integer.toBinaryString(pc);
				PC.setText(pcx);
				MAR.setText(pcx);
				mar=pc;
				mbr=memory[mar];
				int mbl=16-Integer.toBinaryString(mbr).length();
				String mbrx="";
				for(int i=0;i<mbl;i++)
				{
					mbrx=mbrx+"0";
				}
				mbrx=mbrx+Integer.toBinaryString(mbr);
				MBR.setText(mbrx);
				ir=mbr;
				IR.setText(MBR.getText());
				int ai=16-Integer.toBinaryString(mbr).length();
				String ir16="";
				for(int i=0;i<ai;i++)
				{
					ir16=ir16+"0";
				}
				ir16=ir16+Integer.toBinaryString(mbr);
				short op=Short.parseShort(ir16.substring(0,6),2);
				short r=Short.parseShort(ir16.substring(6,8),2);
				short ix=Short.parseShort(ir16.substring(8,10),2);
				short ia=Short.parseShort(ir16.substring(10,11),2);
				short add=Short.parseShort(ir16.substring(11),2);
				int eadd=0;
				ixr[0]=0;
				switch(op)
				{
				case 0:
					System.out.println("Instructions are completed");
					break;
				case 1:
					if(ia==0)
					{
						eadd=(add+ixr[ix]);
					}	
					else if(ia==1)
					{
						eadd=memory[(add+ixr[ix])];
					}
					gpr[r]=memory[eadd];
					int mem16l=16-Integer.toBinaryString(gpr[r]).length();
					String mem16="";
					for(int i=0;i<mem16l;i++)
					{
						mem16=mem16+"0";
					}mem16=mem16+Integer.toBinaryString(gpr[r]);
					if(r==0)
					{
						GPR0.setText(mem16);
					}
					else if(r==1)
					{
						GPR1.setText(mem16);
					}
					else if(r==2)
					{
						GPR2.setText(mem16);
					}
					else if(r==3)
					{
						GPR3.setText(mem16);
					}
					break;
				case 2:
					if(ia==0)
					{
						eadd=(add+ixr[ix]);
					}	
					else if(ia==1)
					{
						eadd=memory[(add+ixr[ix])];
					}
					memory[eadd]=gpr[r];
					break;
				case 3:
					if(ia==0)
					{
						eadd=(add+ixr[ix]);
					}	
					else if(ia==1)
					{
						eadd=memory[(add+ixr[ix])];
					}
					gpr[r]=eadd;
					int mem163l=16-Integer.toBinaryString(gpr[r]).length();
					String mem163="";
					for(int i=0;i<mem163l;i++)
					{
						mem163=mem163+"0";
					}
					mem163=mem163+Integer.toBinaryString(gpr[r]);
					if(r==0)
					{
						GPR0.setText(mem163);
					}
					else if(r==1)
					{
						GPR1.setText(mem163);
					}
					else if(r==2)
					{
						GPR2.setText(mem163);
					}
					else if(r==3)
					{
						GPR3.setText(mem163);
					}
					break;
				case 41:
					if(ia==0)
					{
						eadd=(add);
					}	
					else if(ia==1)
					{
						eadd=memory[add];
					}
					ixr[r]=memory[eadd];
					int mem16xl=16-Integer.toBinaryString(ixr[r]).length();
					String mem16x="";
					for(int i=0;i<mem16xl;i++)
					{
						mem16x=mem16x+"0";
					}
					mem16x=mem16x+Integer.toBinaryString(ixr[r]);
					if(ix==1)
					{
						IXR1.setText(mem16x);
					}
					else if(ix==2)
					{
						IXR2.setText(mem16x);
					}
					else if(ix==3)
					{
						IXR3.setText(mem16x);
					}
					break;
				case 42:
					if(ia==0)
					{
						eadd=(add);
					}	
					else if(ia==1)
					{
						eadd=memory[add];
					}
					memory[eadd]=ixr[ix];
					break;
				}
				pc++;
			} 
		});
		btnNewButton_12.setBounds(587, 399, 89, 23);
		frame.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Run");                          //Creating new Run button
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Run:
				while(memoryStart-pc!=0)
				{
					int pcl=16-Integer.toBinaryString(pc).length();           //Converting integer to 16 bit binary value
					String pcx="";
					for(int i=0;i<pcl;i++)
					{
						pcx=pcx+"0";
					}
					pcx=pcx+Integer.toBinaryString(pc);
					PC.setText(pcx);
					MAR.setText(pcx);
					mar=pc;
					mbr=memory[mar];
					int mbl=16-Integer.toBinaryString(mbr).length();
					String mbrx="";
					for(int i=0;i<mbl;i++)
					{
						mbrx=mbrx+"0";
					}
					mbrx=mbrx+Integer.toBinaryString(mbr);
					MBR.setText(mbrx);
					ir=mbr;
					IR.setText(MBR.getText());
					int ai=16-Integer.toBinaryString(mbr).length();
					String ir16="";
					for(int i=0;i<ai;i++)
					{
						ir16=ir16+"0";
					}
					ir16=ir16+Integer.toBinaryString(mbr);
					short op=Short.parseShort(ir16.substring(0,6),2);
					short r=Short.parseShort(ir16.substring(6,8),2);
					short ix=Short.parseShort(ir16.substring(8,10),2);
					short ia=Short.parseShort(ir16.substring(10,11),2);
					short add=Short.parseShort(ir16.substring(11),2);
					int eadd=0;
					ixr[0]=0;
					switch(op)
					{
					case 0:
						System.out.println("Instructions are completed");
						break Run;
					case 1:
						if(ia==0)
						{
							eadd=(add+ixr[ix]);
						}	
						else if(ia==1)
						{
							eadd=memory[(add+ixr[ix])];
						}
						gpr[r]=memory[eadd];
						int mem16l=16-Integer.toBinaryString(gpr[r]).length();
						String mem16="";
						for(int i=0;i<mem16l;i++)
						{
							mem16=mem16+"0";
						}mem16=mem16+Integer.toBinaryString(gpr[r]);
						if(r==0)
						{
							GPR0.setText(mem16);
						}
						else if(r==1)
						{
							GPR1.setText(mem16);
						}
						else if(r==2)
						{
							GPR2.setText(mem16);
						}
						else if(r==3)
						{
							GPR3.setText(mem16);
						}
						break;
					case 2:
						if(ia==0)
						{
							eadd=(add+ixr[ix]);
						}	
						else if(ia==1)
						{
							eadd=memory[(add+ixr[ix])];
						}
						memory[eadd]=gpr[r];
						break;
					case 3:
						if(ia==0)
						{
							eadd=(add+ixr[ix]);
						}	
						else if(ia==1)
						{
							eadd=memory[(add+ixr[ix])];
						}
						gpr[r]=eadd;
						int mem163l=16-Integer.toBinaryString(gpr[r]).length();
						String mem163="";
						for(int i=0;i<mem163l;i++)
						{
							mem163=mem163+"0";
						}
						mem163=mem163+Integer.toBinaryString(gpr[r]);
						if(r==0)
						{
							GPR0.setText(mem163);
						}
						else if(r==1)
						{
							GPR1.setText(mem163);
						}
						else if(r==2)
						{
							GPR2.setText(mem163);
						}
						else if(r==3)
						{
							GPR3.setText(mem163);
						}
						break;
					case 41:
						if(ia==0)
						{
							eadd=(add+ixr[ix]);
						}	
						else if(ia==1)
						{
							eadd=memory[(add+ixr[ix])];
						}
						ixr[r]=memory[eadd];
						int mem16xl=16-Integer.toBinaryString(ixr[r]).length();
						String mem16x="";
						for(int i=0;i<mem16xl;i++)
						{
							mem16x=mem16x+"0";
						}
						mem16x=mem16x+Integer.toBinaryString(ixr[r]);
						if(ix==1)
						{
							IXR1.setText(mem16x);
						}
						else if(ix==2)
						{
							IXR2.setText(mem16x);
						}
						else if(ix==3)
						{
							IXR3.setText(mem16x);
						}
						break;
					case 42:
						if(ia==0)
						{
							eadd=(add+ixr[ix]);
						}	
						else if(ia==1)
						{
							eadd=memory[(add+ixr[ix])];
						}
						memory[eadd]=ixr[ix];
						break;
					}
					pc++;
				}
			}
		});
		btnNewButton_13.setBounds(587, 433, 89, 23);
		frame.add(btnNewButton_13);
		
		JLabel Halt = new JLabel("Halt");                        //Creating a Halt label and setting bounds
		Halt.setBounds(693, 410, 60, 14);
		frame.add(Halt);
		
		JLabel lblNewLabel_11 = new JLabel("Run");               //Creating a Run label and setting bounds to it.
		lblNewLabel_11.setBounds(693, 437, 60, 14);
		frame.add(lblNewLabel_11);
		
		halt= new JTextField();                          //Creating a Halt field and setting bounds
		halt.setBounds(757, 407, 29, 20);
		frame.add(halt);                                  //loading the Halt value into the Halt text field
		halt.setColumns(10);
		
		Run = new JTextField();                          //Creating a Run field and setting bounds    
		Run.setBounds(757, 434, 29, 20);
		frame.add(Run);                                  //loading the Run value into the Halt text field
		Run.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("MFR");             //Creating a MFR label and setting bounds
		lblNewLabel_12.setBounds(693, 159, 80, 14);
		frame.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Privileged");     //Creating a Privileged label and setting bounds
		lblNewLabel_13.setBounds(693, 195, 80, 14);
		frame.add(lblNewLabel_13);
	}
}
