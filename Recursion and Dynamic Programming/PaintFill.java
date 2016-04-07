public class PaintFill {

	enum Color {
		Black, White, Red, Yellow, Green
	}
	
	public static void main(String[] args){
		PaintFill pf = new PaintFill();
		pf.paintFill();	
	}
	
	private void paintFill(){
		// Call the method
		// paintFill();
	}
	
	private boolean paintFill(Color[][] screen, int x, int y, Color oColor, Color nColor){
		if(x < 0 || y < 0 || x >= screen[0].length || y >= screen[0].length){
			return false;
		}
		if(screen[x][y] == oColor){
			screen[x][y] = nColor;
			paintFill(screen, x+1, y, oColor, nColor);
			paintFill(screen, x, y+1, oColor, nColor);
			paintFill(screen, x-1, y, oColor, nColor);
			paintFill(screen, x, y-1, oColor, nColor);
		}
		return true;
	}
	
}