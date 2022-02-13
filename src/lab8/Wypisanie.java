package lab8;

public class Wypisanie {
    String z;

    Wypisanie(String z)
    {
        this.z =z;
    }

    public void  cutfirst() {
        z=z.replaceFirst("\\  - "," ");
    }
}
