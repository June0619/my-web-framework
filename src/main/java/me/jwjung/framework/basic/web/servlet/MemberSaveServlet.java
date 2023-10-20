package me.jwjung.framework.basic.web.servlet;

import me.jwjung.framework.basic.domain.member.Member;
import me.jwjung.framework.basic.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter();

        StringBuilder htmlBuilder = new StringBuilder();
        String html = htmlBuilder
                .append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<body>\n")
                .append("성공\n")
                .append("<ul>")
                .append("    <li>id=" + member.getId() + "</li>\n")
                .append("    <li>username=" + member.getName() + "</li>\n")
                .append(" <li>age=" + member.getAge() + "</li>\n")
                .append("</ul>\n")
                .append("</body>\n")
                .append("</html>").toString();
        w.write(html);
    }
}
