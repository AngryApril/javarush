package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import java.util.*;


/**
 * Created by alexey.valiev on 10/23/18.
 */
public class ModelData {
    private User activeUser;
    private List<User> users;
    private boolean displayDeletedUserList;

    public User getActiveUser() { return activeUser; }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean isDisplayDeletedUserList() { return displayDeletedUserList; }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }
}
