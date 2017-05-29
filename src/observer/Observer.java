package observer;

import java.util.ArrayList;

//subject or obervable
abstract class Form
{
	ArrayList<FormObserver> observerList = new ArrayList<FormObserver>() ;
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		
		Notify();
	}
	public void Notify()
	{
		for(FormObserver observer : observerList)
			observer.update(this);
	}
	public void attach(FormObserver observer )
	{
		this.observerList.add(observer);
	}
	public void dettach(FormObserver observer )
	{
		observerList.remove(observer);
	}
}

//concreate subject
class MdiForm extends Form
{
	
}

//Observer
interface FormObserver
{
	void update(Form form);
}

//concrete observable
class FormObserverImpl implements FormObserver
{

	@Override
	public void update(Form form) {
		// TODO Auto-generated method stub
		System.out.println("title is changed" + form.getTitle());
	}
	
}

public class Observer {
public static void main(String[] args) {
	Form subject = new MdiForm();
	FormObserver observer = new FormObserverImpl();
	subject.attach(observer);
	
	FormObserver observer1 = new FormObserverImpl();
	subject.attach(observer1);
	
	subject.setTitle("hello World");
	subject.dettach(observer1);
	subject.setTitle("bye world ");
	
}
}
