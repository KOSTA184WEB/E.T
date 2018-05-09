package et.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import et.model.dto.RestaurantDTO;
import et.util.DbUtil;

public class HotplaceDAO {
	

	public static List<RestaurantDTO> selectByKeyWord(String keyWord) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RestaurantDTO> restaurantList = new ArrayList<>();
		String sql = 
			"select * from (select * from RESTAURANT where RES_ADDRESS like ? order by MEETING_COUNT desc)where ROWNUM<=5"; 
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				RestaurantDTO dto = new RestaurantDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
														rs.getString(5), rs.getInt(6), rs.getDouble(7), rs.getDouble(8), rs.getInt(9));
				
				
				restaurantList.add(dto);
			}
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return restaurantList;
	}
}
