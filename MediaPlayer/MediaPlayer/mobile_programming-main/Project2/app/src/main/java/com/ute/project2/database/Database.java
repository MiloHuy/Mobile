package com.ute.project2.database;

import com.ute.project2.R;
import com.ute.project2.model.Artist;
import com.ute.project2.model.Category;
import com.ute.project2.model.Song;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Song> getSongListDownload() {
        List<Song> songListDownload = new ArrayList<>();
        songListDownload.add(new Song("Neil", R.drawable.song, R.raw.file_example, 90000, "Dax", "Skyler"));
        songListDownload.add(new Song("Remi", R.drawable.song, R.raw.file_example, 90000, "Dax", "Dennis"));
        songListDownload.add(new Song("Liam", R.drawable.song, R.raw.file_example, 90000, "Dax", "Nixon"));
        return songListDownload;
    }

    public static List<Song> getSongList() {
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("Neil", R.drawable.song, R.raw.file_example, 90000, "Ballab Buồn", "Skyler"));
        songList.add(new Song("Salem", R.drawable.song, R.raw.file_example, 90000, "Ballab Buồn", "Mohammed"));
        songList.add(new Song("Remi", R.drawable.song, R.raw.file_example, 90000, "Ballab Buồn", "Dennis"));
        songList.add(new Song("Liam", R.drawable.song, R.raw.file_example, 90000, "US-UK", "Nixon"));
        songList.add(new Song("Noah", R.drawable.song, R.raw.file_example, 90000, "US-UK", "Rex"));
        songList.add(new Song("Oliver", R.drawable.song, R.raw.file_example, 90000, "US-UK", "Uriah"));
        songList.add(new Song("Elijah", R.drawable.song, R.raw.file_example, 90000, "US-UK", "Lee"));
        songList.add(new Song("James", R.drawable.song, R.raw.file_example, 90000, "Hiphop", "Louie"));
        songList.add(new Song("William", R.drawable.song, R.raw.file_example, 90000, "Hiphop", "Alberto"));
        songList.add(new Song("Benjamin", R.drawable.song, R.raw.file_example, 90000, "Hiphop", "Reese"));
        songList.add(new Song("Lucas", R.drawable.song, R.raw.file_example, 90000, "Hiphop", "Quinton"));
        songList.add(new Song("Henry", R.drawable.song, R.raw.file_example, 90000, "EDM", "Kingsley"));
        songList.add(new Song("Theodore", R.drawable.song, R.raw.file_example, 90000, "EDM", "Chaim"));
        songList.add(new Song("Jack", R.drawable.song, R.raw.file_example, 90000, "EDM", "Alfredo"));
        songList.add(new Song("Levi", R.drawable.song, R.raw.file_example, 90000, "EDM", "Mauricio"));
        songList.add(new Song("Alexander", R.drawable.song, R.raw.file_example, 90000, "EDM", "Caspian"));
        songList.add(new Song("Jackson", R.drawable.song, R.raw.file_example, 90000, "EDM", "Legacy"));
        songList.add(new Song("Mateo", R.drawable.song, R.raw.file_example, 90000, "V-POP", "Ocean"));
        songList.add(new Song("Daniel", R.drawable.song, R.raw.file_example, 90000, "V-POP", "Ozzy"));
        songList.add(new Song("Michael", R.drawable.song, R.raw.file_example, 90000, "V-POP", "Briar"));
        songList.add(new Song("Mason", R.drawable.song, R.raw.file_example, 90000, "V-POP", "Wilson"));
        songList.add(new Song("Sebastian", R.drawable.song, R.raw.file_example, 90000, "V-POP", "Forest"));
        songList.add(new Song("Ethan", R.drawable.song, R.raw.file_example, 90000, "V-POP", "Grey"));
        return songList;
    }


    public static List<Category> getCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Cách Mạng", R.drawable.cachmang));
        categoryList.add(new Category("Ballab Buồn", R.drawable.ballad));
        categoryList.add(new Category("Jazz", R.drawable.jazz));
        categoryList.add(new Category("Lofi & Chill", R.drawable.lofi));
        categoryList.add(new Category("US-UK", R.drawable.usuk));
        categoryList.add(new Category("V-POP", R.drawable.vpop));
        categoryList.add(new Category("Hiphop", R.drawable.rap));
        categoryList.add(new Category("K-POP", R.drawable.kpop));
        categoryList.add(new Category("EDM", R.drawable.edm));
        categoryList.add(new Category("Thiếu Nhi", R.drawable.thieunhi));
        categoryList.add(new Category("Cách Mạng", R.drawable.cachmang));
        categoryList.add(new Category("Ballab Buồn", R.drawable.ballad));
        categoryList.add(new Category("Jazz", R.drawable.jazz));
        categoryList.add(new Category("Lofi & Chill", R.drawable.lofi));
        categoryList.add(new Category("US-UK", R.drawable.usuk));
        categoryList.add(new Category("V-POP", R.drawable.vpop));
        categoryList.add(new Category("Hiphop", R.drawable.rap));
        categoryList.add(new Category("K-POP", R.drawable.kpop));
        categoryList.add(new Category("EDM", R.drawable.edm));
        return categoryList;
    }


    public static List<Artist> getArtistList() {
        List<Artist> artistList = new ArrayList<>();
        artistList.add(new Artist("Leonardo", R.drawable.artist));
        artistList.add(new Artist("Jose", R.drawable.artist));
        artistList.add(new Artist("Bennett", R.drawable.artist));
        artistList.add(new Artist("Silas", R.drawable.artist));
        artistList.add(new Artist("Nicholas", R.drawable.artist));
        artistList.add(new Artist("Parker", R.drawable.artist));
        artistList.add(new Artist("Beau", R.drawable.artist));
        artistList.add(new Artist("Weston", R.drawable.artist));
        artistList.add(new Artist("Austin", R.drawable.artist));
        artistList.add(new Artist("Connor", R.drawable.artist));
        artistList.add(new Artist("Carson", R.drawable.artist));
        artistList.add(new Artist("Dominic", R.drawable.artist));
        artistList.add(new Artist("Xavier", R.drawable.artist));
        artistList.add(new Artist("Emmett", R.drawable.artist));
        artistList.add(new Artist("Jace", R.drawable.artist));
        artistList.add(new Artist("Declan", R.drawable.artist));
        artistList.add(new Artist("Rowan", R.drawable.artist));
        artistList.add(new Artist("Micah", R.drawable.artist));
        artistList.add(new Artist("Lorenzo", R.drawable.artist));
        artistList.add(new Artist("Cole", R.drawable.artist));
        artistList.add(new Artist("George", R.drawable.artist));
        artistList.add(new Artist("Luis", R.drawable.artist));
        artistList.add(new Artist("Archer", R.drawable.artist));
        artistList.add(new Artist("Enzo", R.drawable.artist));
        artistList.add(new Artist("Jonah", R.drawable.artist));
        artistList.add(new Artist("Ayden", R.drawable.artist));
        artistList.add(new Artist("Theo", R.drawable.artist));
        artistList.add(new Artist("Zachary", R.drawable.artist));
        artistList.add(new Artist("Calvin", R.drawable.artist));
        artistList.add(new Artist("Braxton", R.drawable.artist));
        artistList.add(new Artist("Atlas", R.drawable.artist));
        artistList.add(new Artist("Rhett", R.drawable.artist));
        artistList.add(new Artist("Jude", R.drawable.artist));
        artistList.add(new Artist("Bentley", R.drawable.artist));
        artistList.add(new Artist("Carlos", R.drawable.artist));
        return artistList;
    }
}
