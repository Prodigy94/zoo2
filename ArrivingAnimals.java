import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
public class ArrivingAnimals {
    public static List<Animal> loadArrivingAnimalsFromFile(String filePath ) {
        filePath = "F:\\IntelliJ\\arrivingAnimals.txt";

        List<Animal> arrivingAnimals = new ArrayList<>();


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 6) {
                    String animalDesc = parts[0].trim();
                    String animalBirthSeason = parts[1].trim();
                    String animalColor = parts[2].trim();
                    String animalWeight = parts[3].trim();
                    String origin1 = parts[4].trim();
                    String origin2 = parts[5].trim();

                    // Determine the species based on the animalDesc or other criteria
                    // You may need to implement logic to identify the species correctly

                    // Extract age and gender
                    int age = extractAge(animalDesc);
                    String gender = extractGender(animalDesc);

                    // Concatenate origin1 and origin2 into the origin field
                    String origin = origin1 + ", " + origin2;

                    // Create an Animal object (replace with the correct species)
                    Animal arrivingAnimal = new Animal();
                    arrivingAnimal.setAnimalDesc(animalDesc);
                    arrivingAnimal.setAnimalGender(gender); // Set the gender
                    arrivingAnimal.setAnimalAge(age + " years");
                    arrivingAnimal.setAnimalBirthSeason(animalBirthSeason);
                    arrivingAnimal.setAnimalColor(animalColor);
                    arrivingAnimal.setAnimalWeight(animalWeight);
                    arrivingAnimal.setOrigin(origin);

                    // Add the arriving animal to the list
                    arrivingAnimals.add(arrivingAnimal);
                } else {
                    System.out.println("Invalid data format: " + line);
                }
            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return arrivingAnimals;
    }

    public static int extractAge(String animalDesc) {
        String[] wordsInDesc = animalDesc.split(" ");
        for (int i = 0; i < wordsInDesc.length; i++) {
            if (wordsInDesc[i].equalsIgnoreCase("years") && i > 0) {
                try {
                    return Integer.parseInt(wordsInDesc[i - 1]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0; // Default to 0 if age is not found
    }

    public static String extractGender(String animalDesc) {
        String[] wordsInDesc = animalDesc.split(" ");
        for (String word : wordsInDesc) {
            if ("male".equalsIgnoreCase(word) || "female".equalsIgnoreCase(word)) {
                return word.toLowerCase();
            }
        }
        return "unknown"; // Default to "unknown" if gender is not found
    }

}

