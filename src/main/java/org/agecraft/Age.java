package org.agecraft;

import org.agecraft.age.prehistory.AgePrehistory;

public abstract class Age extends ACComponent {

    public static Age[] ages = new Age[16];

    public static AgePrehistory prehistory = new AgePrehistory(0);
    public static Age agriculture;
    public static Age ancientEgypt;
    public static Age ancientChina;
    public static Age romanGreek;
    public static Age medieval;
    public static Age earlyModern;
    public static Age industrial;
    public static Age modern;
    public static Age future;

    public int id;

    public Age(int id, String name) {
        super(name);
        this.id = id;

        ages[id] = this;
    }
}
