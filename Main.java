import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        Toy toy1 = new Toy(1, "конструктор", 2, 20);
        Toy toy2 = new Toy(2, "кукла", 6, 10);
        Toy toy3 = new Toy(3, "машинка", 15, 5);

        toyShop.addToy(toy1);
        toyShop.addToy(toy2);
        toyShop.addToy(toy3);

        toyShop.changeToyWeight(1, 10);

        Toy prizeToy = toyShop.getRandomPrizeToy();
        toyShop.deleteAndWriteToFile(prizeToy);

        System.out.println("Вы выиграли: " + prizeToy.getName());
    }

}