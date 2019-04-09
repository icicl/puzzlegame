package sickomode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Actions implements ActionListener, MouseListener
{
	private board2 b;
	private int x1;
	private int y1;
	private boolean lock;
	public Actions(board2 m)
	{
		b = m;
		lock=false;
	}

	public void actionPerformed(ActionEvent e)
	{	
		for (square[] i:b.get()) {
			for(square s:i) {
				if (s.isFlagged()) s.unflag();
			}
		}
//		b.reset();

		b.refresh();
	}

	public void mouseClicked(MouseEvent e)
	{
		if (e.getButton() == 1)
		{
			int x = e.getX() / 20 - 1;
			int y = e.getY() / 20 - 1;

			b.select(x, y);
		}

		if (e.getButton() == 3)
		{
			int x = e.getX() / 20 - 1;
			int y = e.getY() / 20 - 1;

	//		b.mark(x, y);
		}

		b.refresh();
	}

	public void mouseEntered(MouseEvent e)
	{

	}

	public void mouseExited(MouseEvent e)
	{

	}

	public void mousePressed(MouseEvent e)
	{
		if (e.getButton()!=3 || lock) return;
		x1 = e.getX();
		y1 = e.getY();
		lock=true;
	}

	public void mouseReleased(MouseEvent e)
	{
		if (e.getButton()!=3)return;
		for (int x = Math.min(x1, e.getX())/20-1;x<=Math.max(x1, e.getX())/20-1;x++){
			for (int y = Math.min(y1, e.getY())/20-1;y<=Math.max(y1, e.getY())/20-1;y++){
				b.mark(x, y);
			}
		}
		lock=false;
		b.refresh();
	}

}