package transformations;

import com.l2jfree.gameserver.instancemanager.TransformationManager;
import com.l2jfree.gameserver.model.L2DefaultTransformation;
import com.l2jfree.gameserver.model.actor.instance.L2PcInstance;

/**
 * Description: <br>
 * This will handle the transformation, giving the skills, and removing them, when the player logs out and is transformed these skills
 * do not save. 
 * When the player logs back in, there will be a call from the enterworld packet that will add all their skills.
 * The enterworld packet will transform a player.
 * 
 * @author durgus
 *
 */
public class Pixy extends L2DefaultTransformation
{
	public Pixy()
	{
		// id, colRadius, colHeight
		super(304, 5.0, 25.0);
	}

	public void transformedSkills(L2PcInstance player)
	{
	}

	public void removeSkills(L2PcInstance player)
	{
	}

	public static void main(String[] args)
	{
		TransformationManager.getInstance().registerTransformation(new Pixy());
	}
}
