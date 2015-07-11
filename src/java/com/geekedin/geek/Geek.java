/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekedin.geek;

import java.util.Vector;

/**
 *
 * @author user
 */
public class Geek
{
    private int id;
    private String name;
    private String surname;
    private String gender;
    private String phoneNumber;
    private String email;
    private String city;
    private String country;
    private int teamId;
    private String image;
    private int skill1;
    private int skill2;
    private int skill3;
    private int skill4;
    private int skill5;
    private int skill6;

    public Geek() {
    }

    public Geek(int id, String name, String surname, String gender, String phoneNumber, String email, String city, String country, int teamId, String image, int skill1, int skill2, int skill3, int skill4, int skill5, int skill6) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.country = country;
        this.teamId = teamId;
        this.image = image;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.skill4 = skill4;
        this.skill5 = skill5;
        this.skill6 = skill6;
    }
    
    public Geek(String name, String surname, String gender, String phoneNumber, String email, String city, String country, int teamId, String image, int skill1, int skill2, int skill3, int skill4, int skill5, int skill6) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.country = country;
        this.teamId = teamId;
        this.image = image;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
