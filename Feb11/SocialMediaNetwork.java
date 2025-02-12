import java.util.ArrayList;
import java.util.List;

class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendsHead;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendsHead = null;
        this.next = null;
    }
}

class SocialMediaNetwork {
    UserNode head;

    public SocialMediaNetwork() {
        this.head = null;
    }

    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public UserNode findUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            addFriendToList(user1, userId2);
            addFriendToList(user2, userId1);
            System.out.println("Friendship added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("User not found!");
        }
    }

    private void addFriendToList(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        if (user.friendsHead == null) {
            user.friendsHead = newFriend;
        } else {
            FriendNode temp = user.friendsHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newFriend;
        }
    }

    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            removeFriendFromList(user1, userId2);
            removeFriendFromList(user2, userId1);
            System.out.println("Friendship removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("User not found!");
        }
    }

    private void removeFriendFromList(UserNode user, int friendId) {
        if (user.friendsHead == null) return;

        if (user.friendsHead.friendId == friendId) {
            user.friendsHead = user.friendsHead.next;
            return;
        }

        FriendNode temp = user.friendsHead;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public List<Integer> findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        List<Integer> mutualFriends = new ArrayList<>();
        if (user1 != null && user2 != null) {
            FriendNode friends1 = user1.friendsHead;
            while (friends1 != null) {
                FriendNode friends2 = user2.friendsHead;
                while (friends2 != null) {
                    if (friends1.friendId == friends2.friendId) {
                        mutualFriends.add(friends1.friendId);
                        break;
                    }
                    friends2 = friends2.next;
                }
                friends1 = friends1.next;
            }
        }
        return mutualFriends;
    }

    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user != null) {
            FriendNode friends = user.friendsHead;
            System.out.println(user.name + "'s friends:");
            while (friends != null) {
                UserNode friendUser = findUserById(friends.friendId);
                System.out.println(friendUser.name);
                friends = friends.next;
            }
        } else {
            System.out.println("User not found!");
        }
    }

    public void countFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user != null) {
            int count = 0;
            FriendNode friends = user.friendsHead;
            while (friends != null) {
                count++;
                friends = friends.next;
            }
            System.out.println(user.name + " has " + count + " friends.");
        } else {
            System.out.println("User not found!");
        }
    }

    public static void main(String[] args) {
        SocialMediaNetwork network = new SocialMediaNetwork();

        network.addUser(1, "Alice", 25);
        network.addUser(2, "Bob", 30);
        network.addUser(3, "Charlie", 22);
        network.addUser(4, "David", 27);

        network.addFriend(1, 2);
        network.addFriend(1, 3);
        network.addFriend(2, 4);
        network.addFriend(3, 4);

        network.displayFriends(1);
        network.displayFriends(2);

        List<Integer> mutualFriends = network.findMutualFriends(1, 4);
        System.out.println("Mutual Friends between Alice and David: " + mutualFriends);

        network.removeFriend(1, 2);
        network.displayFriends(1);

        network.countFriends(1);
    }
}
