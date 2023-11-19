package Model;

public class Author {
    public int id;
    public String authorName;
    public String sex;

    public Author(int id, String authorName, String sex) {
        this.id = id;
        this.authorName = authorName;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getSex() {
        return sex;
    }
}
