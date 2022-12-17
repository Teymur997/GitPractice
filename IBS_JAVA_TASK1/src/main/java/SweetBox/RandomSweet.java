package SweetBox;

public class RandomSweet {
    Sweet[] chocolateBars = new ChocolateBar[] {new ChocolateBar("Alpen Gold", 0.08, 60),
            new ChocolateBar("Милка", 0.085,111), new ChocolateBar("Бабаевский Элитный 75%", 0.1,275)};

    Sweet[] cookie = new Cookie[] {new Cookie("Юбилейное", 0.14,70),
            new Cookie("Яшкино", 0.18,89), new Cookie("Каждый день", 0.15,25)};

    Sweet[] marmalade = new Marmalade[] {new Marmalade("БонПари", 0.075,73),
            new Marmalade("Фрутелла Крутой микс", 0.15,122), new Marmalade("Haribo", 0.175,179)};

    public Sweet getRandomChocolateBar() {
        return chocolateBars[(int)(Math.random()*chocolateBars.length)];
    }

    public Sweet getRandomCookie() {
        return cookie[(int) (Math.random()* cookie.length)];
    }
    public Sweet getRandomMarmalade() {
        return marmalade[(int) (Math.random()* marmalade.length)];
    }


}
