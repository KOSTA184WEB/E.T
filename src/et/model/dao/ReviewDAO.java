package et.model.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import et.model.dto.ReviewDTO;

public interface ReviewDAO {
	/**
	 * 후기 등록
	 **/
	int insertReview(ReviewDTO reviewDto) throws SQLException;
	/**
	 * 후기 삭제
	 **/
	int deleteReview(String reviewId, String reviewPw) throws SQLException;
	
	/**
	 * 후기 수정
	 **/
	int updateReview(ReviewDTO reviewDto) throws SQLException;
	
	/**
	 * 후기 전체검색
	 **/ 
	List<ReviewDTO> selectAllReview() throws SQLException;
	
	/**
	 * 리뷰번호에 해당하는 레코드 검색
	 **/
	ReviewDTO selectReview(String reviewId) throws SQLException;
	
	/**
	 * 상세보기했을때 조회수 추가
	 **/
	int addReviewReadNum(String reviewId) throws SQLException;
	
	/**
	 * 참여하기번호에 해당하는 모집id 검색
	 **/
	List<String> selectMeetingsById(String memberId) throws SQLException;
	
	/**
	 * 모임id에 해당하는 음식점id 검색
	 **/
	String selectRestaurantId(String meetingId) throws SQLException;
	
	/**
	 * 모임id에 해당하는 모집하기 제목 검색
	 **/
	String selectMeetingTitle(String meetingId) throws SQLException;
	
	/**
	 * 모임id에 해당하는 모임 날짜 검색
	 **/
	String selectMeetingDate(String meetingId) throws SQLException;
	
	/**
	 * 음식점 id에 해당하는 평점 검색
	 **/
	int selectRestaurantRate(String resId) throws SQLException;
	
	/**
	 * 음식점 id에 해당하는 음식종류 검색
	 **/
	String selectRestaurantKind(String resId) throws SQLException;
	
	/**
	 * 후기 등록시 음식점id에 평점 추가
	 **/
	int insertResturantRate(int resRate, String resId) throws SQLException;
	
	/**
	 * keyword에 해당하는 레코드 검색
	 **/
	List<ReviewDTO> searchBykeyWord(String keyField, String keyWord) throws SQLException;
	
	/**
	 * 관리자: 후기id에 해당하는 레코드 삭제
	 **/
	int AdminDeleteReview(String reviewId) throws SQLException;
}
