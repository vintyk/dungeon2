package entity;

import com.sun.xml.internal.ws.policy.AssertionSet;
import entity.Witch;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WitchTest {
    @Before
    public void setUp(){
        System.out.println("Начало теста Witch");
    }
    @Test
    public void witchtest () {
        Witch witch = new Witch();
        witch.setManna(200L);
        witch.setName("Artem");
        witch.setId(2L);
        witch.setHelth(300L);
        Assert.assertNotNull(witch);
        Assert.assertEquals((long) 200L, (long) witch.getManna());
        Assert.assertEquals("Artem", witch.getName());
        Assert.assertEquals((long) 2L, (long) witch.getId());
        Assert.assertEquals((long) 300L, (long) witch.getHelth());
    }
    @After
    public void end(){
        System.out.println("конец теста Witch");
    }
}
