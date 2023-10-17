import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        System.out.println("\nWelcome to my Zoo Program, where your animal will never be misplaced!!");

        //List<String> hyenaNames = AnimalNames.getNamesForSpecies("Hyena");
        List<String> hyenaNamesList = new ArrayList<>(AnimalNames.getNamesForSpecies("Hyena"));
        List<String> lionNamesList = new ArrayList<>(AnimalNames.getNamesForSpecies("Lion"));
        List<String> bearNamesList = new ArrayList<>(AnimalNames.getNamesForSpecies("Bear"));
        List<String> tigerNamesList = new ArrayList<>(AnimalNames.getNamesForSpecies("Tiger"));

        System.out.println("\n");
        System.out.println("Hyena Names: " + hyenaNamesList);
        System.out.println("Lion Names: " + lionNamesList);
        System.out.println("Bear Names: " + bearNamesList);
        System.out.println("Tiger Names: " + tigerNamesList);
        System.out.println("\n");

        // Call getAnimalCount to get the total animal count
        int totalAnimalCount = Animal.getAnimalCount();
        System.out.println("\nTotal Animal Count: " + totalAnimalCount);

        List<Animal> arrivingAnimals = ArrivingAnimals.loadArrivingAnimalsFromFile("F:\\IntelliJ\\arrivingAnimals.txt");

        List<Animal> hyenas = new ArrayList<>();
        List<Animal> lions = new ArrayList<>();
        List<Animal> bears = new ArrayList<>();
        List<Animal> tigers = new ArrayList<>();

        Pattern agePattern = Pattern.compile("(\\d+) year old");


        for (Animal animal : arrivingAnimals) {
            String animalDesc = animal.getAnimalDesc();

            if (animalDesc.contains("hyena")) {
                hyenas.add(animal);
            } else if (animalDesc.contains("lion")) {
                lions.add(animal);
            } else if (animalDesc.contains("bear")) {
                bears.add(animal);
            } else if (animalDesc.contains("tiger")) {
                tigers.add(animal);
            }
        }

        System.out.println("\nHyenas: \n");
        for (Animal hyena : hyenas) {
            Hyena newHyena = new Hyena();
            //newHyena.setHyenaName(hyenaNamesList);
            newHyena.setAnimalID(AnimalUtils.genUniqueId("Hyena"));


            Matcher matcher = agePattern.matcher(hyena.getAnimalDesc());
            if (matcher.find()) {
                String age = matcher.group(1);
                String birthSeason = hyena.getAnimalBirthSeason();
                Date birthdate;
                if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                    birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                    calendar.set(Calendar.MONTH, Calendar.JANUARY);
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    birthdate = calendar.getTime();
                }

                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                String formattedBirthdate = sdf.format(birthdate);

                System.out.println(newHyena.getAnimalID() + "; " + /*+ newHyena.getAnimalName() + "; " +*/
                        age + " years old; birth date " + formattedBirthdate + "; " +
                        hyena.getAnimalColor() + "; " +
                        hyena.getAnimalGender() + "; " +
                        hyena.getAnimalWeight() + "; " +
                         hyena.getOrigin());


            }
            System.out.println();
        }

        System.out.println("\nLions: \n");
        for (Animal lion : lions) {
            Lion newLion = new Lion();
           // newLion.setLionName(lionNamesList);
            newLion.setAnimalID(AnimalUtils.genUniqueId("Lion"));



            Matcher matcher = agePattern.matcher(lion.getAnimalDesc());
            if (matcher.find()) {
                String age = matcher.group(1);
                String birthSeason = lion.getAnimalBirthSeason();
                Date birthdate;
                if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                    birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                    calendar.set(Calendar.MONTH, Calendar.JANUARY);
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    birthdate = calendar.getTime();
                }

                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                String formattedBirthdate = sdf.format(birthdate);

                System.out.println(newLion.getAnimalID() + "; " + /*newLion.getAnimalName() + "; " +*/
                        age + " years old; birth date " + formattedBirthdate + "; " +
                        lion.getAnimalColor() + "; " +
                        lion.getAnimalGender() + "; " +
                        lion.getAnimalWeight() + "; "
                         + lion.getOrigin());


            }
            System.out.println();
        }

        // Output the separate lists for each species without the "Animal Description" portion
        System.out.println("\nBears: \n");
        for (Animal bear : bears) {
            Bear newBear = new Bear();
           // newBear.setBearName(bearNamesList);
            newBear.setAnimalID(AnimalUtils.genUniqueId("Bear"));

            Matcher matcher = agePattern.matcher(bear.getAnimalDesc());
            if (matcher.find()) {
                String age = matcher.group(1);
                String birthSeason = bear.getAnimalBirthSeason();
                Date birthdate;
                if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                    birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                    calendar.set(Calendar.MONTH, Calendar.JANUARY);
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    birthdate = calendar.getTime();
                }

                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                String formattedBirthdate = sdf.format(birthdate);

                System.out.println(newBear.getAnimalID() + "; " + /*newBear.getAnimalName() + "; " +*/
                        age + " years old; birth date " + formattedBirthdate + "; " +
                        bear.getAnimalColor() + "; " +
                        bear.getAnimalGender() + "; " +
                        bear.getAnimalWeight() +
                        "; " + bear.getOrigin());


            }
            System.out.println();
        }


        System.out.println("\nTigers: \n");
        for (Animal tiger : tigers) {
            Tiger newTiger = new Tiger();
            //newTiger.setTigerName(tigerNamesList);
            newTiger.setAnimalID(AnimalUtils.genUniqueId("Tiger"));

            Matcher matcher = agePattern.matcher(tiger.getAnimalDesc());
            if (matcher.find()) {
                String age = matcher.group(1);
                String birthSeason = tiger.getAnimalBirthSeason();
                Date birthdate;
                if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                    birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                    calendar.set(Calendar.MONTH, Calendar.JANUARY);
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    birthdate = calendar.getTime();
                }

                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                String formattedBirthdate = sdf.format(birthdate);

                System.out.println(newTiger.getAnimalID() + "; " + /*newTiger.getAnimalName() + "; " +*/
                        age + " years old; birth date " + formattedBirthdate + "; " +
                        tiger.getAnimalColor() + "; " +
                        tiger.getAnimalGender() + "; " +
                        tiger.getAnimalWeight() +
                        "; " + tiger.getOrigin());


            }
            System.out.println();
        }

        int totalHyenas = hyenas.size();
        int totalLions = lions.size();
        int totalBears = bears.size();
        int totalTigers = tigers.size();

        System.out.println("Total Hyenas: " + totalHyenas);
        System.out.println("Total Lions: " + totalLions);
        System.out.println("Total Bears: " + totalBears);
        System.out.println("Total Tigers: " + totalTigers);

// The total count of all animals would be the sum of counts for each species.
        totalAnimalCount = totalHyenas + totalLions + totalBears + totalTigers;
        System.out.println("\nTotal Animal Count: " + totalAnimalCount);


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ZooPopulation.txt"))) {
            // Call getAnimalCount to get the total animal count

            writer.write("Zoo Population:" + totalAnimalCount);    // added totalAnimalCount
            writer.newLine();

            Zoo myZoo = new Zoo(5);



            // List<String> hyenaNames = AnimalNames.getNamesForSpecies("Hyena");
            // ... (rest of your code)

            Collections.shuffle(hyenaNamesList);
            Collections.shuffle(lionNamesList);
            Collections.shuffle(bearNamesList);
            Collections.shuffle(tigerNamesList);
            // Hyenas Habitat
            writer.write("\n\nHyena Habitat:\n");
            writer.newLine();

            int hyenaCounter = 1; // Initialize a counter

            for (int i = 0; i < hyenas.size(); i++) {
                Animal hyena = hyenas.get(i);  // Get the current hyena from the list
                Matcher matcher = agePattern.matcher(hyena.getAnimalDesc());
                if (matcher.find()) {
                    String age = matcher.group(1);
                    String birthSeason = hyena.getAnimalBirthSeason();
                    Date birthdate;
                    if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                        birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                    } else {
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                        calendar.set(Calendar.MONTH, Calendar.JANUARY);
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        birthdate = calendar.getTime();
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                    String formattedBirthdate = sdf.format(birthdate);

                    // Here, set the unique ID and name based on your object structure
                    String uniqueID = "Hy" + String.format("%02d", hyenaCounter); // Generate a unique ID
                    hyenaCounter++; // Increment the counter

                    // Get a name from the list
                    String hyenaName = hyenaNamesList.get(i);

                    hyena.setAnimalID(uniqueID);
                    hyena.setAnimalName(hyenaName);

                    writer.write(hyena.getAnimalID() + "; " + hyena.getAnimalName() + "; " +
                            age + " years old; birth date " + formattedBirthdate + "; " +
                            hyena.getAnimalColor() + "; " +
                            hyena.getAnimalGender() + "; " +
                            hyena.getAnimalWeight() + " pounds; " +
                            "from " + hyena.getOrigin());
                    writer.newLine();
                }
            }


            writer.write("\n\nLion Habitat:\n");
            writer.newLine();

            int lionCounter = 1; // Initialize a counter

            for (int i = 0; i < lions.size(); i++) {
                Animal lion = lions.get(i);  // Get the current lion from the list
                Matcher matcher = agePattern.matcher(lion.getAnimalDesc());
                if (matcher.find()) {
                    String age = matcher.group(1);
                    String birthSeason = lion.getAnimalBirthSeason();
                    Date birthdate;
                    if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                        birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                    } else {
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                        calendar.set(Calendar.MONTH, Calendar.JANUARY);
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        birthdate = calendar.getTime();
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                    String formattedBirthdate = sdf.format(birthdate);

                    // Here, set the unique ID and name based on your object structure
                    String uniqueID = "Li" + String.format("%02d", lionCounter); // Generate a unique ID
                    lionCounter++; // Increment the counter

                    String lionName = lionNamesList.get(i); // Get a name from the list

                    lion.setAnimalID(uniqueID);
                    lion.setAnimalName(lionName);

                    writer.write(lion.getAnimalID() + "; " + lion.getAnimalName() + "; " +
                            age + " years old; birth date " + formattedBirthdate + "; " +
                            lion.getAnimalColor() + "; " +
                            lion.getAnimalGender() + "; " +
                            lion.getAnimalWeight() + " pounds; " +
                            "from " + lion.getOrigin());
                    writer.newLine();
                }
            }
            writer.write("\n\nBear Habitat:\n");
            writer.newLine();

            int bearCounter = 1; // Initialize a counter

            for (int i = 0; i < bears.size(); i++) {
                Animal bear = bears.get(i);  // Get the current bear from the list
                Matcher matcher = agePattern.matcher(bear.getAnimalDesc());
                if (matcher.find()) {
                    String age = matcher.group(1);
                    String birthSeason = bear.getAnimalBirthSeason();
                    Date birthdate;
                    if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                        birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                    } else {
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                        calendar.set(Calendar.MONTH, Calendar.JANUARY);
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        birthdate = calendar.getTime();
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                    String formattedBirthdate = sdf.format(birthdate);

                    // Here, set the unique ID and name based on your object structure
                    String uniqueID = "Br" + String.format("%02d", bearCounter); // Generate a unique ID
                    bearCounter++; // Increment the counter

                    String bearName = bearNamesList.get(i); // Get a name from the list

                    bear.setAnimalID(uniqueID);
                    bear.setAnimalName(bearName);

                    writer.write(bear.getAnimalID() + "; " + bear.getAnimalName() + "; " +
                            age + " years old; birth date " + formattedBirthdate + "; " +
                            bear.getAnimalColor() + "; " +
                            bear.getAnimalGender() + "; " +
                            bear.getAnimalWeight() + " pounds; " +
                            "from " + bear.getOrigin());
                    writer.newLine();
                }
            }
            writer.write("\n\nTiger Habitat:\n");
            writer.newLine();

            int tigerCounter = 1; // Initialize a counter

            for (int i = 0; i < tigers.size(); i++) {
                Animal tiger = tigers.get(i);  // Get the current hyena from the list
                Matcher matcher = agePattern.matcher(tiger.getAnimalDesc());
                if (matcher.find()) {
                    String age = matcher.group(1);
                    String birthSeason = tiger.getAnimalBirthSeason();
                    Date birthdate;
                    if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                        birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                    } else {
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                        calendar.set(Calendar.MONTH, Calendar.JANUARY);
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        birthdate = calendar.getTime();
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                    String formattedBirthdate = sdf.format(birthdate);

                    // Here, set the unique ID and name based on your object structure
                    String uniqueID = "Ti" + String.format("%02d", tigerCounter); // Generate a unique ID
                    tigerCounter++; // Increment the counter

                    String tigerName = tigerNamesList.get(i); // Get a name from the list

                    tiger.setAnimalID(uniqueID);
                    tiger.setAnimalName(tigerName);

                    writer.write(tiger.getAnimalID() + "; " + tiger.getAnimalName() + "; " +
                            age + " years old; birth date " + formattedBirthdate + "; " +
                            tiger.getAnimalColor() + "; " +
                            tiger.getAnimalGender() + "; " +
                            tiger.getAnimalWeight() + " pounds; " +
                            "from " + tiger.getOrigin());
                    writer.newLine();
                }
            }


            // Repeat this structure for lions, bears, and tigers

            // ...

        } catch (IOException e) {
            e.printStackTrace(); // Handle or report the error
        }


    }
}





