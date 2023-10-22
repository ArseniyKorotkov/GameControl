package by.arsy.p2entity;

public class User {

    private int id;
    private String name;
    private boolean master;

    public User(int id, String name, boolean role) {
        this.id = id;
        this.name = name;
        this.master = role;
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

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

}
