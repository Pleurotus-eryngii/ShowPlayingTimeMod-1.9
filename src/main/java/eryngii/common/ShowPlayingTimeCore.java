package eryngii.common;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import eryngii.keyhandlers.ShowPlayingTime_ShowNowDateKey_Handler;
import eryngii.keyhandlers.ShowPlayingTime_ShowTimeKey_Handler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
/*
 * The main class of ShowPlayingTimeMod
 * @author Hayabusa
 * 2016/03/15
 * 1.9 Updated by Eryngii
 * 2016/5/22
 */
@Mod(modid = "ShowPlayingTime", name = "ShowPlayingTime", version = "1.9_1.0")
public class ShowPlayingTimeCore {
	
	@Instance("ShowPlayingTime")
	public static ShowPlayingTimeCore instance;

	//Cキーが押された時の処理 インスタンス生成
	@SideOnly(Side.CLIENT)
	public static final KeyBinding inputKeyC = new KeyBinding("Show Playing Time", Keyboard.KEY_C, "key.categories.gameplay");
	public static final KeyBinding inputKeyV = new KeyBinding("Show Now Date", Keyboard.KEY_V, "key.categories.gameplay");

	@EventHandler
	public void init(FMLInitializationEvent event) throws IOException
	{
		if (event.getSide() == Side.CLIENT)
	    {
	        ClientRegistry.registerKeyBinding(inputKeyC);
	        ClientRegistry.registerKeyBinding(inputKeyV);
	    }
		ShowPlayingTime_ShowTimeKey_Handler keyinstance_C = new ShowPlayingTime_ShowTimeKey_Handler();
		FMLCommonHandler.instance().bus().register(keyinstance_C);
		//プレイ時間表示クラスに投げる
		ShowPlayingTime_ShowNowDateKey_Handler keyinstance_V = new ShowPlayingTime_ShowNowDateKey_Handler();
		FMLCommonHandler.instance().bus().register(keyinstance_V);
		//おまけ機能 現在時間表示クラスに投げる
	}
	public static long startedtime;

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		//postInitで起動時を取得
		//この実装は安全なのか…？
		long i = System.currentTimeMillis();
		System.out.println(i);
		startedtime = i;
		System.out.println(startedtime);
	}

}