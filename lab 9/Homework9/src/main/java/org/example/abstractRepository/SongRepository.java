package org.example.abstractRepository;

import org.example.entity.Song;

public class SongRepository extends AbstractRepository<Song, Long> {
    public SongRepository() {
        super(Song.class);
    }
}

