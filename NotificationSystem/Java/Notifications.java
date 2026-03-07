interface NotificationChannel {

    void send(User user, NotificationMessage message);

}

class EmailNotification implements NotificationChannel {

    public void send(User user, NotificationMessage message) {
        System.out.println("Sending Email to " + user.email);
    }
}

class SMSNotification implements NotificationChannel {

    public void send(User user, NotificationMessage message) {
        System.out.println("Sending SMS to " + user.phone);
    }
}

class PushNotification implements NotificationChannel {

    public void send(User user, NotificationMessage message) {
        System.out.println("Sending Push Notification to " + user.deviceToken);
    }
}

class SlackNotification implements NotificationChannel {

    public void send(User user, NotificationMessage message) {
        System.out.println("Sending Slack Message to " + user.slackId);
    }
}