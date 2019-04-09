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
		marked=!marked;
	}
	public void unflag(){
		flagged = false;
	}
}
