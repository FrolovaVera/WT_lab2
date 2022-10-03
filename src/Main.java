public class Main {
    public static void main(String[] args) {
        AppliancesShop searcher = new AppliancesShop();

        System.out.println("All list of appliences:");
        for (Applience app : Applience.values()){
            searcher.infoAppliances(app.getAppName());
        }
        searcher.findTheCheapestApplience();
        System.out.println("Only kettle: ");
        searcher.infoAppliances(Applience.KETTLE.getAppName());
    }
}
