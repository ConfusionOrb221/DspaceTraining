package org.dspace.app.rest.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dspace.app.rest.model.AlbumRest;
import org.dspace.core.Context;
import org.dspace.music.Album;
import org.dspace.music.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component(AlbumRest.CATEGORY + "." + AlbumRest.NAME)
public class AlbumRestRepository extends DSpaceRestRepository<AlbumRest, UUID> {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private AlbumService albumService;

    @Override
    public AlbumRest findOne(Context context, UUID uuid) {
        try {
            Optional<Album> album = albumService.find(context, uuid);
            if (album.isEmpty()) {
                return null;
            }
            return converter.toRest(album, utils.obtainProjection());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Page<AlbumRest> findAll(Context context, Pageable pageable) {
        try {
            int total = albumService.countTotal(context);
            List<Album> albums = albumService.findAll(context);
            return converter.toRestPage(albums, pageable, total, utils.obtainProjection());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public Class<AlbumRest> getDomainClass() {
        return AlbumRest.class;
    }
}
