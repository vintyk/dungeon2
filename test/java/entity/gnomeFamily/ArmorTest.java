package entity.gnomeFamily;

import dao.ArmorDao;
import dao.UtilitesDao;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static javafx.scene.input.KeyCode.L;
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

    @Test
    public void findAllTest(){
        for (int i = 0; i < 25; i++) {
            Armor armor = new Armor();
            armor.setTypeArmor(TypeArmor.MITHRIL);
            armor.setAbsorbDamage((long)(Math.random()*5)+10);
            armor.setWeight((long)(Math.random()*70)+50);
            ArmorDao.getInstance().save(armor);
        }
        List<Armor> armorList = ArmorDao.getInstance().findAll();
        armorList.forEach(a -> System.out.println(a));
    }
}