package entity;

import entity.Ghost;
import org.junit.Assert;
import org.junit.Test;

public class GhostTest {
    @Test
    public void ghostTest () {
        Ghost ghost = new Ghost();
        ghost.setTransparency(50L);
        ghost.setId(3L);
        ghost.setName("Bight");
        ghost.setHelth(150L);
        Assert.assertNotNull(ghost);
        Assert.assertEquals((long) 50L, (long) ghost.getTransparency());
        Assert.assertEquals((long) 3L, (long) ghost.getId());
        Assert.assertEquals("ht", ghost.getName().substring(3));
        Assert.assertEquals((long) 150L, (long) ghost.getHelth());
    }

}
