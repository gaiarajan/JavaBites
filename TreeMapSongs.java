//**************************************************************************//
//  File that generates array of songs, serializes them, and performs user actions
//  Gayatri Rajan
//**************************************************************************//
import java.io.*;
import java.util.*;
public class TreeMapSongs
{
  public static void main(String [] args)
  {
    int quit=0;
    TreeMap<String, Song> songs=new TreeMap<String, Song>();
    ArrayList<Song> songArray = new ArrayList<Song>();
    ArrayList<String> dateArray = new ArrayList<String>();
    songArray.add(new Song("Mean", "Taylor Swift", 1, 2, 2008));
    songArray.add(new Song("In the Middle", "Hailee Steinfeld", 2, 3, 2012));
    songArray.add(new Song("This is Me", "Hugh Jackman", 3, 12, 2017));
    for(int i=0; i<songArray.size();i++){
      dateArray.add(songArray.get(i).getSongDate());
      songs.put(songArray.get(i).getSongTitle(), songArray.get(i));
    }
    int i=songArray.size();
    while(quit==0){
      try
      {
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("SaveObjects.dat")));
        out.writeObject(songArray);
        out.close();
        ObjectInputStream in= new ObjectInputStream(new BufferedInputStream(new FileInputStream("SaveObjects.dat")));
        songArray = (ArrayList<Song>) in.readObject();
        in.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
      int userAction=Input.getInt("Do you want to (1) display all songs; (2) remove a song; or (3) add a song?");
      if(userAction==1){
        System.out.println();
        for(Map.Entry<String, Song> song: songs.entrySet())
        {
          Song s=songs.get(song.getKey());
          System.out.println(s.getSongTitle()+" : "+s.getSongArtist()+" : "+s.getSongDate());
        }
        System.out.println();
      }
      if(userAction==2){
        String removeTitle=Input.getString("Please enter the title of the song you would like to remove.");
        int removeIndex=Input.getInt("Please enter the number of the song you would like to remove.");
        System.out.println("You have removed "+removeTitle+", by "+songs.get(removeTitle).getSongArtist());
        songs.remove(removeTitle);
        songArray.remove(removeIndex - 1);
        i--;
        System.out.println();
        System.out.println();
      }
      if(userAction==3){
        String title=Input.getString("Please enter song name for song "+(i+1));
  			String artist=Input.getString("Please enter artist name for song "+(i+1));
  			int m=Input.getInt("Please enter publish month for "+ title);
  			int d=Input.getInt("Please enter publish day for "+ title);
  			int y=Input.getInt("Please enter publish year for "+ title);
  		  songArray.add(new Song(title, artist, m, d, y));
        songs.put(songArray.get(i).getSongTitle(), songArray.get(i));
        i++;
        System.out.println();
        System.out.println("You have added a song.");
        System.out.println();
      }
      quit=Input.getInt("Type 1 if you would like to quit. Type 0 if you would like to complete another action.");
    }
  }
}
