import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.zoo.Animal;
import ru.zoo.Veterinarian;
import ru.zoo.Zookeeper;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AnimalTest {

    Faker faker = new Faker();

    Animal animal;

    @BeforeEach
    public void setUp() {
        animal = new Animal(faker.animal().name());
    }

    @Test
    public void shouldBiteVeterinarian() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Veterinarian human = new Veterinarian();

        animal.bite(human);

        Assertions.assertTrue(human.hurt);
        Assertions.assertEquals(
                "Животное " + animal.name + " покусало " + human.profession + "\n",
                outContent.toString()
        );
    }

    @Test
    public void shouldBiteZookeeper() {
        Zookeeper human = new Zookeeper();
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        animal.bite(human);

        Assertions.assertTrue(human.hurt);
        Assertions.assertEquals(
                "Животное " + animal.name + " покусало " + human.profession + "\n",
                outContent.toString()
        );
    }

    @Test
    public void shouldEat() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        animal.eat();

        Assertions.assertFalse(animal.hungry);
        Assertions.assertEquals("Животное " + animal.name + " поело \n",
                outContent.toString());
    }

    @Test
    public void shouldNotEat() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        animal.hungry = false;
        animal.eat();

        Assertions.assertTrue(animal.hungry);
    }
}
