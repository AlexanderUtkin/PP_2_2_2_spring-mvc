package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl extends CarService {
    public static List<Car> certainCars(List<Car> car, int numberOfCars){
        if(numberOfCars == 0 || numberOfCars > 5){
            return car;
        } else {
            return car.stream().limit(numberOfCars).collect(Collectors.toList());
        }
    }
}
