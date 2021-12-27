package oop;

public class DummyDic {

    public String engTorus(String eng) {
        return "Неизвестное слово " + eng;
    }

    public static void main(String[] args) {
        DummyDic tran = new DummyDic();
        String rep = "Negative";
        System.out.println(tran.engTorus(rep));
    }
}
