package survey.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import survey.db.DBConn;
import oracle.jdbc.OracleCallableStatement;
import survey.vo.SurveyVo;

public class SurveyDao {

	public List<SurveyVo> getHairList(String face) {
		
		List<SurveyVo>    list  = new ArrayList<SurveyVo>();
		Connection        conn  = null; 
		CallableStatement cstmt = null;
		ResultSet         rs    = null;
		
	    try {
			DBConn  db   =  new DBConn();
			conn         =  db.getConnection();
			String  sql  =  "{CALL PKG_SURVEY.PROC_HAIR_LIST(?, ?) }";
			cstmt        =  conn.prepareCall(sql);
			
			cstmt.setInt( 1, Integer.parseInt(face) );   // face_num    
			cstmt.registerOutParameter(2, 
				oracle.jdbc.OracleTypes.CURSOR ); // 결과 , cursor
			
			cstmt.execute();  // 스토어드 프로시저 실행
						
			// rs = cstmt.getResultSet(); // 작동안함 - 사용불가
			
			OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt;
			
			rs    =     ocstmt.getCursor(2);
			while( rs.next() ) {
				int       face_num   =  rs.getInt("face_num");
				String    face_name  =  rs.getString("face_name");
				String    hair_id    =  rs.getString("hair_id");
				String    hair_name  =  rs.getString("hair_name");
				SurveyVo  SurveyVo    =  new SurveyVo( face_num, face_name, hair_id, hair_name );
				
				list.add(SurveyVo);	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
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

	public SurveyVo getHair(String hair_id) {
		
		SurveyVo		surveyVo    = null;
		Connection         conn     = null;
		CallableStatement  cstmt    = null;
		
		try {
			DBConn  db  = new DBConn();
			conn 		= db.getConnection();
			String  sql = "{CALL PKG_SURVEY.PROC_HAIR_VIEW(?,?,?,?) }"; 
			cstmt       = conn.prepareCall(sql);
			
			// 프로시저 파라미터 처리
			cstmt.setString(1, hair_id);                   // 첫번재 ? : hair_id
			// out 파라미터 등록
			cstmt.registerOutParameter(2, Types.VARCHAR);  // 2번째 ?  face_name
			cstmt.registerOutParameter(3, Types.VARCHAR);  // 3번째 ?  hair_id 
			cstmt.registerOutParameter(4, Types.VARCHAR);  // 4번째 ?  hair_name
			
			cstmt.executeQuery(); // 프로시저실행
			
			String o_face_name  =  cstmt.getString(2); 
			String o_hair_id 	=  cstmt.getString(3); 
			String o_hair_name  =  cstmt.getString(4);
		
			surveyVo	= new SurveyVo(o_face_name, o_hair_id, o_hair_name);
			System.out.println("SurveyDao surveyVo:" + surveyVo);
			
		} catch(SQLException e) {
			e.printStackTrace();			
		} finally {
			try {
				if(cstmt != null) cstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return surveyVo;
	}

	public void reserveHair(String cid, String hair_name, String resday) {
		
		Connection         conn    =  null;
		CallableStatement  cstmt   =  null;
		
		try {
			DBConn   db  =  new DBConn();
			conn         =  db.getConnection();
			String  sql  =  "{ CALL PKG_SURVEY.PROC_RESERVE(?,?,?) }";
			cstmt        =  conn.prepareCall(sql);
			
			cstmt.setString(1, cid );
			cstmt.setString(2, hair_name );
			cstmt.setString(3, resday );
			
			cstmt.executeUpdate();
			
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


}
