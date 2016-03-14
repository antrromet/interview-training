public class CheckUniqueChars {

	public static void main(String[] args){
		String str = args[0];
		
		CheckUniqueChars cuc = new CheckUniqueChars();
		if(cuc.checkWithStorage(str)){
			System.out.println("\""+str + "\" has unique characters.");
		} else {
			System.out.println("\""+str + "\" does not have any unique characters.");
		}
		
		if(cuc.checkWithoutStorage(str)){
			System.out.println("\""+str + "\" has unique characters.");
		} else {
			System.out.println("\""+str + "\" does not have any unique characters.");
		}
	}
	
	// With using extra storage
	private boolean checkWithStorage(String str){
		System.out.println("Check with extra storage");
		if(str!=null && str.length()>256){
			return false;
		}
		boolean[] arr = new boolean[256];
		for(int i=0;i<str.length();i++){
			int ch = (int) str.charAt(i);
			if(arr[ch]){
				return false;
			} else {
				arr[ch] = true;
			}
		}
		return true;
	}
	
	// Without using extra storage
	private boolean checkWithoutStorage(String str){
		System.out.println("Check without extra storage");
		if(str == null){
			return false;
		}
		for(int i=0;i<str.length();i++){
			for(int j=i+1;j<str.length();j++){
				char ch = str.charAt(i);
				if(ch == str.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}

}