package et.model.service;

import java.sql.SQLException;
import java.util.List;

import et.model.dao.EtDAO;
import et.model.dao.EtDAOImpl;
import et.model.dao.MeetingDAO;
import et.model.dao.RestaurantDAO;
import et.model.dao.ParticipatingDAO;
import et.model.dto.AdminDTO;
import et.model.dto.MeetResDTO;
import et.model.dto.MeetingDTO;
import et.model.dto.MemberDTO;
import et.model.dto.ParticipantDTO;
import et.model.dto.RestaurantDTO;
import et.model.dto.ReviewDTO;



public class EtServiceImpl implements EtService {
	EtDAO etDao = new EtDAOImpl();

	@Override
	public int insertMember(MemberDTO memberDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberDTO> selectAllMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO selectMember(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(MemberDTO memberDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MeetingDTO> selectAllPart() throws SQLException {

		ParticipatingDAO dao = new ParticipatingDAO();
		List<MeetingDTO> list = dao.selectAllPart();
		return list;
	}

	@Override
	public MeetResDTO selectById(String meetingId, boolean flag) throws SQLException {
		ParticipatingDAO dao = new ParticipatingDAO();
/*
		if (flag) {
			if (dao.updateByReadNum(meetingId) == 0) {
				throw new SQLException("조회수 증가 문제");
			}
		}
*/
		MeetResDTO dto = dao.selectById(meetingId);
		if (dto == null) {
			throw new SQLException(meetingId + "에 해당하는 게시물이없습니다.");
		}
		return dto;
	}

	@Override
	public boolean isParticipant(String memberId, String meetingId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertParticipant(ParticipantDTO dto) throws SQLException {
		ParticipatingDAO dao = new ParticipatingDAO();
		//int applyNum = dao.countApplyNum(dto.getMeetingId());
		MeetResDTO mrDTO = dao.selectById(dto.getMeetingId());
		int applyNum = mrDTO.getApplyNum();
		int maxNum = mrDTO.getMaxNum();
		int result=0;
		if(applyNum <maxNum) {
			dao.updateApplyNum(dto.getMeetingId());
			result = dao.insertParticipant(dto);
		}
		if(result==0) {
			throw new SQLException("인원이 가득찼습니다.");
		}
		return result;
	}

	@Override
	public int deleteParticipant(String memberId, String meetingId) {
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
	public List<RestaurantDTO> selectAllRestaurant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDTO selectRestaurant(String resId) {
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
	public int updateRestaurant(RestaurantDTO restaurantDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRestaurant(String resId) {
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
	public List<MeetingDTO> selectAllMeeting() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDTO selectMeeting(String meetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMeeting(MeetingDTO meetingDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMeeting(String meetId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertReview(ReviewDTO reviewDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReviewDTO> selectAllReview() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDTO selectReview(String reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReview(ReviewDTO reviewDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReview(String reviewId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAdmin(AdminDTO adminDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RestaurantDTO selectAdmin(String adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAdmin(AdminDTO adminDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAdmin(String adminId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isMeetingOpener(String meetingId, String memberId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int searchMeetingByKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		return 0;
	}


}
