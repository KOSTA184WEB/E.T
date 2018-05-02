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
 * DB관련 로드, 연결, 닫기를 위한 클래스
 *
 */
public class DbUtil {
	static DataSource ds;
	/**
	 * 로드 사용하려는 DB 제품의 driver를 로딩 static block에서 하는 이유 : 로딩자체가 실패하면 소용없기때문에 생성자보다도 먼저실행되는 static에서 설정
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
	 * 연결 ip, id, pw 등 db에 접속
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	/**
	 * 닫기 isert ,update, delete인경우
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
	 * 닫기 select인경우 닫기
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
