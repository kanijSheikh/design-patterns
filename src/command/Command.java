package command;

import java.util.ArrayList;
	//reciver
	class Document
	{
		private ArrayList<String> _textArray = new ArrayList<String>();

		public void Write(String text)
		{
			_textArray.add(text);
		}
		public void Erase(String text)
		{
			_textArray.remove(text);
		}
		public void Erase(int textLevel)
		{
			_textArray.remove(textLevel);
		}

		public String ReadDocument()
		{
			StringBuilder sb = new StringBuilder();
			for(String text : _textArray)
				sb.append(text);
			return sb.toString();
		}
	}

	//command
	public abstract class Command
	{		
		// Methods
		abstract public void Redo();
		abstract public void Undo();
	}
	//concreatecommand
	class DocumentEditCommand extends Command
	{
		private Document _editableDoc;
		private String _text;
		public DocumentEditCommand(Document doc, String text)
		{
			_editableDoc = doc;
			_text = text;
			_editableDoc.Write(_text);
		}		
		public void Redo()
		{
			_editableDoc.Write(_text);
		}
		public void Undo()
		{
			_editableDoc.Erase(_text);
		}
	}
	//invoker
	class DocumentInvoker
	{
		private ArrayList<Command> _commands = new ArrayList<Command> ();
		private Document _doc = new Document();

		public void Redo( int level )
		{
			System.out.println( "---- Redo level " + level );
			((Command)_commands.get(level)).Redo();
		}

		public void Undo( int level )
		{
			System.out.println( "---- Undo level " + level );
			((Command)_commands.get(level)).Undo();
		}
		
		public void Write(String text)
		{
			DocumentEditCommand cmd = new 
				DocumentEditCommand(_doc,text);
			_commands.add(cmd);
		}
	
		public String Read()
		{
			return _doc.ReadDocument();
		}
	}
	
	//client
	class CommandTest
		{		

			public static void main(String [] args)
			{
				System.out.println("Test for Command");

				DocumentInvoker instance = new DocumentInvoker();
				instance.Write("This is the original text.");
				System.out.println(instance.Read());
				instance.Write(" Here is some other text.");
				System.out.println(instance.Read());
				instance.Undo(1);
				System.out.println("After 1st Undo:" + instance.Read());
				instance.Redo(1);
				System.out.println("After 1st Redo:" + instance.Read());
				instance.Write(" And a little more text.");
				System.out.println(instance.Read());
				instance.Undo(2);
				System.out.println("After 2nd Undo:" + instance.Read());
				instance.Redo(2);
				System.out.println("After 2nd Redo:" + instance.Read());
				instance.Undo(1);
				System.out.println("After 1st Undo:" + instance.Read());

				
			}
			
		}
