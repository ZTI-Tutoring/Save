public class Cmd {
    private Exec exec;
    private String name;

    public Cmd(String name) {
        this.name = name;
    }

    public Exec getExec() {
        return exec;
    }

    public Cmd setExec(Exec exec) {
        this.exec = exec;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
