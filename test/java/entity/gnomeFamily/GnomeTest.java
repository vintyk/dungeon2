package entity.gnomeFamily;

import dao.ArmorDao;
import dao.GnomeDao;
import dao.UtilitesDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class GnomeTest {
    @Test
    public void saveTest(){
        Armor armor = new Armor();
        armor.setTypeArmor(TypeArmor.MITHRIL);
        armor.setAbsorbDamage(15L);
        armor.setWeight(120L);
        Long armorId = ArmorDao.getInstance().save(armor);
        armor.setId(armorId);

        Gnome gnome = new Gnome();
        gnome.setName("Gimly");
        gnome.setGender(Gender.MALE);
        gnome.setHelth(290L);
        gnome.setArmor(armor);

        Long gnomeId = GnomeDao.getInstance().save(gnome);
        System.out.println(armor);
        System.out.println(gnome);
        // Соблюдаем порядок удаления, не нарушая FK
        UtilitesDao.deleteFromTableById("gnome", gnomeId);
        UtilitesDao.deleteFromTableById("armor", armorId);
    }
}