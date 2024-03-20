package ee.tlu.kodutoo;

import lombok.Getter;

@Getter
public class NumberEntity {

    // Getterid ja setterid
    String name;
    String description;
    int number;

    public NumberEntity(String name, String description, int number) {
        this.name = name;
        this.description = description;
        this.number = number;
    }
}