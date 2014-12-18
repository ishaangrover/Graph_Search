import java.util.*;

public class GraphSearch {

	/**
	 * Searches the Graph passed in as an AdjcencyList(adjList) to find if a path exists from the start node to the goal node
	 * using General Graph Search.
	 * 
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be visited.
	 * 
	 * The structure(struct) passed in is an empty structure may behave as a Stack or Queue and the
	 * correspondingly search function should execute DFS(Stack) or BFS(Queue) on the graph.
	 * 
	 * @param start
	 * @param struct
	 * @param adjList
	 * @param goal
	 * @return true if path exists false otherwise
	 */
	public static <T> boolean search(T start, Structure<T> struct, Map<T, List<T>> adjList, T goal) {
		if(start == null)
			return false;
		if(start == goal)
			return true;
		LinkedList<T> visited = new LinkedList<T>();
		visited.add(start);
		List<T> temp = adjList.get(start);
		for(int i = 0; i< temp.size(); i++)
		{
			struct.add(temp.get(i));
		}
		while(!struct.isEmpty())
		{
			T remove = struct.remove();
			if( !contains(remove, visited))
				visited.add(remove);
			if(remove.equals(goal))
				return true;
			temp = adjList.get(remove);
			for(int i = 0; i< temp.size(); i++)
			{
				if( !contains(temp.get(i), visited) && temp.get(i)!=null)
					struct.add(temp.get(i));
			}
			
			
		}
		return false;
	}
	
	private static <T> boolean contains(T node, LinkedList<T> visited)
	{
		int flag=0;
		for(int i = 0; i<visited.size(); i++)
		{
			if(node.equals(visited.get(i)))
			{
				flag=1;
			}
		}
		if(flag == 0)
			return false;
		else 
			return true;
		
	}
	
	/**
	 * Find the shortest distance between the start node and the goal node in the given a weighted graph 
	 * in the form of an adjacency list where the edges only have positive weights
	 * Return the aforementioned shortest distance if there exists a path between the start and goal,-1
	 * otherwise.
	 * 
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be visited.
	 * There are no negative edge weights in the graph.
	 * 
	 * @param start
	 * @param adjList
	 * @param goal
	 * @return the shortest distance between the start and the goal node
	 */
	
	
	public static <T> int dsp(T start, Map<T, List<Pair<T, Integer>>> adjList, T goal) {
		Set<T> set = adjList.keySet();	
		HashMap<T, Integer> map = new HashMap();
		LinkedList<T> visited = new LinkedList<T>();
		int count = 0;
		T[] arr = (T[])set.toArray();
		for(int i= 0; i<arr.length; i++)
		{
			if(arr[i].equals(start))
			{
				map.put(arr[i], 0);
			}
			else
				map.put(arr[i], (int) Double.POSITIVE_INFINITY);
		}
		
		
		T node = start;
		while(!visited.contains(goal) && count <= set.size() )
		{
			if(!visited.contains(node)){
				visited.add(node);
				List<Pair<T, Integer>> temp = adjList.get(node);
				for(int i=0; i<temp.size(); i++)
				{
					if(!visited.contains(temp.get(i).a) && (temp.get(i).b + map.get(node) < map.get(temp.get(i).a)))
					{
						map.put(temp.get(i).a, temp.get(i).b + map.get(node));
					}
				}

				node = findMin(map, visited, arr,node);	
			
		}
			count++;
		}
		if(count>=adjList.size()+1)
			return -1;
		return map.get(goal);
		

	}
	
	private static <T> T findMin(HashMap<T, Integer> map, LinkedList<T> visited, T[] arr ,T node)
	{
		int min = (int)Double.POSITIVE_INFINITY;
		T temp = node;
		for(int i= 0; i<arr.length; i++){
			
			if(map.get(arr[i]) < min && !visited.contains(arr[i])){
				min = map.get(arr[i]);
				temp = arr[i];
			}
		}
		
		return temp;
	}
}


