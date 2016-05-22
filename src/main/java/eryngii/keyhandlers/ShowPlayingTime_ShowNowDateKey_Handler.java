package eryngii.keyhandlers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import eryngii.common.ShowPlayingTimeCore;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * @author Hayabusa
 * 2015/03/16
 * 1.9 Updated by Eryngii
 * 2016/5/22
 * 特定のキーを押すことで現在日時を表示する機能
 */

public class ShowPlayingTime_ShowNowDateKey_Handler 
{

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void inputKey(InputEvent.KeyInputEvent e)
	{
		if (ShowPlayingTimeCore.inputKeyV.isPressed())
	    {
			/*
			//System.out.println("Vキー押された");
			EntityPlayer entP = Minecraft.getMinecraft().thePlayer;
			//Instant ins = Instant.now();
			LocalDateTime nowdate = LocalDateTime.now();
			entP.addChatMessage(new TextComponentTranslation("現在日時:" + nowdate.getYear() + "年" + nowdate.getMonthValue() + "月" + nowdate.getDayOfMonth() + "日"
					+ nowdate.getHour() + "時" + nowdate.getMinute() + "分" ));
					*/
			EntityPlayer entP = Minecraft.getMinecraft().thePlayer;
			Calendar c = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("現在日時yyyy年MM月dd日hh時mm分");
			
			entP.addChatMessage(new TextComponentTranslation((sdf.format(c.getTime())) ));

	    }
	}
	    	
}
	
