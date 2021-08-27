CREATE TABLE album
(
    id UUID NOT NULL,
    title VARCHAR(100) NOT NULL,
    artist VARCHAR(100) NOT NULL,
    release_date TIMESTAMP,
    item_id UUID REFERENCES item(uuid)
);

CREATE INDEX id_idx ON album(id);
CREATE INDEX title_idx ON album(title);
CREATE INDEX artist_idx ON album(artist);
CREATE INDEX release_date_idx ON album(release_date);