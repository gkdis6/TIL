package memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utility.DBClose;
import utility.Open;

public class MemoDAO {
	/**
	 * 레코드 생성 
	 * @param dto - 생성될 데이터
	 * @return true - 생성 성공, false - 생성 실패
	 */
	public boolean create(MemoDTO dto) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO memo (name, content, pass) ");
		sql.append("values(?,?,?)");
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setString(1, dto.getName());
			prst.setString(2, dto.getContent());
			prst.setString(3, dto.getPass());
			
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
	 * @param memonum - primary key
	 * @return MemoDTO - 레코드 하나
	 */
	public MemoDTO read(int memonum) {
		MemoDTO dto = null;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		
		sql.append("select memonum, name, content, pass ");
		sql.append("from memo where memonum = ? ");
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, memonum);
			
			rs = prst.executeQuery();
			if (rs.next()) {
				dto = new MemoDTO();
				dto.setMemonum(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setPass(rs.getString(4));
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
	
	public boolean update(MemoDTO dto) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("update memo set content = ?, pass = ? ");
		sql.append("where memonum = ?");
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setString(1, dto.getContent());
			prst.setString(2, dto.getPass());
			prst.setInt(3, dto.getMemonum());
			
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
	 * @param memonum - primary key
	 * @return boolean true - 삭제 성공, false - 삭제 실패
	 */
	public boolean delete(int memonum) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("delete from memo ");
		sql.append("where memonum = ?");
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, memonum);
			
			int cnt = prst.executeUpdate();
			if(cnt>0) flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con);
		}
		return flag;
	}
	
	public List<MemoDTO> list(){
		List<MemoDTO> list = new ArrayList<>();
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		
		sql.append("select * ");
		sql.append("from memo order by name desc");
		try {
			prst = con.prepareStatement(sql.toString());
			rs = prst.executeQuery();
			while(rs.next()) {
				MemoDTO dto = new MemoDTO();
				dto.setMemonum(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setPass(rs.getString(4));
				
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
