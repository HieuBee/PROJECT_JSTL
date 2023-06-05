package bean;

public class User {
    private int id;
    private String fullName;
    private String code;
    private String birthday;
    private String createTime;

    public User() {
    }

    public User(int id, String fullName, String code, String birthday, String createTime) {
        this.id = id;
        this.fullName = fullName;
        this.code = code;
        this.birthday = birthday;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
