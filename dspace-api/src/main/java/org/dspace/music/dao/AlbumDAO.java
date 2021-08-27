package org.dspace.music.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.dspace.core.AbstractHibernateDAO;
import org.dspace.core.Context;
import org.dspace.core.GenericDAO;
import org.dspace.music.Album;

public interface AlbumDAO extends GenericDAO<Album> {

    public int countRows(Context context) throws SQLException;

    public List<Album> findByArtist(Context context, String artist) throws SQLException;

}
