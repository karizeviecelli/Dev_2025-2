import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        Car ferrari = new Car("Ferrari 360 Spider");
        Car bugatti = new Car("Bugatti Veyron");
        Car lambo = new Car("Lamborguini Diablo");
        Car ford = new Car("Ford Modneo");

        cars.add(ferrari);
        cars.add(bugatti);
        cars.add(lambo);

        cars.add(1, ford);

        System.out.println("Lista de Carros:");
        for (Car car : cars){
            System.out.println(car);
        }
    }
}