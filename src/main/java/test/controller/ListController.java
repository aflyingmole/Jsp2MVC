package test.controller;

import test.DTO.Member;
import test.dao.ListDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/member/list")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListDAO dao = new ListDAO();
        ArrayList<Member> list = dao.select();

        req.setAttribute("list", list);
        req.getRequestDispatcher("list.jsp").forward(req, resp);

    }
}
