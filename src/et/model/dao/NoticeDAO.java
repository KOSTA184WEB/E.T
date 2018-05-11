package et.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import et.model.dto.NoticeDTO;
import et.util.DbUtil;

public class NoticeDAO {
	/**
	 * 전체 출력
	 **/
	public List<NoticeDTO> selectNoticeAll() throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<NoticeDTO> list = new ArrayList<>();
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("select * from admin_board");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				NoticeDTO noticeDTO = new NoticeDTO
						(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9));
				
				list.add(noticeDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	
	/**
	 * 공지 작성하기
	 */
	public int insertNotice(NoticeDTO noticeDTO) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		String sql = "insert into admin_board values(admin_board_seq.nextval,?,?,?,sysdate,0,?,?,?)";
		int result = 0;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1,noticeDTO.getAdminId());
			ps.setString(2,noticeDTO.getNoticeTitle());
			ps.setString(3,noticeDTO.getNoticeContents());
			ps.setString(4,noticeDTO.getfileName());
			ps.setInt(5,noticeDTO.getfileSize());
			ps.setString(6,noticeDTO.getIsPublic());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;		
	}
	
	/**
	 * 공지 자세히보기
	 **/
	public NoticeDTO selectNotice(String noticeId) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		NoticeDTO noticeDTO =null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("select * from admin_board where admin_board_id=?");
			ps.setString(1, noticeId);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				noticeDTO = new NoticeDTO
						(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return noticeDTO;
	}
	
	/**
	 * 조회수 증가
	 **/
	public int addNoticeReadNum(String noticeId) throws SQLException{
		Connection con= null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("update admin_board set admin_readnum =admin_readnum+1 where admin_board_id=?");
			ps.setString(1, noticeId);
			i=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return i;
	}
	
	/**
	 * 수정하기
	 **/
	public int updateNotice(NoticeDTO noticeDTO) throws SQLException{
		Connection con= null;
		PreparedStatement ps=null;
		int i=0;

		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("update admin_board set admin_title=?, admin_contents=?, isPublic=? where admin_board_id=?");
			ps.setString(1,noticeDTO.getNoticeTitle());
			ps.setString(2, noticeDTO.getNoticeContents());
			ps.setString(3, noticeDTO.getIsPublic());
			ps.setString(4, noticeDTO.getNoticeId());
			
			i=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return i;
	}
	
	/**
	 * 삭제하기
	 **/
	public int deleteNotice(String noticeId) throws SQLException{
		Connection con= null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("delete from admin_board where admin_board_id=?");
			ps.setString(1, noticeId);
			i=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return i;
	}
}
