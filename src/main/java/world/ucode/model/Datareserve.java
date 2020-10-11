package world.ucode.model;

public class Datareserve {
    static public Datareserve dataserve = new Datareserve();
    public boolean first_enty = false;
    public boolean tosave = false;
    public int feedpos = 41;
    public int waterpos = 78;
    public int medicinepos = 46;
    public int cleanpos = 38;
    public int crabs = 50;
    public int health = 80;



    private Datareserve() {

    }

    public void updateval(int health, int feedpos, int waterpos, int medicinepos, int cleanpos, int crabs) {
        this.feedpos = feedpos;
        this.waterpos = waterpos;
        this.medicinepos = medicinepos;
        this.cleanpos = cleanpos;
        this.crabs = crabs;
        this.health = health;
    }
}
