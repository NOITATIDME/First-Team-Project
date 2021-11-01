package file.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import file.db.DBConn;

public class FileDao {
		
		public int upload(String fileName, String fileRealName, int bbsID) {
			
			Connection        conn    = null;
			PreparedStatement pstmt   = null;
			
			try {
				DBConn db  = new DBConn();
				conn       = db.getConnection();
				String sql = "INSERT INTO bbs_file VALUES (?,?,?)";
				pstmt.setString(1, fileName);
				pstmt.setString(2, fileRealName);
				pstmt.setInt(3, bbsID);
				return pstmt.executeUpdate();
			} catch (Exception e) {
				
			}
			return -1;
			
		}
}
	