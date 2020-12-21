package org.inria.restlet.mta.resources;

import objects.Oceans;
import objects.Requin;
import org.inria.restlet.mta.backend.Backend;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.util.List;

public class RequinsResource extends ServerResource {

    private Backend backend_;
    private Requin requin;

    public RequinsResource()
    {
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
    }

    @Get("json")
    public JsonRepresentation getRequin() throws JSONException {

       int requinsCount = backend_.getDatabase().getSharks().size();
        JSONObject requinObject = new JSONObject();
        requinObject.put("count", requinsCount);
        return new JsonRepresentation(requinObject);
    }

    @Post("json")
    public Representation createRequin() throws JSONException {
        Requin requin = new Requin(Oceans.ocean);
        requin = backend_.getDatabase().postSharks(requin);

        JSONObject requinObject = new JSONObject();
        //userObject.put("CycloVieRequin", Requin.CycloVieRequin);
        // userObject.put("Status_Vie_Req", requin.getStatus_Vie_Req());
        if(requin != null){
            requinObject.put("Poisson_requin", requin.getId());
            requinObject.put("positionI", requin.getPositionI());
            requinObject.put("positionJ", requin.getPositionJ());
            requinObject.put("id", requin.getId());
        }
        return new JsonRepresentation(requinObject);

    }






}
