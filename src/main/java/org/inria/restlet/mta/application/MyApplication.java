package org.inria.restlet.mta.application;


import org.inria.restlet.mta.resources.RequinResource;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 *
 * Application.
 *
 * @author msimonin
 *
 */
public class MyApplication extends Application
{

    public MyApplication(Context context)
    {
        super(context);
    }

    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        router.attach("/sharks/{shark_id}", RequinResource.class);
        return router;
    }
}
