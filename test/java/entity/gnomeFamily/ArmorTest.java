package entity.gnomeFamily;

import dao.ArmorDao;
import dao.UtilitesDao;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


public class ArmorTest {

    @Test
    public void saveTest() {
        Armor armor = new Armor();
        armor.setTypeArmor(TypeArmor.MITHRIL);
        armor.setAbsorbDamage(15L);
        armor.setWeight(120L);

        Long armorId = ArmorDao.getInstance().save(armor);
        Optional<Armor> armorOptional = ArmorDao.getInstance().findById(armorId);
        if (armorOptional.isPresent()) {
            Armor armorFromDb = armorOptional.get();
            System.out.println(armorFromDb);
        }
        UtilitesDao.deleteFromTableById("armor", armorId);
    }

    @Test
    public void findAllTest() {
        List listIds = new ArrayList();
        for (int i = 0; i < 15; i++) {
            Random r = new Random();
            TypeArmor[] list = new TypeArmor[]{TypeArmor.MITHRIL, TypeArmor.IRON, TypeArmor.STEEL};
            TypeArmor randomTypeArmor = list[r.nextInt(list.length)];

            Armor armor = new Armor();
            armor.setTypeArmor(randomTypeArmor);
            armor.setAbsorbDamage((long) (Math.random() * 30) + 25);
            armor.setWeight((long) (Math.random() * 70) + 50);
            Long armorId = ArmorDao.getInstance().save(armor);
            listIds.add(armorId);
        }
        List<Armor> armorList = ArmorDao.getInstance().findAll();
        armorList.forEach(myElement -> System.out.println(myElement));
        Assert.assertEquals(15, armorList.size());

        listIds.forEach(myElement -> UtilitesDao.deleteFromTableById("armor", (long) myElement));
    }
}
