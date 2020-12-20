package org.inria.restlet.mta.resources;

import objects.Requin;
import objects.Zone;
import org.inria.restlet.mta.backend.Backend;
import org.json.JSONException;
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
    public JsonRepresentation getRequin() throws JSONException {

        String sharkId = (String) getRequest().getAttributes().get("shark_id");
        int requinId = Integer.valueOf(sharkId);
        requin = backend_.getDatabase().getSharks(requinId);



        JSONObject requinObject = new JSONObject();
        //userObject.put("CycloVieRequin", Requin.CycloVieRequin);
       // userObject.put("Status_Vie_Req", requin.getStatus_Vie_Req());
        if(requin != null){
            requinObject.put("requinsmort", requin.getId());
            requinObject.put("Poisson_requin", requin.getId());
            requinObject.put("positionI", requin.getPositionI());
            requinObject.put("positionJ", requin.getPositionJ());
        }



        return new JsonRepresentation(requinObject);
    }




}
