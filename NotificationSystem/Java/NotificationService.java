class NotificationService {

    public void sendNotification(User user, String type, NotificationMessage message) {

        NotificationChannel channel = NotificationFactory.getChannel(type);

        channel.send(user, message);
    }
}