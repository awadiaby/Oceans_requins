package org.inria.restlet.mta.resources;

import objects.Requin;
import objects.Zone;
import org.inria.restlet.mta.backend.Backend;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class RequinResource extends ServerResource {

    private Backend backend_;
    private Requin requin;

    public RequinResource()
    {
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
    }

    @Get("json")
    public JsonRepresentation getRequin(){

        String sharkId = (String) getRequest().getAttributes().get("sharkd");
        int requinId = Integer.valueOf(sharkId);
        requin = backend_.getDatabase().getSharks(requinId);



        JSONObject userObject = new JSONObject();
        //userObject.put("CycloVieRequin", Requin.CycloVieRequin);
       // userObject.put("Status_Vie_Req", requin.getStatus_Vie_Req());
       /* userObject.put("requinsmort", requin.getId());
        userObject.put("Poisson_requin", requin.getId());
        userObject.put("positionI", requin.getPositionI());
        userObject.put("positionJ", requin.getPositionJ());
        */


        return new JsonRepresentation(true);
    }




}
