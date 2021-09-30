package bbs;

public class BbsTest {

	public static void main(String[] args) {
		BbsDAO dao = new BbsDAO();
//		create(dao);
//		read(dao);
		//update(dao);
//		delete(dao);

	}

	private static void create(BbsDAO dao) {
		BbsDTO dto = new BbsDTO();
		dto.setWname("홍길동");
		dto.setTitle("제목");
		dto.setContent("내용");
		dto.setPasswd("1234");
		if(dao.create(dto)) {
			p("성공");
		}else {
			p("실패");
		}
		
	}

	private static void read(BbsDAO dao) {
		BbsDTO dto = dao.read(1);
		p(dto);
	}
	
	private static void update(BbsDAO dao) {
		BbsDTO dto = dao.read(1);
		dto.setTitle("변경된 제목입니다.");
		dto.setContent("변경된 내용입니다.");
		if(dao.update(dto)) {
			p("수정 성공");
		}else {
			p("수정 실패");
		}
	}
	
	private static void delete(BbsDAO dao) {
		if(dao.delete(1)) {
			p("삭제 성공");
		}else {
			p("삭제 실패");
		}
	}
	
	private static void p(String string) {
		System.out.println(string);
		
	}
	
	private static void p(BbsDTO dto) {
		System.out.println("게시글 번호 : " +dto.getBbsno());
		System.out.println("게시자 이름 : " +dto.getWname());
		System.out.println("게시글 제목 : " +dto.getTitle());
		System.out.println("조회수 : " +dto.getViewcnt());
		System.out.println("게시 날짜 : " +dto.getWdate());
	}

}
