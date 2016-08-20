package com.jmartis.registration.service;

import com.jmartis.registration.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by magic on 8/20/2016.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final AtomicLong counter = new AtomicLong();
    private static List<User> users;

    static {
        users = dummyData();
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    private static List<User> dummyData() {
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(), "Beneficio", "Marte", "info@ben.com"));
        users.add(new User(counter.incrementAndGet(), "Mauricio", "Venezuela", "mauricio@minacion.com"));
        users.add(new User(counter.incrementAndGet(), "Alicia", "Brazil", "alicia@arbol.com"));
        return users;
    }

    public User findById(long id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User findByName(String name) {
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(long id) {

        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    public boolean isUserExist(User user) {
        return findByName(user.getUsername())!=null;
    }

    public void deleteAllUsers(){
        users.clear();
    }

}
