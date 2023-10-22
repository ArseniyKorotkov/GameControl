package by.arsy.p4service;

import by.arsy.p2entity.User;
import by.arsy.p3dao.UserDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class UserService {

    private static final UserService SERVICE = new UserService();
    private final UserDao userDao = UserDao.getInstance();
    private final HashMap<Integer, User> CONNECT_USERS = new HashMap<>();

    private UserService() {
    }

    public Optional<User> getUser(String name, String pass) {
        return userDao.findUser(name, pass);
    }

    public void addUserToConnect(User user) {
        CONNECT_USERS.put(user.getId(), user);
    }

    public boolean haveName(String name) {
        return userDao.findName(name);
    }

    public HashMap<Integer ,User> getConnectUsers() {
        return CONNECT_USERS;
    }

    public Optional<String> isUserConnectById(int id) {
        Optional<String> name = Optional.empty();
        if(CONNECT_USERS.containsKey(id)) {
            name = Optional.of(CONNECT_USERS.get(id).getName());
        }
        return name;
    }

    public void saveUser(String name, String password, boolean master) {
        userDao.registration(name, password, master);
    }

    public void changePass(String name, int hashNewPass) {
        userDao.changePass(name, hashNewPass);
    }

    public ArrayList<String> findNamesCanDeleteUsers(String userName) {
        return userDao.findNamesCanDeleteUsers(userName);
    }

    public void deleteUserByName(String name) {
        CONNECT_USERS.remove(getIdByName(name));
        userDao.deleteUserByName(name);
    }

    public void logoutUser(User user) {
        if(user != null) {
            CONNECT_USERS.remove(user.getId());
        }
    }

    public int getIdByName(String name) {
        return userDao.getIdByName(name);
    }

    public static UserService getInstance() {
        return SERVICE;
    }


}
