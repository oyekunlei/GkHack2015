/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekedin.dao;

import com.geekedin.geek.Geek;
import com.geekedin.skill.Skill;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author user
 */
public class GeekDAO extends DatabaseConnector
{
    public int register(Geek geek) throws SQLException
    {
        String sql = "INSERT INTO tblgeek(name, surname, gender, phoneNumber, email, city, country, teamId, image, skill1, skill2, skill3, skill4, skill5, skill6) VALUES('"+geek.getName()+"', '"+geek.getSurname()+"', '"+geek.getGender()+"', '"+geek.getPhoneNumber()+"', '"+geek.getEmail()+"', '"+geek.getCity()+"', '"+geek.getCountry()+"', "+geek.getTeamId()+", '"+geek.getImage()+"', "+geek.getSkill1()+", "+geek.getSkill2()+", "+geek.getSkill3()+", "+geek.getSkill4()+", "+geek.getSkill5()+", "+geek.getSkill6()+")";
        return statement.executeUpdate(sql);
    }
    
    public int update(Geek geek) throws SQLException
    {
        String sql = "UPDATE tblgeek SET name = '"+geek.getName()+"', surname = '"+geek.getSurname()+"', gender = '"+geek.getGender()+"', phoneNumber = '"+geek.getPhoneNumber()+"' email = '"+geek.getEmail()+"', city = '"+geek.getCity()+"', country = '"+geek.getCountry()+"', teamId = "+geek.getTeamId()+", image = '"+geek.getImage()+"', skill1 = "+geek.getSkill1()+", skill2 = "+geek.getSkill2()+", skill3 = "+geek.getSkill3()+", skill4 = "+geek.getSkill4()+", skill5 = "+geek.getSkill5()+", skill6 = "+geek.getSkill6()+" WHERE id = "+ geek.getId();
        return statement.executeUpdate(sql);
    }
    
    public int updateTeam(int geekId, int teamId) throws SQLException
    {
        String sql = "UPDATE tblgeek SET teamId = "+teamId+" WHERE id = " + geekId;
        return statement.executeUpdate(sql);
    }
    
    public Vector<Geek> getGeeks() throws SQLException
    {
        Vector<Geek> geeks = new Vector<Geek>();
        
        String sql = "SELECT * FROM tblgeek";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            geeks.add(new Geek(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16)));
        }
        return geeks;
    }
    
    public Vector<Geek> getGeeksBySkills(int skillId) throws SQLException
    {
        Vector<Geek> geeks = new Vector<Geek>();
        
        String sql = "SELECT * FROM tblgeek WHERE skill1 = "+skillId+" OR skill2 = "+skillId+" OR skill3 = "+skillId+" OR skill4 = "+skillId+" OR skill5 = "+skillId+" OR skill6 = "+skillId+"";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            geeks.add(new Geek(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16)));
        }
        return geeks;
    }
    
    public Vector<Geek> getGeeksByName(String name) throws SQLException
    {
        Vector<Geek> geeks = new Vector<Geek>();
        
        String sql = "SELECT * FROM tblgeek WHERE name = '"+name+"'";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            geeks.add(new Geek(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16)));
        }
        return geeks;
    }
    
    public Vector<Geek> getGeeksBySurname(String surname) throws SQLException
    {
        Vector<Geek> geeks = new Vector<Geek>();
        
        String sql = "SELECT * FROM tblgeek WHERE name = '"+surname+"'";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            geeks.add(new Geek(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16)));
        }
        return geeks;
    }
    
    public Vector<Geek> getGeeksByTeam(int teamId) throws SQLException
    {
        Vector<Geek> geeks = new Vector<Geek>();
        
        String sql = "SELECT * FROM tblgeek WHERE teamId = '"+teamId+"'";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            geeks.add(new Geek(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16)));
        }
        return geeks;
    }
    
    public Geek getGeek(int geekId) throws SQLException
    {
        Geek geek = null;
        
        String sql = "SELECT * FROM tblgeek WHERE id ="+ geekId;
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            geek = new Geek(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16));
        }
        return geek;
    }
    
    public Geek getGeek() throws SQLException
    {
        Geek geek = null;
        
        String sql = "SELECT * FROM tblgeek WHERE id = (SELECT MAX(id) FROM tblgeek)";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            geek = new Geek(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16));
        }
        return geek;
    }
    
    public Vector<Integer> getGeekSkills(int geekId) throws SQLException
    {
        Vector<Integer> skills = new Vector<Integer>();
        
        String sql = "SELECT skill1, skill2, skill3, skill4, skill5, skill6 FROM tblgeek WHERE id = "+ geekId;
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            skills.add(rs.getInt(1));
            skills.add(rs.getInt(2));
            skills.add(rs.getInt(3));
            skills.add(rs.getInt(4));
            skills.add(rs.getInt(5));
            skills.add(rs.getInt(6));
        }
        
        return skills;
    }
    
    public Vector<Geek> getTeamMenbers(int teamId) throws SQLException
    {
        Vector<Geek> geeks = new Vector<Geek>();
        
        String sql = "SELECT * FROM tblGeek WHERE teamid =" + teamId;
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            geeks.add(new Geek(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16)));
        }
        
        return geeks;
    }
    
}
