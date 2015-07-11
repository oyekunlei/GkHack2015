/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.geekedin.challenge.Challenge;
import com.geekedin.dao.ChallengeDAO;
import com.geekedin.dao.GeekDAO;
import com.geekedin.dao.LoginDAO;
import com.geekedin.dao.SkillDAO;
import com.geekedin.geek.Geek;
import com.geekedin.login.Login;
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
public class RegisterServlet extends HttpServlet 
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
            if(decision.equalsIgnoreCase("load"))
            {
                SkillDAO sd = new SkillDAO();
               sd.open(usn, pwsd, url);
               Vector<Skill> skills = (Vector<Skill>) sd.getSkills();
               sd.close();
               
               session.setAttribute("skills", skills);
               response.sendRedirect("register.jsp"); 
            }
            else if(decision.equalsIgnoreCase("logout"))
            {
                session.setAttribute("geek", null);
                response.sendRedirect("index.jsp");
            }
               
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
        
        GeekDAO dao = new GeekDAO();
        HttpSession session = request.getSession(true);
        try
        {
            dao.open(usn, pwsd, url);
            if(decision.equalsIgnoreCase("Register"))
            {
                Geek geek = new Geek();
                geek.setName(request.getParameter("name"));
                geek.setSurname(request.getParameter("surname"));
                geek.setGender(request.getParameter("gender"));
                geek.setPhoneNumber(request.getParameter("phone"));
                geek.setEmail(request.getParameter("email"));
                geek.setCity(request.getParameter("city"));
                geek.setCountry(request.getParameter("country"));

               String[] skills = request.getParameterValues("skills");

                if(skills.length == 1)
                {
                    geek.setSkill1(Integer.parseInt(skills[0]));
                }
                else if(skills.length == 2)
                {
                    geek.setSkill1(Integer.parseInt(skills[0]));
                    geek.setSkill2(Integer.parseInt(skills[1]));
                }
                else if(skills.length == 3)
                {
                    geek.setSkill1(Integer.parseInt(skills[0]));
                    geek.setSkill2(Integer.parseInt(skills[1]));
                    geek.setSkill3(Integer.parseInt(skills[2]));
                }
                else if(skills.length == 4)
                {
                    geek.setSkill1(Integer.parseInt(skills[0]));
                    geek.setSkill2(Integer.parseInt(skills[1]));
                    geek.setSkill3(Integer.parseInt(skills[2]));
                    geek.setSkill4(Integer.parseInt(skills[3]));
                }
                else if(skills.length == 5)
                {
                    geek.setSkill1(Integer.parseInt(skills[0]));
                    geek.setSkill2(Integer.parseInt(skills[1]));
                    geek.setSkill3(Integer.parseInt(skills[2]));
                    geek.setSkill4(Integer.parseInt(skills[3]));
                    geek.setSkill5(Integer.parseInt(skills[4]));
                }
                else
                {
                    geek.setSkill1(Integer.parseInt(skills[0]));
                    geek.setSkill2(Integer.parseInt(skills[1]));
                    geek.setSkill3(Integer.parseInt(skills[2]));
                    geek.setSkill4(Integer.parseInt(skills[3]));
                    geek.setSkill5(Integer.parseInt(skills[4]));
                    geek.setSkill6(Integer.parseInt(skills[5]));
                }

                if(dao.register(geek) > 0)
                {
                    session.setAttribute("geek", dao.getGeek());

                    response.sendRedirect("setLogin.jsp");
                }
                else
                {
                    response.sendRedirect("register.jsp");
                }
           }
           else if(decision.equalsIgnoreCase("Set Login Details"))
           {
               LoginDAO ld = new LoginDAO();
               ld.open(usn, pwsd, url);
               Login login = new Login();
               Geek geek = (Geek) session.getAttribute("geek");
               login.setId(geek.getId());
               login.setUsername(request.getParameter("username"));
               login.setPassword(request.getParameter("password"));
               
               if(ld.addUser(login) > 0)
               {
                   response.sendRedirect("home.jsp");
               }
               else
               {
                   response.sendRedirect("setLogin.jsp");
               }
               ld.close();
           }
           else if(decision.equalsIgnoreCase("Login"))
           {
               LoginDAO ld = new LoginDAO();
               ld.open(usn, pwsd, url);
               Login login = ld.validate(request.getParameter("username"), request.getParameter("password"));
               
               if(login != null)
               {
                   session.setAttribute("geek", dao.getGeek(login.getId()));
                   Vector<Integer> skillIds = dao.getGeekSkills(login.getId());
                   Vector<Skill> geekskills = new Vector<Skill>();
                   Vector<Skill> skills = new Vector<Skill>();
                   SkillDAO sd = new SkillDAO();
                   sd.open(usn, pwsd, url);
                   for(int id: skillIds)
                   {
                       if(id != 0)
                       {
                           geekskills.add(sd.getSkill(id));
                       }
                   }
                   skills = sd.getSkills();
                   sd.close();
                   
                   ChallengeDAO cd = new ChallengeDAO();
                   cd.open(usn, pwsd, url);
                   Vector<Challenge> challenges = new Vector<Challenge>();
                   challenges = cd.getChallenges();
                   cd.close();
                   
                   session.setAttribute("geekskills", geekskills);
                   session.setAttribute("challenges", challenges);
                   session.setAttribute("skills", skills);
                   response.sendRedirect("home.jsp");
               }
               else
               {
                   response.sendRedirect("index.jsp");
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
