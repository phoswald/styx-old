package styx.db.mmap;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import styx.StyxException;
import styx.core.sessions.AbstractSessionFactory;
import styx.core.sessions.TestAnyTransaction;

@RunWith(Parameterized.class)
public class TestMmapTransaction extends TestAnyTransaction {

    public TestMmapTransaction(AbstractSessionFactory sf) {
        super(sf);
    }

    @Parameters
    public static Collection<?> getParameters() throws StyxException {
        return Arrays.<Object[]>asList(new Object[] { // test parameter [0]
                    MmapSessionProvider.createSessionFactory(Paths.get("target", "styx-session", "TestMmapSession.2.db"), 64 << 10)
            });
    }
}
