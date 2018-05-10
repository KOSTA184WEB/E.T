package et.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import et.model.dto.ReviewDTO;
import et.util.DbUtil;

public class ReviewDAOImpl implements ReviewDAO {

	@Override
	public int insertReview(ReviewDTO reviewDto) throws SQLException {
		Connection con= null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("insert into review values(SEQ_REVIEW.NEXTVAL,?,?,?,?,?,sysdate,0,?,?,?)");

			ps.setString(1, reviewDto.getMemberId());
			ps.setString(2, reviewDto.getMeetingId());
			ps.setString(3, reviewDto.getResId());
			ps.setString(4, reviewDto.getReviewTitle());
			ps.setString(5, reviewDto.getReviewContents());
			ps.setString(6, reviewDto.getFileName());
			ps.setInt(7, reviewDto.getFileSize());
			ps.setString(8, reviewDto.getReviewPw());
			
			i=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return i;
	}

	@Override
	public int deleteReview(String reviewId, String reviewPw) throws SQLException {
		Connection con= null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("delete from review where review_id=? and board_pw=?");
			ps.setString(1, reviewId);
			ps.setString(2, reviewPw);
			i=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return i;
	}

	@Override
	public int updateReview(ReviewDTO reviewDto) throws SQLException {
		Connection con= null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("update review set meeting_id=?, res_id=?, review_title=?, review_contents=? where review_id=? and board_pw=?");
			ps.setString(1, reviewDto.getMeetingId());
			ps.setString(2, reviewDto.getResId());
			ps.setString(3, reviewDto.getReviewTitle());
			ps.setString(4, reviewDto.getReviewContents());
			ps.setString(5, reviewDto.getReviewId());
			ps.setString(6, reviewDto.getReviewPw());
			
			i=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return i;
	}

	@Override
	public List<ReviewDTO> selectAllReview() throws SQLException {
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ReviewDTO> list = new ArrayList<>();
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("select * from review");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				ReviewDTO reviewDto = new ReviewDTO
						(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
								rs.getString(5), rs.getString(6), rs.getString(7), 
								rs.getInt(8),rs.getString(9),rs.getInt(10), rs.getString(11));
				list.add(reviewDto);
						
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		//System.out.println(list);
		return list;
	}
	
	@Override
	public ReviewDTO selectReview(String reviewId) throws SQLException {
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ReviewDTO reviewDto=null;
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("select * from review where review_id=?");
			ps.setString(1, reviewId);
			//System.out.println(reviewId);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				reviewDto = new ReviewDTO
						(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
								rs.getString(5), rs.getString(6), rs.getString(7), 
								rs.getInt(8),rs.getString(9),rs.getInt(10), rs.getString(11));
						
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return reviewDto;
	}	

	@Override
	public int addReviewReadNum(String reviewId) throws SQLException {
		Connection con= null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("update review set review_readnum =review_readnum+1 where review_id=?");
			ps.setString(1, reviewId);
			i=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return i;
	}
	
	@Override
	public List<String> selectMeetingsById(String memberId) throws SQLException{
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<String> list = new ArrayList<>();
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("select meeting_id from participant where member_id=?");
			ps.setString(1, memberId);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String meetingId =rs.getString(1);
				
				list.add(meetingId);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	@Override 
	public String selectMeetingTitle(String meetingId) throws SQLException{
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String meetingTitle=null;
		
		try {
			con=DbUtil.getConnection();
			ps= con.prepareStatement("select meeting_title from meeting where meeting_id=?");
			ps.setString(1, meetingId);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				meetingTitle = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return meetingTitle;
	}
	
	@Override
	public String selectRestaurantId(String meetingId) throws SQLException{
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String resId=null;
		
		try {
			con=DbUtil.getConnection();
			ps= con.prepareStatement("select res_id from meeting where meeting_id=?");
			ps.setString(1, meetingId);
			rs=ps.executeQuery();
			if(rs.next()) {
				resId=rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return resId;
	}
	
	@Override
	public String selectMeetingDate(String meetingId) throws SQLException{
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String meeting_date=null;
		//System.out.println("meetingId:"+meetingId);
		try {
			con=DbUtil.getConnection();
			ps= con.prepareStatement("select meeting_date from meeting where meeting_id=?");
			ps.setString(1, meetingId);
			rs=ps.executeQuery();
			
			if(rs.next()) {				
				meeting_date=rs.getString(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return meeting_date;
	}
	
	@Override
	public int insertResturantRate(int resRate, String resId) throws SQLException{
		Connection con= null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("update restaurant set res_rate=(res_rate*res_rate_count+?)/(res_rate_count+1), "
					+ "res_rate_count=res_rate_count+1 where res_id =?");
			ps.setInt(1, resRate);
			ps.setString(2, resId);
			i=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return i;
	}
	
	@Override
	public int selectRestaurantRate(String resId) throws SQLException{
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int resRate=0;
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("select res_rate from restaurant where res_id=? ");
			ps.setString(1, resId);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				resRate=rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return resRate;
	}
	
	@Override
	public String selectRestaurantKind(String resId) throws SQLException{
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String resKind=null;
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("select res_kind from restaurant where res_id=? ");
			ps.setString(1, resId);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				resKind=rs.getString(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return resKind;
	}
	
	@Override
	public List<ReviewDTO> searchBykeyWord(String keyField, String keyWord) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql =null;
		List<ReviewDTO> list = new ArrayList<>();
		
		try {
			con=DbUtil.getConnection();
			if(keyField.equals("memberId")) {
				sql = "select * from review where member_id like ?";
				
			}else if(keyField.equals("reviewTitle")) {
				sql = "select * from review where review_title like ?";
			}else {
				sql = "select * from review where res_id like ?";
			}
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%");
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				ReviewDTO reviewDto = new ReviewDTO
						(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
								rs.getString(5), rs.getString(6), rs.getString(7), 
								rs.getInt(8),rs.getString(9),rs.getInt(10), rs.getString(11));
				list.add(reviewDto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	
	@Override
	public int AdminDeleteReview(String reviewId) throws SQLException{
		Connection con= null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement("delete from review where review_id=?");
			ps.setString(1, reviewId);
			i=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return i;
	}
	
}
