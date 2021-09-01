package org.dspace.app.rest;

import org.dspace.app.rest.model.AlbumRest;
import org.dspace.app.rest.model.hateoas.DSpaceResource;
import org.dspace.app.rest.model.hateoas.annotations.RelNameDSpaceResource;
import org.dspace.app.rest.utils.Utils;

@RelNameDSpaceResource(AlbumRest.NAME)
public class AlbumResource extends DSpaceResource<AlbumRest> {
    public AlbumResource(AlbumRest data, Utils utils) {
        super(data, utils);
    }
}
