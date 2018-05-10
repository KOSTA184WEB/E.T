package et.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import et.model.dto.MemberDTO;
import et.util.DbUtil;

public class MemberDAO {
	//
	/**
	 * id 중복 체크
	 */
	public static String idCheck(String memberId) throws SQLException {// id중복체크
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		String result = "사용가능합니다.";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select id from member where id=?");
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = "중복입니다.";
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	public static int insert(MemberDTO dto) throws SQLException { // 회원 가입
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			// con.setAutoCommit(false); // 자동커밋 false로 지정
			ps = con.prepareStatement("insert into member values(?,?,?,?,(to_char(sysdate,'rrrr')-substr(?,0,4)),?,?,?,?,?,'conf',?,?)");
			ps.setString(1, dto.getMemberId());
			ps.setString(2, dto.getMemberPw());
			ps.setString(3, dto.getMemberName());
			ps.setInt(4, dto.getMemberBirth());
			ps.setInt(5, dto.getMemberBirth());
			ps.setString(6, dto.getMemberGender());
			ps.setString(7, dto.getMemberPhone());
			ps.setString(8, dto.getMemberEmail());
			ps.setString(9, dto.getMemberQuestion());
			ps.setString(10, dto.getMemberAnswer());
			ps.setInt(11, 0);
			ps.setInt(12, 0);
			result = ps.executeUpdate(); // 쿼리 실행

		} finally {
			DbUtil.dbClose(con, ps, null);
		}
		return result;
	}

	/**
	 * 로그인 체크
	 */
	public static int loginCheck(String memberId, String memberPw) throws SQLException { // db에 저장된 id와 pw를 체크한다
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String dbPW = ""; // db에서 꺼낸 비밀번호를 담을 변수
		int result = -1;
		try {
			StringBuffer query = new StringBuffer(); // 아마 아래에 ps에서 쓰려고 한것 같은데 맞나
			query.append("SELECT MEMBER_PW FROM member WHERE member_id=?");

			con = DbUtil.getConnection();
			ps = con.prepareStatement(query.toString());
			ps.setString(1, memberId);
			rs = ps.executeQuery(); // 실행

			if (rs.next()) { // 입력된 아이디에 해당하는 비밀번호가 존재하는 경우
				dbPW = rs.getString(1);
				System.out.println("디비비밀번호: " + dbPW);

				if (dbPW.equals(memberPw))
					result = 1; // 넘겨받은 비번이 같음
				else
					result = 0; // 넘겨받은 비번 다름
			} else {
				result = -1; // 찾는 아이디가 존재하지 않을 경우
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return result;
	}

	/**
	 * 로그인한 회원 정보 담기
	 */
	public static MemberDTO selectMember(String memberId) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select member_pw,member_name,member_birth,member_age,member_gender,member_phone,member_email,member_question,member_answer from member where member_id=?";
		MemberDTO memberDTO = new MemberDTO();

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			rs = ps.executeQuery(); // 실행

			if (rs.next()) { // 입력된 아이디에 해당하는 정보 가져오기
				String memPw = rs.getString(1);
				String memName = rs.getString(2);
				int memBirth = rs.getInt(3);
				int memAge = rs.getInt(4);
				String memGender = rs.getString(5);
				String memPhone = rs.getString(6);
				String memEmail = rs.getString(7);
				String memQuest = rs.getString(8);
				String memAnsw = rs.getString(9);

				memberDTO = new MemberDTO(memberId, memPw, memName, memBirth, memAge, memGender, memPhone, memEmail, memQuest, memAnsw);
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return memberDTO;
	}

	public static List<MemberDTO> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 회원 정보 수정
	 */
	public static int updateMember(MemberDTO memberDTO) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update member set member_pw=?, member_phone=?, member_email=?, member_answer=? where member_id=?"; // 비밀번호, 전화번호, 이메일, 답변
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberDTO.getMemberPw());
			ps.setString(2, memberDTO.getMemberPhone());
			ps.setString(3, memberDTO.getMemberEmail());
			ps.setString(4, memberDTO.getMemberAnswer());
			ps.setString(5, memberDTO.getMemberId()); 

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}

		return result;

	}

	/**
	 * 회원 탈퇴
	 */
	public static int delete(String memberId) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("delete from member where memberId=?");
			ps.setString(1, memberId);
			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
