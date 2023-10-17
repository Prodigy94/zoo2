import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Animal {
    private String animalName;

    private String animalDesc;
    protected String animalAge; // optional
    private String animalBirthSeason;
    private Date animalBirthdate;
    protected String animalGender;
    protected String animalWeight;
    protected String animalColor;
    protected String origin;
    protected String animalID;






    private static int animalCount = 0;
    public Animal(){
        animalCount++;

    }
    public static int getAnimalCount() {
        return animalCount;
    }


    public void setAnimalBirthdate(Date animalBirthdate) {
        this.animalBirthdate = animalBirthdate;
    }

    public void setAnimalDesc(String animalDesc) {
        this.animalDesc = animalDesc;
    }

    public void setAnimalAge(String animalAge) {
        this.animalAge = animalAge;
    }

    public void setAnimalGender(String animalGender) {
        this.animalGender = animalGender;
    }

    public void setAnimalBirthSeason(String animalBirthSeason) {
        this.animalBirthSeason = animalBirthSeason;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public void setAnimalWeight(String animalWeight) {
        this.animalWeight = animalWeight;
    }

    public void setOrigin(String origin1) {
        this.origin = origin1;
    }

    public void setAnimalID(String animalID) {
        this.animalID = animalID;
    }
    public String getFormattedBirthDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        return sdf.format(animalBirthdate);
    }

    public String getAnimalID() {
        return animalID;
    }

    public String getAnimalAge() {
        return animalAge;
    }

    public Date getAnimalBirthdate() {
        return animalBirthdate;
    }

    public String getAnimalDesc() {
        return animalDesc;
    }



    public String getAnimalGender() {
        return animalGender;
    }

    public String getAnimalBirthSeason() {
        return animalBirthSeason;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public String getAnimalWeight() {
        return animalWeight;
    }

    public String getOrigin() {
        return origin;
    }



    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public Date getBirthdate() {
        return animalBirthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.animalBirthdate = birthdate;
    }
}
