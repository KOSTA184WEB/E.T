package et.model.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import et.model.dao.ReviewDAO;
import et.model.dao.ReviewDAOImpl;
import et.model.dto.AdminDTO;
import et.model.dto.MeetingDTO;
import et.model.dto.MemberDTO;
import et.model.dto.RestaurantDTO;
import et.model.dto.ReviewDTO;

public class EtServiceImpl implements EtService {

	@Override
	public int insertMember(MemberDTO memberDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberDTO> selectAllMember() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO selectMember(String memberId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(MemberDTO memberDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memberId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isParticipant(String memberId, String meetingId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertParticipant(String memberId, String meetingId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteParticipant(String memberId, String meetingId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertRestaurant(RestaurantDTO restaurantDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RestaurantDTO> selectAllRestaurant() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDTO selectRestaurant(String resId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateRestaurant(RestaurantDTO restaurantDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRestaurant(String resId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMeeting(MeetingDTO meetingDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MeetingDTO> selectAllMeeting() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDTO selectMeeting(String meetId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMeeting(MeetingDTO meetingDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMeeting(String meetId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
///////////////////////////////////////////////////////////////////////
	ReviewDAO reviewDAO = new ReviewDAOImpl();
	@Override
	public int insertReview(ReviewDTO reviewDto) throws SQLException {
		int result = reviewDAO.insertReview(reviewDto);
		if(result==0) throw new SQLException("등록되지 않았습니다");
		return result;
	}

	@Override
	public List<ReviewDTO> selectAllReview() throws SQLException {
		List<ReviewDTO> list = reviewDAO.selectAllReview();
		//System.out.println("서비스:"+list);
		return list;
	}

	@Override
	public ReviewDTO selectReview(String reviewId, boolean state) throws SQLException {
		//조회수 증가
		if(state) {
			if(reviewDAO.addReviewReadNum(reviewId)==0) {
				throw new SQLException("조회수를 증가시킬 수 없습니다");
			}
		}
		//상세보기
		ReviewDTO reviewDto = reviewDAO.selectReview(reviewId);
		if(reviewDto==null) throw new SQLException(reviewId+"에 해당하는 후기가 없습니다");
		return reviewDto;
	}

	@Override
	public int updateReview(ReviewDTO reviewDto) throws SQLException {
		int result=reviewDAO.updateReview(reviewDto);
		if(result==0) throw new SQLException("수정되지 않았습니다");
		return result;
	}

	@Override
	public int deleteReview(String reviewId,String reviewPw) throws SQLException {
		int result=reviewDAO.deleteReview(reviewId, reviewPw);
		if(result==0) throw new SQLException("삭제되지 않았습니다");
		return result;
	}
	
	@Override
	public List<String> selectMeetingsById(String memberId) throws SQLException{
		List<String> list=reviewDAO.selectMeetingsById(memberId);
		if(list==null) throw new SQLException("해당되는 모집ID가 없습니다");
		return list;
	}
	
	@Override 
	public String selectMeetingTitle(String meetingId) throws SQLException{
		String meetingTitle =reviewDAO.selectMeetingTitle(meetingId);
		if(meetingTitle==null) throw new SQLException("해당되는 글이 없습니다");
		return meetingTitle;
	}
	
	@Override
	public String selectRestaurantId(String meetingId) throws SQLException{
		String resId =reviewDAO.selectRestaurantId(meetingId);
		System.out.println("service resId :"+resId);
		if(resId==null) throw new SQLException("해당되는 음식점이 없습니다");
		return resId;
	}
	
	@Override
	public String selectMeetingDate(String meetingId) throws SQLException{
		String meetingDate = reviewDAO.selectMeetingDate(meetingId);
		if(meetingDate==null) throw new SQLException("해당되는 모임날짜가 없습니다");
		return meetingDate;
	}
	
	@Override
	public int insertResturantRate(int resRate, String resId) throws SQLException{
		int result = reviewDAO.insertResturantRate(resRate, resId);
		if(result==0) throw new SQLException("평점을 추가하지 못했습니다");
		return result;
	}
	
	@Override
	public int selectRestaurantRate(String resId) throws SQLException{
		int result = reviewDAO.selectRestaurantRate(resId);
		if(result==0) throw new SQLException("해당되는 평점이 없습니다");
		return result;
	}
	
	@Override
	public String selectRestaurantKind(String resId) throws SQLException{
		String resKind=reviewDAO.selectRestaurantKind(resId);
		if(resKind==null) throw new SQLException("해당되는 음식종류가 없습니다");
		return resKind;
	}
	
	@Override
	public List<ReviewDTO> searchBykeyWord(String keyField, String keyWord) throws SQLException{
		List<ReviewDTO> list = reviewDAO.searchBykeyWord(keyField, keyWord);
		if(list==null) throw new SQLException("해당되는 후기가 없습니다");
		return list;
	}
///////////////////////////////////////////////////////////////////////////////////
	@Override
	public int insertAdmin(AdminDTO adminDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RestaurantDTO selectAdmin(String adminId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAdmin(AdminDTO adminDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAdmin(String adminId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isMeetingOpener(String meetingId, String memberId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int searchMeetingByKeyWord(String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
