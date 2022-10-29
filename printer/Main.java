package printer;

public class Main {

	  public static void main(String[] args) {
	    // TODO Auto-generated method stub
	    Printer prn = new Printer();

	    PrinterTask task1 = new PrinterTask(prn, "Hip");
	    PrinterTask task2 = new PrinterTask(prn, "Hop");

	    Thread thread1 = new Thread(task1);
	    Thread thread2 = new Thread(task2);

	    thread1.start();
	    thread2.start();

	  }

	}