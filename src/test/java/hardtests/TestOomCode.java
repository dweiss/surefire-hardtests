package hardtests;

import java.util.LinkedList;

import org.junit.Test;

public class TestOomCode {
  static LinkedList<byte[]> ohMy = new LinkedList<byte[]>(); 

  @Test
  public void oomInCode() {
    int stringLength = 1024 * 1024 * 5;
    while (true) {
      try {
          ohMy.add(new byte [stringLength]);
      } catch (OutOfMemoryError e) {
        if (stringLength < 100) {
          throw e;
        } else {
          stringLength /= 2;
        }
      }
    }
  }
}
