package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.InitSystem;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.InitSystem.ModeSystem.NormalMode;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.InitSystem.ModeSystem.iSystemMode;

public class Setup {

	private iSystemMode modeSystem = new NormalMode();
	
	public void changeMode(iSystemMode systemMode){
		modeSystem = systemMode;
	}
	public iSystemMode getModeSystem(){
		return modeSystem;
	}
	
	
}
