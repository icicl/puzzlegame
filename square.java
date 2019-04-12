package sickomode;

public class square {
	private boolean bad;
	private boolean visible;
	private boolean flagged;//yellow
	private boolean marked;//red
	public square(boolean b){
		bad = b;
		visible = false;
		flagged= false;
		marked=false;
	}
	public void click(){
		visible = true;
	}
	public boolean isbad(){
		return bad;
	}
	public void flag(){
		flagged = !(flagged||marked);
	}
	public boolean isVis(){
		return visible;
	}
	public boolean isFlagged(){
		return flagged;
	}
	public boolean isMarked(){
		return marked;
	}
	public void mark(){
		marked=!(marked||flagged);
		if (marked)flagged=false;
	}
	public void mark_(){
		marked=!flagged&&!marked;
	}
	public void mark__(){
		marked=!flagged;
	}
	public void unflag(){
		flagged = false;
	}
	public void unmark(){
		marked=false;
	}
}
