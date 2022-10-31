package core.model;

public enum Permition {
    WRITE("write"),
    READ("read");

    private final String permission;


    Permition(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
