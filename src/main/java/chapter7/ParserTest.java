package chapter7;

interface Parseable {

  public abstract void parse(String fileName);
}

class ParserManager {

  public static Parseable getParser(String type) {
    if (type.equals("XML")) {
      Parseable parseable = new XMLParser();
      return parseable;
    } else {
      Parseable parseable = new HTMLParser();
      return parseable;
    }
  }
}

class XMLParser implements Parseable {

  @Override
  public void parse(String fileName) {
    System.out.println(fileName + "- XML parsing completed.");
  }
}

class HTMLParser implements Parseable {

  @Override
  public void parse(String fileName) {
    System.out.println(fileName + "- HTML parsing completed.");
  }
}


public class ParserTest {

  public static void main(String[] args) {
    Parseable parser = ParserManager.getParser("XML");
    parser.parse("document.xml");

    parser = ParserManager.getParser("HTML");
    parser.parse("document2.html");
  }

}
