package sickomode;
import javax.swing.JFrame;

public class trogdogmillionaire {
	public static void main(String[] args){
		board2 b = new board2(10,.02,.25);
		b.rows_();
		b.cols_();
		b.vals();
		b.valsb();
		b.valsb2();
//		draw d = new draw(b);
/*		JFrame frame= new JFrame("test");	
		frame.getContentPane().add(new draw(b));
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		

*/
	}
}
