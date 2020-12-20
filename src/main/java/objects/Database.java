package objects;

public interface Database {

    public Zone getZoneInfo(int id);
    public void postSharks(Requin sharks);
    public int getSharksCount();
    public Requin getSharks(int shark_id);
    public int getTunas();
}
