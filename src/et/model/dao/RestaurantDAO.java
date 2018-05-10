package et.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import et.model.dto.RestaurantDTO;
import et.util.DbUtil;

public class RestaurantDAO {
	public static int insertRestaurant(RestaurantDTO resDto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("insert into restaurant VALUES(res_seq.nextval,?,?,?,?,0,?,?,0)");

			ps.setString(1, resDto.getResName());
			ps.setString(2, resDto.getResKind());
			ps.setString(3, resDto.getResAddress());
			ps.setString(4, resDto.getResPhone());
			ps.setDouble(5, resDto.getLat());
			ps.setDouble(6, resDto.getLng());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	public static List<RestaurantDTO> selectAllRestaurant() throws SQLException {
		return null;

	}

	public static RestaurantDTO selectRestaurant(String resId) throws SQLException {
		return null;

	}
	
	public static String searchResIdByAddr(String addr) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String resId = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select res_id from restaurant where res_address = ?");

			ps.setString(1, addr);
			rs = ps.executeQuery();
			if(rs.next()) {
				resId = rs.getString(1);
			}
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return resId;
	}

	public static int updateRestaurant(RestaurantDTO restaurantDto) throws SQLException {
		return 0;

	}

	public static int deleteRestaurant(String resId) throws SQLException {
		return 0;

	}

	/**
	 * 주소로 식당이 등록되어있는지 판별
	 * 
	 * @param resAddr
	 * @return 식당 주소
	 * @throws SQLException
	 */
	public static String isNewRestaurant(String resAddr) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String resId = null;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select res_id from restaurant where res_address =?");
			ps.setString(1, resAddr);

			rs = ps.executeQuery();

			if (rs.next()) {
				resId = rs.getString(1);
			}

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return resId;
	}

	public static int updateMeetingCount(String resId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("update restaurant set meeting_count=meeting_count+1 where res_id = ?");
			ps.setString(1, resId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	public static int updateDecMeetingCount(String resId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("update restaurant set meeting_count=meeting_count-1 where res_id = ?");
			ps.setString(1, resId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
}
