package sickomode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Actions implements ActionListener, MouseListener
{
	private board2 b;

	public Actions(board2 m)
	{
		b = m;
	}

	public void actionPerformed(ActionEvent e)
	{	
		for (square[] i:b.get()) {
			for(square s:i) {
				if (s.isFlagged()) s.flag();
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

			b.mark(x, y);
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

	}

	public void mouseReleased(MouseEvent e)
	{

	}

}