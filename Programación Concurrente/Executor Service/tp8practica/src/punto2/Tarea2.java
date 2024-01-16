package punto2;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Tarea2 implements Runnable{

	@Override
	public void run() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));	
	}
}