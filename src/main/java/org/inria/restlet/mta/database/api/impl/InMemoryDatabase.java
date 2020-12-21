package org.inria.restlet.mta.database.api.impl;

import java.util.*;

import objects.PoissonPilotes;
import objects.Requin;
import objects.Zone;
import org.inria.restlet.mta.database.api.Database;
import org.inria.restlet.mta.internals.User;

/**
 *
 * In-memory database 
 *
 * @author Awa Diaby
 * @author KArla Rosas
 *
 */
public class InMemoryDatabase implements Database
{

    static final int N = 3;
    static final int MAX_REQUINS = 5;
    static final int MAX_POISSON_PILOTES = 30;

    private Zone[][] ocean = new Zone[N][N];
    private List<Requin> requins = new ArrayList();
    private List<PoissonPilotes> poissonpilotes = new ArrayList();
    /** User count (next id to give).* /
    private int userCount_;*/

    /** User Hashmap. */
   // Map<Integer, User> users_;


    public InMemoryDatabase()
    {
        ocean = new Zone[N][N];
    }

    /*@Override
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
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(ocean[i][j].getId() == id) {
                    return  ocean[i][j];
                }
            }
        }
        return null;
    }

    @Override
    public Requin postSharks(Requin sharks) {
        int i = (int) (Math.random() * N);
        int j= (int) (Math.random() * N);

        while(ocean[i][j]!=null){
            i = (int) (Math.random() * N);
            j= (int) (Math.random() * N);
        }
        sharks.setPositionI(i);
        sharks.setPositionJ(j);
        sharks.setId(Requin.NEXT_ID++);
        requins.add(sharks);

        Zone zone = new Zone(i,j);
        zone.setRequinPresent(sharks);
        ocean[i][j] = zone;
        return sharks;
    }

    @Override
    public int getSharksCount() {
        return requins.size();
    }

    @Override
    public Requin getSharks(int shark_id) {
        for(Requin requin: this.requins){
            if(requin.getId() == shark_id){
                return requin;
            }
        }
        return null;
    }

    @Override
    public int getTunas() {
        int countSardine = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                countSardine+= ocean[i][j].getNb_sardines_();
            }
        }
        return countSardine;
    }

    @Override
    public List<Requin> getSharks() {
        return this.requins;
    }

}
