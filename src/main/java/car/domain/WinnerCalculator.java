package car.domain;

import java.util.*;

public class WinnerCalculator {
    public static List<Car> getWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
