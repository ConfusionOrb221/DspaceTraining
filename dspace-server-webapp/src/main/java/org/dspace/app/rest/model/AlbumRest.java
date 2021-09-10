package org.dspace.app.rest.model;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.dspace.music.Album;

/**
 * This class serves as a REST representation for the {@link Album} class
 */
import org.dspace.app.rest.RestResourceController;
import org.dspace.scripts.Process;

public class AlbumRest extends BaseObjectRest<UUID> {

    public static final String CATEGORY = RestAddressableModel.MUSIC;
    public static final String NAME = "album";
    public static final String PLURAL_NAME = "albums";

    private UUID id;
    private String title;
    private String artist;
    private Date releaseDate;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String getCategory() {
        return CATEGORY;
    }

    @Override
    public Class getController() {
        return RestResourceController.class;
    }

    @Override
    public String getType() {
        return NAME;
    }

    @Override
    public String getTypePlural() {
        return super.getTypePlural();
    }
}
