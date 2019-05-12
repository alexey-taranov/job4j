package ru.job4j.profession;

import java.util.Date;

public class Engineer extends  Profession {

    public Engineer(String name, String surname, String education, Date birthday) {
        super(name, surname, education, birthday);
    }

    public Program doProgram(Program program) {
        return new Program("name");
    }
}
