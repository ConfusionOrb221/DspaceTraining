package org.dspace.music.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.dspace.core.AbstractHibernateDAO;
import org.dspace.core.Context;
import org.dspace.music.Album;
import org.dspace.music.Album_;
import org.dspace.music.dao.AlbumDAO;

public class AlbumDAOImpl extends AbstractHibernateDAO<Album> implements AlbumDAO {

    @Override
    public int countRows(Context context) throws SQLException {
        CriteriaBuilder criteriaBuilder = getCriteriaBuilder(context);
        CriteriaQuery criteriaQuery = getCriteriaQuery(criteriaBuilder, Album.class);
        Root<Album> albumRoot = criteriaQuery.from(Album.class);
        criteriaQuery.select(albumRoot);

        return count(context, criteriaQuery, criteriaBuilder, albumRoot);
    }

    @Override
    public List<Album> findByArtist(Context context, String artist) throws SQLException {
        CriteriaBuilder criteriaBuilder = getCriteriaBuilder(context);
        CriteriaQuery criteriaQuery = getCriteriaQuery(criteriaBuilder, Album.class);
        Root<Album> albumRoot = criteriaQuery.from(Album.class);
        criteriaQuery.select(albumRoot);
        criteriaQuery.where(
                criteriaBuilder.equal(albumRoot.get(Album_.ARTIST), artist)
        );

        return list(context, criteriaQuery, false, Album.class, -1, -1);
    }
}
