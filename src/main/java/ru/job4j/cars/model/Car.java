package ru.job4j.cars.model;

import javax.persistence.GenerationType;
import javax.persistence.*;

import java.util.Objects;

/**
 * Модель данных описывающая Автомобиль
 * Реализовать площадку продаж машин. [#4747]
 * Уровень : 3. МидлКатегория : 3.3. HibernateТопик : 3.3.2. Mapping
 * - Спроектируйте SQL схему для сайта по продажам машин.
 * - Добавьте POJO классы и hibernate mapping. В этом задании нужно использовать аннотации.
 * - Загрузите схему в корень репозитория в папку db.
 *
 * @author SlartiBartFast-art
 * @version 01
 * @since 22.11.21
 */
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mark;

    private String bodyType;

    private String engine;

    private String transmission;

    private String color;

    private String drive;

    private String mileage;

    @ManyToOne
    @JoinColumn(name = "car")
    private User user;

    public Car() {
    }

    public static Car of(String mark, String bodyType, String engine,
                  String transmission, String color,
                  String drive, String mileage) {
        Car car = new Car();
        car.mark = mark;
        car.bodyType = bodyType;
        car.engine = engine;
        car.transmission = transmission;
        car.color = color;
        car.drive = drive;
        car.mileage = mileage;
        return car;
    }

    public Car of(String mark, String bodyType) {
        Car car = new Car();
        this.mark = mark;
        this.bodyType = bodyType;
        return car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Car: id=%s, mark=%s, bodyType=%s, engine=%s,"
                        + " transmission=%s, color=%s, drive=%s, mileage=%s, User=%s",
                id, mark, bodyType, engine, transmission, color, drive, mileage, user);
    }
}
