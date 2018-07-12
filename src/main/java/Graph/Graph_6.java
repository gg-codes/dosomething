package graph;
import java.util.*;

public class Graph_6
{

	public static void main(String[] args)
	{
		Set<String> set = new TreeSet<>();
		set.add("POON");
		set.add("PLEE");
		set.add("SAME"); 
		set.add("POIE");
		set.add("PLEA");
		set.add("PLIE");
		set.add("POIN");
		//System.out.println(set);
		String start = "TOON";
		String target = "PLEA";
		System.out.println(shortestChainToTarget(start, target, set));
	}

	private static int shortestChainToTarget(String start, String target, Set<String> set)
	{
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		String str;
		int count = 1;
		while (!queue.isEmpty())
		{
			String current = queue.poll();
			Iterator<String> it = set.iterator();
			while (it.hasNext())
			{
				str = it.next();
				if (ifAdjacent(current, str))
				{
					it.remove();
					count++;
					queue.add(str);
					if (str.equals(target))
					{
						return count;
					}
				}
			}
		}
		return 0;
	}

	private static boolean ifAdjacent(String current, String str)
	{
		int length = current.length();
		int noMatchCount = 0;

		for (int i=0;i < length;i++)
		{
			if (current.charAt(i) != str.charAt(i))
			{
				noMatchCount++;
			}
			if (noMatchCount > 1)
			{
				return false;
			}
		}
		if (noMatchCount == 1)
		{
			System.out.println("Matching " + current + " and " + str);
		}
		return noMatchCount == 1;
	}
}
