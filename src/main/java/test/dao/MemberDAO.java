package test.dao;


import db.JdbcUtil;
import test.DTO.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

    public int insert(Member member) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = JdbcUtil.getCon();
            String sql = "insert into member values(?,?,?,?,sysdate)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPwd());
            pstmt.setString(3, member.getEmail());
            pstmt.setInt(4, member.getAge());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[에러]" + e.getMessage());
            return -1;
        } finally {
            JdbcUtil.close(con, pstmt, null);
        }
    }

    public int delete(String id) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = JdbcUtil.getCon();
            String sql = "DELETE FROM member WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("[에러] " + e.getMessage());
            return -1;
        } finally {
            JdbcUtil.close(con, ps, null);
        }
    }

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
            while (rs.next()) {
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

    public int update(Member vo) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = JdbcUtil.getCon();
            String sql = "update member set pwd=?,email=?,age=? where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, vo.getPwd());
            pstmt.setString(2, vo.getEmail());
            pstmt.setInt(3, vo.getAge());
            pstmt.setString(4, vo.getId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
           e.getMessage();
            return -1;
        } finally {
            JdbcUtil.close(con, pstmt, null);
        }
    }

    public Member select(String id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getCon();
            String sql = "select * from member where id = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("id"));
                member.setPwd(rs.getString("pwd"));
                member.setEmail(rs.getString("email"));
                member.setAge(rs.getInt("age"));
                member.setRegDate(rs.getDate("regdate"));
                return member;
            } else {
                return null;
            }

        } catch (SQLException e) {
           e.getMessage();
            return null;
        } finally {
            JdbcUtil.close(con, pstmt, null);
        }
    }
}
