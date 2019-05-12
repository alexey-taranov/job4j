package ru.job4j.profession;

import java.util.Date;

public class Doctor extends Profession {

    public Doctor(String name, String surname, String education, Date birthday) {
        super(name, surname, education, birthday);
    }

    public Diagnose heal(Pacient pacient) {
      return new Diagnose("desc");
    }
}
