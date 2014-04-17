package org.lineware.MaryousHat;

import com.badlogic.gdx.Game;
import com.kilobolt.Screens.SplashScreen;
import com.kilobolt.ZBHelpers.AssetLoader;

public class MHGame extends Game {

	private static IActivityRequestHandler myRequestHandler;
	private static ActionResolver resolver;
	
	public MHGame(IActivityRequestHandler handler, ActionResolver resolver){
		myRequestHandler = handler;
		this.resolver = resolver;
	}
	
	@Override
	public void create() {
		AssetLoader.load();
		resolver.onStartGSPS();
		setScreen(new SplashScreen(this, myRequestHandler, resolver));
	}

	@Override
	public void dispose() {
		resolver.onStopGSPS();
		super.dispose();
		AssetLoader.dispose();
	}
	
	

}