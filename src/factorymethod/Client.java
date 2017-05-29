package factorymethod;
//interface (Product)
interface Logger {

	public void log(String message);
}

//concrete implementation of the Logger (Product) 
class XMLLogger implements Logger {

	public void log(String message) {
		//log to xml
		System.err.println("logging");
	}

}

//the abstract Creator
abstract class AbstractLoggerCreator 
{
	//the factory method
	public abstract Logger createLogger();
	
	
	//the operations that are implemented for all LoggerCreators
	//like anOperation() in our diagram
	public Logger getLogger()
	{
		//depending on the subclass, we'll get a particular logger.
		Logger logger = createLogger();
		
		//could do other operations on the logger here
		
		return logger;
	}
	
}
//ConcreteCreator
class XMLLoggerCreator extends AbstractLoggerCreator{

	@Override
	public Logger createLogger() {
		XMLLogger logger = new XMLLogger();
		return logger;
	}

}
public class Client {
	private void someMethodThatLogs(AbstractLoggerCreator logCreator)
	{
		Logger logger = logCreator.createLogger();
		logger.log("message");
		
	}
	
	
	
	public static void main(String[] args)
	{
		//for the purposes of this example, create an XMLLoggerCreator directly, 
		//but this would normally be passed to constructor for use.
		AbstractLoggerCreator creator = new XMLLoggerCreator();
		
		Client client = new Client();
		client.someMethodThatLogs(creator);
	}
	
}

