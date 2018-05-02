package et.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * DB���� �ε�, ����, �ݱ⸦ ���� Ŭ����
 *
 */
public class DbUtil {
	static DataSource ds;
	/**
	 * �ε� ����Ϸ��� DB ��ǰ�� driver�� �ε� static block���� �ϴ� ���� : �ε���ü�� �����ϸ� �ҿ���⶧���� �����ں��ٵ� ��������Ǵ� static���� ����
	 */
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���� ip, id, pw �� db�� ����
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	/**
	 * �ݱ� isert ,update, delete�ΰ��
	 */
	public static void dbClose(Connection con, Statement st) {
		try {
			if (st != null)
				con.close();
			if (st != null)
				st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * �ݱ� select�ΰ�� �ݱ�
	 */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			dbClose(con, st);
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
