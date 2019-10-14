package onetofive;

/**
 * @ClassName student
 * @Description TODO
 * @Acthor Administrator
 * @Date 2019-07-02 20:07
 * @Version 1.0
 **/


public class Student {
    private String name;
    private Integer math;
    private Integer language;
    private Integer english;

    public Student(String name, Integer math, Integer language, Integer english) {
        this.name = name;
        this.math = math;
        this.language = language;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", math=" + math +
                ", language=" + language +
                ", english=" + english +
                '}';
    }
}
