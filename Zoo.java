// Zoo class
class Zoo {
    private Animal[] animals;

    public Zoo(int capacity) {
        animals = new Animal[capacity];
    }

    public void addAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                animals[i] = animal;
                System.out.println(animal.getName() + " has been added to the zoo.");
                return;
            }
        }
        System.out.println("The zoo is full. Cannot add " + animal.getName() + ".");
    }

    public void makeAllSounds() {
        System.out.println("All animals in the zoo make sounds:");
        for (Animal animal : animals) {
            if (animal != null) {
                animal.makeSound();



                // MAIN
                // Zoo myZoo = new Zoo(5);
                //
                //        // Add animals to the zoo
                //        myZoo.addAnimal(new Lion("Scar"));
                //        myZoo.addAnimal(new Bear("Yogi"));
                //        myZoo.addAnimal(new Lion("Mufasa"));
                //        myZoo.addAnimal(new Bear("Smokey"));
                //        myZoo.addAnimal(new Tiger("Tony"));
                //        myZoo.addAnimal(new Hyena("Shenzi"));
                //
                //        // Make all animals in the zoo make sounds
                //        myZoo.makeAllSounds();


                // ANIMALS
                // public Lion(String name) {
                //
                //        super(name);
                //    }
                //
                //    @Override
                //    public void makeSound() {
                //
                //        System.out.println("Roar!");
                //    }


            }
        }
    }
}