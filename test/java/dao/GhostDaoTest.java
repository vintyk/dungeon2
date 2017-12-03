package dao;

import entity.Ghost;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class GhostDaoTest {
    @Before
    public void setUp() {
    }

    @Test
    public void saveTest() {
        Ghost ghost = new Ghost();
        ghost.setName("BuBa");
        ghost.setTransparency(80L);
        ghost.setHelth(100L);

        GhostDao.getInstance().save(ghost);

        Long idFromDb = UtilitesDao.getIdFromGhost("ghost");
        System.out.println(idFromDb);
        Optional<Ghost> ghostFromBd = GhostDao.getInstance().findById(idFromDb);
        if (ghostFromBd.isPresent()) {
            Ghost myGhost = ghostFromBd.get();
            System.out.println(myGhost);
            Assert.assertEquals(ghost, myGhost);
            UtilitesDao.deleteFromTableById("ghost", idFromDb);
        }
    }

}
