package entity.gnomeFamily;

import org.junit.Assert;
import org.junit.Test;

public class TypeArmorTest {
    @Test
    public void getTypeArmor() {
        Assert.assertEquals("Мифрил", TypeArmor.MITHRIL.getTypeArmor());
        Assert.assertEquals("Железо", TypeArmor.IRON.getTypeArmor());
        Assert.assertEquals("Сталь", TypeArmor.STEEL.getTypeArmor());
    }
}