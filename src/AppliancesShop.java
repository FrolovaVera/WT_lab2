import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppliancesShop {
    private File appFile = new File("appliances.txt");
    public AppliancesShop(){
        this.appFile = appFile;
    }

public void infoAppliances(String appName){
    List<String> appInfo =  fileParser(appName);
    for (String s : appInfo) {//вывод всех строк в коллекции
        System.out.println("     "+s);
    }
}
public List<String> fileParser(String appName){
        List<String> appInfo = new ArrayList<>();
    try {
        FileReader fr = new FileReader(appFile);
        Scanner scanner = new Scanner(fr);// считывать данные, которые вводят юзеры.
        String info;
        String currApp;
        while (scanner.hasNext()) {
            info = scanner.nextLine();
            currApp = info.substring(0, appName.length());

            if (currApp.equals(appName)) {
                appInfo.add(info);
            }
        }
        fr.close();
        scanner.close();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        return appInfo;
    }
}

public void findTheCheapestApplience(){
        String appInfo = null;
        double price;

        try{
            FileReader fr = new FileReader(appFile);
            Scanner scanner = new Scanner(fr);
            if (scanner.hasNext()) {
                appInfo = scanner.nextLine();
                price = appliancePrice(appInfo);

                double currPrice;
                String currAppInfo;

                while (scanner.hasNext()) {
                    currAppInfo = scanner.nextLine();
                    currPrice = appliancePrice(currAppInfo);

                    if (currPrice < price) {
                        appInfo = currAppInfo;
                        price = currPrice;
                    }
                }

            }

            System.out.println("The cheapest applience: "+ appInfo);

            fr.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
}

private double appliancePrice(String appInfo){
    String[] appProperties = appInfo.split("-");
    double price;

    for (String s:appProperties){
         if ((s.substring(s.length()-3)).equals("BYN")){
             s=s.substring(0,s.length()-3);
             price = Double.valueOf(s);
             return  price;
         }
    }
    return 0.0;
}
}

