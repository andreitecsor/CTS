package assignments.no4.test.memento;

import assignments.no4.main.memento.ChatRoom;
import assignments.no4.main.memento.ChatRoomBackup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ChatRoomBackupTest {
    public static ChatRoom chatRoom;

    @Before
    public void setUp() throws Exception {
        chatRoom = new ChatRoom("192.0.1.1", 8080);
        chatRoom.conectare();
    }

    @After
    public void tearDown() throws Exception {
        chatRoom.deconectare();
    }

    @Test
    public void mementoTest() {
        chatRoom.adaugaMesaj("Andrei", "Salutare! Cum merge tema la CTS?");
        chatRoom.adaugaMesaj("Andrei1", "Salut... incet dar sigur");
        chatRoom.adaugaMesaj("Andrei", "Stiu ce zici... nu prea mai e inspiratie pe ultima suta...");
        Map<LocalDateTime, String> conversatieDeVerificat = chatRoom.getConversatie();
        ChatRoomBackup backup1 = chatRoom.salveazaConversatie();
        chatRoom.stergeConversatia();
        chatRoom.restaureazaConversatie(backup1);
        assertEquals("Conversatie restaurata", conversatieDeVerificat, chatRoom.getConversatie());
    }


}