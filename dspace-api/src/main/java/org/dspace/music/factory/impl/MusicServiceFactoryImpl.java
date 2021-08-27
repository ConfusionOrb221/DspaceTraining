package org.dspace.music.factory.impl;

import org.dspace.music.factory.MusicServiceFactory;
import org.dspace.music.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

public class MusicServiceFactoryImpl extends MusicServiceFactory {

    @Autowired(required = true)
    private AlbumService albumService;


    @Override
    public AlbumService getScriptService() {
        return albumService;
    }
}
