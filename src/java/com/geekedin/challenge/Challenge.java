/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekedin.challenge;

import com.geekedin.skill.Skill;
import java.util.Vector;

/**
 *
 * @author user
 */
public class Challenge 
{
    private int id;
    private int geekId;
    private String name;
    private String overview;
    private String category;
    private int skill1;
    private int skill2;
    private int skill3;
    private int skill4;
    private int skill5;
    private int skill6;

    public Challenge() {
    }

    public Challenge(int id, int geekId, String name, String overview, String category, int skill1, int skill2, int skill3, int skill4, int skill5, int skill6) {
        this.id = id;
        this.geekId = geekId;
        this.name = name;
        this.overview = overview;
        this.category = category;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.skill4 = skill4;
        this.skill5 = skill5;
        this.skill6 = skill6;
    }

    public Challenge(int geekId, String name, String overview, String category, int skill1, int skill2, int skill3, int skill4, int skill5, int skill6) {
        this.geekId = geekId;
        this.name = name;
        this.overview = overview;
        this.category = category;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.skill4 = skill4;
        this.skill5 = skill5;
        this.skill6 = skill6;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeekId() {
        return geekId;
    }

    public void setGeekId(int geekId) {
        this.geekId = geekId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSkill1() {
        return skill1;
    }

    public void setSkill1(int skill1) {
        this.skill1 = skill1;
    }

    public int getSkill2() {
        return skill2;
    }

    public void setSkill2(int skill2) {
        this.skill2 = skill2;
    }

    public int getSkill3() {
        return skill3;
    }

    public void setSkill3(int skill3) {
        this.skill3 = skill3;
    }

    public int getSkill4() {
        return skill4;
    }

    public void setSkill4(int skill4) {
        this.skill4 = skill4;
    }

    public int getSkill5() {
        return skill5;
    }

    public void setSkill5(int skill5) {
        this.skill5 = skill5;
    }

    public int getSkill6() {
        return skill6;
    }

    public void setSkill6(int skill6) {
        this.skill6 = skill6;
    }
    
    public Vector<Integer> getSkills()
    {
        Vector<Integer> skills = new Vector<Integer>();
        skills.add(this.skill1);
        skills.add(this.skill2);
        skills.add(this.skill3);
        skills.add(this.skill4);
        skills.add(this.skill5);
        skills.add(this.skill6);
        
        return skills;
    }
            
}
