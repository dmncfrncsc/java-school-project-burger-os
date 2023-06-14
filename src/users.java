public class users {
    private String id;
    private String name;
    private String level;
    private String username;
    private String password;
    private String status;

    public users(String id, String name, String level, String username, String password, String status) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void editUsers(String name, String level, String username, String password,String Status) {
        this.name = name;
        this.level = level;
        this.username = username;
        this.password = password;
        this.status = Status;
    }
    public void editStatus(String status){
        this.status=status;
    }
    /*    public users(String id, String name, String level, String username, String password) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.username = username;
        this.password = password;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/
}
