package et.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.model.dao.ElectronicsDAO;
import kosta.model.dao.ElectronicsDAOImpl;
import kosta.model.dto.Electronics;

public class ElectronicsService {
	private static ElectronicsDAO electronicsDAO = new ElectronicsDAOImpl();

	/**
	 * ElectronicsDAOImpl�� ��緹�ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 */
	public static List<Electronics> selectAll() throws SQLException {
		List<Electronics> list = electronicsDAO.selectAll();
		return list;
	}

	/**
	 * ElectronicsDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	 */
	public static int insert(Electronics elec) throws SQLException{
		int re = electronicsDAO.insert(elec);
		if(re == 0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
		return re;
	}

	/**
	 * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 * 
	 * @param :
	 *            boolean flag - ��ȸ�� ���� ���θ� �Ǻ��ϴ� �Ű�������(true�̸� ��ȸ������ / false�̸� ��ȸ�� ���� ����)
	 */
	public static Electronics selectByModelNum(String modelNum, boolean state) throws SQLException {
		if (state) {
			// ��ȸ�� ����
			if (electronicsDAO.updateReadNum(modelNum) == 0) {
				throw new SQLException("��ȸ�� ���� ��Ű�µ� ������ �߻��ֻ��־־־־�");
			}
		}
		Electronics electronics = electronicsDAO.selectByModelNum(modelNum);
		if (electronics == null)
			throw new SQLException(modelNum + "�� �ش��ϴ� ��������� �����ϴ�.");

		return electronics;
	}
	/**
	 * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	 */


	/**
	 * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	 */
	
}
