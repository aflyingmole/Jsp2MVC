package test.dao;

import db.JdbcUtil;
import test.DTO.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListDAO {
    public ArrayList<Member> select() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getCon();
            String sql = "select * from member";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            ArrayList<Member> list = new ArrayList<>();
            while(rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("id"));
                member.setPwd(rs.getString("pwd"));
                member.setEmail(rs.getString("email"));
                member.setAge(rs.getInt("age"));
                member.setRegDate(rs.getDate("regdate"));
                list.add(member);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("[에러]" + e.getMessage());
            return null;
        } finally {
            JdbcUtil.close(con, pstmt, null);
        }
    }
}
