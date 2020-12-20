package objects;

import java.util.ArrayList;
import java.util.List;

public class DatabaseImpl implements Database {

    static final int N = 3;
    static final int MAX_REQUINS = 5;
    static final int MAX_POISSON_PILOTES = 30;

    private Zone[][] ocean = new Zone[N][N];
    private List<Requin> requins = new ArrayList();
    private List<PoissonPilotes> poissonpilotes = new ArrayList();

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
    public void postSharks(Requin sharks) {
        int i = (int) Math.random() * N;
        int j= (int) Math.random() * N;
        sharks.setPositionI(i);
        sharks.setPositionJ(j);
        sharks.setId(Requin.NEXT_ID++);
        requins.add(sharks);

        ocean[i][j].setRequinPresent(sharks);
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
}
