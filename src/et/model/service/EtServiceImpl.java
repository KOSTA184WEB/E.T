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
import et.model.dao.ReviewDAOImpl;

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
				throw new SQLException("��ȸ�� ���� ����");
			}
		}
*/
		MeetResDTO dto = dao.selectById(meetingId);
		if (dto == null) {
			throw new SQLException(meetingId + "�� �ش��ϴ� �Խù��̾����ϴ�.");
		}
		return dto;
	}
	
	@Override
	public boolean isParticipant(String memberId, String meetingId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertParticipant(ParticipantDTO dto,String loginId) throws SQLException {
		ParticipatingDAO dao = new ParticipatingDAO();
		//int applyNum = dao.countApplyNum(dto.getMeetingId());
		MeetResDTO mrDTO = dao.selectById(dto.getMeetingId());
		int checkResult = dao.meetCheck(dto.getMeetingId(),loginId);
		System.out.println("checkRe="+checkResult);
		if(checkResult==1) {
			throw new SQLException("�̹� �����Ǿ��ֽ��ϴ�.");
		}
		int applyNum = mrDTO.getApplyNum();
		int maxNum = mrDTO.getMaxNum();
		int result=0;
		if(applyNum <maxNum) {
			dao.updateApplyNum(dto.getMeetingId());
			result = dao.insertParticipant(dto);
		}
		if(result==0) {
			throw new SQLException("�ο��� ����á���ϴ�.");
		}
		return result;
	}

	@Override
	public int deleteParticipant(String memberId, String meetingId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertRestaurant(RestaurantDTO restaurantDto) throws SQLException {
		int re = 0;
		//restaurant�� ��ϵǾ��ִ��� �Ǻ�
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
		//restaurant�� ��ϵǾ��ִ��� �Ǻ�
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
			throw new SQLException("������ �������� �ʾҽ��ϴ�.");
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
///////////////////////////////////////////////////////////////////////
	ReviewDAO reviewDAO = new ReviewDAOImpl();
	@Override
	public int insertReview(ReviewDTO reviewDto) throws SQLException {
		int result = reviewDAO.insertReview(reviewDto);
		if(result==0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�");
		return result;
	}

	@Override
	public List<ReviewDTO> selectAllReview() throws SQLException {
		List<ReviewDTO> list = reviewDAO.selectAllReview();
		//System.out.println("����:"+list);
		return list;
	}

	@Override
	public ReviewDTO selectReview(String reviewId, boolean state) throws SQLException {
		//��ȸ�� ����
		if(state) {
			if(reviewDAO.addReviewReadNum(reviewId)==0) {
				throw new SQLException("��ȸ���� ������ų �� �����ϴ�");
			}
		}
		//�󼼺���
		ReviewDTO reviewDto = reviewDAO.selectReview(reviewId);
		if(reviewDto==null) throw new SQLException(reviewId+"�� �ش��ϴ� �ıⰡ �����ϴ�");
		return reviewDto;
	}

	@Override
	public int updateReview(ReviewDTO reviewDto) throws SQLException {
		int result=reviewDAO.updateReview(reviewDto);
		if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�");
		return result;
	}

	@Override
	public int deleteReview(String reviewId,String reviewPw) throws SQLException {
		int result=reviewDAO.deleteReview(reviewId, reviewPw);
		if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�");
		return result;
	}
	
	@Override
	public List<String> selectMeetingsById(String memberId) throws SQLException{
		List<String> list=reviewDAO.selectMeetingsById(memberId);
		if(list==null) throw new SQLException("�ش�Ǵ� ����ID�� �����ϴ�");
		return list;
	}
	
	@Override 
	public String selectMeetingTitle(String meetingId) throws SQLException{
		String meetingTitle =reviewDAO.selectMeetingTitle(meetingId);
		if(meetingTitle==null) throw new SQLException("�ش�Ǵ� ���� �����ϴ�");
		return meetingTitle;
	}
	
	@Override
	public String selectRestaurantId(String meetingId) throws SQLException{
		String resId =reviewDAO.selectRestaurantId(meetingId);
		if(resId==null) throw new SQLException("�ش�Ǵ� �������� �����ϴ�");
		return resId;
	}
	
	@Override
	public String selectMeetingDate(String meetingId) throws SQLException{
		String meetingDate = reviewDAO.selectMeetingDate(meetingId);
		if(meetingDate==null) throw new SQLException("�ش�Ǵ� ���ӳ�¥�� �����ϴ�");
		return meetingDate;
	}
	
	@Override
	public int insertResturantRate(int resRate, String resId) throws SQLException{
		int result = reviewDAO.insertResturantRate(resRate, resId);
		if(result==0) throw new SQLException("������ �߰����� ���߽��ϴ�");
		return result;
	}
	
	@Override
	public int selectRestaurantRate(String resId) throws SQLException{
		int result = reviewDAO.selectRestaurantRate(resId);
		if(result==0) throw new SQLException("�ش�Ǵ� ������ �����ϴ�");
		return result;
	}
	
	@Override
	public String selectRestaurantKind(String resId) throws SQLException{
		String resKind=reviewDAO.selectRestaurantKind(resId);
		if(resKind==null) throw new SQLException("�ش�Ǵ� ���������� �����ϴ�");
		return resKind;
	}
	
	@Override
	public List<ReviewDTO> searchBykeyWord(String keyField, String keyWord) throws SQLException{
		List<ReviewDTO> list = reviewDAO.searchBykeyWord(keyField, keyWord);
		if(list==null) throw new SQLException("�ش�Ǵ� �ıⰡ �����ϴ�");
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
