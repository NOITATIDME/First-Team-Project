package board.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import board.db.DBConn;
import board.vo.BoardVo;
import board.vo.PageVo;
import oracle.jdbc.OracleCallableStatement;

public class BoardDao {
	
	// 게시판 글 추가
	public void boardInsert(BoardVo vo) {
		
		Connection        conn    = null;
		CallableStatement cstmt   = null;
		
		try {
			DBConn db  = new DBConn();
			conn       = db.getConnection();
			String sql = "{CALL PKG_HBOARD.PROC_BOARD_INSERT(?,?,?,?, ?,?,?,?) }";
			cstmt      = conn.prepareCall(sql);
			
			cstmt.setString(1, vo.getMenu_id() );
			cstmt.setString(2, vo.getTitle() );
			cstmt.setString(3, vo.getCont() );
			cstmt.setString(4, vo.getWriter() );
			cstmt.setInt(5, vo.getBnum() );
			cstmt.setInt(6, vo.getLvl() );
			cstmt.setInt(7, vo.getStep() );
			cstmt.setInt(8, vo.getNref() );
			
			cstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( cstmt != null ) cstmt.close();
				if( conn  != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	// 게시판 페이지
	public PageVo getBoardPaging(String menu_id, int nowpage, int pagecount) {
		
		PageVo pageVo = new PageVo();
		Connection        conn  = null; 
		CallableStatement cstmt = null;
		
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "{CALL  PKG_HBOARD.PROC_BOARD_PAGING(?, ?, ?, ?) }";
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1,  menu_id);             // Menu Id     
			cstmt.setInt(2,  nowpage);                // nowpage     
			cstmt.setInt(3,  pagecount);              // pagecount     
			cstmt.registerOutParameter(4, 
				Types.NUMERIC );                      // 결과 , 전체자료수
			
			cstmt.execute();  // 스토어드 프로시저 실행
			
			int  totalcount  = cstmt.getInt(4);
			
			pageVo = new PageVo(nowpage, pagecount, totalcount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( cstmt != null ) cstmt.close();
				if( conn  != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pageVo;
	}
	
	// 게시판 목록 조회
	public List<BoardVo> getBoardPagingList(String menu_id, int nowpage, int pagecount) {
		
		List<BoardVo>     list  = new ArrayList<BoardVo>();
		Connection        conn  = null; 
		CallableStatement cstmt = null;
		ResultSet         rs    = null;
		
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "{CALL  PKG_HBOARD.PROC_BOARD_PAGINGLIST(?, ?, ?, ?, ?) }";
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1,  menu_id);             // Menu Id     
			cstmt.setInt(2,  nowpage);                // nowpage     
			cstmt.setInt(3,  pagecount);              // pagecount     
			cstmt.registerOutParameter(4, 
				Types.NUMERIC );                      // 결과 , 전체자료수
			cstmt.registerOutParameter(5, 
					oracle.jdbc.OracleTypes.CURSOR ); // 결과 , cursor
			
			cstmt.execute();  // 스토어드 프로시저 실행
			
			OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt;
			
			int  totalcount  = ocstmt.getInt(4);
			
			rs    =     ocstmt.getCursor(5);
			while( rs.next() ) {
				int      idx        =  rs.getInt("idx");
				String   title      =  rs.getString("title");
				String   writer     =  rs.getString("writer");   
				String   regdate    =  rs.getString("regdate");   
				String   cname    =  rs.getString("cname");   
				int      readcount  =  rs.getInt("readcount");
				int      bnum       =  rs.getInt("bnum");
				int      lvl        =  rs.getInt("lvl");
				int      step       =  rs.getInt("step");
				int      nref       =  rs.getInt("nref");
				int      delnum     =  rs.getInt("delnum");
			
				BoardVo  boardVo    =  new BoardVo(idx, menu_id, title, "",
						writer, regdate, cname, readcount, bnum, lvl, step,
						nref, delnum, totalcount);
				
				list.add(boardVo);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs    != null ) rs.close();
				if( cstmt != null ) cstmt.close();
				if( conn  != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	// 게시판 글 내용 조회
	public BoardVo getView(int idx) {
		
		BoardVo             boardVo = null;
		
		Connection          conn  = null;
		CallableStatement   cstmt = null;
		ResultSet           rs    = null;
		
		try {
			DBConn   db   =  new DBConn();
			conn          =  db.getConnection();
			String   sql  =  "{CALL  PKG_HBOARD.PROC_BOARD_VIEW(?, ?) }";
			cstmt         =  conn.prepareCall( sql );
			
			cstmt.setInt(1,  idx);
			cstmt.registerOutParameter(2, 
					oracle.jdbc.OracleTypes.CURSOR );
			
			cstmt.executeQuery();
			
			OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt; 
			
			rs  =  ocstmt.getCursor( 2 );  // 2번째 ?
			
			if( rs.next() ) {
						
				int     idxnum     =  rs.getInt("idx");
				String  menu_id    =  rs.getString("menu_id"); 
				String  title      =  rs.getString("title");
				String  cont       =  rs.getString("cont");
				String  writer     =  rs.getString("writer");
				String  regdate    =  rs.getString("regdate");
				int     readcount  =  rs.getInt("readcount");
				int     bnum       =  rs.getInt("bnum");
				int     lvl        =  rs.getInt("lvl");
				int     step       =  rs.getInt("step");
				int     nref       =  rs.getInt("nref");
				int     delnum     =  rs.getInt("delnum");
				
				boardVo = new BoardVo(idxnum, menu_id, title,
						cont, writer, regdate, readcount, bnum, lvl, step, nref, delnum);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( cstmt != null ) cstmt.close();
				if( conn  != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return boardVo;
	}

	// 게시판 글 수정
	public void boardUpdate(int idx, String title, String cont) {
		
		Connection        conn    = null;
		CallableStatement cstmt   = null;
		
		try {
			DBConn db  = new DBConn();
			conn       = db.getConnection();
			String sql = "{CALL PKG_HBOARD.PROC_BOARD_UPDATE(?,?,?) }";
			cstmt      = conn.prepareCall(sql);
			
			cstmt.setInt(1, idx );
			cstmt.setString(2, title );
			cstmt.setString(3, cont );
			
			cstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( cstmt != null ) cstmt.close();
				if( conn  != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 게시판 글 삭제
	public void boardDelete(int idx) {
		
		Connection        conn    = null;
		CallableStatement cstmt   = null;
		
		try {
			DBConn db  = new DBConn();
			conn       = db.getConnection();
			String sql = "{CALL PKG_HBOARD.PROC_BOARD_DELETE(?) }";
			cstmt      = conn.prepareCall(sql);
			
			cstmt.setInt(1, idx );
			
			cstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( cstmt != null ) cstmt.close();
				if( conn  != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
