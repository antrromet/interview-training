public class RobotGrid {

	public static void main(String[] args) {
		
	}
	
	private boolean getPath(int x, int y, ArrayList<Point> path){
		if(x < 0 || y < 0 || !isFree(x,y)){
			return false;
		}
		
		boolean isAtOrigin = (x == 0) && (y == 0);
		if(isAtOrigin || getPath(x-1, y, path) || getPath(x, y-1, path)){
			Point p = new Point(x, y);
			path.add(p);		
			return true;
		}
		return false;
	}
	
	private boolean getPathDP(int x, int y, ArrayList<Ponit> path, Hashtable<Point, Boolean> cache){
		if(x < 0 || y < 0 || !isFree(x,y)){
			return false;
		}
		Point p = new Point(x, y);
		if (cache.containsKey(p)){
			return cache.get(p);
		}
		boolean isAtOrigin = (x == 0) && (y == 0);
		if(isAtOrigin || getPathDP(x-1, y, path, cache) || getPathDP(x, y-1, path, cache)){
			path.add(p);
			return true;
		}
		return false;
	}

}