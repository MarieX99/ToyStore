import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyShop {
    private List<Toy> toys;
    public  ToyShop() {
        toys = new ArrayList<>();

    }
    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public  void changeToyWeight(int id, double weight) {
        for(Toy toy : toys) {
            if(toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }

    }
    public Toy getRandomPrizeToy() {
        Toy prizeToy = null;
        double weightSum = 0;

        for(Toy toy : toys) {
            weightSum += toy.getWeight();
        }

        double randomWeight = Math.random() * weightSum;

        for(Toy toy : toys) {
            randomWeight -= toy.getWeight();

            if(randomWeight <= 0) {
                prizeToy = toy;
                break;
            }
        }
        return prizeToy;
    }

    public void deleteAndWriteToFile(Toy toy) {
        toys.remove(toy);
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("PrizeToy.txt", true))) {
            writer.write(toy.getId() + " " + toy.getName());
            writer.newLine();
        }catch (IOException e) {
            e.printStackTrace();
        }

        toy.reduceQuantity();

    }

}
