package address;

import java.util.List;

public class AddressTest {

	public static void main(String[] args) {
		AddressDAO dao = new AddressDAO();
		//create(dao);
		//read(dao);
		//update(dao);
		//delete(dao);
		list(dao);
		
	}
	
	private static void list(AddressDAO dao) {
		List<AddressDTO> list = dao.list();
		
		for(int i = 0; i < list.size(); i++) {
			AddressDTO dto = list.get(i);
			p(dto);
			p("=========================");
		}
	}

	private static void delete(AddressDAO dao) {
		if (dao.delete(16)) {
			p("삭제 성공");
		}else {
			p("삭제 실패");
		}
	}

	private static void update(AddressDAO dao) {
		AddressDTO dto = dao.read(1);
		dto.setHandphone("000-3333-2222");
		dto.setAddress("경주");
		if(dao.update(dto)) {
			p("수정 성공");
		}else {
			p("수정 실패");
		}
		
	}

	private static void read(AddressDAO dao) {
		AddressDTO dto = dao.read(18);
		p(dto);
		
	}

	private static void p(AddressDTO dto) {
		System.out.println("번호 : " + dto.getAddressnum());
		System.out.println("이름 : " + dto.getName());
		System.out.println("전화 : " + dto.getHandphone());
		System.out.println("주소 : " + dto.getAddress());
		
	}

	private static void create(AddressDAO dao) {
		AddressDTO dto = new AddressDTO(0, "이길동", "010-9999-8888", "서울");
		if(dao.create(dto)) {
			p("레코드 생성 성공");
		}else {
			p("레코드 생성 실패");
		}
	}
	
	private static void p(String s) {
		System.out.println(s);
	}
}
