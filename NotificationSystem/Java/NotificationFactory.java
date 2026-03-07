class NotificationFactory {

    public static NotificationChannel getChannel(String type) {

        switch(type) {

            case "EMAIL":
                return new EmailNotification();

            case "WHATSAPP":
                return new WhatsappNotification();

            case "SLACK":
                return new SlackNotification();

            case "PUSH":
                return new PushNotification();

            default:
                throw new IllegalArgumentException("Invalid notification type");
        }
    }
}