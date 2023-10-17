import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Lion extends Animal{
    private static int numberOfLions = 0;


    public Lion(){

        numberOfLions++;
    }

    public static int getNumberOfLions(){
        return numberOfLions;
    }

    static Set<String> usedLionNames = new HashSet<>();

    private String generateUniqueName(List<String> lionNamesList) {
        Random random = new Random();
        String randomLionName = null;

        // Keep generating a random name until an unused one is found
        do {
            int randomIndex = random.nextInt(lionNamesList.size());
            randomLionName = lionNamesList.get(randomIndex);
        } while (usedLionNames.contains(randomLionName));

        // Add the used name to the set to prevent duplicates
        usedLionNames.add(randomLionName);

        return randomLionName;
    }



    // Public method to set the Hyena's name to call on from Main
    public void setLionName(List<String> lionNamesList) {
        String randomLionName = generateUniqueName(lionNamesList);
        setAnimalName(randomLionName);
    }
}
