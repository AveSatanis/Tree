package model.family_tree.human.service;

import model.family_tree.human.Gender;
import model.family_tree.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private int genId;
    private Human human;
    private String name;
    private LocalDate BirthDate;
    private Gender gender;

    public HumanBuilder setHumanName(String name){
        this.name = name;
        return this;
    }

    public HumanBuilder setBirthDate(LocalDate BirthDate){
        this.BirthDate = BirthDate;
        return this;
    }

    public HumanBuilder setGender(Gender gender){
        this.gender = gender;
        return this;
    }

    public void createHuman(){
        human = new Human();
    }

    private void nextId(){
        human.setId(genId++);
    }

    public void createName(){
        human.setName(name);
    }

    public void createBirthDate(){
        human.setBirthDate(BirthDate);
    }

    public void createGender(){
        human.setGender(gender);
    }


    public Human build(){
        createHuman();
        createName();
        createGender();
        createBirthDate();
        nextId();
        return human;
    }
}
