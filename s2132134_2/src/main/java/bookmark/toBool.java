package bookmark;

public class toBool {
	boolean bool = false;
	public toBool(Object object) {
		if (((String) object).equals("true")) {
			bool = true;
		} else {
			bool = false;
		}
	}
	
	public boolean get() {
		return bool;
	}
}
