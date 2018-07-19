package fasttrackse.team1.qlthuviendientu.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fasttrackse.team1.qlthuviendientu.entyti.Admin;

public class SerializeFileFactory {
	public static boolean luuFile(ArrayList<Admin>user,String path)
	{
		try
		{
			FileOutputStream fos=new FileOutputStream(path);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(user);
			oos.close();
			fos.close();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	public static ArrayList<Admin>docFile(String path)
	{
		ArrayList<Admin>admin=new ArrayList<Admin>();
		try
		{
			FileInputStream fis=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object data=ois.readObject();
			admin=(ArrayList<Admin>) data;
			ois.close();
			fis.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return admin;
	}
}
