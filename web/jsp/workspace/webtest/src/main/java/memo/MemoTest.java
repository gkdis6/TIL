package memo;

import java.util.*;

import bbs.BbsDAO;
import bbs.BbsDTO;

public class MemoTest {

	public static void main(String[] args) {
		MemoDAO dao = new MemoDAO();
		
//		create(dao);
//		read(dao);
//		update(dao);
//		delete(dao);
		list(dao);

	}

	private static void list(MemoDAO dao) {
		Map map = new HashMap();
		map.put("col", "wname");
		map.put("word", "박");
		map.put("sno", 1);
		map.put("eno", 5);

		List<MemoDTO> list = dao.list(map);
		
		for(int i = 0; i<list.size(); i++) {
//			System.out.println(list.get(i));
			MemoDTO dto = list.get(i);
			p(dto);
			p("=======================");
		}
	}
	
	private static void create(MemoDAO dao) {
		MemoDTO dto = new MemoDTO();
		dto.setWname("박길동");
		dto.setTitle("글 생성");
		dto.setContent("글 내용입니다.");
		dto.setPasswd("1234");
		if(dao.create(dto)) {
			p("성공");
		}else {
			p("실패");
		}
	}
	
	private static void read(MemoDAO dao) {
		MemoDTO dto = dao.read(10);
		dao.upViewCnt(dto.getMemono());
		p(dto);
	}
	
	private static void update(MemoDAO dao) {
		MemoDTO dto = dao.read(10);
		dto.setTitle("변경된 제목입니다.");
		dto.setContent("변경된 내용입니다.");
		if(dao.update(dto)) {
			p("수정 성공");
		}else {
			p("수정 실패");
		}
	}
	
	private static void delete(MemoDAO dao) {
		if(dao.delete(10)) {
			p("삭제 성공");
		}else {
			p("삭제 실패");
		}
	}
	
	private static void p(MemoDTO dto) {
		p("번호:"+dto.getMemono());
		p("이름:"+dto.getWname());
		p("제목:"+dto.getTitle());
		p("내용:"+dto.getContent());
	}
	
	private static void p(String string) {
		System.out.println(string);
	}
}
