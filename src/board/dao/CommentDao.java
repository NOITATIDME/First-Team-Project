package board.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import board.db.DBConn;
import board.vo.CommentVo;
import oracle.jdbc.OracleCallableStatement;

public class CommentDao {

	// 게시판 댓글 추가
	public void commentInsert(CommentVo commentVo) {
			Connection        conn    = null;
			CallableStatement cstmt   = null;
			
			try {
				DBConn db  = new DBConn();
				conn       = db.getConnection();
				String sql = "{CALL PKG_HBOARD.PROC_BOARD_COMMENTINSERT(?, ?, ?, ?, ?, ?, ?) }";
				cstmt      = conn.prepareCall(sql);
				
				cstmt.setInt(1, commentVo.getComment_hboard() );
				cstmt.setString(2, commentVo.getComment_writer() );
				cstmt.setString(3, commentVo.getComment_cont() );
				cstmt.setInt(4, commentVo.getComment_bnum() );
				cstmt.setInt(5, commentVo.getComment_lvl() );
				cstmt.setInt(6, commentVo.getComment_step() );
				cstmt.setInt(7, commentVo.getComment_nref() );
				
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

	// 게시판 댓글 목록 조회
	public List<CommentVo> getBoardCommentList(int boardNum, int comment_nowpage, int comment_pagecount) {
		
		List<CommentVo>     list  = new ArrayList<CommentVo>();
		Connection        conn  = null; 
		CallableStatement cstmt = null;
		ResultSet         rs    = null;
		
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "{CALL  PKG_HBOARD.PROC_BOARD_COMMENTPAGINGLIST(?, ?, ?, ?, ?) }";
			cstmt = conn.prepareCall(sql);
			
			cstmt.setInt(1,  boardNum);             // comment_hboard
			cstmt.setInt(2,  comment_nowpage);                 // nowpage     
			cstmt.setInt(3,  comment_pagecount);              // pagecount     
			cstmt.registerOutParameter(4, 
				Types.NUMERIC );                      // 결과 , 전체자료수
			cstmt.registerOutParameter(5, 
					oracle.jdbc.OracleTypes.CURSOR ); // 결과 , cursor
			
			cstmt.execute();  // 스토어드 프로시저 실행
			
			OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt;
			
			int  comment_totalcount  = ocstmt.getInt(4);
			
			rs    =     ocstmt.getCursor(5);
			while( rs.next() ) {
				int      comment_rn     =  rs.getInt("rn");
				int      comment_idx     =  rs.getInt("comment_idx");
				int      comment_hboard  =  rs.getInt("comment_hboard");
				String   comment_writer  =  rs.getString("comment_writer");   
				String   comment_regdate =  rs.getString("comment_regdate");   
				String   comment_cont    =  rs.getString("comment_cont");
				int      comment_bnum    =  rs.getInt("comment_bnum");
				int      comment_lvl     =  rs.getInt("comment_lvl");
				int      comment_step    =  rs.getInt("comment_step");
				int      comment_nref    =  rs.getInt("comment_nref");
				int      comment_delnum  =  rs.getInt("comment_delnum");
			
				CommentVo  commentVo    =  new CommentVo(comment_rn, comment_idx, comment_hboard, comment_writer, comment_regdate, comment_cont, comment_bnum, comment_lvl, comment_step, comment_nref, comment_delnum, comment_totalcount);
				
				list.add(commentVo);				
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
	
	// 게시판 댓글 조회
	public CommentVo getCommentView(int comment_idx) {
		
		
		CommentVo             commentVo = null;
		
		Connection          conn  = null;
		CallableStatement   cstmt = null;
		ResultSet           rs    = null;
		
		try {
			DBConn   db   =  new DBConn();
			conn          =  db.getConnection();
			String   sql  =  "{CALL  PKG_HBOARD.PROC_BOARD_COMMENTVIEW(?, ?) }";
			cstmt         =  conn.prepareCall( sql );
			
			cstmt.setInt(1,  comment_idx);
			cstmt.registerOutParameter(2, 
					oracle.jdbc.OracleTypes.CURSOR );
			
			cstmt.executeQuery();
			
			OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt; 
			
			rs  =  ocstmt.getCursor( 2 );  // 2번째 ?
			
			if( rs.next() ) {
						
				int      comment_idxnum     =  rs.getInt("comment_idx");
				int      comment_hboard  =  rs.getInt("comment_hboard");
				String   comment_writer  =  rs.getString("comment_writer");   
				String   comment_regdate =  rs.getString("comment_regdate");   
				String   comment_cont    =  rs.getString("comment_cont");
				int      comment_bnum    =  rs.getInt("comment_bnum");
				int      comment_lvl     =  rs.getInt("comment_lvl");
				int      comment_step    =  rs.getInt("comment_step");
				int      comment_nref    =  rs.getInt("comment_nref");
				int      comment_delnum  =  rs.getInt("comment_delnum");
				
				commentVo = new CommentVo(0, comment_idxnum, comment_hboard, comment_writer, comment_regdate, comment_cont, comment_bnum, comment_lvl, comment_step, comment_nref, comment_delnum, comment_delnum);
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
		
		return commentVo;
	}
	
	// 게시판 댓글 수정
	public void commentUpdate(int comment_idx, int comment_hboard, String comment_cont) {
		
		Connection        conn    = null;
		CallableStatement cstmt   = null;
		
		try {
			DBConn db  = new DBConn();
			conn       = db.getConnection();
			String sql = "{CALL PKG_HBOARD.PROC_BOARD_COMMENTUPDATE(?,?,?) }";
			cstmt      = conn.prepareCall(sql);
			
			cstmt.setInt(1, comment_idx );
			cstmt.setInt(2, comment_hboard );
			cstmt.setString(3, comment_cont );
			
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
	
	// 게시판 댓글 삭제
	public boolean commentDelete(int comment_idx) {
		
		boolean result = false;
		
		Connection        conn    = null;
		CallableStatement cstmt   = null;
		
		try {
			DBConn db  = new DBConn();
			conn       = db.getConnection();
			String sql = "{CALL PKG_HBOARD.PROC_BOARD_COMMENTDELETE(?) }";
			cstmt      = conn.prepareCall(sql);
			
			cstmt.setInt(1, comment_idx );
			
			int flag = cstmt.executeUpdate();
			if(flag > 0) {
				result = true;
				conn.commit();
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
		return result;
	}
	
	// 게시판의 댓글들 조회
	public CommentVo getBoardCommentView(int idx) {
		CommentVo             commentVo = null;
		
		Connection          conn  = null;
		CallableStatement   cstmt = null;
		ResultSet           rs    = null;
		
		try {
			DBConn   db   =  new DBConn();
			conn          =  db.getConnection();
			String   sql  =  "{CALL  PKG_HBOARD.PROC_BOARD_BOARDCOMMENTVIEW(?, ?) }";
			cstmt         =  conn.prepareCall( sql );
			
			cstmt.setInt(1,  idx);
			cstmt.registerOutParameter(2, 
					oracle.jdbc.OracleTypes.CURSOR );
			
			cstmt.executeQuery();
			
			OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt; 
			
			rs  =  ocstmt.getCursor( 2 );  // 2번째
			
			if( rs.next() ) {
						
				int      comment_idxnum     =  rs.getInt("comment_idx");
				int      comment_hboard  =  rs.getInt("comment_hboard");
				String   comment_writer  =  rs.getString("comment_writer");   
				String   comment_regdate =  rs.getString("comment_regdate");   
				String   comment_cont    =  rs.getString("comment_cont");
				int      comment_bnum    =  rs.getInt("comment_bnum");
				int      comment_lvl     =  rs.getInt("comment_lvl");
				int      comment_step    =  rs.getInt("comment_step");
				int      comment_nref    =  rs.getInt("comment_nref");
				int      comment_delnum  =  rs.getInt("comment_delnum");
				
				commentVo = new CommentVo(0, comment_idxnum, comment_hboard, comment_writer, comment_regdate, comment_cont, comment_bnum, comment_lvl, comment_step, comment_nref, comment_delnum, comment_delnum);
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
		
		return commentVo;
	}
	
}
