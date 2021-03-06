package tetris;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Implements the GraphWalker model: src/main/resources/tetris/BoardTest.graphml
 * The graph can be found in PNG format in the doc folder.
 * 
 * The interface BoardTest, that SomeBoardTest implements, is generated by
 * GraphWalker dynamically, but can be forced by running:
 * mvn graphwalker:generate-sources.
 */
@GraphWalker(value = "random(edge_coverage(100))", start = "setUp")
public class SomeBoardTest extends ExecutionContext implements BoardTest {

  @Override
  public void setUp() {
    System.out.println("Running: setUp");
  }

  @Override
  public void drop() {
    System.out.println("Running: drop");
  }

  @Override
  public void tick() {
    System.out.println("Running: tick");
  }

  @Override
  public void boardReady() {
    System.out.println("Running: boardReady");
  }

  @Override
  public void boardBusy() {
    System.out.println("Running: boardBusy");
  }
}
