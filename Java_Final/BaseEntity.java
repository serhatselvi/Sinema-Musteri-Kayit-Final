
public abstract class BaseEntity {
    protected int id;
    protected String name;

    public BaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void bilgiGoster();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
