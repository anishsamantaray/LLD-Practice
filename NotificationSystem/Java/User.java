class User {

    String userId;
    String email;
    String phone;
    String deviceToken;
    String slackId;

    public User(String userId, String email, String phone, String deviceToken, String slackId) {
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.deviceToken = deviceToken;
        this.slackId = slackId;
    }
}

