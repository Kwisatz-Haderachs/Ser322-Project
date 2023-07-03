CREATE TABLE artist (
        artist_id INT NOT NULL PRIMARY KEY,
        artist_name VARCHAR(100)
);

CREATE TABLE song (
      song_id INT NOT NULL PRIMARY KEY,
      title VARCHAR(100),
      year_of_release INT,
      duration TIME
);

CREATE TABLE users (
       asurite VARCHAR(20) NOT NULL PRIMARY KEY,
       username VARCHAR(30)
);

CREATE TABLE album (
       album_id INT NOT NULL PRIMARY KEY,
       album_name VARCHAR(100),
       duration TIME,
       artist_id INT NOT NULL,
       FOREIGN KEY (artist_id) REFERENCES artist(artist_id)
);

CREATE TABLE genre (
    genre_id INT NOT NULL PRIMARY KEY,
    genre VARCHAR(25)
);

CREATE TABLE playlist (
      playlist_id INT NOT NULL PRIMARY KEY,
      creation_date DATE,
      title VARCHAR(100),
      asurite VARCHAR(20) NOT NULL,
      FOREIGN KEY (asurite) REFERENCES users(asurite)
);

CREATE TABLE song_genre (
        song_id INT,
        genre_id INT,
        FOREIGN KEY (song_id) REFERENCES song(song_id),
        FOREIGN KEY (genre_id) REFERENCES genre(genre_id)
);

CREATE TABLE artist_song (
         song_id INT,
         artist_id INT,
         FOREIGN KEY (song_id) REFERENCES song(song_id),
         FOREIGN KEY (artist_id) REFERENCES artist(artist_id)
);

CREATE TABLE album_song (
            song_id INT,
            album_id INT,
            FOREIGN KEY (song_id) REFERENCES song(song_id),
            FOREIGN KEY (album_id) REFERENCES album(album_id)
);

CREATE TABLE playlist_songs (
           playlist_id INT,
           song_id INT,
           FOREIGN KEY (playlist_id) REFERENCES playlist(playlist_id),
           FOREIGN KEY (song_id) REFERENCES song(song_id)
);

CREATE TABLE user_playlist (
        user_id varchar(20),
        playlist_id INT,
        FOREIGN KEY (user_id) REFERENCES users(asurite),
        FOREIGN KEY (playlist_id) REFERENCES playlist(playlist_id)
);