package assignments.no4.main.memento;

import java.time.LocalDateTime;
import java.util.Map;

public class ChatRoomBackup {
    private Map<LocalDateTime, String> conversatie;
    private LocalDateTime momentBackup;

    public ChatRoomBackup(Map<LocalDateTime, String> conversatie) {
        this.conversatie = conversatie;
        momentBackup = LocalDateTime.now();
    }

    public Map<LocalDateTime, String> getConversatie() {
        return conversatie;
    }
}
