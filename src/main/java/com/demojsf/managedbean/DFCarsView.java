package com.demojsf.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

@ManagedBean(name = "dfCarsView")
@ViewScoped
public class DFCarsView implements Serializable {
     
    private List<Car> cars;
  
    private CarService service;
     
    @PostConstruct
    public void init() {
    	service = new CarService(); 
        cars = service.createCars(9);
    }
     
    public List<Car> getCars() {
        return cars;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
     
    public void selectCarFromDialog(Car car) {
        PrimeFaces.current().dialog().closeDynamic(car);
    }
}