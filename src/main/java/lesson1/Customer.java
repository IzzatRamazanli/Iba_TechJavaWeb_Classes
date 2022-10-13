package lesson1;

public record Customer(int id, String name, String surname) {

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "name: " + name + "\n" +
                "surname: " + surname + "\n";
    }
}
