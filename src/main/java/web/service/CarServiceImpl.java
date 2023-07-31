package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    static List<Car> car;

    {
        car = new ArrayList<>();

        car.add(new Car(1, "BMW", "Red"));
        car.add(new Car(2, "Audi", "Blue"));
        car.add(new Car(3, "Opel", "Black"));
        car.add(new Car(4, "Renault", "White"));
        car.add(new Car(5, "Fiat", "Green"));
    }
    static List<Car> certainCars(int numberOfCars){


        if(numberOfCars <= 0 || numberOfCars > 5){
            return car;
        } else {
            return car.stream().limit(numberOfCars).collect(Collectors.toList());
        }
    }
}
