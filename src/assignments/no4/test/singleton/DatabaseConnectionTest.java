package assignments.no4.test.singleton;

import assignments.no4.main.singleton.DatabaseConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DatabaseConnectionTest {
    public static DatabaseConnection databaseConnection;

    @Before
    public void setUp() throws Exception {
        databaseConnection = DatabaseConnection.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        databaseConnection.deconectare();
    }

    @Test
    public void singletonTest() {
        DatabaseConnection databaseConnection2 = DatabaseConnection.getInstance();
        assertEquals("Referinta la acelasi obiect unic", databaseConnection, databaseConnection2);
    }

}