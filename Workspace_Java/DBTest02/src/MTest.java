import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 선택");
		System.out.println("1:전체선택 2:특정 부서 선택 3: 부서 추가 4: 부서 수정 5: 부서 삭제 6: 종료");
		int select = sc.nextInt();

		switch (select) {
		case 1:
			selectList();
			break;
		case 2:
			selectOne();
			break;
		case 3:
			insert();
			break;
		case 4:
			update();
			break;
		case 5:
			delete();
			break;
		default:
			System.out.println("종료");
		}
		sc.close();
	}

	public static void selectList() {
		// 1. driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. query 준비
		String sql = " SELECT * FROM DEPT ";
		Statement stmt = null;

		try {
			// 3.
			stmt = con.createStatement();

			// 4.
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				System.out.println(
						res.getInt("DEPTNO") + " \t " + res.getString("DNAME") + " \t " + res.getString("LOC"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. db 종료
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void selectOne() {
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호 입력 : ");
		int deptno = sc.nextInt();

		// 1. driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. query 준비
		String sql = " SELECT * FROM DEPT " + " WHERE DEPTNO = " + deptno;
		Statement stmt = null;

		try {
			// 3.
			stmt = con.createStatement();

			// 4.
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				System.out.println(
						res.getInt("DEPTNO") + " \t " + res.getString("DNAME") + " \t " + res.getString("LOC"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. db 종료
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void insert() {
		Scanner sc = new Scanner(System.in);
		System.out.print("부서번호 입력 : ");
		int deptno = sc.nextInt();
		System.out.print("부서이름 입력 : ");
		String dname = sc.next();
		System.out.print("지역 입력 : ");
		String loc = sc.next();

		// 1. driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3.
		String sql = " INSERT INTO DEPT VALUES(?, ?, ?) ";
		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, deptno);
			pstm.setString(2, dname);
			pstm.setString(3, loc);

			// 4.
			int res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("성공적으로 추가하였습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void update() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇번부서의 내용을 업데이트 하시겠습니까? : ");
		int deptno = sc.nextInt();
		System.out.println("바꿀 내용의 종류 : (DNAME -> 2 , LOC -> 3)");
		int choice = sc.nextInt();
		sc.nextLine();

		String dname = "";
		String loc = "";
		// dname, loc 중 무엇을 고르냐에 따라 입력할 값을 다르게 해준다.
		if (choice == 2) {
			System.out.print("새로운 부서이름을 입력해주세요 : ");
			dname = sc.nextLine();
		} else if (choice == 3) {
			System.out.print("새로운 지역명을 입력해주세요 : ");
			loc = sc.nextLine();
		} else {
			System.out.println("잘못된 입력입니다. 2, 3중에 하나를 입력해주세요.");
			return;
		}

		// 1. driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3.
		String sql = "";
		PreparedStatement pstm = null;
		try {
			// 3.
			switch (choice) {
			case 2:
				sql = " UPDATE DEPT SET DNAME = ? WHERE DEPTNO = ?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, dname);
				break;
			case 3:
				sql = " UPDATE DEPT SET LOC = ? WHERE DEPTNO = ?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, loc);
				break;
			}
			pstm.setInt(2, deptno);

			// 4.
			try {
				int res = pstm.executeUpdate();
				if (res > 0) {
					System.out.println("업데이트 성공");
				} else {
					System.out.println("부서번호가 잘못되었습니다. 올바른 부서번호를 입력해주세요.");
				}
			} catch (SQLSyntaxErrorException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇번부서를 삭제 하시겠습니까? : ");
		int deptno = sc.nextInt();

		// 1. driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3.
		String sql = "";
		PreparedStatement pstm = null;
		try {
			// 3.
			sql = " DELETE FROM DEPT WHERE DEPTNO = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, deptno);

			// 4.
			try {
				int res = pstm.executeUpdate();
				if (res > 0) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("부서번호가 잘못되었습니다. 올바른 부서번호를 입력해주세요.");
				}
			} catch (SQLSyntaxErrorException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
