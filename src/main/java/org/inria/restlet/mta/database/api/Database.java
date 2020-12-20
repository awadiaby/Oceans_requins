package org.inria.restlet.mta.database.api;

import java.util.Collection;
import java.util.List;

import objects.Requin;
import objects.Zone;
import org.inria.restlet.mta.internals.User;

/**
 *
 * Interface to the database.
 *
 * @author msimonin
 *
 */
public interface Database
{

    /**
     *
     * Create a new user in the database.
     *
     * @param name      The name of the user
     * @param age       The age of the user
     * @return  the new user.
     */
    //User createUser(String name, int age);


    /**
     *
     * Returns the list of users.
     *
     * @return the list of users
     */
    //Collection<User> getUsers();


    /**
     *  Returns the user with a given id.
     *
     *  @return the user
     */
    //User getUser(int id);




    public Zone getZoneInfo(int id);
    public void postSharks(Requin sharks);
    public int getSharksCount();
    public Requin getSharks(int shark_id);
    public int getTunas();

}
