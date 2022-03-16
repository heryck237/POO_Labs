package hanoi;

/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */
import org.junit.Test;
import util.Pile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppTest {

  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
  public void popPileShouldReturnTheFirstElement() {
    Pile pile = new Pile();
    pile.push(1);
    assertEquals(1, pile.pop());
  }

  @Test
  public void toStringShouldRepresentTheTour() {
    Pile pile = new Pile();
    for (int i = 4; i > 0; --i) pile.push(i);
    assertEquals("[ <1> <2> <3> <4> ]", pile.toString());
  }

  @Test
  public void getPileShouldReturnAPile() {
    Pile pile = new Pile();
    pile.push(3);
    pile.push(2);
    pile.push(1);
    Object[] tab2 = {1, 2, 3};
    assertEquals(tab2, pile.getPile());
  }

  @Test
  public void shouldShowResultInConsole() {
    App.main(new String[] {"4"});
  }

  @Test
  public void shouldShowResultWithGraphics() {
    App.main(new String[] {});
  }

  @Test(expected = RuntimeException.class)
  public void appShouldReturnRunTimeErrorWithMoreThanOneParameter() {
    App.main(new String[] {"4", "5"});
  }

  @Test(expected = RuntimeException.class)
  public void HanoiShouldReturnRunTimeErrorWithNegativeDisk() {
    Hanoi hanoi = new Hanoi(-2);
  }

  @Test(expected = RuntimeException.class)
  public void HanoiShouldReturnRunTimeErrorWithZeroDisk() {
    Hanoi hanoi = new Hanoi(0);
  }
}
