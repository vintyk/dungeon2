package dao;

import entity.Color;
import entity.Orc;
import org.junit.Test;

public class OrcTest {

    @Test
    public void saveTest(){
        Orc orc = new Orc();
        orc.setColor(Color.GREEN);
        orc.setHelth(99L);
        orc.setName("Алекс");
        orc.setForce(33L);
        System.out.println(orc);

    OrcDao.getInstance().save(orc);

    }
}
