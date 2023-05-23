package Network;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private Boolean loggedIn;
    private List<User> friends = new ArrayList<>();
    private List<String> messages = new ArrayList<>();
    private Socket userSocket = new Socket();

    public User(String name) {
        this.name = name;
        this.loggedIn = false;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setUserSocket(Socket userSocket) {
        this.userSocket = userSocket;
    }

    public String getName() {
        return name;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public List<User> getFriends() {
        return friends;
    }

    public Socket getUserSocket() {
        return userSocket;
    }

    public List<String> getMessages() {
        return messages;
//        List<String> oldMessages = new ArrayList<>();
//        oldMessages.addAll(messages);
//        messages.clear();
//        return oldMessages;
    }
}
