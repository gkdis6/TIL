package memo;

public class MemoDTO {

	private int memonum;
	private String name;
	private String content;
	private String pass;
	/**
	 * @return the memonum
	 */
	public int getMemonum() {
		return memonum;
	}
	/**
	 * @param memonum the memonum to set
	 */
	public void setMemonum(int memonum) {
		this.memonum = memonum;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	public MemoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemoDTO(int memonum, String name, String content, String pass) {
		super();
		this.memonum = memonum;
		this.name = name;
		this.content = content;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "MemoDTO [memonum=" + memonum + ", name=" + name + ", content=" + content + ", pass=" + pass + "]";
	}
	
}
