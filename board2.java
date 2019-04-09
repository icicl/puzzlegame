package sickomode;

import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class board2 extends JFrame{
	private int size;
	private square[][] q;
	private int[] rows;
	private int[] cols;
	private double chance;
	private boolean[][] stars;
	private boolean[][] stars_;
	private boolean done;
	private double ch_s_;
	private double ch_x_;
	private draw d;
	private JButton clear;
	private JButton reset;
/*	public board(int sz, double ch){
		size = sz;
		chance = ch;
		q = new square[size][size];
		rows = new int[size];
		cols = new int[size];
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++){
				q[i][j] = new square(Math.random() <= chance);
			}
		}
		for (int i = 0;i<size;i++){
			for (square s:q[i]) rows[i] += s.isbad() ? 1 : 0;
		}
		for (int i = 0;i<size;i++){
			for (square s[]:q) cols[i] += s[i].isbad() ? 1 : 0;
		}
	}*/
	public board2(int sz,double ch_s,double ch_x){
		ch_s_=ch_s;
		ch_x_=ch_x;
		done = false;
		size = sz;
		chance = ch_s;
//		stars = new boolean[size][size];
//		stars_ = new boolean[size][size];
		reset();
/*		for (int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if (Math.random() < ch_s){
					stars[i][j] = true;//maybe else false
					for (int ii=-1;ii<2;ii++){
						for (int jj=-1;jj<2;jj++){
							try{
								stars_[i+ii][j+jj] = true;
							} catch(IndexOutOfBoundsException e){};
						}
					}
				}
			}
		}
		q = new square[size][size];
		rows = new int[size];
		cols = new int[size];
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++){
				q[i][j] = new square(Math.random() <= ch_x && stars_[i][j] && !stars[i][j]);
			}
		}
		for (int i = 0;i<size;i++){
			for (square s:q[i]) rows[i] += s.isbad() ? 1 : 0;
		}
		for (int i = 0;i<size;i++){
			for (square s[]:q) cols[i] += s[i].isbad() ? 1 : 0;
		}*/
//		d = new draw(this);

		add(d, BorderLayout.CENTER);
		reset = new JButton("New Game");
		clear = new JButton("Clear Marks");
		//add(reset, BorderLayout.NORTH);
		//add(clear, BorderLayout.SOUTH);

		reset.addActionListener(new Actions(this));
		clear.addActionListener(new Actions(this));
		setTitle("SAMPLE text");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setVisible(true);
	

	}
	
	public void reset() {
		stars = new boolean[size][size];
		stars_ = new boolean[size][size];
		for (int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if (Math.random() < ch_s_){
					stars[i][j] = true;//maybe else false
					for (int ii=-1;ii<2;ii++){
						for (int jj=-1;jj<2;jj++){
							try{
								stars_[i+ii][j+jj] = true;
							} catch(IndexOutOfBoundsException e){};
						}
					}
				}
			}
		}
		q = new square[size][size];
		rows = new int[size];
		cols = new int[size];
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++){
				q[i][j] = new square(Math.random() <= ch_x_ && stars_[i][j] && !stars[i][j]);
			}
		}
		boolean keep=false;
		for (int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if (stars[i][j]){
			for (int ii=-1;ii<2;ii++){
				for (int jj=-1;jj<2;jj++){
					try{
						keep = keep||q[i+ii][j+jj].isbad();
					} catch(IndexOutOfBoundsException e){};
				}
			}
			stars[i][j]=keep;}
			}
		}
		stars_ = new boolean[size][size];
		for (int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if (stars[i][j]){
					for (int ii=-1;ii<2;ii++){
						for (int jj=-1;jj<2;jj++){
							try{
								stars_[i+ii][j+jj] = true;
							} catch(IndexOutOfBoundsException e){};
						}
					}
				}
			}
		}

		for (int i = 0;i<size;i++){
			for (square s:q[i]) rows[i] += s.isbad() ? 1 : 0;
		}
		for (int i = 0;i<size;i++){
			for (square s[]:q) cols[i] += s[i].isbad() ? 1 : 0;
		}	
		d=new draw(this);
	}
	
	
	public void refresh() {
		d.repaint();
	}
	public void select(int x,int y) {
		if (x==-1&&y==-1){
			return;
		}
		if (x==-1){
			for (int j=0;j<size;j++)q[j][y].mark_();
			return;
		}
		if (y==-1){
			for (int j=0;j<size;j++)q[x][j].mark_();
			return;
		}
		q[x][y].flag();
		if (won()) win();
	}
	public void mark(int x,int y){
		q[x][y].mark();
//		q[x][y].unflag();
	}
	public int getSize_(){
		return size;
	}
	public void rows_(){
		for (int i:rows)
		System.out.print(i);
		System.out.println();
	}
	public void cols_(){
		for (int i:cols)
		System.out.print(i);
		System.out.println();
	}
	public void rows__(){
		for (int i:row2)
		System.out.print(i);
		System.out.println();
	}
	public void cols__(){
		for (int i:col2)
		System.out.print(i);
		System.out.println();
	}
	public void vals(){
		for (square[] s:q){
			System.out.println("");
			for (square s2:s) System.out.print(s2.isbad()?1:0);
		}
	}
	public void valsb(){
		System.out.println();
		for (boolean[] s:stars){
			System.out.println("");
			for (boolean s2:s) System.out.print(s2?1:0);
		}
	}
	public void valsb2(){
		System.out.println();
		for (boolean[] s:stars_){
			System.out.println("");
			for (boolean s2:s) System.out.print(s2?1:0);
		}
		
	}
	public square[][] get(){
		return q;
	}
	public int[] getRows(){
		return rows;
	}
	public int[] getCols(){
		return cols;
	}
	public boolean[][] getStars(){
		return stars;
	}
	private int[] col2;
	private int[] row2;
	private int temp;
	public boolean won() {
	//	col2=new int[size];row2=new int[size];
		for (int i = 0;i<size;i++){
			temp=0;
			for (square s:q[i]) temp+=s.isFlagged() ? 1 : 0;//row2[i] += s.isbad() ? 1 : 0;
			if (temp!=rows[i]){
				System.out.println(temp+" "+rows[i]+" "+i);
				return false;
			}
		}
		for (int i = 0;i<size;i++){
			temp=0;
			for (square s[]:q) temp+=s[i].isFlagged() ? 1 : 0;//col2[i] += s[i].isbad() ? 1 : 0;
					if(temp!=cols[i]){
						System.out.println(temp+"-"+cols[i]+" "+i);
						return false;
					}
		}
		System.out.println("ok");
	//	rows__();
		//cols__();
		//cols_();
	//	System.out.println((Arrays.equals(cols,col2)));
	//	if (!(Arrays.equals(cols,col2)&&Arrays.equals(rows,row2))){
	//		return false;
		//}
		for (int i =0;i<size;i++){
			for (int j=0;j<size;j++){
				if (q[i][j].isFlagged() && !stars_[i][j]){
					System.out.println(i+j);
					return false;
				}
			}
		}
		return true;
/*		for (square[] ss:q) {
			for (square s:ss) {
				if (s.isbad() != s.isFlagged()) return false;
			}
		}
		System.out.println("won");
		return true;*/
	}
	public void win() {
		JOptionPane.showMessageDialog(null, "Congratulations! You won!");
	}
}
