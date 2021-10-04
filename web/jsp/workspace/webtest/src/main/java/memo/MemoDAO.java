package memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import bbs.BbsDTO;
import utility.DBClose;
import utility.Open;

public class MemoDAO {
	public boolean create(MemoDTO dto) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO memo(memono, wname, title, content, passwd, wdate) ");
		sql.append(" values((SELECT nvl(max(memono),0) +1 FROM memo),  ");
		sql.append(" ?, ?, ?, ?, sysdate) ");

		try {
			prst = con.prepareStatement(sql.toString());
			prst.setString(1, dto.getWname());
			prst.setString(2, dto.getTitle());
			prst.setString(3, dto.getContent());
			prst.setString(4, dto.getPasswd());

			int cnt = prst.executeUpdate();

			if (cnt > 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(prst, con);
		}

		return flag;
	}

	public MemoDTO read(int memono) {
		MemoDTO dto = null;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		sql.append(" select memono, wname, title, content, viewcnt, ");
		sql.append(" to_char(wdate,'yyyy-mm-dd') wdate ");
		sql.append(" from memo where memono = ? ");
		
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, memono);
			rs = prst.executeQuery();
			
			if(rs.next()) {
				dto = new MemoDTO();
				dto.setMemono(rs.getInt("memono"));
				dto.setWname(rs.getString("wname"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setViewcnt(rs.getInt("viewcnt"));
				dto.setWdate(rs.getString("wdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(con, prst, rs);
		}
		
		return dto;
	}

	public boolean update(MemoDTO dto) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append(" update memo set title = ?, content = ? ");
		sql.append(" where memono = ? ");
		
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setString(1, dto.getTitle());
			prst.setString(2, dto.getContent());
			prst.setInt(3, dto.getMemono());
			
			int cnt = prst.executeUpdate();

			if (cnt > 0)
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con);
		}
		
		return flag;
	}
	
	public void upViewCnt(int memono) {
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" update memo ");
		sql.append(" set viewcnt = viewcnt +1 ");
		sql.append(" where memono = ? ");
		
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, memono);
			prst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con);
		}
		
	}

	public boolean delete(int memono) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("delete from memo ");
		sql.append("where memono = ? ");
		
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, memono);
			
			int cnt = prst.executeUpdate();
			if(cnt>0) flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con);
		}
		
		return flag;
	}

	public boolean passCheck(Map map) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		
		sql.append(" select count(memono) as cnt ");
		sql.append(" from memo where memono = ? ");
		sql.append(" and passwd = ? ");
		
		int memono = (Integer)map.get("memono");
		String passwd = (String)map.get("passwd");
		
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, memono);
			prst.setString(2, passwd);
			
			rs = prst.executeQuery();
			
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt>0) flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(con, prst, rs);
		}
		
		return flag;
	}

	public List<MemoDTO> list(Map map) {
		List<MemoDTO> list = new ArrayList<MemoDTO>();
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		
		String col = (String)map.get("col");
		String word = (String)map.get("word");
		int sno = (Integer)map.get("sno");
		int eno = (Integer)map.get("eno");
		
		sql.append(" SELECT memono, wname, title, viewcnt, to_char(wdate,'yyyy-mm-dd') as wdate, r, content ");
		sql.append(" from( ");
		sql.append(" 	SELECT memono, wname, title, viewcnt, wdate, rownum r , content ");
		sql.append(" 	from( ");
		sql.append("		SELECT memono, wname, title, viewcnt, wdate, content ");
		sql.append("		FROM memo  ");
		if(word.trim().length() > 0 && col.equals("title_content")) {
			sql.append(" where title like '%'||?||'%' ");
			sql.append(" or content like '%'||?||'%' ");
		} else if (word.trim().length() > 0) {
			sql.append(" where " + col + " like '%'||?||'%' ");
		}
		sql.append(" order by wdate desc ");
		sql.append( "	) )" );
		sql.append( "WHERE r >= ? AND r <= ? ");
		
		try {
			prst = con.prepareStatement(sql.toString());
			int i = 0;
			if(word.trim().length() > 0 && col.equals("title_content")) {
				prst.setString(++i, word);
				prst.setString(++i, word);
			} else if (word.trim().length() > 0) {
				prst.setString(++i, word);
			}
			prst.setInt(++i, sno);
			prst.setInt(++i, eno);
			
			rs = prst.executeQuery();
			
			while(rs.next()) {
				MemoDTO dto = new MemoDTO();
				dto.setMemono(rs.getInt("memono"));
				dto.setWname(rs.getString("wname"));
				dto.setTitle(rs.getString("title"));
				dto.setViewcnt(rs.getInt("viewcnt"));
				dto.setWdate(rs.getString("wdate"));
				dto.setContent(rs.getString("content"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(con, prst, rs);
		}
		
		
		return list;
	}

	public int total(String col, String word) {
		int total = 0;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		
		sql.append(" select count(*) from memo ");
		if(word.trim().length() > 0 && col.equals("title_content")) {
			sql.append(" where title like '%'||?||'%' ");
			sql.append(" or content like '%'||?||'%' ");
		} else if (word.trim().length() > 0) {
			sql.append(" where " + col + " like '%'||?||'%' ");
		}
		
		try {
			prst = con.prepareStatement(sql.toString());
			if(word.trim().length() > 0 && col.equals("title_content")) {
				prst.setString(1, word);
				prst.setString(2, word);
			} else if (word.trim().length() > 0) {
				prst.setString(1, word);
			}
			rs = prst.executeQuery();
			
			rs.next();
			total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(con, prst, rs);
		}
		
		return total;
	}
}
