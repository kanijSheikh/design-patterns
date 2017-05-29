package chainofresponsibility;

	abstract class Process
	{
		private Process _nextProcess;

		protected abstract void RunNext() throws InterruptedException;

		public void Run() 
		{
			try {
				RunNext();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(_nextProcess != null)
			{
				_nextProcess.Run();
			}
		}

		public void SetNextProcess(Process process)
		{
			_nextProcess = process;
		}		
	}

	class FirstProcess extends Process
	{
		protected  void RunNext() throws InterruptedException
		{
			System.out.println("Beginning first process....");
			Thread.sleep(1000);	
			System.out.println("Ending first process....");
		}
	}

	class SecondProcess extends Process
	{
		protected  void RunNext() throws InterruptedException
		{
			System.out.println("Beginning second process....");
			Thread.sleep(2000);
			System.out.println("Ending second process....");
		}
	}

	class ThirdProcess extends Process
	{
		protected  void RunNext() throws InterruptedException
		{
			System.out.println("Beginning third process....");
			Thread.sleep(3000);		
			System.out.println("Ending third process....");
		}
	}

	public class ChainOfResponsibility
	{		

		public static void main(String [] args)
		{
			System.out.println("------------------------------");
			System.out.println("Test for Chain of Responsibility");

			Process firstProcess = new FirstProcess();
			Process secondProcess = new SecondProcess();
			Process thirdProcess = new ThirdProcess();
			firstProcess.SetNextProcess(secondProcess);
			secondProcess.SetNextProcess(thirdProcess);
			thirdProcess.SetNextProcess(null);

			firstProcess.Run();

		}

	}
	
	