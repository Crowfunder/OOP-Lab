package car;

import org.junit.Test;

import static org.junit.Assert.*;
public class GearboxTest {

    @Test
    public void setCurrentGear() throws GearboxException {
        int maxgear = 10;
        Gearbox gearbox = new Gearbox("as", 2, 2, maxgear, new Clutch("ew", 2, 2));

        for (int i = 0; i < maxgear*2; i++) {
            gearbox.setCurrentGear(maxgear+10);
        }

        for (int i = 0; i < maxgear*4; i++) {
            gearbox.setCurrentGear(-1*maxgear);
        }

        assertTrue(gearbox.getCurrentGear() > 0);
    }
}