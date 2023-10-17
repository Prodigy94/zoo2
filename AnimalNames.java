import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalNames {
    private static Map<String, List<String>> speciesNames = new HashMap<>();

    static {
        loadNamesFromFile();
    }

    public static void loadNamesFromFile() {
        String filePath ="F:\\IntelliJ\\animalNames.txt" ; // Update with the actual file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String currentSpecies = null;
            List<String> currentNames = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.endsWith(" Names:")) {
                    if (currentSpecies != null) {
                        speciesNames.put(currentSpecies, currentNames);
                    }
                    currentSpecies = line.replace(" Names:", "").trim();
                    currentNames = new ArrayList<>();
                } else if (currentSpecies != null && !line.isEmpty()) {
                    currentNames.add(line);
                }
            }

            // Add the names for the last species
            if (currentSpecies != null) {
                speciesNames.put(currentSpecies, currentNames);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getNamesForSpecies(String species) {
        return speciesNames.get(species);
    }
}