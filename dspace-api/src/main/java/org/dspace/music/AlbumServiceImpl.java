package org.dspace.music;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.dspace.core.Context;
import org.dspace.music.dao.AlbumDAO;
import org.dspace.music.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDAO albumDAO;

    @Override
    public Album create(Context context, String title, String artist) throws SQLException {
        Album album = new Album();
        album.setArtist(artist);
        album.setTitle(title);
        return albumDAO.create(context, album);
    }

    @Override
    public Optional<Album> find(Context context, UUID id) throws SQLException {
        return Optional.of(albumDAO.findByID(context, Album.class, id));
    }

    @Override
    public int countTotal(Context context) throws SQLException {
        return albumDAO.countRows(context);
    }

    @Override
    public List<Album> findAll(Context context) throws SQLException {
        return albumDAO.findAll(context, Album.class);
    }

    @Override
    public void delete(Context context, Album album) throws SQLException {
        albumDAO.delete(context, album);
    }

    @Override
    public List<Album> findAllByArtist(Context context, String artist) throws SQLException {
        return albumDAO.findByArtist(context, artist);
    }
}
