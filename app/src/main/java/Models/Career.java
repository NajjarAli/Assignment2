package Models;

public class Career {
    private String degree;
    private String major;
    private String school;
    private String year;
    private String company;
    private String job;
    private String startYear;
    private String endYear;

    public Career(String degree, String major, String school, String year, String company, String job, String startYear, String endYear) {
        this.degree = degree;
        this.major = major;
        this.school = school;
        this.year = year;
        this.company = company;
        this.job = job;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    @Override
    public String toString() {
        return "Career{" +
                "degree='" + degree + '\'' +
                ", major='" + major + '\'' +
                ", school='" + school + '\'' +
                ", year='" + year + '\'' +
                ", company='" + company + '\'' +
                ", job='" + job + '\'' +
                ", startYear='" + startYear + '\'' +
                ", endYear='" + endYear + '\'' +
                '}';
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }
}
