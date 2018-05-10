package et.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			long deadLine = Long.parseLong(meetingDto.getMeetingDate())-10000;
			ps.setString(1, "3");
			ps.setString(2, meetingDto.getResId());
			ps.setString(3, meetingDto.getMenu());
			ps.setInt(4, meetingDto.getMaxNum());
			ps.setString(5, meetingDto.getMeetingDate());
			ps.setString(6, deadLine+"");
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
		Connection con =null;
		PreparedStatement ps = null;
		int result=0;
		try {
			System.out.println(meetingDto.getResId());
			System.out.println(meetingDto.getMenu());
			System.out.println(meetingDto.getMaxNum());
			System.out.println(meetingDto.getMeetingDate());
			System.out.println(meetingDto.getDeadline());
			System.out.println(meetingDto.getMeetingDes());
			System.out.println(meetingDto.getMeetingTitle());
			System.out.println(meetingDto.getGenderOption());
			System.out.println(meetingDto.getMeetingId());

			con =DbUtil.getConnection();
			ps=con.prepareStatement("update meeting set res_id=?,menu=?,max_num=?,meeting_date=to_date(?,'yyyyMMddhh24miss'),deadline=to_date(?,'yyyyMMddhh24miss'),meeting_description=?,meeting_title=?,gender_option=? where meeting_id=? ");
			long deadline = Long.parseLong(meetingDto.getMeetingDate())-10000;
			ps.setString(1, meetingDto.getResId());
			ps.setString(2, meetingDto.getMenu());
			ps.setInt(3, meetingDto.getMaxNum());
			ps.setString(4, meetingDto.getMeetingDate());
			ps.setString(5, deadline+"");
			ps.setString(6, meetingDto.getMeetingDes());
			ps.setString(7, meetingDto.getMeetingTitle());
			ps.setString(8, meetingDto.getGenderOption());
			ps.setString(9, meetingDto.getMeetingId());
			result= ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	

	public static int deleteMeeting(String meetId) throws SQLException {
		return 0;

	}

	public static String searchResIdByMeetingId(String meetingId) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String dbResId = null;
		try {
			con =DbUtil.getConnection();
			ps=con.prepareStatement("select res_id from meeting where meeting_id =?");
			ps.setString(1, meetingId);
			rs= ps.executeQuery();
			
			if(rs.next()) {
				dbResId = rs.getString(1);
				System.out.println(dbResId);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dbResId;
	}
}
