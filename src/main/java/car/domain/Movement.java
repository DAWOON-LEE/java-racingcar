package car.domain;

import java.util.List;

public class Movement {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Movement(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void moveCars() {
        for (Car car : cars) {
            if (moveStrategy.canMove()) {
                car.move();
            }
        }
    }
}
