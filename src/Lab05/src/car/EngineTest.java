package car;

import static org.junit.Assert.*;

public class EngineTest {

    @org.junit.Test
    public void increaseRPM() {
        int maxrpm = 10;
        Engine engine = new Engine(maxrpm, "e", 2, 2);

        for (int i = 0; i < maxrpm*2; i++) {
            engine.increaseRPM(1);
        }
        assertFalse(engine.getRpm() > maxrpm);

        for (int i = 0; i < maxrpm*4; i++) {
            engine.decreaseRPM(i);
        }

        assertFalse(engine.getRpm() < 0);

        engine.engineStop();
        engine.increaseRPM(maxrpm);
        assertNotEquals(engine.getRpm(), maxrpm);
    }
}