package com.dlka.watcheverremote;

import java.util.List;

import android.app.ProgressDialog;
import android.util.Log;



public class XBMCClient {
//    private JSONRPC2Session mySession;
	Process proc;
	private static Shell.Interactive rootSession;

    public XBMCClient(String format, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public void sendLeft() {
        sendCmd("Input.Left");
    }
    
    public void sendRight() {
        sendCmd("Input.Right");
    }
    
    public void sendUp() {
        sendCmd("Input.Up");
    }
    
    public void sendDown() {
        sendCmd("Input.Down");
    }
    
    public void sendBack() {
        sendCmd("Input.Back");
    }
    
//    public void askInfo() {
//        sendCmd("Input.Info", null);
//    }
    
    public void sendSelect() {
        sendCmd("Input.Select");
    }
        
    public void play() {
    	sendCmd("play");
    }
    
    public void showWatch() {
    	sendCmd("showwatchapp");
    }
    
    public void showMovies() {
    	sendCmd("playmovies");
    }
    
//    public void showBack() {
//    	sendCmd("backkey");
//    }
    
    
//    private void inputAction(String action) {
//        Map<String,Object> params = new HashMap<String,Object>();
//        params.put("action", action);
//        sendCmd("Input.ExecuteAction", params);
//    }
//
//    
//    private void activateWindow(String name, String option) {
//        Map<String,Object> params = new HashMap<String,Object>();
//        params.put("window", name);
//        String[] options = new String[1];
//        options[0] = option;
//        params.put("parameters", options);
//        sendCmd("GUI.ActivateWindow", params);
//    }

    public void playPause() {
    	sendCmd("Player.PlayPause");
    }
    
    public void stop() {
    	sendCmd("Player.Stop");
    }
    
    public void decreaseVolume() {
    	sendCmd("volumedown");
    }
    
    public void increaseVolume() {
    	sendCmd("volumeup");
    }
    
    public void mute() {
    	sendCmd("mute");
    }


    
//    private void sendToPlayer(String cmd) {
//        Map<String,Object> params = new HashMap<String,Object>();
//        params.put("playerid", Integer.valueOf(1));
//        sendCmd(cmd, params);
//    }
    
//    class SendCMD extends AsyncTask<JSONRPC2Request, Void, Void> {
//        protected Void doInBackground(JSONRPC2Request... reqs) {
//            try {
//                mySession.send(reqs[0]);
//            } catch (JSONRPC2SessionException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }
//
//    
    private void sendCmd(String cmd) {
//        JSONRPC2Request req = new JSONRPC2Request(cmd, params, 1);
//        new SendCMD().execute(req);
    	Log.d(MyExtensionService.LOG_TAG, cmd);
//    	if (cmd == null) {
//      return;
//      Log.e(MyExtensionService.LOG_TAG, "emptycommand");
//  }
    String cmd2="";

    	if(cmd.equalsIgnoreCase("Input.Left")) 
    		cmd2="keyevent 21";
    	else if(cmd.equalsIgnoreCase("Input.Right"))
    		cmd2="keyevent 22";
    	else if(cmd.equalsIgnoreCase("Input.Up"))
    		cmd2="keyevent 19";
    	else if(cmd.equalsIgnoreCase("Input.Down"))
    		cmd2="keyevent 20";
    	else if(cmd.equalsIgnoreCase("Input.Back"))
    		cmd2="keyevent 4";
    	else if(cmd.equalsIgnoreCase("Input.Select"))
    		cmd2="keyevent 66";//enterkey
    	else if(cmd=="play")
    		cmd2="tap 300 400"; //one tap for play
    	else if(cmd=="showwatchapp");
    		//TODO Start Watchapp
    	
    	else if(cmd=="playmovies");
    		//TODO Start Playmovies
    	else if(cmd=="Player.PlayPause"){
    		//cmd2="keyevent 85";
    		runCmd(cmd2="tap 300 400"); //one tap for info //one tap for pause
    		cmd2="tap 300 400";}
    	else if(cmd=="Player.Stop")
    		cmd2="keyevent 86";
    	else if(cmd=="volumedown")
    		cmd2="keyevent 25"; 
    	else if(cmd=="volumeup")
    		cmd2="keyevent 24";
    	else if(cmd=="mute")
    		cmd2="keyevent 91";
    	else if(cmd=="powerkey")
			cmd2="keyevent 26";
    	else if(cmd=="powerkey.hold")
		cmd2="keyevent --longpress 26";
    	else
    	Log.d(MyExtensionService.LOG_TAG, "cmd "+cmd+" not accepted");
    	
    	runCmd(cmd2);
    	
    }

	private void runCmd(String cmd2){
    	Log.d(MyExtensionService.LOG_TAG, "runcmd");
    	try
    
    {
    	Log.d(MyExtensionService.LOG_TAG, "try");
  
    	//Runtime rt = Runtime.getRuntime();
    	//proc = rt.exec("su"); Log.d(MyExtensionService.LOG_TAG, "access root");
        String cmd3="su -c /system/bin/input "+cmd2+"\n";
        String cmd3a="/system/bin/input "+cmd2;
        //Log.d(MyExtensionService.LOG_TAG, cmd3);
        
        //proc = rt.exec(cmd3);
        openRootShell(cmd3a);
        //rootSession.addCommand(cmd3a);
                
        
       //private boolean suAvailable = false;
       //suAvailable = Shell.SU.available();
       //if (suAvailable) {
       //    suVersion = Shell.SU.version(false);
       //    suVersionInternal = Shell.SU.version(true);
       //    suResult = 
       //Shell.SU.run(cmd3);
       //}

       
       //DataOutputStream os = new DataOutputStream(proc.getOutputStream());
        //os.writeBytes(cmd3);
        //os.flush();
        
        // os.writeBytes("exit\n");
        //os.flush();
       
        
        //Shell.setShell("sh");
       //Shell.runCommand(cmd3);
       Log.d(MyExtensionService.LOG_TAG, "create process");
        
        //testing purposes
//        InputStream is = proc.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);
//        String line;
//while ((line = br.readLine()) != null) {
//     	Log.d(MyExtensionService.LOG_TAG, "return of command"+line);
     	//end testing
//}
       } catch (Throwable t)
      {
        t.printStackTrace();
      }
}

private void openRootShell(String cmd3) {
	 if (rootSession != null) {
		 Log.d(MyExtensionService.LOG_TAG, "if");   
		 rootSession.addCommand(cmd3);
		    }
	 else{
		 Log.d(MyExtensionService.LOG_TAG,"else");
        // start the shell in the background and keep it alive as long as the app is running
        rootSession = new Shell.Builder().
                useSU().
                setWantSTDERR(false).
                setWatchdogTimeout(5).
                setMinimalLogging(true).
                open();
    }
}
}