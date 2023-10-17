import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hyena extends Animal{

    public Hyena() {
        numOfHyenas++;

    }
    public static int getNumOfHyenas(){
        return numOfHyenas;
    }
    private static int numOfHyenas = 0;





    //
    static Set<String> usedHyenaNames = new HashSet<>();

    // Private method to generate a unique name for a Hyena
    private String generateUniqueName(List<String> hyenaNamesList) {
        Random random = new Random();
        String randomHyenaName = null;

        // Keep generating a random name until an unused one is found
        do {
            int randomIndex = random.nextInt(hyenaNamesList.size());
            randomHyenaName = hyenaNamesList.get(randomIndex);
        } while (usedHyenaNames.contains(randomHyenaName));

        // Add the used name to the set to prevent duplicates
        usedHyenaNames.add(randomHyenaName);

        return randomHyenaName;
    }

    // Public method to set the Hyena's name to call on from Main
    public void setHyenaName(List<String> hyenaNamesList) {
        String randomHyenaName = generateUniqueName(hyenaNamesList);
        setAnimalName(randomHyenaName);
    }
}
























