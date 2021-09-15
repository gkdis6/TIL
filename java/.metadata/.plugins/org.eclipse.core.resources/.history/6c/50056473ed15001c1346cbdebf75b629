package address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utility.DBClose;
import utility.Open;

public class AddressDAO {

	/**
	 * 레코드 생성 
	 * @param dto - 생성될 데이터
	 * @return true - 생성 성공, false - 생성 실패
	 */
	public boolean create(AddressDTO dto) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO address (name, handphone, address) ");
		sql.append("values(?,?,?)");
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setString(1, dto.getName());
			prst.setString(2, dto.getHandphone());
			prst.setString(3, dto.getAddress());
			
			int cnt = prst.executeUpdate();
			
			if(cnt > 0) flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con);
		}
		
		return flag;
	}

	/**
	 * 레코드 하나를 가져옵니다.
	 * @param addressnum - primary key
	 * @return AddressDTO - 레코드 하나
	 */
	public AddressDTO read(int addressnum) {
		AddressDTO dto = null;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		
		sql.append("select addressnum, name, handphone, address ");
		sql.append("from address where addressnum = ? ");
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, addressnum);
			
			rs = prst.executeQuery();
			if (rs.next()) {
				dto = new AddressDTO();
				dto.setAddressnum(rs.getInt("addressnum"));
				dto.setName(rs.getString("name"));
				dto.setHandphone(rs.getString("handphone"));
				dto.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con, rs);
		}
		
		return dto;
		
	}
	/**
	 * 레코드 수정
	 * @param dto - 수정할 데이터
	 * @return true - 수정 성공, false - 수정 실패
	 */
	
	public boolean update(AddressDTO dto) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("update address set handphone = ?, address = ? ");
		sql.append("where addressnum = ?");
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setString(1, dto.getHandphone());
			prst.setString(2, dto.getAddress());
			prst.setInt(3, dto.getAddressnum());
			
			int cnt = prst.executeUpdate();
			if(cnt>0) flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con);
		}
		return flag;
	}
	/**
	 * 레코드 삭제
	 * @param addressnum - primary key
	 * @return boolean true - 삭제 성공, false - 삭제 실패
	 */
	public boolean delete(int addressnum) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("delete from address ");
		sql.append("where addressnum = ?");
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, addressnum);
			
			int cnt = prst.executeUpdate();
			if(cnt>0) flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con);
		}
		return flag;
	}
	
	public List<AddressDTO> list(){
		List<AddressDTO> list = new ArrayList<>();
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		
		sql.append("select * ");
		sql.append("from address order by name desc");
		try {
			prst = con.prepareStatement(sql.toString());
			rs = prst.executeQuery();
			while(rs.next()) {
				AddressDTO dto = new AddressDTO();
				dto.setAddressnum(rs.getInt("addressnum"));
				dto.setName(rs.getString("name"));
				dto.setHandphone(rs.getString("handphone"));
				dto.setAddress(rs.getString("address"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con,rs);
		}
		
		return list;
	}
}
