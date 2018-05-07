package et.model.dao;

import java.sql.SQLException;
import java.util.List;

import et.model.dto.AdminDTO;
import et.model.dto.MeetingDTO;
import et.model.dto.MemberDTO;
import et.model.dto.RestaurantDTO;
import et.model.dto.ReviewDTO;

public interface EtDAO {
	/********************** Member CRUD **********************/
	public int insertMember(MemberDTO memberDto) throws SQLException;
	public List<MemberDTO> selectAllMember() throws SQLException;
	public MemberDTO selectMember(String memberId) throws SQLException;
	public int updateMember(MemberDTO memberDto) throws SQLException;
	public int deleteMember(String memberId) throws SQLException;

	/********************** Participant CRUD **********************/
	public boolean isParticipant(String memberId, String meetingId) throws SQLException;
	public int insertParticipant(String memberId, String meetingId) throws SQLException;
	public int deleteParticipant(String memberId, String meetingId) throws SQLException;

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
	
	
}
