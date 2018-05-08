package et.model.service;

import java.sql.SQLException;
import java.util.List;

import et.model.dao.EtDAO;
import et.model.dao.EtDAOImpl;
import et.model.dao.MeetingDAO;
import et.model.dao.RestaurantDAO;
import et.model.dto.AdminDTO;
import et.model.dto.MeetingDTO;
import et.model.dto.MemberDTO;
import et.model.dto.RestaurantDTO;
import et.model.dto.ReviewDTO;

public class EtServiceImpl implements EtService {
	EtDAO etDao = new EtDAOImpl();
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
		int re = 0;
		//restaurant가 등록되어있는지 판별
		String resId = RestaurantDAO.isNewRestaurant(restaurantDto.getResAddress());
		if(resId==null){
			re = RestaurantDAO.insertRestaurant(restaurantDto);
		}else {
			RestaurantDAO.updateMeetingCount(resId);
		}
		return re;
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
	public String searchResIdByAddr(String addr) throws SQLException {
		//restaurant가 등록되어있는지 판별
		String resId = RestaurantDAO.searchResIdByAddr(addr);

		return resId;
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
		int re = 0;
		//meeting Dto insert
		re = MeetingDAO.insertMeeting(meetingDto);
		if(re == 0) {
			throw new SQLException("모임이 생성되지 않았습니다.");
		}
		return re;
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

	@Override
	public int insertReview(ReviewDTO reviewDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReviewDTO> selectAllReview() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDTO selectReview(String reviewId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReview(ReviewDTO reviewDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReview(String reviewId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

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
