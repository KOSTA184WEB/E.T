package et.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import et.model.dto.DepositDTO;
import et.model.dto.MeetResPartDTO;
import et.util.DbUtil;

public class MyPageDAOImpl implements MyPageDAO {

	@Override
	public List<MeetResPartDTO> selectUpcomingMeeting(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select meeting.meeting_id, meeting.meeting_date, meeting.meeting_title, participant.PARTICIPANT__DATE, participant.participant_id from meeting, participant, restaurant where meeting.meeting_id=participant.meeting_id and meeting.res_id=restaurant.res_id and participant.participant_cancel='n' and meeting.deadline > sysdate and participant.member_id=? order by meeting.meeting_date desc";
		List<MeetResPartDTO> userMeetingList = new ArrayList<>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String meetingId = rs.getString(1);
				System.out.println("meetingId=  "+meetingId);
				String arr [] = rs.getString(2).split(" ", 2);
				String meetingDate = arr[0];
				String meetingTime = arr[1];
				System.out.println("meetingDate : " + meetingDate + " meetingTime : " + meetingTime);
				String meetingTitle = rs.getString(3);				
				String arr2 [] = rs.getString(4).split(" ",2);
				String participantDate = arr2[0];				
				String participantId = rs.getString(5);
				
				MeetResPartDTO meetResPartDTO = new MeetResPartDTO(memberId, meetingId, participantId, meetingDate, meetingTime, meetingTitle, participantDate);
			
				userMeetingList.add(meetResPartDTO);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return userMeetingList;
	}

	@Override
	public List<MeetResPartDTO> selectPastMeeting(String memberId) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select meeting.meeting_id, meeting.meeting_date, meeting.meeting_title, participant.PARTICIPANT__DATE, participant.participant_id from meeting, participant, restaurant where meeting.meeting_id=participant.meeting_id and meeting.res_id=restaurant.res_id and participant.participant_cancel='n' and meeting.deadline <= sysdate and participant.member_id=? order by meeting.meeting_date desc";
		List<MeetResPartDTO> pastMeetingList = new ArrayList<>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String meetingId = rs.getString(1);
				System.out.println("meetingId=  "+meetingId);
				String arr [] = rs.getString(2).split(" ", 2);
				String meetingDate = arr[0];
				String meetingTime = arr[1];
				String meetingTitle = rs.getString(3);
				String arr2 [] = rs.getString(4).split(" ",2);
				String participantDate = arr2[0];
				String participantId = rs.getString(5);
				
				MeetResPartDTO meetResPartDTO = new MeetResPartDTO(memberId, meetingId, participantId, meetingDate, meetingTime, meetingTitle, participantDate);
			
				pastMeetingList.add(meetResPartDTO);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return pastMeetingList;
	}

	@Override
	public int cancelMeeting(String memberId, String participantId) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update participant set participant_cancel='y' where member_id=? and participant_id=?";
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			ps.setString(2, participantId);
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}
	
	@Override
	public List<DepositDTO> selectDepositList(String memberId) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select deposit.deposit_description, nvl(deposit.plus_deposit,0), nvl(deposit.minus_deposit,0), nvl(deposit.current_deposit,0), DEPOSIT.DEPOSIT_UPDATE_DATE from deposit, member where deposit.member_id=member.member_id and deposit.member_id=? order by DEPOSIT.DEPOSIT_UPDATE_DATE desc";
		
		List<DepositDTO> depositList = new ArrayList<>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			DepositDTO depositDTO = new DepositDTO();
			
			while(rs.next()) {
				
				String depositDescription = rs.getString(1);
				int plusDeposit = rs.getInt(2);
				int minusDeposit = rs.getInt(3);
				int currentDeposit = rs.getInt(4);
				String arr [] = rs.getString(5).split(" ", 2);
				String depositUpdateDate = arr[0];
				
				/*if(minusDeposit==0) { // 디파짓 증가일 때
					depositDTO = new DepositDTO(memberId, depositDescription, plusDeposit, currentDeposit, depositUpdateDate); 
					
				}else if(plusDeposit==0) { // 디파짓 차감일 때
					depositDTO = new DepositDTO(memberId, depositDescription, minusDeposit, depositUpdateDate, currentDeposit); 
				}*/
				
				depositDTO = new DepositDTO(memberId, depositDescription, plusDeposit, minusDeposit, currentDeposit, depositUpdateDate); 
							
				depositList.add(depositDTO);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return depositList;		
	}

	@Override
	public int addDeposit(DepositDTO depositDTO) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into deposit(deposit_id,member_id,deposit_description,plus_deposit,current_deposit,deposit_update_date) values(d_seq.nextval,?,?,?,(select current_deposit from deposit where deposit_update_date=(select max(deposit_update_date) from deposit))+?,sysdate)";
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, depositDTO.getMemberId());
			ps.setString(2, depositDTO.getDepositDescription());
			ps.setInt(3, depositDTO.getPlusDeposit());			
			ps.setInt(4, depositDTO.getPlusDeposit());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}
	
	@Override
	public int cutDeposit(DepositDTO depositDTO) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into deposit(deposit_id,member_id,deposit_description,minus_deposit,current_deposit,deposit_update_date) values(d_seq.nextval,?,?,?,(select current_deposit from deposit where deposit_update_date=(select max(deposit_update_date) from deposit))-?,sysdate)";
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, depositDTO.getMemberId());
			ps.setString(2, depositDTO.getDepositDescription());
			ps.setInt(3, depositDTO.getPlusDeposit());			
			ps.setInt(4, depositDTO.getPlusDeposit());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

}
