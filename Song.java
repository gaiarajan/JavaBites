//*******************************************************************
//  Song object class
//  Gayatri Rajan
//*******************************************************************
import java.io.Serializable;
public class Song implements Serializable
{
	public String songTitle;
	public String songArtist;
	public transient Date songDate;
  public Song(String title, String artist, int month, int day, int year)//Song constructor
  {
    setSongTitle(title);
		setSongArtist(artist);
    Date date=new Date(month, day, year);
    songDate = date;//defining hireDate
    setSongDate(month, day, year);
  }
  public String getSongTitle()
	{
	   return songTitle;
	}
  public void setSongTitle(String title)
  {
    songTitle=title;
  }
	public String getSongArtist()
	{
		 return songArtist;
	}
	public void setSongArtist(String artist)
	{
		songArtist=artist;
	}
  public String getSongDate()
  {
    return songDate.getDate();
  }
  public void setSongDate(int month, int day, int year)
  {
    songDate.setDate(month, day, year);
  }

}
