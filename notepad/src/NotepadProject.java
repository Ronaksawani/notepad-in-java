
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotepadProject extends JFrame implements ActionListener {

	JMenuBar mb;
	JMenu m1,m2,m3,m4,m5;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11;
	JTextArea ta;
	NotepadProject()
	{
		setTitle("Notepad");
		setBounds(100,100,800,600);
		setVisible(true);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    mb =new JMenuBar();
		m1 = new JMenu("File");
		mi1 = new JMenuItem("New");
		mi2 = new JMenuItem("Open");
		mi3 = new JMenuItem("Save");
		
		m2 = new JMenu("Edit");
		mi4=new JMenuItem("cut");
		mi5=new JMenuItem("paste");
		mi6=new JMenuItem("copy");
		mi7=new JMenuItem("Select all");
		
		m3=new JMenu("Format");
		m5=new JMenu("Font Size");
		mi11=new JMenuItem("Select Background Color");
		mi10=new JMenuItem("40");
		mi8 = new JMenuItem("Select Font Colour");
		
		m4 = new JMenu("Help");
		mi9 = new JMenuItem("About");

	
		ta = new JTextArea();
		
		ta.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,30));
		
		mb = new JMenuBar();
		
		add(mb);
		mb.add(m1);
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		
		mb.add(m2);
		m2.add(mi4);
		m2.add(mi5);
		m2.add(mi6);
		m2.add(mi7);

		mb.add(m3);
	    m3.add(m5);
	    m5.add(mi10);
        m3.add(mi11);
		m3.add(mi8);

		
		mb.add(m4);
		m4.add(mi9);

        
		setJMenuBar(mb);
        add(new JScrollPane(ta));
		
	  
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);
		mi7.addActionListener(this);
		mi8.addActionListener(this);
		mi9.addActionListener(this);
		mi10.addActionListener(this);
		mi11.addActionListener(this);

		mi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
		mi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
		mi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
			
	}	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mi1)
		   {
			 ta.setText(null);
		   }
		else if(e.getSource()==mi2)
		   {
			 JFileChooser fc=new JFileChooser();    
			 int i=fc.showOpenDialog(this);    
			 System.out.println("i= "+i);
			 if(i==JFileChooser.APPROVE_OPTION)
			  {    
				File f=fc.getSelectedFile();    
				String filepath=f.getPath();    
				  try
				    {  
				    	BufferedReader br=new BufferedReader(new FileReader(filepath));    
					    String s1="",s2="";                         
				    	while((s1=br.readLine())!=null)
				        	{    						   
				        		s2=s2+s1+"\n";
			        		}    					
			       		ta.setText(s2);    
			    		br.close();    
		      		}catch (Exception ex) { ex.getMessage(); }
			   } 
		   }
		else if(e.getSource()==mi3)
		   {
			 JFileChooser fc=new JFileChooser();    
			 int i=fc.showSaveDialog(this);    
			System.out.println("i= "+i);
			 if(i==JFileChooser.APPROVE_OPTION)
			  {    
				File f=fc.getSelectedFile();    
				String filename=f.getPath();    
				try
				  {  
				    	BufferedWriter br=new BufferedWriter(new FileWriter(filename));    					                        
					    ta.write(br);    
				  }catch (Exception ex) { ex.getMessage(); }
			  } 
		   }
		   else if(e.getSource()==mi4)
		   {
			   ta.cut();
		   }
		   else if(e.getSource()==mi5)
		   {
			   ta.paste();
		   }
		   else if(e.getSource()==mi6)
		   {
			   ta.copy();
		   }
		   else if(e.getSource()==mi7)
		   {
			   ta.selectAll();
		   }
		  else if(e.getSource()==mi8)
		  {
			Color color=JColorChooser.showDialog(this,"Select a color",Color.BLACK);    
			ta.setForeground(color);
		  }
		  else if(e.getSource()==mi10)
		   {
			ta.setFont(new Font(ta.getFont().getName(),ta.getFont().getStyle(),40));
		   }
		   else if(e.getSource()==mi11)
		  {
			Color color=JColorChooser.showDialog(this,"Select a color",Color.WHITE);    
			ta.setBackground(color);
		  }
		else
		{
			JOptionPane.showMessageDialog(null,"Basic of java programming");
			
		}
	}
	

	public static void main(String[] args) throws Exception {

		  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
	    	new NotepadProject();
	}

}