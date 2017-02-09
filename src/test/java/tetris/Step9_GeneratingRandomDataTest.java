package tetris;

import org.junit.Test;

import static org.junit.Assert.*;

import net.java.quickcheck.characteristic.Classification;
import net.java.quickcheck.generator.iterable.Iterables;
import net.java.quickcheck.generator.PrimitiveGenerators;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

public class Step9_GeneratingRandomDataTest {

    private static Logger LOGGER = Logger.getLogger("Step9_GeneratingRandomDataTest");
    private FileHandler fileHandler;

    // TODO: add tests that use random data generation
    @Test
    public void test_to_generate_random_data() {

        try {
            fileHandler = new FileHandler("Step9_GeneratingRandomDataTest.log");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {}
        
        Classification c = new Classification();
        
        for (Boolean b : Iterables.toIterable(PrimitiveGenerators.booleans())) {
            if (b.booleanValue()) {
                c.classifyCall("TRUE");
            } else {
                c.classifyCall("FALSE");
            }
            
            assertTrue(b.booleanValue() || !b.booleanValue());
        }

        for (Object cat : c.getCategories()) {
            LOGGER.info("[GeneratingRandomDataTest.test_to_generate_random_data()] ===> " + cat +
                        " => " + c.getFrequency(cat));
        }
    }

}
