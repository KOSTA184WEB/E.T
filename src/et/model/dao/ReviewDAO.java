package et.model.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import et.model.dto.ReviewDTO;

public interface ReviewDAO {
	/**
	 * �ı� ���
	 **/
	int insertReview(ReviewDTO reviewDto) throws SQLException;
	/**
	 * �ı� ����
	 **/
	int deleteReview(String reviewId, String reviewPw) throws SQLException;
	
	/**
	 * �ı� ����
	 **/
	int updateReview(ReviewDTO reviewDto) throws SQLException;
	
	/**
	 * �ı� ��ü�˻�
	 **/ 
	List<ReviewDTO> selectAllReview() throws SQLException;
	
	/**
	 * �����ȣ�� �ش��ϴ� ���ڵ� �˻�
	 **/
	ReviewDTO selectReview(String reviewId) throws SQLException;
	
	/**
	 * �󼼺��������� ��ȸ�� �߰�
	 **/
	int addReviewReadNum(String reviewId) throws SQLException;
	
	/**
	 * �����ϱ��ȣ�� �ش��ϴ� ����id �˻�
	 **/
	List<String> selectMeetingsById(String memberId) throws SQLException;
	
	/**
	 * ����id�� �ش��ϴ� ������id �˻�
	 **/
	String selectRestaurantId(String meetingId) throws SQLException;
	
	/**
	 * ����id�� �ش��ϴ� �����ϱ� ���� �˻�
	 **/
	String selectMeetingTitle(String meetingId) throws SQLException;
	
	/**
	 * ����id�� �ش��ϴ� ���� ��¥ �˻�
	 **/
	String selectMeetingDate(String meetingId) throws SQLException;
	
	/**
	 * ������ id�� �ش��ϴ� ���� �˻�
	 **/
	int selectRestaurantRate(String resId) throws SQLException;
	
	/**
	 * ������ id�� �ش��ϴ� �������� �˻�
	 **/
	String selectRestaurantKind(String resId) throws SQLException;
	
	/**
	 * �ı� ��Ͻ� ������id�� ���� �߰�
	 **/
	int insertResturantRate(int resRate, String resId) throws SQLException;
	
	/**
	 * keyword�� �ش��ϴ� ���ڵ� �˻�
	 **/
	List<ReviewDTO> searchBykeyWord(String keyField, String keyWord) throws SQLException;
	
	/**
	 * ������: �ı�id�� �ش��ϴ� ���ڵ� ����
	 **/
	int AdminDeleteReview(String reviewId) throws SQLException;
}
