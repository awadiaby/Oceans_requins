package org.inria.restlet.mta.database.api.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.Requin;
import objects.Zone;
import org.inria.restlet.mta.database.api.Database;
import org.inria.restlet.mta.internals.User;

/**
 *
 * In-memory database 
 *
 * @author ctedeschi
 * @author msimonin
 *
 */
public class InMemoryDatabase implements Database
{

    /** User count (next id to give).*/
    private int userCount_;

    /** User Hashmap. */
   // Map<Integer, User> users_;


  //  public InMemoryDatabase()
    {
      //  users_ = new HashMap<Integer, User>();
    }

    @Override
    public User createUser(String name, int age) {
        return null;
    }

    @Override
    public Collection<User> getUsers() {
        return null;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    /**
     *
     * Synchronized user creation.

     * @return the user created
     */
//    @Override
//    public synchronized User createUser(String name, int age)
//    {
//        User user = new User(name, age);
//        user.setId(userCount_);
//        users_.put(userCount_, user);
//        userCount_ ++;
//        return user;
//    }

    @Override
    public Zone getZoneInfo(int id) {
        return null;
    }

    @Override
    public void postSharks(Requin sharks) {

    }

    @Override
    public int getSharksCount() {
        return 0;
    }

    @Override
    public Requin getSharks(int shark_id) {
        return null;
    }

    @Override
    public int getTunas() {
        return 0;
    }

}
