package request;

public class Pageinfo {

	private int nowPage;
	private String searchColumn;
	private String searchWord;
	public Pageinfo(int nowPage, String searchColumn, String searchWord) {
		super();
		this.nowPage = nowPage;
		this.searchColumn = searchColumn;
		this.searchWord = searchWord;
	}
	public Pageinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Pageinfo [nowPage=" + nowPage + ", searchColumn=" + searchColumn + ", searchWord=" + searchWord + "]";
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public String getSearchColumn() {
		return searchColumn;
	}
	public void setSearchColumn(String searchColumn) {
		this.searchColumn = searchColumn;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
}
