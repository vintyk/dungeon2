package entity.gnomeFamily;

import dao.ArmorDao;
import dao.UtilitesDao;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ArmorTest {

    @Test
    public void saveTest(){
        Armor armor = new Armor();
        armor.setTypeArmor(TypeArmor.MITHRIL);
        armor.setAbsorbDamage(15L);
        armor.setWeight(120L);

        Long armorId = ArmorDao.getInstance().save(armor);
        Optional<Armor> armorOptional = ArmorDao.getInstance().findById(armorId);
        if (armorOptional.isPresent()){
            Armor armorFromDb = armorOptional.get();
            System.out.println(armorFromDb);
        }
        UtilitesDao.deleteFromTableById("armor", armorId);
    }
}