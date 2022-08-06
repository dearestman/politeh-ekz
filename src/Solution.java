import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data.add("Политех - программист - 270");
        data.add("ИТМО - программист - 269");
        data.add("ГУ - программист - 125");
        data.add("Политех - программист - 299");

        for (String str:getSolution(data,  "программист",269)
             ) {
            System.out.println(str);
        }
    }
    static List<String> getSolution(List<String> data, String speciality, int points){
        List<University> universities = new ArrayList<>();
        List<University> resultUniversities = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (String str:data
        ) {
            universities.add(new University(str.split(" - ")[0], str.split(" - ")[1], Integer.parseInt(str.split(" - ")[2])));
        }
        try {
            for (University un : universities
            ) {
                if (speciality.equals(un.getSpeciality()) & points >= un.getPassingScore()) {
                    resultUniversities.add(un);
                }
            }
            Collections.sort(resultUniversities);

            for (University un : resultUniversities
            ) {
                result.add(un.getName());
            }
        } catch (Exception e){
            e.getStackTrace();
        }
        return result;
    }
}

class University implements Comparable<University>{
    private String name;
    private String speciality;
    private int passingScore;

    public University(String name, String speciality, int passingScore) {
        this.name = name;
        this.speciality = speciality;
        this.passingScore = passingScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(int passingScore) {
        this.passingScore = passingScore;
    }

    @Override
    public int compareTo(University o) {
        return o.getPassingScore()- this.passingScore;
    }
}