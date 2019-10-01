package com.iu.t1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDAO {
	public void selectTest4(String ename) {
		// emp 출력
		// empno, ename, sal, job
		String username = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			String sql = "select empno,ename,sal,job from emp where ename = '" + ename + "'";
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				int sal = rs.getInt("sal");
				String job = rs.getString("job");

				System.out.println("번호 : " + empno);
				System.out.println("이름 : " + ename);
				System.out.println("급여 : " + sal);
				System.out.println("직업 : " + job);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectTest3() {
		// emp 출력
		// 부서별, 부서번호, 급여총합계, 급여평균
		String username = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			String sql = "select deptno,sum(sal) total, avg(sal) avg from emp " + "group by deptno order by deptno asc";

			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int empno = rs.getInt(1); // = rs.getInt("deptno");
				int total = rs.getInt(2); // rs.getInt("total");
				int avg = rs.getInt(3); // rs.getInt("avg");

				System.out.println("부서 번호 : " + empno);
				System.out.println("총 월급 : " + total);
				System.out.println("평균 월급 : " + avg);
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void selectTest2() {
		// emp 테이블의 내용을 출력
		// emp 테이블의 ename,sal,comm,job,deptno 출력
		String username = "scott";
		String password = "tiger";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// 드라이버 로딩
			Class.forName(driver);
			// DB서버에 로그인
			con = DriverManager.getConnection(url, username, password);
			// Query문 작성
			String sql = "select ename,sal,comm,job,deptno from emp";
			// Query문 전송
			st = con.createStatement();
			// Query문 처리
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				System.out.println("ename : " + ename);
				System.out.println("sal : " + sal);
				System.out.println("comm : " + comm);
				System.out.println("job : " + job);
				System.out.println("deptno : " + deptno);
				System.out.println();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void selectTest() {
		// 1. 4가지 정보
		// 1) ID
		String username = "scott";
		// 2) PW
		String password = "tiger";
		// 3) IP Port
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		// 4) Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		// 2. driver를 메모리에 로딩
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 완료");

			// 3. Connection 정보 (DB서버에 로그인)
			con = DriverManager.getConnection(url, username, password);
			System.out.println("로그인 및 접속 성공");

			// 4. Query문 작성
			String sql = "select * from dept"; // ;안붙여도 됨
			// 5. Query 전송
			st = con.createStatement();

			// 6. Query 전송 및 처리
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int num = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(num);
				System.out.println(dname);
				System.out.println(loc);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
