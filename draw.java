package sickomode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class draw extends JPanel{
	private square[][] sq;
	private board2 b;
	private int[] rows;
	private int[] cols;
	private int size;
	private boolean[][] stars;
	public draw(board2 b_)
	{
		b = b_;
		sq = b_.get();
		rows = b_.getRows();
		cols = b_.getCols();
		size = b_.getSize_();
		stars = b_.getStars();
		addMouseListener(new Actions(b));

		setPreferredSize(new Dimension(b_.getSize_() * 20 +20, b_.getSize_() * 20+20));
	}
	public void paintComponent(Graphics g){
		paintHeaders(g);
		paintComponent_(g);
	}
	private void paintHeaders(Graphics g){
		for (int i=0;i<size;i++){
			paintNum(g,0,1+i,cols[i]);
			paintNum(g,1+i,0,rows[i]);
		}
	}
	private void paintNum(Graphics g,int i,int j,int num){
		if (num == 1)
		{
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
		}
		else if (num == 2)
		{
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 7, j * 20 + 11, i * 20 + 7, j * 20 + 15);	//5
			g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);	//7
		}
		else if (num == 3)
		{
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
			g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);	//7
		}
		else if (num == 4)
		{
			g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);		//1
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
		}
		else if (num == 5)
		{
			g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);		//1
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
			g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);	//7
		}
		else if (num == 6)
		{
			g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);		//1
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 7, j * 20 + 11, i * 20 + 7, j * 20 + 15);	//5
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
			g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);	//7
		}
		else if (num == 7)
		{
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
		}
		else if (num == 8)
		{
			g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);		//1
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 7, j * 20 + 11, i * 20 + 7, j * 20 + 15);	//5
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
			g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);	//7
		}
		else if (num == 9)
		{
			g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);		//1
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
//			g.drawLine(i * 20 + 7, j * 20 + 11, i * 20 + 7, j * 20 + 15);	//5
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
			g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);	//7
		}
		else if (num == 0)
		{
			g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);		//1
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
//			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 7, j * 20 + 11, i * 20 + 7, j * 20 + 15);	//5
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
			g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);	//7
		}
		else{
			System.out.println("BIG OOF");
		}
	

	}
	public void paintComponent_(Graphics g)
	{
		

		for (int i = 0; i < b.getSize_(); i++)
		{

			for (int j = 0; j < b.getSize_(); j++)
			{
				square current = sq[i][j];
				if (stars[i][j]) {
					g.setColor(Color.GREEN);
					g.fillRect((i+1) * 20, (j+1) * 20, (i+1) * 20 + 20, (j+1) * 20 + 20);
				}
				else {
					if (current.isFlagged())
					{
	
						g.setColor(Color.YELLOW);
						g.fillRect((i+1) * 20, (j+1) * 20, (i+1) * 20 + 20, (j+1) * 20 + 20);
					}
					else if (current.isMarked())
					{
	
						g.setColor(Color.RED);
						g.fillRect((i+1) * 20, (j+1) * 20, (i+1) * 20 + 20, (j+1) * 20 + 20);
					}
					else
					{
						g.setColor(Color.LIGHT_GRAY);
						g.fillRect((i+1) * 20, (j+1) * 20, (i+1) * 20 + 20, (j+1) * 20 + 20);
					}
				}

			}
			
		}
		for (int i = 0; i < b.getSize_(); i++)
		{
			
			g.setColor(Color.BLACK);
			
			g.drawLine((i+1) * 20, 0, (i+1) * 20, b.getSize_() * 20 + 20);
			g.drawLine(0,(i+1) * 20, b.getSize_() * 20 + 20, (i+1) * 20);
		}
	}

}
