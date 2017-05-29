package decorator;

	abstract class WindowControl
	{
		private int _height;
		private int _width;
		private int _x;
		private int _y;

		public int getHeight()
		{
			return _height;
		}
		public void setHeight(int height)
		{
			_height = height;
		}
		public int getWidth()
		{
			return _width;
		}
		public void setWidth(int width)
		{
			_width= width;
		}
		public int getXCoord()
		{
			return _x;
		}
		public void setXCoord(int x)
		{
			_x= x;
		}
		public int getYCoord()
		{
			return _y;
		}
		public void setYCoord(int y)
		{
			_y= y;
		}
		public abstract void Render();
	}
	class TextBox extends WindowControl
	{
		private String _value;

		public TextBox(int height, int width, int x, int y)
		{
			this.setHeight( height);
			this.setWidth( width);
			this.setXCoord( x);
			this.setYCoord(y);
		}

		public String getValue()
		{
			return _value;
		}
		public void setValue(String value)
		{
			this._value = value;
		}
		public void Render()
		{
			System.out.println("--TextBox Height:"+this.getHeight());
			System.out.println("--TextBox Width:"+this.getWidth());
			System.out.println("--TextBox X Coord:"+this.getXCoord());
			System.out.println("--TextBox Y Coord:"+this.getYCoord());
			System.out.println("--TextBox Value:"+_value);
		}
	}

	abstract class ControlDecorator extends WindowControl
	{
		protected WindowControl underlyingControl;

		public ControlDecorator(WindowControl control)
		{
			underlyingControl = control;
		}
		public void Render()
		{
			underlyingControl.Render();
		}
	}

	class TextBoxScrollDecorator extends ControlDecorator
	{
		private int _scrollBarWidth;
		private int _scrollBarPosition = 0;

		public TextBoxScrollDecorator(TextBox textBox) 
		{		
			super(textBox);
		}

		public int getScrollBarWidth()
		{
			return _scrollBarWidth;
		}

		public void setScrollBarWidth(int scrollBarWidth)
		{
			_scrollBarWidth = scrollBarWidth;
		}
		public int getScrollBarPosition()
		{
			return _scrollBarPosition;
			
		}
		public void setScrollBarPosition(int scrollBarPosition)
		{
			_scrollBarPosition = scrollBarPosition;
		}
		public   void Render()
		{
			super.Render();
			System.out.println("Added decorator values:");
			System.out.println("--Scroll Bar Width:" +_scrollBarWidth);
			System.out.println("--Scroll Bar Position:" +_scrollBarPosition);
		}
	}
	
	public class Decorator
	{		

		public static void main(String [] args)
		{
			System.out.println("------------------------------");
			System.out.println("Test for Decorator");
			System.out.println("TextBox without decorator..");
			TextBox textBox = new TextBox(250,350,1200,300);
			textBox.setValue("Some Text...");
			textBox.Render();
			System.out.println("TextBox with decorator..");
			TextBoxScrollDecorator scrollable = new TextBoxScrollDecorator(textBox);
			scrollable.setScrollBarPosition(20);
			scrollable.setScrollBarWidth(10);
			scrollable.Render();
			
		}

		

	}
	
