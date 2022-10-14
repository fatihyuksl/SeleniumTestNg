
public class US_022 {}
    /*
    TradyLinnPages trd = new TradyLinnPages();
    Actions action = new Actions(Driver.getDriver());
    SoftAssert soft = new SoftAssert();

    @Test
    public void US_0022_TC_001() {
        //1. tradylinn.com git.
        Driver.getDriver().get(ConfigReader.getProperty("tradyUrl"));
        //2. Sayfayı aşağı kaydır.
        action.sendKeys(Keys.PAGE_DOWN).perform();
        //3. Bütün kategorilerde "Tümünü gör" linkinin olduğunu doğrula.
        boolean tumunugorvisible = trd.tumunuGor.stream().allMatch(t -> t.isDisplayed());
        soft.assertTrue(tumunugorvisible);
        //4. "Tümünü gör" linklerinin ilgili kategorinin anasayfasına yönlendirdiğini doğrula.
        Random rnd=new Random();
        int random= rnd.nextInt(trd.tumunuGor.size()-1);
        System.out.println(random);
        String randomCategorie=trd.allCategories.get(random).getText();
        System.out.println(randomCategorie);
        trd.selecto(randomCategorie).click();
        Assert.assertTrue(randomCategorie.equalsIgnoreCase(trd.check.getText()));
    }

    @Test
    public void US_0022_TC_002() throws InterruptedException {
        //1. tradylinn.com git.
        Driver.getDriver().get(ConfigReader.getProperty("tradyUrl"));
        //2. Sayfayı aşağı kaydır.
        action.sendKeys(Keys.PAGE_DOWN).perform();
        //3. "İndirimli Ürünler" sayfasına git.
        WebElement tumunuggor = trd.selecto("İndirimli Ürünler");
        String str = tumunuggor.getText();
        tumunuggor.click();
        soft.assertTrue(str.equalsIgnoreCase(trd.check.getText()));
        //4. Açılır menüde default seçeneğin "Varsayılan Sıralama" olduğunu doğrula.
        Select select = new Select(trd.dde);
        Assert.assertTrue(select.getOptions().get(0).getText().equalsIgnoreCase("Varsayılan Sıralama"));
        //5. Açılır menüde bu seçeneklerin olduğunu doğrula:
        //	En çok incelenene göre sırala
        //	En çok oy alana göre sırala
        //	En yeniye göre sırala
        //	Fiyata göre sırala: Düşükten yükseğe
        //	Fiyata göre sırala: Yüksekten düşüğe
        List<String> arr = Arrays.asList("En çok incelenene göre sırala", "En çok oy alana göre sırala", "Fiyata göre sırala: Düşükten yükseğe", "Fiyata göre sırala: Yüksekten düşüğe");
        Thread.sleep(5000);
        for (int i = 0; i < arr.size(); i++) {
            soft.assertTrue(trd.choiceElement(select.getOptions(), arr.get(i)).isDisplayed());
        }
        //6. kullanici "Fiyata göre sırala: Düşükten yükseğe" seçecek
        Thread.sleep(5000);
        select.selectByVisibleText("Fiyata göre sırala: Düşükten yükseğe");
        //7. "Fiyata göre sırala: Düşükten yükseğe" seçildiğinde, fiyatların düşükten yükseğe sıralandığını doğrula.
        Thread.sleep(5000);
        ArrayList<Double> prices1=new ArrayList<>();
        for (int i = 0; i < trd.allPrices.size(); i++) {
            prices1.add(i, Double.valueOf((trd.allPrices.get(i).getText().split("₺")[0])));
        }
        Thread.sleep(5000);
        boolean isDescSorted = true; // Baştan true dedik.
        // Burada artık isAscSorted küçükten büyüğe sıralı mı değil mi gösterir.
        for (int i = 1; i < trd.allPrices.size(); i++) {
            if(prices1.get(i) > prices1.get(i-1)) {
                isDescSorted = false; // Sırayı bozan koşul denk gelirse false olacak.
            }
        }
        soft.assertTrue(isDescSorted);
        Thread.sleep(5000);
        //8. kullanici "Fiyata göre sırala: Yüksekten düşüğe" seçecek
        select.selectByVisibleText("Fiyata göre sırala: Yüksekten düşüğe");
        Thread.sleep(10000);
        //9. "Fiyata göre sırala: Yüksekten düşüğe" seçildiğinde, fiyatların yüksekten düşüğe sıralandığını doğrula.
        ArrayList<Double> prices2=new ArrayList<>();
        for (int i = 0; i < trd.allPrices.size(); i++) {
            prices2.add(i, Double.valueOf((trd.allPrices.get(i).getText().split("₺")[0].replace(",", ""))));
        }
        System.out.println(prices2);
        // Burada artık isDescSorted büyükten küçüğe sıralı mı değil mi gösterir.
        boolean isAscSorted = true; // Baştan true dedik.
        Thread.sleep(5000);
        for (int i = 1; i < trd.allPrices.size(); i++) {
            if(prices2.get(i) < prices2.get(i-1)) {
                isAscSorted = false; // Sırayı bozan koşul denk gelirse false olacak.
            }
        }
        soft.assertTrue(isAscSorted);
        Thread.sleep(5000);
        Driver.getClose();

    }
}*/
