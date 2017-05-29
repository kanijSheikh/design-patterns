package bridge;


	//Abstraction
	abstract class Request
	{
		private RequestImplementor _implementor;

		public void SetImplementor(RequestImplementor implementor)
		{
			System.out.println( implementor.getClass().getName() + "{0} set as Implementor for Bridge..");
			_implementor = implementor;
		}

		protected RequestImplementor getImplementor()
		{
			return _implementor;
		}	
		public abstract void Process(String request);

	}
	//Refined Abstraction
	class RequestHandler extends Request
	{
		public  void Process(String request)
		{
			System.out.println("Calling the Process Method:");
			getImplementor().ProcessRequest(request);
		}
	}

	abstract class RequestImplementor
	{
		public abstract void ProcessRequest(String request);
	}
	//Concrete Implementor
	class HttpRequest  extends RequestImplementor
	{
		public void ProcessRequest(String request)
		{
			System.out.println(getClass().getName() +"--Implementor processed this request: "+ request); 
		}
	}
	class ISAPIRequest extends RequestImplementor
	{
		public void ProcessRequest(String request)
		{
			System.out.println(getClass().getName() +"--Implementor processed this request: "+ request); 
		}
	}
	
	class FTPRequest extends RequestImplementor
	{
		public void ProcessRequest(String request)
		{
			System.out.println(getClass().getName() +"--Implementor processed this request: "+ request); 
		}
	}
	class SMTPRequest extends RequestImplementor
	{
		public void ProcessRequest(String request)
		{
			System.out.println(getClass().getName() +"--Implementor processed this request: "+ request); 
		}
	}
	public class Bridge
	{		

		public static void main(String [] args)
		{
			System.out.println("------------------------------");
			System.out.println("Test for Bridge");

			System.out.println("RequestHandler (Refined Abstraction) initialized as base type Request (Abstraction)..");
			Request request = new RequestHandler();
			request.SetImplementor(new HttpRequest());
			request.Process("This is a HTTP request stream..");

			request.SetImplementor(new ISAPIRequest());

			request.Process("This is a ISAPI request stream..");

			request.SetImplementor(new FTPRequest());
			request.Process("This is a FTP request stream..");

			request.SetImplementor(new SMTPRequest());
			request.Process("This is a SMTP request stream..");

		}

		

	}
