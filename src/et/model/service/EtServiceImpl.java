package et.model.service;

import java.sql.SQLException;
import java.util.List;

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
	EtDAO etDao = new EtDAOImpl();
	

	private MemberDAO memberDAO = new MemberDAO();
	

	public MemberDTO logIn(String memberId, String memberPw) throws SQLException {
		
		MemberDTO memberDTO = new MemberDTO();
		
		int result = memberDAO.loginCheck(memberId, memberPw); // 로그인 확인
		
		if(result==1){ // 아이디 존재할 때
			memberDTO = memberDAO.selectMember(memberId); // 회원 정보 담기
		}else{
			throw new SQLException("로그인 할 수 없습니다.");
		}
		
		return memberDTO;

	}	
	
	@Override
	public MemberDTO selectMember(String memberId) throws SQLException {
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO = memberDAO.selectMember(memberId); // 회원 정보 담기
		
		if(memberDTO==null){
			throw new SQLException("회원 정보 불러올 수 없습니다.");
		}
		
		return memberDTO;
	}

	@Override
	public int updateMember(MemberDTO memberDTO) throws SQLException{
		
		int result = memberDAO.updateMember(memberDTO);
		if(result==0) {
			throw new SQLException("회원 정보 수정 실패");
		}
		
		return result;
	}
	   
   @Override
   public int insertMember(MemberDTO memberDto) throws SQLException{
     int re = MemberDAO.insert(memberDto);

		if (re == 0) {
			throw new SQLException("가입이 되지 않았습니다.");
		}
		return re;
   }

	@Override
   public List<MemberDTO> selectAllMember() throws SQLException{
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
	public boolean isParticipant(String memberId, String meetingId){
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
			throw new SQLException("이미 참여되어있습니다.");
		}
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
	
	/////////////////////////////// 후기 ////////////////////////////////////////
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
	
	@Override
	public int AdminDeleteReview(String reviewId) throws SQLException{
		int result=reviewDAO.AdminDeleteReview(reviewId);
		if(result==0) throw new SQLException("삭제되지 않았습니다");
		return result;
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
	
	//////////////////////////공지 쓰기 ////////////////////////////////////////////////////////
	NoticeDAO noticeDAO = new NoticeDAO();
	@Override
	public int insertNotice(NoticeDTO noticeDTO) throws SQLException{
		int result = noticeDAO.insertNotice(noticeDTO);
		if(result==0) throw new SQLException("등록되지 않았습니다");
		return result;
	}
	
	@Override
	public List<NoticeDTO> selectNoticeAll() throws SQLException{
		List<NoticeDTO> list =noticeDAO.selectNoticeAll();
		return list;
	}
	
	@Override
	public NoticeDTO selectNotice(String noticeId, boolean state) throws SQLException{
		//조회수 증가
				if(state) {
					if(noticeDAO.addNoticeReadNum(noticeId)==0) {
						throw new SQLException("조회수를 증가시킬 수 없습니다");
					}
				}
				//상세보기
				NoticeDTO noticeDTO = noticeDAO.selectNotice(noticeId);
				if(noticeDTO==null) throw new SQLException(noticeId+"에 해당하는 공지가 없습니다");
				return noticeDTO;
	}
	
	@Override
	public int updateNotice(NoticeDTO noticeDTO) throws SQLException{
		int result = noticeDAO.updateNotice(noticeDTO);
		if(result==0) throw new SQLException("수정되지 않았습니다");
		return result;
	}
	
	@Override
	public int deleteNotice(String noticeId) throws SQLException{
		int result = noticeDAO.deleteNotice(noticeId);
		if(result==0) throw new SQLException("삭제되지 않았습니다");
		return result;
	}
	/////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
   public List<RestaurantDTO> selectByKeyWord(String keyWord) throws SQLException {
      
      List<RestaurantDTO> restaurantList = HotplaceDAO.selectByKeyWord(keyWord);
      if(restaurantList==null) {
         throw new SQLException("핫 플레이스 정보가 없습니다.");
      }
      return restaurantList;
   }
   
   
   private MyPageDAO myPageDAO = new MyPageDAOImpl();
	
   @Override
	public List<MeetResPartDTO> selectUpcomingMeeting(String memberId) throws SQLException{
				
		List<MeetResPartDTO> userMeetingList = myPageDAO.selectUpcomingMeeting(memberId);
		if(userMeetingList==null) {
			throw new SQLException("예약한 모임이 없습니다.");
		}
		
		return userMeetingList;
	}
	
	@Override
	public List<MeetResPartDTO> selectPastMeeting(String memberId) throws SQLException{
		
		List<MeetResPartDTO> pastMeetingList = myPageDAO.selectPastMeeting(memberId);
		if(pastMeetingList==null) {
			throw new SQLException("예약한 모임이 없습니다.");
		}
		
		return pastMeetingList;
	}
	
	@Override
	public int cancelMeeting(String memberId, String participantId) throws SQLException{ // 파라미터에 어떤 정보 들어가야하는지 생각 필요!!!
		
		int result = myPageDAO.cancelMeeting(memberId, participantId);
		
		if(result==0) {
			throw new SQLException("취소 실패");
		}
		
		return result;
	} 
	
	/** 디파짓 **/
	@Override
	public List<DepositDTO> selectDepositList(String memberId) throws SQLException{
		
		List<DepositDTO> depositList = myPageDAO.selectDepositList(memberId);
		
		if(depositList==null) {
			throw new SQLException("디파짓 사용 내역이 없습니다.");
		}
		
		return depositList;
	}
	
	@Override
	public int addDepoist(DepositDTO depositDTO) throws SQLException {
		int result = myPageDAO.addDeposit(depositDTO);
		
		if(result==0) {
			throw new SQLException("디파짓 증가 실패");
		}
		return result;
	}

	@Override
	public int cutDepoist(DepositDTO depositDTO) throws SQLException {
		int result = myPageDAO.cutDeposit(depositDTO);
		
		if(result==0) {
			throw new SQLException("디파짓 차감 실패");
		}
		return result;
	} 
   
}
