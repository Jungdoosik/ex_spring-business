package kr.or.iei.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import kr.or.iei.member.model.vo.Member;

@Repository(value="mDAO")
public class MemberDAO {

	public Member selectLoginMember(Connection conn, String userId, String userPwd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		
		String query = "select * from member where user_Id=? and user_Pwd = ? and end_YN='N'";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m = new Member();
				m.setUserNo(rset.getInt("user_No"));
				m.setUserId(rset.getString("user_Id"));
				m.setUserPwd(rset.getString("user_Pwd"));
				m.setUserName(rset.getString("user_Name"));
				m.setUserAddr(rset.getString("user_Addr"));
				m.setRegDate(rset.getDate("reg_Date"));
				m.setEndYN(rset.getString("end_YN").charAt(0));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;
	}

}
