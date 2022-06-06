package homework0603test;

public interface DatabaseQuery {
	public static final int DATABASE_VERSION = 1;
	
	public abstract int insert(String id, String pw);

}
