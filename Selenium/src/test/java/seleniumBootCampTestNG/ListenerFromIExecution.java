package seleniumBootCampTestNG;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.IExecutionListener;

public class ListenerFromIExecution implements IExecutionListener {

	private long time;
	@Override
	public void onExecutionStart() {
		time = System.currentTimeMillis();
		String ds = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println(ds);
	}

	@Override
	public void onExecutionFinish() {
		System.out.println(System.currentTimeMillis()-time);
	}
	
}