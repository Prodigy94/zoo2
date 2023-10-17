import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Bear extends Animal{
    private static int numberOfBears = 0;
    public Bear(){
        numberOfBears++;
    }

    public static int getNumberOfBears(){
        return numberOfBears;
    }

    static Set<String> usedBearNames = new HashSet<>();
    private String generateUniqueName(List<String> bearNamesList) {
        Random random = new Random();
        String randomBearName = null;

        // Keep generating a random name until an unused one is found
        do {
            int randomIndex = random.nextInt(bearNamesList.size());
            randomBearName = bearNamesList.get(randomIndex);
        } while (usedBearNames.contains(randomBearName));

        // Add the used name to the set to prevent duplicates
        usedBearNames.add(randomBearName);

        return randomBearName;
    }

    // Public method to set the Hyena's name to call on from Main
    public void setBearName(List<String> bearNamesList) {
        String randomBearName = generateUniqueName(bearNamesList);
        setAnimalName(randomBearName);
    }

}
