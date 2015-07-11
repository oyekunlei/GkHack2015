/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.geekedin.category.Category;
import com.geekedin.challenge.Challenge;
import com.geekedin.dao.CategoryDAO;
import com.geekedin.dao.ChallengeDAO;
import com.geekedin.dao.GeekDAO;
import com.geekedin.dao.SkillDAO;
import com.geekedin.geek.Geek;
import com.geekedin.skill.Skill;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class ChallengeServlet extends HttpServlet 
{

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
        
        String usn = getServletContext().getInitParameter("usn");
        String pwsd = getServletContext().getInitParameter("pwsd");
        String url = getServletContext().getInitParameter("url");
        
        String decision = request.getParameter("select");
        
        HttpSession session = request.getSession(true);
        
        try
        {
            ChallengeDAO dao = new ChallengeDAO();
            dao.open(usn, pwsd, url);
            if(decision.equalsIgnoreCase("ViewChallenges"))
            {
                CategoryDAO cd = new CategoryDAO();
                cd.open(usn, pwsd, url);
                
                Vector<Category> categories = cd.getCategories();
                session.setAttribute("categories", categories);
                
                response.sendRedirect("challenges.jsp");
                
                cd.close();
                
                
            }
            else if(decision.equalsIgnoreCase("AddChallenge"))
            {
                Challenge c = new Challenge();
                c.setGeekId(Integer.parseInt(request.getParameter("geekId")));
                c.setName(request.getParameter("name"));
                c.setOverview(request.getParameter("overview"));
                
                String[] skills = request.getParameterValues("skills");

                if(skills.length == 1)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                }
                else if(skills.length == 2)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                }
                else if(skills.length == 3)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                    c.setSkill3(Integer.parseInt(skills[2]));
                }
                else if(skills.length == 4)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                    c.setSkill3(Integer.parseInt(skills[2]));
                    c.setSkill4(Integer.parseInt(skills[3]));
                }
                else if(skills.length == 5)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                    c.setSkill3(Integer.parseInt(skills[2]));
                    c.setSkill4(Integer.parseInt(skills[3]));
                    c.setSkill5(Integer.parseInt(skills[4]));
                }
                else
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                    c.setSkill3(Integer.parseInt(skills[2]));
                    c.setSkill4(Integer.parseInt(skills[3]));
                    c.setSkill5(Integer.parseInt(skills[4]));
                    c.setSkill6(Integer.parseInt(skills[5]));
                }
                
                if(dao.addChallenge(c) > 0)
                {
                    Vector<Challenge> challenges = new Vector<Challenge>();
                    challenges = dao.getChallenges();
                    session.setAttribute("challenges", challenges);
                    response.sendRedirect("viewChallenges.jsp");
                }
                else
                {
                    response.sendRedirect("addChallenge.jsp");
                }
            }
            else if(decision.equalsIgnoreCase("ViewByCategory"))
            {
                GeekDAO gd = new GeekDAO();
                gd.open(usn, pwsd, url);
                
                Vector<Geek> geeks = gd.getGeeks();
                
                gd.close();
                String category = request.getParameter("category");
                Vector<Challenge> challenges = dao.getChallengeByCategory(category);
                session.setAttribute("catChallenges", challenges);
                
                session.setAttribute("geeks", geeks);
                Vector<Integer> teams = new Vector<Integer>();
                
                for(Challenge challenge: challenges)
                {
                    teams.add(dao.countTeams(challenge.getId()));
                }
                
                session.setAttribute("teams", teams);
                
                SkillDAO sd = new SkillDAO();
                sd.open(usn, pwsd, url);
                Vector<Skill> skills = sd.getSkills();
                sd.close();
                
                response.sendRedirect("viewChallenges.jsp");
            }
            dao.close();
        }
        catch(Exception ex)
        {
            out.println(ex.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String usn = getServletContext().getInitParameter("usn");
        String pwsd = getServletContext().getInitParameter("pwsd");
        String url = getServletContext().getInitParameter("url");
        
        String decision = request.getParameter("select");
        
        HttpSession session = request.getSession(true);
        try
        {
            ChallengeDAO dao = new ChallengeDAO();
            dao.open(usn, pwsd, url);
            if(decision.equalsIgnoreCase("Add Challenge"))
            {
                Challenge c = new Challenge();
                c.setGeekId(Integer.parseInt(request.getParameter("geekId")));
                c.setName(request.getParameter("name"));
                c.setOverview(request.getParameter("overview"));
                
                String[] skills = request.getParameterValues("skills");

                if(skills.length == 1)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                }
                else if(skills.length == 2)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                }
                else if(skills.length == 3)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                    c.setSkill3(Integer.parseInt(skills[2]));
                }
                else if(skills.length == 4)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                    c.setSkill3(Integer.parseInt(skills[2]));
                    c.setSkill4(Integer.parseInt(skills[3]));
                }
                else if(skills.length == 5)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                    c.setSkill3(Integer.parseInt(skills[2]));
                    c.setSkill4(Integer.parseInt(skills[3]));
                    c.setSkill5(Integer.parseInt(skills[4]));
                }
                else
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                    c.setSkill3(Integer.parseInt(skills[2]));
                    c.setSkill4(Integer.parseInt(skills[3]));
                    c.setSkill5(Integer.parseInt(skills[4]));
                    c.setSkill6(Integer.parseInt(skills[5]));
                }
                
                if(dao.addChallenge(c) > 0)
                {
                    Vector<Challenge> challenges = new Vector<Challenge>();
                    challenges = dao.getChallenges();
                    session.setAttribute("challenges", challenges);
                    response.sendRedirect("viewChallenges.jsp");
                }
                else
                {
                    response.sendRedirect("addChallenge.jsp");
                }
            }
            else if(decision.equalsIgnoreCase("View Challenges"))
            {
                Vector<Challenge> challenges = (Vector<Challenge>) dao.getChallenges();
                session.setAttribute("challenges", challenges);
                
                response.sendRedirect("viewChallenges.jsp");
            }
            else if(decision.equalsIgnoreCase("Edit Challenge"))
            {
                Challenge c = new Challenge();
                c.setId(Integer.parseInt(request.getParameter("challengeId")));
                c.setName(request.getParameter("name"));
                c.setOverview(request.getParameter("overview"));
                
                String[] skills = request.getParameterValues("skills");

                if(skills.length == 1)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                }
                else if(skills.length == 2)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                }
                else if(skills.length == 3)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                    c.setSkill3(Integer.parseInt(skills[2]));
                }
                else if(skills.length == 4)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                    c.setSkill3(Integer.parseInt(skills[2]));
                    c.setSkill4(Integer.parseInt(skills[3]));
                }
                else if(skills.length == 5)
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                    c.setSkill3(Integer.parseInt(skills[2]));
                    c.setSkill4(Integer.parseInt(skills[3]));
                    c.setSkill5(Integer.parseInt(skills[4]));
                }
                else
                {
                    c.setSkill1(Integer.parseInt(skills[0]));
                    c.setSkill2(Integer.parseInt(skills[1]));
                    c.setSkill3(Integer.parseInt(skills[2]));
                    c.setSkill4(Integer.parseInt(skills[3]));
                    c.setSkill5(Integer.parseInt(skills[4]));
                    c.setSkill6(Integer.parseInt(skills[5]));
                }
                if(dao.updateChallenge(c) > 0)
                {
                    response.sendRedirect("viewChallenges.jsp");
                }
                else
                {
                    response.sendRedirect("editChallenge.jsp");
                }
            }
            else if(decision.equalsIgnoreCase("Delete Challenge"))
            {
                int challengeId = Integer.parseInt(request.getParameter("challengeId"));
                 if(dao.deleteChallenge(challengeId) > 0)
                 {
                     response.sendRedirect("viewChallenges.jsp");
                 }
                 else
                 {
                     response.sendRedirect("editChallenge.jsp");
                 }
            }
               dao.close();
        }
        catch(Exception ex)
        {
            out.println(ex.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
