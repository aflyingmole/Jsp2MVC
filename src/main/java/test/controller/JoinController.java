package test.controller;

import test.DTO.Member;
import test.dao.MemberDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/join")
public class JoinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/member/join.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 전송된 데이터 DB에 저장
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");
        String age = req.getParameter("age");

        int iage = Integer.parseInt(age);

        MemberDAO dao = new MemberDAO();
        Member member = new Member(id, pwd, email, iage, null);
        int n = dao.insert(member);

        if(n==1){
            req.setAttribute("msg", "회원가입 완료;;;");
        } else {
            req.setAttribute("msg", "오류로 인해 회원가입이 실패");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/member/result.jsp");
        rd.forward(req, resp);


        // 결과를 응답하기
    }


}
