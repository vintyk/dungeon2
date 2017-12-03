package entity;

import dao.OrcTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OrcTest.class,
        GhostTest.class
//        BaseEvilTest.class,
})
public class _TestSuit {
}
