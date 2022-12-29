package externalizable;

import java.io.*;

/**
 * Створіть клас Car.
 * Опишіть у ньому 3 різних поля, включаючи статичні поля, створіть конструктор, методи.
 * За допомогою Java створіть файл та виконайте серіалізацію об'єкта Car використовуючи інтерфейс
 * Externalizable.
 **/

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Tucson", 25000);
        File file = new File("src/externalizable/Car.txt");
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
            os.writeObject(car);
            Car otherCar = (Car) is.readObject();
            System.out.println(otherCar);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
