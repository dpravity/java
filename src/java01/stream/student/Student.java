package java01.stream.student;


public class Student implements Comparable<Student> {
    private String name;
    private int ban;
    private int totalScore;

    public Student(){}

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    /**
     * 총점 내림차순 기본 정렬
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Student o) {
        return o.totalScore - this.totalScore;
//        return o.name.compareTo(this.name);
//        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ban=" + ban +
                ", totalScore=" + totalScore +
                '}';
    }
}
