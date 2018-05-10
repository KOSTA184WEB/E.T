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
	 * id �ߺ� üũ
	 */
	public static String idCheck(String memberId) throws SQLException {// id�ߺ�üũ
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		String result = "��밡���մϴ�.";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select id from member where id=?");
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = "�ߺ��Դϴ�.";
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	public static int insert(MemberDTO dto) throws SQLException { // ȸ�� ����
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			// con.setAutoCommit(false); // �ڵ�Ŀ�� false�� ����
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
			result = ps.executeUpdate(); // ���� ����

		} finally {
			DbUtil.dbClose(con, ps, null);
		}
		return result;
	}

	/**
	 * �α��� üũ
	 */
	public static int loginCheck(String memberId, String memberPw) throws SQLException { // db�� ����� id�� pw�� üũ�Ѵ�
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String dbPW = ""; // db���� ���� ��й�ȣ�� ���� ����
		int result = -1;
		try {
			StringBuffer query = new StringBuffer(); // �Ƹ� �Ʒ��� ps���� ������ �Ѱ� ������ �³�
			query.append("SELECT MEMBER_PW FROM member WHERE member_id=?");

			con = DbUtil.getConnection();
			ps = con.prepareStatement(query.toString());
			ps.setString(1, memberId);
			rs = ps.executeQuery(); // ����

			if (rs.next()) { // �Էµ� ���̵� �ش��ϴ� ��й�ȣ�� �����ϴ� ���
				dbPW = rs.getString(1);
				System.out.println("����й�ȣ: " + dbPW);

				if (dbPW.equals(memberPw))
					result = 1; // �Ѱܹ��� ����� ����
				else
					result = 0; // �Ѱܹ��� ��� �ٸ�
			} else {
				result = -1; // ã�� ���̵� �������� ���� ���
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return result;
	}

	/**
	 * �α����� ȸ�� ���� ���
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
			rs = ps.executeQuery(); // ����

			if (rs.next()) { // �Էµ� ���̵� �ش��ϴ� ���� ��������
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
	 * ȸ�� ���� ����
	 */
	public static int updateMember(MemberDTO memberDTO) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update member set member_phone=?, member_email=?, member_answer=? where member_id=?"; // ��ȭ��ȣ, �̸���, �亯
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberDTO.getMemberPhone());
			ps.setString(2, memberDTO.getMemberEmail());
			ps.setString(3, memberDTO.getMemberAnswer());
			ps.setString(4, memberDTO.getMemberId());

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}

		return result;

	}

	/**
	 * ȸ�� Ż��
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
