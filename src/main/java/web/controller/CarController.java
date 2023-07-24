package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private final CarServiceImpl carServiceImpl;

    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(value = "count", defaultValue = "5") int carCount, Model model){
        List<Car> car = new ArrayList<>();
        car.add(new Car(1,"BMW","Red"));
        car.add(new Car(2,"Audi","Blue"));
        car.add(new Car(3,"Opel","Black"));
        car.add(new Car(4,"Renault","White"));
        car.add(new Car(5,"Fiat","Green"));
        car = CarServiceImpl.certainCars(car, carCount);
        model.addAttribute("car", car);
        return "cars";
    }


}
