package org.dspace.music.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.dspace.core.Context;
import org.dspace.music.Album;

public interface AlbumService {

    public Album create(Context context, String title, String artist) throws SQLException;

    public Optional<Album> find(Context context, UUID id) throws SQLException;

    public int countTotal(Context context) throws SQLException;

    public List<Album> findAll(Context context) throws SQLException;

    public void delete(Context context, Album album) throws SQLException;

    public List<Album> findAllByArtist(Context context, String artist) throws SQLException;
}
