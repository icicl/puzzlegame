package sickomode;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class trogdogmillionaire {
	private static boolean active;
	private static int sz;
	private static int df;
	public static void main(String[] args){
//		double dif=2.5;//1-6
		JSlider diff = new JSlider(1,11,5);
		diff.setMajorTickSpacing(2);
		diff.setMinorTickSpacing(1);
		sz = 12;
		df = 5;
		// Add positions label in the slider
		Hashtable position = new Hashtable();
		position.put(1, new JLabel("Pathetic"));
		position.put(3, new JLabel("Trivial"));
		position.put(5, new JLabel("Easy"));
		position.put(7, new JLabel("Acceptable"));
		position.put(9, new JLabel("Moderate"));
		position.put(11, new JLabel("Hard-ish"));
		         
		// Set the label to be drawn
		diff.setLabelTable(position); 
		diff.setPaintTicks(true);
		diff.setPaintLabels(true);
        JLabel difflabel = new JLabel("Difficulty",JLabel.CENTER);
		diff.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e){
				difflabel.setText("Difficulty Level: "+((JSlider)e.getSource()).getValue());
				df = ((JSlider)e.getSource()).getValue();
			}
		});

		JFrame frame= new JFrame("mission contorl");
		JSlider size = new JSlider(8,20,12);
		size.setMajorTickSpacing(2);
		size.setMinorTickSpacing(1);
		// Add positions label in the slider
		Hashtable position2 = new Hashtable();
		position2.put(8, new JLabel("8"));
		position2.put(10, new JLabel("10"));
		position2.put(12, new JLabel("12"));
		position2.put(14, new JLabel("14"));
		position2.put(16, new JLabel("16"));
		position2.put(18, new JLabel("18"));
		position2.put(20, new JLabel("20"));
		         
		// Set the label to be drawn
		size.setLabelTable(position2); 
		size.setPaintTicks(true);
		size.setPaintLabels(true);
        JLabel sizelabel = new JLabel("Board Size",JLabel.CENTER);
		size.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e){
				sizelabel.setText("Board size: "+((JSlider)e.getSource()).getValue());
				sz=((JSlider)e.getSource()).getValue();
			}
		});
		
		JButton go = new JButton("GO!");
		active=false;
		go.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  //  if (active)return;
		    active=true;
		    board2 b = new board2(sz,df*.015,df*.05);
		  }
		});
		//JSlider size = new JSlider(8,20,12);
//		frame.getContentPane().add(diff);
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(5, 1));
		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JPanel panel1 = new JPanel();
//        JPanel panel2 = new JPanel();
 //       panel2.add(difflabel);
        frame.add(difflabel);frame.add(diff);frame.add(go);frame.add(sizelabel);frame.add(size);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);		

		//board2 b = new board2(16,dif*.03,dif*.1);
		//b.rows_();
		//b.cols_();
		//b.vals();
		//b.valsb();
	//	b.valsb2();
//		draw d = new draw(b);
/*		JFrame frame= new JFrame("test");	
		frame.getContentPane().add(new draw(b));
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		

*/
	}
//	public void makeNew(int sz_,double d1,double d2){
//	    board2 b = new board2(sz_,d1,d2);
//	}

}
