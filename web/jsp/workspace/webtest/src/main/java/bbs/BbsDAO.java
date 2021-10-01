package bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import utility.DBClose;
import utility.Open;

public class BbsDAO {
	public boolean create(BbsDTO dto) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO bbs(bbsno, wname, title, content, passwd, wdate, grpno ) ");
		sql.append(" values((SELECT nvl(max(bbsno),0)+1 AS bbsno FROM bbs), ");
		sql.append(" ?,?,?,?,sysdate,(select nvl(max(grpno),0) +1 as grpno from bbs)) ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getWname());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(pstmt, con);
		}
		return flag;
	}
	
	public boolean replyCreate(BbsDTO dto) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO bbs(bbsno, wname, title, content, passwd, wdate, grpno, indent, ansnum ) ");
		sql.append(" values((SELECT nvl(max(bbsno),0)+1 AS bbsno FROM bbs), ");
		sql.append(" ?,?,?,?,sysdate,?,?,? ) ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getWname());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setInt(5, dto.getGrpno());
			pstmt.setInt(6, dto.getIndent()+1);
			pstmt.setInt(7, dto.getAnsnum()+1);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(pstmt, con);
		}
		return flag;
	}
	
	public BbsDTO read(int bbsno) {
		BbsDTO dto = null;
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		sql.append(" select bbsno, wname, title, viewcnt, content, ");
		sql.append("to_char(wdate,'yyyy-mm-dd') wdate ");
		sql.append(" from bbs where bbsno = ?");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, bbsno);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new BbsDTO();
				dto.setBbsno(rs.getInt("bbsno"));
				dto.setWname(rs.getString("wname"));
				dto.setTitle(rs.getString("title"));
				dto.setViewcnt(rs.getInt("viewcnt"));
				dto.setContent(rs.getString("content"));
				dto.setWdate(rs.getString("wdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		return dto;
	}
	
	public BbsDTO replyRead(int bbsno) {
		BbsDTO dto = null;
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		
		sql.append(" select bbsno, title, grpno, indent, ansnum ");
		sql.append(" from bbs ");
		sql.append(" where bbsno = ?");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, bbsno);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new BbsDTO();
				dto.setBbsno(rs.getInt("bbsno"));
				dto.setTitle(rs.getString("title"));
				dto.setGrpno(rs.getInt("grpno"));
				dto.setIndent(rs.getInt("indent"));
				dto.setAnsnum(rs.getInt("ansnum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return dto;
	}
	
	public void upAnsnum(Map map) {
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		int ansnum = (Integer)map.get("ansnum");
		int grpno = (Integer)map.get("grpno");
		
		sql.append(" update bbs ");
		sql.append(" set ansnum = ansnum + 1 ");
		sql.append(" where grpno=? and ansnum > ? ");
		
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, grpno);
			prst.setInt(2, ansnum);
			prst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con);
		}
	}
	
	public boolean update(BbsDTO dto) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("update bbs set title = ?, content = ? ");
		sql.append("where bbsno = ? ");
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setString(1, dto.getTitle());
			prst.setString(2, dto.getContent());
			prst.setInt(3, dto.getBbsno());
			
			int cnt = prst.executeUpdate();
			if(cnt>0) flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con);
		}
		return flag;
	}
	
	public boolean delete(int bbsno) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("delete from bbs ");
		sql.append("where bbsno = ? ");
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, bbsno);
			
			int cnt = prst.executeUpdate();
			if(cnt>0) flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con);
		}
		return flag;
	}
	
	public void upViewcnt(int bbsno) {
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE BBS ");
		sql.append(" SET VIEWCNT = VIEWCNT +1 " );
		sql.append(" WHERE BBSNO =? ");
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, bbsno);
			prst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(prst, con);
		}
	}
	
	public boolean passCheck(Map map) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		
		sql.append(" select count(bbsno) as cnt ");
		sql.append(" from bbs where bbsno = ? ");
		sql.append(" and passwd = ? ");
		
		int bbsno = (Integer)map.get("bbsno");
		String passwd = (String)map.get("passwd");
		
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, bbsno);
			prst.setString(2, passwd);
			
			rs = prst.executeQuery();
			
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt>0) flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, prst, rs);
		}
		
		return flag;
	}
	
	public List<BbsDTO> list(Map map){
		List<BbsDTO> list = new ArrayList<BbsDTO>();
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		
		String col = (String)map.get("col"); //name, title, content, title_content 
		String word = (String)map.get("word");
		int sno = (Integer)map.get("sno");
		int eno = (Integer)map.get("eno");
		
		sql.append(" SELECT bbsno, wname, title, viewcnt, to_char(wdate,'yyyy-mm-dd') as wdate, grpno, indent, ansnum, r ");
		sql.append(" from( ");
		sql.append(" 	SELECT bbsno, wname, title, viewcnt, wdate, grpno, indent, ansnum, rownum r ");
		sql.append(" 	from( ");
		sql.append("		SELECT bbsno, wname, title, viewcnt, wdate, grpno, indent, ansnum ");
		sql.append("		FROM bbs  ");
		if(word.trim().length() > 0 && col.equals("title_content")) {
			sql.append(" where title like '%'||?||'%' ");
			sql.append(" or content like '%'||?||'%' ");
		} else if (word.trim().length() > 0) {
			sql.append(" where " + col + " like '%'||?||'%' ");
		}
		sql.append(" order by grpno desc, ansnum ");
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
				BbsDTO dto = new BbsDTO();
				dto.setBbsno(rs.getInt("bbsno"));
				dto.setWname(rs.getString("wname"));
				dto.setTitle(rs.getString("title"));
				dto.setGrpno(rs.getInt("grpno"));
				dto.setIndent(rs.getInt("indent"));
				dto.setAnsnum(rs.getInt("ansnum"));
				dto.setViewcnt(rs.getInt("viewcnt"));
				dto.setWdate(rs.getString("wdate"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		sql.append(" select count(*) from bbs ");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, prst, rs);
		}
		return total;
	}
}
