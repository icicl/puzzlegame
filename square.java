package sickomode;

public class square {
	private boolean bad;
	private boolean visible;
	private boolean flagged;
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
		flagged = !flagged;
	}
	public boolean isVis(){
		return visible;
	}
	public boolean isFlagged(){
		return flagged;
	}
}
