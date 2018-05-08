package et.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import et.model.dto.MeetingDTO;
import et.model.dto.RestaurantDTO;
import et.util.DbUtil;

public class MeetingDAO {
	/********************** Meeting CRUD **********************/
	public static int insertMeeting(MeetingDTO meetingDto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("insert into meeting values(meet_seq.nextval,?,?,0,?,?,TO_DATE(?, 'yyyyMMddhh24miss'),TO_DATE(?, 'yyyyMMddhh24miss'),?,?,'default',?)");
			//ps = con.prepareStatement("insert into meeting values(meet_seq.nextval,?,?,0,?,?,sysdate,sysdate,?,?,'default',?)");

			System.out.println(meetingDto.getMemberId() + " | " + meetingDto.getResId() + " | " + meetingDto.getMenu() + " | " + meetingDto.getMaxNum()
					+ " | " + meetingDto.getMeetingDate() + " | " + meetingDto.getDeadline() + " | " + meetingDto.getMeetingDes() + " | " + meetingDto.getMeetingTitle()
					+ " | " + meetingDto.getGenderOption() + " | ");
			ps.setString(1, "3");
			ps.setString(2, meetingDto.getResId());
			ps.setString(3, meetingDto.getMenu());
			ps.setInt(4, meetingDto.getMaxNum());
			ps.setString(5, meetingDto.getMeetingDate());
			ps.setString(6, meetingDto.getMeetingDate());
			ps.setString(7, meetingDto.getMeetingDes());
			ps.setString(8, meetingDto.getMeetingTitle());
			ps.setString(9, meetingDto.getGenderOption());
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	public static List<MeetingDTO> selectAllMeeting() throws SQLException {
		return null;

	}

	public static RestaurantDTO selectMeeting(String meetId) throws SQLException {
		return null;

	}

	public static int updateMeeting(MeetingDTO meetingDto) throws SQLException {
		return 0;

	}

	public static int deleteMeeting(String meetId) throws SQLException {
		return 0;

	}
}
