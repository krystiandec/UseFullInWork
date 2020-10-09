package Services.training.interviewIssues.nameStatistics.childs;


public enum Gender {
    MALE('M'),
    FEMALE('F');

    char sign;

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    Gender(char sign) {
        this.sign = sign;
    }
}

