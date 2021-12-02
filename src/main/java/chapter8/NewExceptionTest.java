package chapter8;

public class NewExceptionTest {

  static final int NUM = 10;

  public static void main(String[] args) {
    try {
      startInstallation();
      copyFile();
    } catch (SpaceException e) {
      System.out.println("에러 메세지 : " + e.getMessage() + ", 에러코드 : " + e.getErrorCode());
      e.printStackTrace();
      System.out.println("디스크의 공간을 확보하고 설치해주세요.");
    } catch (MemoryException e) {
      System.out.println("에러 메세지 : " + e.getMessage() + ", 에러코드 : " + e.getErrorCode());
      e.printStackTrace();
      System.gc();
      System.out.println("다시 설치해 주세요. ");
    } finally {
      System.out.println("임시 파일을 삭제합니다.");
      deleteFiles();
    }


  }

  public static void startInstallation() throws SpaceException, MemoryException {
    if (!enoughSpace()) {
      throw new SpaceException(
          "설치할 공간이 부sdfsldkjfklsdjflksadjflksdjflksjdalfkjsdfkljdslkfjsdklfjsdlkfjskldfjlksdjflksdjf족합니asdds다.",
          100);
    }
    if (!enoughMemory()) {
      throw new MemoryException("메모리가 부족합니다.", 200);
    }
  }

  public static void copyFile() {

  }

  public static void deleteFiles() {

  }

  public static boolean enoughSpace() {
    return true;
  }

  public static boolean enoughMemory() {
    return false;
  }
}


class SpaceException extends Exception {

  private final int ERR_CODE;

  public SpaceException(String msg, int errCode) {
    super(msg);
    this.ERR_CODE = errCode;
  }

  public int getErrorCode() {
    return ERR_CODE;
  }
}

class MemoryException extends Exception {

  private final int ERR_CODE;

  public MemoryException(String msg, int errCode) {
    super(msg);
    this.ERR_CODE = errCode;
  }

  public int getErrorCode() {
    return ERR_CODE;
  }
}
