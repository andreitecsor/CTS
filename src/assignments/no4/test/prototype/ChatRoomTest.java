package assignments.no4.test.prototype;

import assignments.no4.main.prototype.ChatRoom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChatRoomTest {
    public static ChatRoom chatRoom;

    @Before
    public void setUp() throws Exception {
        chatRoom = new ChatRoom("192.0.1.1", 8080);
    }

    @After
    public void tearDown() throws Exception {
        chatRoom.deconectare();
    }

    @Test
    public void prototypeObjectIdenticValuesTest() {
        ChatRoom chatRoom2 = (ChatRoom) chatRoom.clone();
        assertEquals("Clonă reușită", chatRoom.toString(), chatRoom2.toString());
    }

    @Test
    public void prototypeDifferentHashcodeTest() {
        ChatRoom chatRoom2 = (ChatRoom) chatRoom.clone();
        assertNotEquals("Referinta diferita", chatRoom.hashCode(), chatRoom2.hashCode());
    }

}