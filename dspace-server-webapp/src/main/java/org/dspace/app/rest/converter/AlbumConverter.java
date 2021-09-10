package org.dspace.app.rest.converter;

import org.dspace.app.rest.model.AlbumRest;
import org.dspace.app.rest.projection.Projection;
import org.dspace.music.Album;
import org.springframework.stereotype.Component;

@Component
public class AlbumConverter implements DSpaceConverter<Album, AlbumRest>{

    @Override
    public AlbumRest convert(Album modelObject, Projection projection) {
        AlbumRest albumRest = new AlbumRest();
        albumRest.setProjection(projection);
        albumRest.setId(modelObject.getId());
        albumRest.setArtist(modelObject.getArtist());
        albumRest.setTitle(modelObject.getTitle());
        albumRest.setReleaseDate(modelObject.getReleaseDate());
        return albumRest;
    }

    @Override
    public Class<Album> getModelClass() {
        return Album.class;
    }
}
