package memo;

import java.util.List;

public class MemoTEST {

	public static void main(String[] args) {
		MemoDAO dao = new MemoDAO();

//		create(dao);
//		read(dao);
//		update(dao);
//		delete(dao);
		list(dao);
	}

	private static void list(MemoDAO dao) {
		List<MemoDTO> list = dao.list();

		for (int i = 0; i < list.size(); i++) {
			MemoDTO dto = list.get(i);
			p(dto);
			p("=========================");
		}
	}

	private static void delete(MemoDAO dao) {
		if (dao.delete(4)) {
			p("삭제 성공");
		} else {
			p("삭제 실패");
		}
	}

	private static void update(MemoDAO dao) {
		MemoDTO dto = dao.read(1);
		dto.setContent("오늘 저녁은 무엇일까요?");
		dto.setPass("5678");
		if (dao.update(dto)) {
			p("수정 성공");
		} else {
			p("수정 실패");
		}
	}

	private static void read(MemoDAO dao) {
		MemoDTO dto = dao.read(1);
		p(dto);
	}

	private static void create(MemoDAO dao) {
		MemoDTO dto = new MemoDTO(0, "이길동", "어서오세요", "3456");
		if(dao.create(dto)) {
			p("레코드 생성 성공");
		}else {
			p("레코드 생성 실패");
		}
	}

	private static void p(String s) {
		System.out.println(s);
	}

	private static void p(MemoDTO dto) {
		System.out.println("번호 : " + dto.getMemonum());
		System.out.println("이름 : " + dto.getName());
		System.out.println("내용 : " + dto.getContent());
		System.out.println("비밀번호 : " + dto.getPass());

	}

}
