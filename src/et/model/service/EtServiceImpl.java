package et.model.service;

import java.sql.SQLException;
import java.util.List;

import et.model.dao.EtDAO;
import et.model.dao.EtDAOImpl;
import et.model.dao.HotplaceDAO;
import et.model.dao.MeetingDAO;
import et.model.dao.MemberDAO;
import et.model.dao.MyPageDAO;
import et.model.dao.MyPageDAOImpl;
import et.model.dao.ParticipatingDAO;
import et.model.dao.RestaurantDAO;
import et.model.dto.AdminDTO;
import et.model.dto.DepositDTO;
import et.model.dto.MeetResDTO;
import et.model.dto.MeetResPartDTO;
import et.model.dto.MeetingDTO;
import et.model.dto.MemberDTO;
import et.model.dto.ParticipantDTO;
import et.model.dto.RestaurantDTO;
import et.model.dto.ReviewDTO;



public class EtServiceImpl implements EtService {
   EtDAO etDao = new EtDAOImpl();


	private MemberDAO memberDAO = new MemberDAO();
	
	@Override
	public MemberDTO logIn(String memberId, String memberPw) throws SQLException {
		
		MemberDTO memberDTO = new MemberDTO();
		
		int result = memberDAO.loginCheck(memberId, memberPw); // �α��� Ȯ��
		
		if(result==1){ // ���̵� ������ ��
			memberDTO = memberDAO.selectMember(memberId); // ȸ�� ���� ���
		}else{
			throw new SQLException("�α��� �� �� �����ϴ�.");
		}
		
		return memberDTO;
	}

	@Override
	public MemberDTO selectMemberInfo(String memberId) throws SQLException {
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO = memberDAO.selectMember(memberId); // ȸ�� ���� ���
		
		if(memberDTO==null){
			throw new SQLException("ȸ�� ���� �ҷ��� �� �����ϴ�.");
		}
		
		return memberDTO;
	}

	@Override
	public int updateMemberInfo(MemberDTO memberDTO) throws SQLException{
		
		int result = memberDAO.updateMember(memberDTO);
		if(result==0) {
			throw new SQLException("ȸ�� ���� ���� ����");
		}
		
		return result;
	}
	   
   @Override
   public int insertMember(MemberDTO memberDto) throws SQLException{
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public List<MemberDTO> selectAllMember() throws SQLException{
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public int deleteMember(String memberId) throws SQLException{
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
   public boolean isParticipant(String memberId, String meetingId) {
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
   public int deleteParticipant(String memberId, String meetingId) {
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
      //restaurant�� ��ϵǾ��ִ��� �Ǻ�
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

   @Override
   public List<RestaurantDTO> selectByKeyWord(String keyWord) throws SQLException {
      
      List<RestaurantDTO> restaurantList = HotplaceDAO.selectByKeyWord(keyWord);
      if(restaurantList==null) {
         throw new SQLException("�� �÷��̽� ������ �����ϴ�.");
      }
      return restaurantList;
   }
   
   
   private MyPageDAO myPageDAO = new MyPageDAOImpl();
	
   @Override
	public List<MeetResPartDTO> selectUpcomingMeeting(String memberId) throws SQLException{
				
		List<MeetResPartDTO> userMeetingList = myPageDAO.selectUpcomingMeeting(memberId);
		if(userMeetingList==null) {
			throw new SQLException("������ ������ �����ϴ�.");
		}
		
		return userMeetingList;
	}
	
	@Override
	public List<MeetResPartDTO> selectPastMeeting(String memberId) throws SQLException{
		
		List<MeetResPartDTO> pastMeetingList = myPageDAO.selectPastMeeting(memberId);
		if(pastMeetingList==null) {
			throw new SQLException("������ ������ �����ϴ�.");
		}
		
		return pastMeetingList;
	}
	
	@Override
	public int cancelMeeting(String memberId, String participantId) throws SQLException{ // �Ķ���Ϳ� � ���� �����ϴ��� ���� �ʿ�!!!
		
		int result = myPageDAO.cancelMeeting(memberId, participantId);
		
		if(result==0) {
			throw new SQLException("���sql ����");
		}
		
		return result;
	} 
	
	/** ������ **/
	@Override
	public List<DepositDTO> selectDepositList(String memberId) throws SQLException{
		
		List<DepositDTO> depositList = myPageDAO.selectDepositList(memberId);
		
		if(depositList==null) {
			throw new SQLException("������ ��� ������ �����ϴ�.");
		}
		
		return depositList;
	}
	
	@Override
	public int addDepoist(DepositDTO depositDTO) throws SQLException {
		int result = myPageDAO.addDeposit(depositDTO);
		
		if(result==0) {
			throw new SQLException("������ ���� ����");
		}
		return result;
	}

	@Override
	public int cutDepoist(DepositDTO depositDTO) throws SQLException {
		int result = myPageDAO.cutDeposit(depositDTO);
		
		if(result==0) {
			throw new SQLException("������ ���� ����");
		}
		return result;
	} 
   


}