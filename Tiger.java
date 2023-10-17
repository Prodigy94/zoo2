import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Tiger extends Animal{

    private static int numbOfTigers = 0;

    public Tiger(){
        numbOfTigers++;
    }
    public static int getNumOfTiger() {
        return numbOfTigers;
    }

    static Set<String> usedTigerNames = new HashSet<>();
    private String generateUniqueName(List<String> tigerNamesList) {
        Random random = new Random();
        String randomTigerName = null;

        // Keep generating a random name until an unused one is found
        do {
            int randomIndex = random.nextInt(tigerNamesList.size());
            randomTigerName = tigerNamesList.get(randomIndex);
        } while (usedTigerNames.contains(randomTigerName));

        // Add the used name to the set to prevent duplicates
        usedTigerNames.add(randomTigerName);

        return randomTigerName;
    }

    // Public method to set the Hyena's name to call on from Main
    public void setTigerName(List<String> tigerNamesList) {
        String randomTigerName = generateUniqueName(tigerNamesList);
        setAnimalName(randomTigerName);
    }

}
