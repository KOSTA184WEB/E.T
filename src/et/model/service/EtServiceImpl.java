package et.model.service;

import java.sql.SQLException;
import java.util.List;
import org.apache.jasper.xmlparser.SymbolTable;
import et.model.dao.EtDAO;
import et.model.dao.EtDAOImpl;
import et.model.dao.HotplaceDAO;
import et.model.dao.MeetingDAO;
import et.model.dao.NoticeDAO;
import et.model.dao.MemberDAO;
import et.model.dao.MyPageDAO;
import et.model.dao.MyPageDAOImpl;
import et.model.dao.ParticipatingDAO;
import et.model.dao.RestaurantDAO;
import et.model.dao.ReviewDAO;
import et.model.dao.ParticipatingDAO;
import et.model.dto.AdminDTO;
import et.model.dto.DepositDTO;
import et.model.dto.MeetResDTO;
import et.model.dto.MeetResPartDTO;
import et.model.dto.MeetingDTO;
import et.model.dto.MemberDTO;
import et.model.dto.NoticeDTO;
import et.model.dto.ParticipantDTO;
import et.model.dto.RestaurantDTO;
import et.model.dto.ReviewDTO;
import et.model.dao.ReviewDAOImpl;

public class EtServiceImpl implements EtService {	

	private MemberDAO memberDAO = new MemberDAO();

	@Override
	public MemberDTO logIn(String memberId, String memberPw) throws SQLException {

		MemberDTO memberDTO = new MemberDTO();

		int result = memberDAO.loginCheck(memberId, memberPw); // �α��� Ȯ��

		if (result == 1) { // ���̵� ������ ��
			memberDTO = memberDAO.selectMember(memberId); // ȸ�� ���� ���
		} else {
			throw new SQLException("�α��� �� �� �����ϴ�.");
		}

		return memberDTO;
	}

	@Override
	public MemberDTO selectMember(String memberId) throws SQLException {

		MemberDTO memberDTO = new MemberDTO();

		memberDTO = memberDAO.selectMember(memberId); // ȸ�� ���� ���

		if (memberDTO == null) {
			throw new SQLException("ȸ�� ���� �ҷ��� �� �����ϴ�.");
		}

		return memberDTO;
	}

	@Override
	public int updateMember(MemberDTO memberDTO) throws SQLException {

		int result = memberDAO.updateMember(memberDTO);
		if (result == 0) {
			throw new SQLException("ȸ�� ���� ���� ����");
		}

		return result;
	}

	@Override
	public int insertMember(MemberDTO memberDto) throws SQLException {
		int re = MemberDAO.insert(memberDto);

		if (re == 0) {
			throw new SQLException("������ ���� �ʾҽ��ϴ�.");
		}
		return re;
	}

	@Override
	public List<MemberDTO> selectAllMember() throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
	public MeetResDTO selectById(String meetingId, boolean flag, String loginId) throws SQLException {
		ParticipatingDAO dao = new ParticipatingDAO();
		/*
		 * if (flag) { if (dao.updateByReadNum(meetingId) == 0) { throw new
		 * SQLException("��ȸ�� ���� ����"); } }
		 */
		System.out.println("et����:"+meetingId);
		System.out.println("et����:"+loginId);
		MeetResDTO dto = dao.selectById(meetingId, loginId);
		if (dto == null) {
			throw new SQLException(meetingId + "�� �ش��ϴ� �Խù��̾����ϴ�.");
		}
		return dto;
	}

	@Override
	public boolean isParticipant(String memberId, String meetingId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertParticipant(ParticipantDTO dto, String loginId) throws SQLException {
		ParticipatingDAO dao = new ParticipatingDAO();
		// int applyNum = dao.countApplyNum(dto.getMeetingId());
		MeetResDTO mrDTO = dao.selectById(dto.getMeetingId(), loginId);
		int checkResult = dao.meetCheck(dto.getMeetingId(), loginId);
		System.out.println("checkRe=" + checkResult);
		if (checkResult == 1) {
			throw new SQLException("�̹� �����Ǿ��ֽ��ϴ�.");
		}
		int applyNum = mrDTO.getApplyNum();
		int maxNum = mrDTO.getMaxNum();
		int result = 0;
		if (applyNum < maxNum) {
			dao.updateApplyNum(dto.getMeetingId());
			result = dao.insertParticipant(dto);
		}
		if (result == 0) {
			throw new SQLException("�ο��� ����á���ϴ�.");
		}
		return result;
	}

	public int meetingCheck(String meetingId, String loginId) throws SQLException {
		ParticipatingDAO dao = new ParticipatingDAO();
		MeetResDTO mrDTO = dao.meetingCheck(meetingId, loginId);
		int result=0;
		System.out.println("memberId:"+mrDTO.getMemberId());
		System.out.println("partId:"+mrDTO.getPartMemberId());
		if(mrDTO.getMemberId().equals(mrDTO.getPartMemberId())) {
			System.out.println("����");
			result=1;
		}
		return result;

	}

	@Override
	public int deleteParticipant(String memberId, String meetingId) throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertRestaurant(RestaurantDTO restaurantDto) throws SQLException {
		int re = 0;
		// restaurant�� ��ϵǾ��ִ��� �Ǻ�
		String resId = RestaurantDAO.isNewRestaurant(restaurantDto.getResAddress());
		if (resId == null) {
			re = RestaurantDAO.insertRestaurant(restaurantDto);
		} else {
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
	public RestaurantDTO selectRestaurant(String resId)throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchResIdByAddr(String addr) throws SQLException {
		// restaurant�� ��ϵǾ��ִ��� �Ǻ�
		String resId = RestaurantDAO.searchResIdByAddr(addr);

		return resId;
	}

	@Override
	public int updateRestaurant(RestaurantDTO restaurantDto) throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRestaurant(String resId) throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMeeting(MeetingDTO meetingDto) throws SQLException {
		int re = 0;
		// meeting Dto insert
		re = MeetingDAO.insertMeeting(meetingDto);
		if (re == 0) {
			throw new SQLException("������ �������� �ʾҽ��ϴ�.");
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
	public int updateMeeting(MeetingDTO meetingDto) throws SQLException {
		int result = MeetingDAO.updateMeeting(meetingDto);
		/*if(result==0) {
			throw new SQLException("������ �����Ͽ����ϴ�.");
		}*/
		return result;
	}

	@Override
	public int deleteMeeting(String meetId) {
		// TODO Auto-generated method stub
		return 0;
	}

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
	
	@Override
	public int AdminDeleteReview(String reviewId) throws SQLException{
		int result=reviewDAO.AdminDeleteReview(reviewId);
		if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�");
		return result;
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
	public boolean isMeetingOpener(String meetingId, String memberId)throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int searchMeetingByKeyWord(String keyWord) throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RestaurantDTO> selectByKeyWord(String keyWord) throws SQLException {

		List<RestaurantDTO> restaurantList = HotplaceDAO.selectByKeyWord(keyWord);
		if (restaurantList == null) {
			throw new SQLException("�� �÷��̽� ������ �����ϴ�.");
		}
		return restaurantList;
	}

	private MyPageDAO myPageDAO = new MyPageDAOImpl();

	@Override
	public List<MeetResPartDTO> selectUpcomingMeeting(String memberId) throws SQLException {

		List<MeetResPartDTO> userMeetingList = myPageDAO.selectUpcomingMeeting(memberId);
		if (userMeetingList == null) {
			throw new SQLException("������ ������ �����ϴ�.");
		}

		return userMeetingList;
	}

	@Override
	public List<MeetResPartDTO> selectPastMeeting(String memberId) throws SQLException {

		List<MeetResPartDTO> pastMeetingList = myPageDAO.selectPastMeeting(memberId);
		if (pastMeetingList == null) {
			throw new SQLException("������ ������ �����ϴ�.");
		}

		return pastMeetingList;
	}

	@Override
	public int cancelMeeting(String memberId, String participantId) throws SQLException { // �Ķ���Ϳ� � ���� �����ϴ��� ����
																							// �ʿ�!!!

		int result = myPageDAO.cancelMeeting(memberId, participantId);

		if (result == 0) {
			throw new SQLException("��� ����");
		}

		return result;
	}

	/** ������ **/
	@Override
	public List<DepositDTO> selectDepositList(String memberId) throws SQLException {

		List<DepositDTO> depositList = myPageDAO.selectDepositList(memberId);

		if (depositList == null) {
			throw new SQLException("������ ��� ������ �����ϴ�.");
		}

		return depositList;
	}

	@Override
	public int addDepoist(DepositDTO depositDTO) throws SQLException {
		int result = myPageDAO.addDeposit(depositDTO);

		if (result == 0) {
			throw new SQLException("������ ���� ����");
		}
		return result;
	}

	@Override
	public int cutDepoist(DepositDTO depositDTO) throws SQLException {
		int result = myPageDAO.cutDeposit(depositDTO);

		if (result == 0) {
			throw new SQLException("������ ���� ����");
		}
		return result;
	}

	@Override
	public void updateResCount(String resId, boolean state) throws SQLException {
		if(state) {
			RestaurantDAO.updateMeetingCount(resId);
		}else {
			RestaurantDAO.updateDecMeetingCount(resId);
		}
		
			
	}

	@Override
	public String searchResIdByMeetingId(String meetingId) throws SQLException {
		
		String dbResId = MeetingDAO.searchResIdByMeetingId(meetingId);
		System.out.println("meetingId:"+meetingId);
		System.out.println("����ResId"+dbResId);
		if(dbResId ==null) {
			throw new SQLException("�ش� meeting�� �Ĵ������� �����ϴ�.");
		}
		return dbResId;
	}

	@Override
	public List<NoticeDTO> selectNoticeAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeDTO selectNotice(String noticeId, boolean state) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateNotice(NoticeDTO noticeDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
@Override
	public RestaurantDTO selectAllByResName(String resName) throws SQLException {
		RestaurantDTO dto = HotplaceDAO.selectAllByResName(resName);
		if(dto == null) {
			throw new SQLException("dto �������� ����");
		}
		return dto;
	} 

}