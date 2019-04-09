package sickomode;

import java.awt.BorderLayout;

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
		add(reset, BorderLayout.NORTH);
		add(clear, BorderLayout.SOUTH);

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
		q[x][y].flag();
		if (won()) win();
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
	public boolean won() {
		for (square[] ss:q) {
			for (square s:ss) {
				if (s.isbad() != s.isFlagged()) return false;
			}
		}
		System.out.println("won");
		return true;
	}
	public void win() {
		JOptionPane.showMessageDialog(null, "Congratulations! You won!");
	}
}
