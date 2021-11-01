package member.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import member.db.DBConn;
import member.vo.MemberVo;
import oracle.jdbc.OracleCallableStatement;

public class MemberDao {

	// 회원 목록 페이징 조회
	public List<MemberVo> getMemberPagingList(int nowpage, int pagecount) {
		
		List<MemberVo>     list  = new ArrayList<MemberVo>();
		Connection        conn  = null; 
		CallableStatement cstmt = null;
		ResultSet         rs    = null;
		
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "{CALL  PKG_MEMBER.PROC_MEMBER_PAGINGLIST(?, ?, ?, ?) }";
			cstmt = conn.prepareCall(sql);
			
			cstmt.setInt(1,  nowpage);                // nowpage     
			cstmt.setInt(2,  pagecount);              // pagecount     
			cstmt.registerOutParameter(3, 
				Types.NUMERIC );                      // 결과 , 전체자료수
			cstmt.registerOutParameter(4, 
					oracle.jdbc.OracleTypes.CURSOR ); // 결과 , cursor
			
			cstmt.execute();  // 스토어드 프로시저 실행
			
			OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt;
			
			int  totalcount  = ocstmt.getInt(3);
			
			rs    =     ocstmt.getCursor(4);
			while( rs.next() ) {
				int      rn         =  rs.getInt("RN");
				String   cid        =  rs.getString("CID");
				String   cpwd       =  rs.getString("CPWD");
				String   cbirth     =  rs.getString("CBIRTH");   
				String   cname      =  rs.getString("CNAME");   
				String   cemail     =  rs.getString("CEMAIL");
				String   cresult    =  rs.getString("CRESULT");
				String   resday     =  rs.getString("RESDAY");
			
				MemberVo  memberVo    =  new MemberVo(rn, cid, cpwd, cbirth, cname, cemail, cresult, resday, totalcount);
				
				list.add(memberVo);				
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

	// 회원 목록 조회
	public List<MemberVo> getMemberList() {
		
		List<MemberVo>     list  = new ArrayList<MemberVo>();
		Connection        conn  = null; 
		CallableStatement cstmt = null;
		ResultSet         rs    = null;
		
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "{CALL  PKG_MEMBER.PROC_MEMBER_MEMBERLIST(?) }";
			cstmt = conn.prepareCall(sql);
			
			cstmt.registerOutParameter(1, 
					oracle.jdbc.OracleTypes.CURSOR ); // 결과 , cursor
			
			cstmt.execute();  // 스토어드 프로시저 실행
			
			OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt;
			
			rs    =     ocstmt.getCursor(1);
			while( rs.next() ) {
				String   cid        =  rs.getString("CID");
				String   cpwd       =  rs.getString("CPWD");
				String   cbirth     =  rs.getString("CBIRTH");   
				String   cname      =  rs.getString("CNAME");   
				String   cemail     =  rs.getString("CEMAIL");
				String   cresult    =  rs.getString("CRESULT");
				String   resday     =  rs.getString("RESDAY");
			
				MemberVo  memberVo    =  new MemberVo(0, cid, cpwd, cbirth, cname, cemail, cresult, resday);
				
				list.add(memberVo);				
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
	
	// 아이디, 비밀번호 일치 확인
	public MemberVo getLogin(String cid, String cpwd) {
		MemberVo memberVo = null;
		Connection        conn  = null; 
		CallableStatement cstmt = null;
		
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "{CALL  PKG_CLIENTINFO.PROC_CINFO_LOGIN(?, ?, ?, ?) }";
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, cid);
			cstmt.setString(2, cpwd);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			
			cstmt.executeQuery();
			
			String o_cid = cstmt.getString(3);
			String o_cpwd = cstmt.getString(4);
			
			memberVo = new MemberVo(o_cid, o_cpwd);
			System.out.println("memberVo= " + memberVo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( cstmt != null ) cstmt.close();
				if( conn  != null ) conn.close();
			} catch (SQLException e) {
			}
		}
		
		return memberVo;
	}

	public void memberInsert(MemberVo vo) {
		  
	      Connection         conn    = null;
	      CallableStatement  cstmt   = null;
	        
	      try {
	         DBConn db  = new DBConn();
	         conn       = db.getConnection();
	         String sql = "{CALL PKG_CLIENTINFO.PROC_CINFO_INSERT(?,?,?,?,?)}";
	         cstmt = conn.prepareCall(sql);
	         
	         cstmt.setString(1, vo.getCid());
	         cstmt.setString(2, vo.getCpwd());
	         cstmt.setString(3, vo.getCname());
	         
	         String cbirth  = vo.getCbirth();
	         System.out.println(cbirth);
	         String year    = cbirth.substring(0,4); 
	         String month   = cbirth.substring(5,7); 
	         String day     = cbirth.substring(8); 
	         String birthday   = year + month + day;
	         int    birth   = Integer.parseInt(birthday);
	         cstmt.setInt(4, birth);
	         
	         cstmt.setString(5, vo.getCemail());
	         
	         if(vo.getCid() == null || vo.getCid().equals("")) {}
	         if(vo.getCpwd() == null || vo.getCpwd().equals("")) {}
	         if(vo.getCname() == null || vo.getCname().equals("")) {}
	         if(vo.getCemail() == null || vo.getCemail().equals("")) {}
	         
	         cstmt.executeQuery();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }  finally {
	         try {
	            if( cstmt != null ) cstmt.close();
	            if( conn  != null ) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	}

	public String getName(String cid) {
		String           cname  = null;
		Connection        conn  = null; 
		CallableStatement cstmt = null;
		
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "{CALL  PKG_CLIENTINFO.PROC_CINFO_GET_NAME(?, ?) }";
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, cid);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			
			cstmt.executeQuery();
			
			cname = cstmt.getString(2);
			System.out.println(cname);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
						if( cstmt != null ) cstmt.close();
						if( conn  != null ) conn.close();
					} catch (SQLException e) {
					}
				
			}
		return cname;		
	}

	public String getPwd(String cid) {
		String           passwd  = null;
		Connection        conn  = null; 
		CallableStatement cstmt = null;
		
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "{CALL  PKG_CLIENTINFO.PROC_CINFO_GET_PWD(?, ?) }";
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, cid);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			
			cstmt.executeQuery();
			
			passwd = cstmt.getString(2);

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
						if( cstmt != null ) cstmt.close();
						if( conn  != null ) conn.close();
					} catch (SQLException e) {
					}
				
			}
		return passwd;	
		
	}

}
