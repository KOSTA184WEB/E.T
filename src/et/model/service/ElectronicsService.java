package et.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.model.dao.ElectronicsDAO;
import kosta.model.dao.ElectronicsDAOImpl;
import kosta.model.dto.Electronics;

public class ElectronicsService {
	private static ElectronicsDAO electronicsDAO = new ElectronicsDAOImpl();

	/**
	 * ElectronicsDAOImpl의 모든레코드 검색하는 메소드 호출
	 */
	public static List<Electronics> selectAll() throws SQLException {
		List<Electronics> list = electronicsDAO.selectAll();
		return list;
	}

	/**
	 * ElectronicsDAOImpl의 레코드 삽입하는 메소드 호출
	 */
	public static int insert(Electronics elec) throws SQLException{
		int re = electronicsDAO.insert(elec);
		if(re == 0) throw new SQLException("등록되지 않았습니다.");
		return re;
	}

	/**
	 * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
	 * 
	 * @param :
	 *            boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	 */
	public static Electronics selectByModelNum(String modelNum, boolean state) throws SQLException {
		if (state) {
			// 조회수 증가
			if (electronicsDAO.updateReadNum(modelNum) == 0) {
				throw new SQLException("조회수 증가 시키는데 문제가 발생애새애애애애애");
			}
		}
		Electronics electronics = electronicsDAO.selectByModelNum(modelNum);
		if (electronics == null)
			throw new SQLException(modelNum + "에 해당하는 사움정보는 없습니다.");

		return electronics;
	}
	/**
	 * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	 */


	/**
	 * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 수정 메소드 호출
	 */
	
}
