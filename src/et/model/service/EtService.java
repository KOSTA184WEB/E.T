package et.model.service;

import java.sql.SQLException;
import java.util.List;

import et.model.dto.AdminDTO;
import et.model.dto.DepositDTO;
import et.model.dto.MeetResDTO;
import et.model.dto.MeetResPartDTO;
import et.model.dto.MeetingDTO;
import et.model.dto.MemberDTO;
import et.model.dto.ParticipantDTO;
import et.model.dto.RestaurantDTO;
import et.model.dto.ReviewDTO;

public interface EtService {
	
   /********************** LogIn **********************/
	public MemberDTO logIn(String memberId, String memberPw) throws SQLException;
	
   /********************** Member CRUD **********************/
   public int insertMember(MemberDTO memberDto) throws SQLException;
   public List<MemberDTO> selectAllMember() throws SQLException;
   public MemberDTO selectMemberInfo(String memberId) throws SQLException;
   public int updateMemberInfo(MemberDTO memberDTO) throws SQLException;
   public int deleteMember(String memberId) throws SQLException;

   /********************** Participant CRUD 
    * @throws SQLException **********************/
   public List<MeetingDTO> selectAllPart() throws SQLException;
   public MeetResDTO selectById(String meetingId,boolean flag) throws SQLException;
   public boolean isParticipant(String memberId, String meetingId);
   public int insertParticipant(ParticipantDTO dto, String loginId) throws SQLException;
   public int deleteParticipant(String memberId, String meetingId);

   /********************** Restaurant CRUD **********************/
   public int insertRestaurant(RestaurantDTO restaurantDto) throws SQLException;
   public List<RestaurantDTO> selectAllRestaurant() throws SQLException;
   public RestaurantDTO selectRestaurant(String resId) throws SQLException;
   public int updateRestaurant(RestaurantDTO restaurantDto) throws SQLException;
   public int deleteRestaurant(String resId) throws SQLException;
   
   /********************** Meeting CRUD **********************/
   public int insertMeeting(MeetingDTO meetingDto) throws SQLException;
   public List<MeetingDTO> selectAllMeeting() throws SQLException;
   public RestaurantDTO selectMeeting(String meetId) throws SQLException;
   public int updateMeeting(MeetingDTO meetingDto) throws SQLException;
   public int deleteMeeting(String meetId) throws SQLException;

   /********************** Review CRUD **********************/
   public int insertReview(ReviewDTO reviewDto) throws SQLException;
   public List<ReviewDTO> selectAllReview() throws SQLException;
   public RestaurantDTO selectReview(String reviewId) throws SQLException;
   public int updateReview(ReviewDTO reviewDto) throws SQLException;
   public int deleteReview(String reviewId) throws SQLException;
   
   /********************** admin CRUD **********************/
   public int insertAdmin(AdminDTO adminDto) throws SQLException;
   public RestaurantDTO selectAdmin(String adminId) throws SQLException;
   public int updateAdmin(AdminDTO adminDto) throws SQLException;
   public int deleteAdmin(String adminId) throws SQLException;
   
   /********************** my page **********************/
   public List<MeetResPartDTO> selectUpcomingMeeting(String memberId) throws SQLException;
   public List<MeetResPartDTO> selectPastMeeting(String memberId) throws SQLException;
   public int cancelMeeting(String memberId, String participantId) throws SQLException;
   public List<DepositDTO> selectDepositList(String memberId) throws SQLException;
   public int addDepoist(DepositDTO depositDTO) throws SQLException;
   public int cutDepoist(DepositDTO depositDTO) throws SQLException;
   
   
   /********************** �߰��Ǵ� Service method **********************/
   
   /**
    * Meeting���� ���� ��û�� �� ����ڰ� Meeting�� ���������� Ȯ���ϴ� �޼ҵ�
    * @param meetingId
    * @param memberId
    * @return
    */
   public boolean isMeetingOpener(String meetingId, String memberId) throws SQLException;
   
   /**
    * keyWord�� ���� �˻�
    * @param keyWord
    * @return
    */
   public int searchMeetingByKeyWord(String keyWord) throws SQLException;
   
   public String searchResIdByAddr(String addr) throws SQLException;
   
   /**
    * �˻���(����)�� �ش��ϴ� ������ ����Ƚ���� ���� �Ĵ��� List���·� �޾ƿ�
    * @param keyWord
    * @return
    */
   public List<RestaurantDTO> selectByKeyWord(String keyWord) throws SQLException;
   
   //�߰����� method�� interface�Լ��� �߰��ϰ� impl Ŭ�������� �����Ͽ� ����ϵ�����.
   
   

   

}