package sem3;


public class EmailNotificationService implements NotificationService {
	@Override
	public void sendNotification(Person destination, String msg) {
		System.out.println("Sending email to " + destination.getEmail());
		System.out.println(msg);

	}

}
