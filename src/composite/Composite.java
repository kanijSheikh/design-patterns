package composite;

import java.util.ArrayList;

	//Component
	abstract class Component
	{
		private String _name;

		public Component(String name)
		{
			_name = name;
		}

		public String getName()
		{
			return _name;
		}
		public abstract void Draw();

		public int hashcode()
		{
			return _name.hashCode();
		}
		public boolean equals(Object obj)
		{
			if(obj != null && obj instanceof Component)
				return _name.equals (((Component)obj).getName());
			else
				return false;
		}

		public String toString()
		{
			return _name;
		}


	}
	//Leaf
	class GraphicalComponent extends Component
	{
		
		public GraphicalComponent(String name){
			super(name);
		}
		

		public void Draw()
		{
			System.out.println("--" + super.getName() + ".Draw() called to draw GraphicalComponent.");
		}
	}

	//composite
	class GraphicalComposite extends Component
	{
		private ArrayList<Component> _children = new ArrayList<Component>();

		public GraphicalComposite(String name) {
			super(name);
		}
		
		public void Add(Component child)
		{
			_children.add(child);
		}

		public void Remove(Component child)
		{
			_children.remove(child);
		}

		public Component GetChild(int index)
		{
			return (Component)_children.get(index);
		}

		public  void Draw()
		{
			System.out.println("--" + super.getName() + ".Draw() called to draw GraphicalComponent.");
			for(Component comp :_children)			
				comp.Draw();
		}
	}
	public class Composite
	{		

		public static void main(String [] args)
		{
			System.out.println("------------------------------");
			System.out.println("Test for Composite");
			
			System.out.println("Create Root 'OuterPanel' Composite..");
			GraphicalComposite root = new GraphicalComposite("OuterPanel");
			System.out.println("Add 'Circle' to Root 'OuterPanel' Composite..");
			root.Add(new GraphicalComponent("Circle"));
			System.out.println("Add 'Square' to Root 'OuterPanel' Composite..");
			root.Add(new GraphicalComponent("Square"));
			System.out.println("Add 'Triangle' to Root 'OuterPanel' Composite..");
			root.Add(new GraphicalComponent("Triangle"));

			System.out.println("Create Child 'InnerPanel' Composite..");
			GraphicalComposite childComposite = new GraphicalComposite("InnerPanel");
			System.out.println("Add 'Line' to Child 'InnerPanel' Composite..");
			childComposite.Add(new GraphicalComponent("Line"));

			System.out.println("Add Child 'InnerPanel' to Root 'OuterPanel' Composite..");
			root.Add(childComposite);

			GraphicalComponent removable = new GraphicalComponent("Single Line");
			System.out.println("Add Child 'Single Line' Component to Root 'OuterPanel' Composite..");
			root.Add(removable);
			System.out.println("Remove Child 'Single Line' Component to Root 'OuterPanel' Composite..");
			root.Remove(removable);

			root.Draw();

			System.out.println("Hit any key to continue");
		}
	}
	