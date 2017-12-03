package dao;

import entity.Witch;
import org.junit.Test;

public class WithDaoTest {

    @Test
    public void saveTest () {
        Witch witch = new Witch();
        witch.setName("Kelly");
        witch.setManna(73L);
        witch.setHelth(44L);
        System.out.println(witch);

        WithDao.getInstance().save(witch);
    }
}