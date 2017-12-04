package entity.gnomeFamily;

import dao.ArmorDao;
import dao.UtilitesDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArmorTest {

    @Test
    public void saveTest(){
        Armor armor = new Armor();
        armor.setTypeArmor(TypeArmor.MITHRIL);
        armor.setAbsorbDamage(15L);
        armor.setWeight(120L);

        Long armorId = ArmorDao.getInstance().save(armor);


        UtilitesDao.deleteFromTableById("armor", armorId);
    }
}