package com.javarush.task.task36.task3608.model;

/**
 * Created by alexey.valiev on 10/23/18.
 */
public interface Model {

    void loadDeletedUsers();
    ModelData getModelData();
    void loadUsers();
    void displayDeletedUserList();
    void loadUserById(long UserId);
    void deleteUserById(long id);
    void changeUserData(String name, long id, int level);
}
