package chapter8;


public class TryWithResourceEx {

  public static void main(String[] args) {
    try (CloseableResource cr = new CloseableResource();) {
      cr.exceptionWork(false);
    } catch (WorkException we) {
      we.printStackTrace();
    } catch (CloseException closeException) {
      closeException.printStackTrace();
    }
    System.out.println("first End");

    try (CloseableResource cr = new CloseableResource();) {
      cr.exceptionWork(true);
    } catch (WorkException we) {
      we.printStackTrace();
    } catch (CloseException closeException) {
      closeException.printStackTrace();
    }
    System.out.println("second End.");

  }
}

class CloseableResource implements AutoCloseable {

  public void exceptionWork(boolean exception) throws WorkException {
    System.out.println("exceptionWork(" + exception + ") 가 호출됨. ");

    if (exception) {
      throw new WorkException("WorkException 발생!!");
    }
  }

  @Override
  public void close() throws CloseException {
    System.out.println("close() 가 호출됨.");
    throw new CloseException("CloseException 발생!!");
  }
}

class WorkException extends Exception {

  public WorkException(String msg) {
    super(msg);
  }
}

class CloseException extends Exception {

  CloseException(String msg) {
    super(msg);
  }
}

