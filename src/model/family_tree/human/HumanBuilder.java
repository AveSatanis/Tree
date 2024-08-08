package model.family_tree.human;

import java.time.LocalDate;
import java.time.Period;

public class HumanBuilder {
    private int genId;
    private Human human;
    private String humanName;
    private LocalDate birthDate, deathDate;
    private int humanAge;


    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }
        else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }


    public HumanBuilder setHumanName(String humanName ){
        this.humanName = humanName;
        return this;
    }

    public HumanBuilder setHumanAge(int humanAge){
        this.humanAge = humanAge;
        return this;
    }

    public void createHuman(){
        human = new Human();
    }

    private void nextId(){
        human.setId(genId++);
    }

    public void createName(){
        human.setName(humanName);
    }

    public void createAge(){
        human.getAge();
    }

    public int getHumanAge() {
        return humanAge;
    }

    public Human build(){
        createHuman();
        createName();
        createAge();
        nextId();
        return human;
    }
}
