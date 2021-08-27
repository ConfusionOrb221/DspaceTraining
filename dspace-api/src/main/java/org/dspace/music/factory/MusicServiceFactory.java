package org.dspace.music.factory;

import org.dspace.music.service.AlbumService;
import org.dspace.services.factory.DSpaceServicesFactory;

public abstract class MusicServiceFactory {

    /**
     * This method will return an instance of the ScriptService
     * @return An instance of the ScriptService
     */
    public abstract AlbumService getScriptService();

    /**
     * Use this method to retrieve an implementation of the ScriptServiceFactory to use to retrieve the different beans
     * @return An implementation of the ScriptServiceFactory
     */
    public static MusicServiceFactory getInstance() {
        return DSpaceServicesFactory.getInstance().getServiceManager()
                .getServiceByName("musicServiceFactory", MusicServiceFactory.class);
    }
}
