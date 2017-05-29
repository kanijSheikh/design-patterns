package adapter;
	//target
	class Element
	{		
		private String _typeName;

		public Element(String typeName)
		{
			System.out.println("Element of type created." +typeName);
			_typeName = typeName;
		}

		public String getName()
		{
			return _typeName;
		}

		public void SetVaporTemperature(float temperature)
		{
			System.out.println("Using method SetVaporTemperature(float temperature)..");
			System.out.println( _typeName + "-- vapor temperature set to " + temperature);
		}
		public void SetFreezeTemperature(float temperature)
		{
			System.out.println("Using method SetFreezeTemperature(float temperature)..");
			System.out.println( _typeName + "-- vapor temperature set to " + temperature);
			
		}
		public void SetNormalTemperature(float temperature)
		{
			System.out.println("Using method SetNormalTemperature(float temperature)..");
			System.out.println( _typeName + "-- vapor temperature set to " + temperature);
		}
	}
	
	//Adaptee
	class Water
	{
		public void SetBoilingTemperature(float temperature)
		{
			System.out.println("Using method SetBoilingTemperature(float temperature)..");
			System.out.println("--Water has a boiling temperature set to " + temperature);
		}
		public void SetIceTemperature(float temperature)
		{
			System.out.println("Using method SetIceTemperature(float temperature)..");
			System.out.println("--Water has a boiling temperature set to " + temperature);
		}
		public void SetLiquidTemperature(float temperature)
		{
			System.out.println("Using method SetLiquidTemperature(float temperature)..");
			System.out.println("--Water has a boiling temperature set to " + temperature);
		}
	}

	//Adapter
	class WaterAdapter extends  Element
	{
		private Water _adaptee = new Water();

		public WaterAdapter(String typeName) {
			super(typeName);
			
		}

		public void SetVaporTemperature(float temperature)
		{
			_adaptee.SetBoilingTemperature(temperature);
		}
		public void SetFreezeTemperature(float temperature)
		{
			_adaptee.SetIceTemperature(temperature);
		}
		public void SetNormalTemperature(float temperature)
		{
			_adaptee.SetLiquidTemperature(temperature);
		}
	}
	
	public class Adapter
	{		

		public static void main(String [] args)
		{
			System.out.println("------------------------------");
			System.out.println("Test for Adapter");

			System.out.println("First we test the normal implementation...");
			Element silicon = new Element("Silicon");
			silicon.SetFreezeTemperature(-20);
			silicon.SetVaporTemperature(3000);
			silicon.SetNormalTemperature(105);
			System.out.println("Next we test the adapter implementation...");

			Element water = new WaterAdapter("H2O");
			water.SetFreezeTemperature(20);
			water.SetVaporTemperature(140);
			water.SetNormalTemperature(75);

		}

		

	}

