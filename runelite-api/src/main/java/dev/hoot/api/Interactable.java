package dev.hoot.api;

import net.runelite.api.util.Text;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface Interactable
{
	String[] getRawActions();

	int getActionId(int action);

	default List<String> getActions()
	{
		if (getRawActions() == null)
		{
			return null;
		}

		return Arrays.stream(getRawActions()).filter(Objects::nonNull).map(Text::removeTags).collect(Collectors.toList());
	}

	void interact(String action);

	void interact(int index);

	void interact(final int identifier, final int opcode, final int param0, final int param1);

	void interact(int index, int menuAction);

	default boolean hasAction(String... actions)
	{
		return getRawActions() != null && Arrays.stream(actions).filter(Objects::nonNull).anyMatch(x -> getActions().contains(x));
	}
}