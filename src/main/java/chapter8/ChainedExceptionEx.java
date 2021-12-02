package chapter8;

public class ChainedExceptionEx {

  public static void main(String[] args) {
    try {
      install();
    } catch (InstallException e) {
      System.out.println("main 에서 받은 에러 : " + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void install() throws InstallException {
    try {
      startInstallation();
      copyFile();
    } catch (SpaceException e) {
      System.out.println("에러 메세지 : " + e.getMessage() + ", 에러코드 : " + e.getErrorCode());
      e.printStackTrace();
      System.out.println("디스크의 공간을 확보하고 설치해주세요.");

      InstallException ie = new InstallException("공간, 설치에러!!");
      ie.initCause(e);
      throw ie;
    } catch (MemoryException e) {
      System.out.println("에러 메세지 : " + e.getMessage() + ", 에러코드 : " + e.getErrorCode());
      e.printStackTrace();
      System.gc();
      System.out.println("다시 설치해 주세요. ");

      InstallException ie = new InstallException("메모리, 설치에러");
      ie.initCause(e);
      throw ie;
    } finally {
      System.out.println("임시 파일을 삭제합니다.");
      deleteFiles();
    }
  }

  public static void startInstallation() throws SpaceException, MemoryException {
    if (!enoughSpace()) {
      throw new SpaceException("설치할 공간이 부족합니다.", 100);
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

class InstallException extends Exception {

  public InstallException(String msg) {
    super(msg);
  }
}

class SpaceException1 extends Exception {

  public SpaceException1(String msg, int errCode) {
    super(msg);
  }
}

class MemoryException1 extends Exception {

  public MemoryException1(String msg, int errCode) {
    super(msg);
  }

}
