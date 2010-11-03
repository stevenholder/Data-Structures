import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class OurGraphAL {
	private ArrayList<ArrayList<Integer>> graphArray;
	
	public OurGraphAL() {
		this(2);
	}

	public OurGraphAL(int nVertices) {
		graphArray = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < nVertices; i++) {
			graphArray.add(new ArrayList<Integer>());
		}
	}
	
	public boolean createVertex() {
		return graphArray.add(new ArrayList<Integer>());
	}
	
	public boolean removeVertex(int vertex) {
		int size = graphArray.size()-1;
		Iterator<Integer> itr  = this.getVertices();
		
		while(itr.hasNext()) {
			graphArray.get(itr.next()).remove((Object)vertex);
		}
		
		if(vertex == size) {
			graphArray.remove(vertex);
		} else {
			graphArray.set(vertex, graphArray.get(size));
			graphArray.remove(size);
			itr  = this.getVertices();
			while(itr.hasNext()) {
				int next = itr.next();
				if(graphArray.get(next).contains(size)){
					graphArray.get(next).remove((Object)size);
					graphArray.get(next).add(vertex);
				}
				Collections.sort(graphArray.get(next));
			}
		}
		return true;
	}
	
	public boolean createEdge(int source, int destination) {
		if(source >= graphArray.size() || destination >= graphArray.size()) {
			return false;
		}
		graphArray.get(source).add(destination);
		graphArray.get(destination).add(source);
		return true;
	}
	
	public boolean removeEdge(int source, int destination) {
		if(isEdge(source, destination)) {
			graphArray.get(source).remove(destination);
			graphArray.get(destination).remove(source);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEdge(int source, int destination) {
		if(source >= graphArray.size() || destination >= graphArray.size()) {
			return false;
		}
		return graphArray.get(source).contains(destination); 

	}
	
	public Iterator<Integer> getVertices() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < graphArray.size(); i++) {
			temp.add(i);
		}
		return temp.iterator();
	}
	
	public Iterator<Integer> getVertices(int vertex) {
		if(vertex >= graphArray.size()) {
			return null;
		}
		return graphArray.get(vertex).iterator();
	}
	
	public ArrayList<Integer> bfs(int neighbor) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		OurLinkedQueue<Integer> q = new OurLinkedQueue<Integer>();
		q.offer(neighbor);
		temp.add(neighbor);
		
		while(q.peek() != null) {
			Iterator<Integer> itr = this.getVertices(q.poll());
			while(itr.hasNext()) {
				int next = itr.next();
				if(!temp.contains(next)) {
					q.offer(next);
					temp.add(next);
				}
			}
		}	
		return temp;		
	}
	
	public ArrayList<Integer> dfs(int neighbor) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		OurArrayStack<Integer> q = new OurArrayStack<Integer>();
		q.push(neighbor);
		temp.add(neighbor);
		
		while(q.peek() != null) {
			Iterator<Integer> itr = this.getVertices(q.pop());
			while(itr.hasNext()) {
				int next = itr.next();
				if(!temp.contains(next)) {
					q.push(next);
					temp.add(next);
				}
			}
		}	
		return temp;		
	}
	
	public static void main(String[] args) {
		OurGraphAL graph = new OurGraphAL(7);
		graph.createEdge(0, 1);
		graph.createEdge(0, 2);
		graph.createEdge(0, 5);
		graph.createEdge(0, 6);
		graph.createEdge(3, 4);
		graph.createEdge(3, 5);
		graph.createEdge(4, 5);
		graph.createEdge(4, 6);
		
		Iterator<Integer> itr = graph.getVertices();
		
		while(itr.hasNext()) {
			int i = itr.next();
			System.out.print(i + " - ");
			Iterator<Integer> itr2 = graph.getVertices(i);
			while(itr2.hasNext()) {
				System.out.print(itr2.next());
			}
			System.out.println();
		}
		
		System.out.println();
		/*
		graph.removeVertex(3);
		
		itr = graph.getVertices();
		
		while(itr.hasNext()) {
			int i = itr.next();
			System.out.print(i + " - ");
			Iterator<Integer> itr2 = graph.getVertices(i);
			while(itr2.hasNext()) {
				System.out.print(itr2.next());
			}
			System.out.println();
		}
		*/
		
		for(Integer i : graph.bfs(4)) {
			System.out.println(i);
		}
	}
}
