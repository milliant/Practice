/**
 * 
 */
package jftp;

import net.sf.jftp.net.BasicConnection;
import net.sf.jftp.net.ConnectionListener;
import net.sf.jftp.net.wrappers.NfsConnection;

/**
 * @author milliant
 *
 */
public class NfsTry implements ConnectionListener{

	
	 private boolean isThere = false;

	 public static long time = 0;
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public 	NfsTry(String url){
		
		NfsConnection nfs = new NfsConnection(url);
		nfs.addConnectionListener(this);
		nfs.login("username","password");
		while(!isThere)
		{
			try { Thread.sleep(10); }
			catch(Exception ex) { ex.printStackTrace(); }
		}
		nfs.chdir("pub/linux/kernel");//

		
	}
	
	
	
	

	@Override
	public void updateRemoteDirectory(BasicConnection con) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProgress(String file, String type, long bytes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionInitialized(BasicConnection con) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionFailed(BasicConnection con, String why) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionFinished(BasicConnection con) {
		// TODO Auto-generated method stub
		
	}

}
