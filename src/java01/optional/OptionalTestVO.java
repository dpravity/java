package java01.optional;

public class OptionalTestVO {

    private String name;
    private int age;

    public OptionalTestVO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "OptionalTestVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
