package Services.training.interviewIssues.nameStatistics.childs;

public class Child {
    private int yearOfBirth;
    private Gender gender;
    private String ethnicity;
    private String name;
    private Integer count;

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private Gender genderHandler(String gender) {
        if (gender.toUpperCase().equals("FEMALE")) {
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }

    public Child(int yearOfBirth, String gender, String ethnicity, String name, Integer count) {
        this.yearOfBirth = yearOfBirth;
        this.gender = genderHandler(gender);
        this.ethnicity = ethnicity;
        this.name = name;
        this.count = count;
    }

}
