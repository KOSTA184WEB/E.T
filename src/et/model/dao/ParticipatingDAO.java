package et.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import et.model.dto.MeetResDTO;
import et.model.dto.MeetingDTO;
import et.model.dto.ParticipantDTO;
import et.util.DbUtil;

public class ParticipatingDAO {
	public List<MeetingDTO> selectAllPart() throws SQLException{
		Connection con= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MeetingDTO> list = new ArrayList<>();
		System.out.println("dao¾È³ç");
		try {
			con=DbUtil.getConnection();
			ps = con.prepareStatement("select * from meeting ");
			rs =ps.executeQuery();
			while(rs.next()) {
				MeetingDTO dto = new MeetingDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
				list.add(dto);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		System.out.println(list);
		return list;
	}
	
	public MeetResDTO selectById(String meetingId) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MeetResDTO dto = null;
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement("select RESTAURANT.RES_ADDRESS,RESTAURANT.RES_NAME,MEETING.APPLY_NUM,MEETING.GENDER_OPTION,MEETING.MEETING_DATE,MEETING.MEETING_DESCRIPTION, RESTAURANT.lat, RESTAURANT.lng, Meeting.meeting_id ,Meeting.MAX_NUM from MEETING,RESTAURANT where RESTAURANT.RES_ID=MEETING.RES_ID and meeting.meeting_id=?");
			ps.setString(1, meetingId);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto= new MeetResDTO(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getDouble(8),rs.getString(9),rs.getInt(10));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return dto;
	}

	public int updateByReadNum(String meetingId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertParticipant(ParticipantDTO dto) throws SQLException {
		Connection con= null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("insert into participant values(?,?,?,?,sysdate,?)");
			ps.setString(1, dto.getParticipantId());
			ps.setString(2, dto.getMemberId());
			ps.setString(3, dto.getMeetingId());
			ps.setString(4, dto.getParticipantCancel());
			ps.setInt(5, dto.getApplyNum());
			result=ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;		
	}
	
	public int countApplyNum(String meetingId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps =con.prepareStatement("select count(1) from participant where MEETING_id =?");
			ps.setString(1, meetingId);
			rs =ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
				System.out.println("resutl:"+result);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
		
	}

	public void updateApplyNum(String meetingId) throws SQLException {
		Connection con= null;
		PreparedStatement ps = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("update meeting set apply_num=apply_num+1 where meeting_id=?");
			ps.setString(1, meetingId);
			ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
	}
	
	public int meetCheck(String meetingId, String loginId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps =con.prepareStatement("select*from  participant  where member_id=? and meeting_id=?");
			ps.setString(1, loginId);
			ps.setString(2, meetingId);
			rs = ps.executeQuery();
			if(rs.next()) {
				result=1;
			}
		}finally{
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
		
	}

}
