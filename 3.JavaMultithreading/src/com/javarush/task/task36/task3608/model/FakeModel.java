package com.javarush.task.task36.task3608.model;
import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Created by alexey.valiev on 10/23/18.
 */
public class FakeModel implements Model {

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("A",1,1));
        list.add(new User("B",2,1));
        modelData.setUsers(list);
    }

    public void setModelData(ModelData modelData) {
        this.modelData = modelData;
    }

    @Override
    public void loadDeletedUsers(){
        throw new UnsupportedOperationException();
    }

    @Override
    public void displayDeletedUserList() {}

    @Override
    public void loadUserById(long UserId) { throw new UnsupportedOperationException();}

    @Override
    public void deleteUserById(long id) { throw new UnsupportedOperationException();}

    @Override
    public void changeUserData(String name, long id, int level) { throw new UnsupportedOperationException(); }
}
