//*******************************************************************
//  File that generates array of songs and serializes them based on input
//  Gayatri Rajan
//*******************************************************************
import java.io.*;
import java.util.*;
public class Test
{
	public static void main(String args[])
	{
		int songNumber=Input.getInt("How many songs are in your collection?");
		Song[] songArray=new Song[songNumber];//generates array of employees
		Date[] dateArray=new Date[songNumber];
		String title;
		String artist;
		int m;
		int d;
		int y;
		String filename=Input.getString("Please enter filename for saving");
		for(int i=0; i<songArray.length;i++)
		{
			title=Input.getString("Please enter song name for song "+(i+1));
			artist=Input.getString("Please enter artist name for song "+(i+1));
			m=Input.getInt("Please enter publish month for "+ title);
			d=Input.getInt("Please enter publish day for "+ title);
			y=Input.getInt("Please enter publish year for "+ title);
		  songArray[i] = new Song(title, artist, m, d, y);
			dateArray[i] = new Date(m, d, y);//songDate is transient, so we need one in this file for display
    }
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
			for(int j=0; j<songArray.length;j++)
			{
				out.writeObject(songArray[j]);
			}
			out.close();
			String filename2=Input.getString("Please enter filename for getting properties");//if they aren't the same, bad stuff
			ObjectInputStream in= new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename2)));
			for(int k=0; k<songArray.length; k++)
			{
				songArray[k]=(Song)in.readObject();
				display(songArray[k], dateArray[k]);
			}
			in.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void display(Song s, Date d)
	{
			System.out.println(s.getSongTitle()+"\t"+s.getSongArtist()+"\t"+d.getDate());
	}
}
