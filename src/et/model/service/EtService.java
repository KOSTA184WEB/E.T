package et.model.service;

import java.util.List;

import et.model.dto.AdminDTO;
import et.model.dto.MeetingDTO;
import et.model.dto.ReviewDTO;
import et.model.dto.MemberDTO;
import et.model.dto.RestaurantDTO;

public interface EtService {
	/********************** Member CRUD **********************/
	public int insertMember(MemberDTO memberDto);
	public List<MemberDTO> selectAllMember();
	public MemberDTO selectMember(String memberId);
	public int updateMember(MemberDTO memberDto);
	public int deleteMember(String memberId);

	/********************** Participant CRUD **********************/
	public boolean isParticipant(String memberId, String meetingId);
	public int insertParticipant(String memberId, String meetingId);
	public int deleteParticipant(String memberId, String meetingId);

	/********************** Restaurant CRUD **********************/
	public int insertRestaurant(RestaurantDTO restaurantDto);
	public List<RestaurantDTO> selectAllRestaurant();
	public RestaurantDTO selectRestaurant(String resId);
	public int updateRestaurant(RestaurantDTO restaurantDto);
	public int deleteRestaurant(String resId);

	/********************** Meeting CRUD **********************/
	public int insertMeeting(MeetingDTO meetingDto);
	public List<MeetingDTO> selectAllMeeting();
	public RestaurantDTO selectMeeting(String meetId);
	public int updateMeeting(MeetingDTO meetingDto);
	public int deleteMeeting(String meetId);

	/********************** Review CRUD **********************/
	public int insertReview(ReviewDTO reviewDto);
	public List<ReviewDTO> selectAllReview();
	public RestaurantDTO selectReview(String reviewId);
	public int updateReview(ReviewDTO reviewDto);
	public int deleteReview(String reviewId);
	
	/********************** admin CRUD **********************/
	public int insertAdmin(AdminDTO adminDto);
	public RestaurantDTO selectAdmin(String adminId);
	public int updateAdmin(AdminDTO adminDto);
	public int deleteAdmin(String adminId);
	
	
	
	/********************** �߰��Ǵ� Service method **********************/
	
	/**
	 * Meeting���� ���� ��û�� �� ����ڰ� Meeting�� ���������� Ȯ���ϴ� �޼ҵ�
	 * @param meetingId
	 * @param memberId
	 * @return
	 */
	public boolean isMeetingOpener(String meetingId, String memberId);
	
	/**
	 * keyWord�� ���� �˻�
	 * @param keyWord
	 * @return
	 */
	public int searchMeetingByKeyWord(String keyWord);
	
	//�߰����� method�� interface�Լ��� �߰��ϰ� impl Ŭ�������� �����Ͽ� ����ϵ�����.

}
