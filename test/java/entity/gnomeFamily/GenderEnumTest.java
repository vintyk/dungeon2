package entity.gnomeFamily;

import entity.gnomeFamily.Gender;
import org.junit.Assert;
import org.junit.Test;

public class GenderEnumTest {

    @Test
    public void genderEnumTest(){
        Assert.assertEquals("Гномиха", Gender.FEMALE.getGender());
        Assert.assertEquals("Гном", Gender.MALE.getGender());
    }
}
