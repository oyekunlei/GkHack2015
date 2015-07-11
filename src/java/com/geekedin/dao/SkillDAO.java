/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekedin.dao;

import com.geekedin.skill.Skill;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author user
 */
public class SkillDAO extends DatabaseConnector
{
    public Vector<Skill> getSkills() throws SQLException
    {
        Vector<Skill> skills = new Vector<Skill>();
        String sql = "SELECT * FROM tblskill";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            skills.add(new Skill(rs.getInt(1), rs.getString(2)));
        }
        return skills;
    }
    
    public Skill getSkill(int id) throws SQLException
    {
        Skill skill = null;
        
        String sql = "SELECT * FROM tblskill WHERE id = "+ id;
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            skill = new Skill(rs.getInt(1), rs.getString(2));
        }
        
        return skill;
    }
}
