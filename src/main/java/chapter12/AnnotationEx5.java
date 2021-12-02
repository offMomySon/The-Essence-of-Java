package chapter12;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111")
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "160101", hhmmss = "235959"))
public class AnnotationEx5 {
  public static void main(String[] args) {

    Class<AnnotationEx5> cls = AnnotationEx5.class;

//    TestInfo anno = AnnotationEx5.class.getAnnotation(TestInfo.class);

    TestInfo anno = cls.getAnnotation(TestInfo.class);
    System.out.println("anno.testedBy() = " + anno.testedBy());
    System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
    System.out.println("anno.testDate().hhmmss() = " + anno.testDate().hhmmss());

    for (String str : anno.testTools()) {
      System.out.println("testTool = " + str);
    }
    System.out.println();

    Annotation[] annotations = AnnotationEx5.class.getAnnotations();
    for (Annotation annotation : annotations) {
      System.out.println(annotation);
    }
  }
}

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo {
  int count() default 1;

  String testedBy();

  String[] testTools() default "JUnit";

  TestType testType() default TestType.FIRST;

  DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
  String yymmdd();

  String hhmmss();
}

enum TestType {FIRST, FINAL}