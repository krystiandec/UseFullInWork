package Services.training.interviewIssues.nameStatistics.childs;

public class Child {
    int yearOfBirth;
    Gender gender;
    String ethnicity;
    String name;

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

    private Gender genderHandler(String gender){
        if(gender.toUpperCase().equals("FEMALE")){
            return Gender.FEMALE;
        }else{
            return Gender.MALE;
        }
    }

    public Child(int yearOfBirth, String gender, String ethnicity, String name) {
        this.yearOfBirth = yearOfBirth;
        this.gender = genderHandler(gender);
        this.ethnicity = ethnicity;
        this.name = name;
    }

}
