import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<SuperBowlFinal> superBowlFinals = new ArrayList<>();
        try(Scanner scanFile = new Scanner(new File("SuperBowl.txt"))) {
            while (scanFile.hasNextLine()){
                String line = scanFile.nextLine();
                if(!line.contains("Ssz;")){
                    superBowlFinals.add(new SuperBowlFinal(line));
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("4. feladat: Döntők száma: " + superBowlFinals.size());
        System.out.println("5. feladat: Átlagos pontkülönbség: " + String.format("%.1f",averagePointsDifference(superBowlFinals)));
        System.out.println("6. feladat: Legmagasabb nézőszám a döntők során: \n" + mostSpectators(superBowlFinals));

        try(PrintWriter writer = new PrintWriter("SuperBowlNew.txt")){
            writer.println("Ssz;Dátum;Győztes(Játszott meccsek száma);Eredmény;Vesztes(Játszott meccsek száma);Helyszín;VárosÁllam;Nézőszám");
            List<SuperBowlFinal> auxiliaryList = new ArrayList<>();

            for (SuperBowlFinal superBowlFinal: superBowlFinals){
                auxiliaryList.add(superBowlFinal);
                writer.println(
                        superBowlFinal.getId() + ";" +
                        superBowlFinal.getDate() + ";" +
                        superBowlFinal.getWinner() + "(" + playedMatchesCount(auxiliaryList,superBowlFinal.getWinner()) + ");" +
                        superBowlFinal.getResult() + ";" +
                        superBowlFinal.getLooser() + "(" + playedMatchesCount(auxiliaryList,superBowlFinal.getLooser()) + ");" +
                        superBowlFinal.getLocation() + ";" +
                        superBowlFinal.getCityAndState() + ";" +
                        superBowlFinal.getSpectatorsCount()
                );
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static double averagePointsDifference(List<SuperBowlFinal> superBowlFinals){
        int sum = 0;
        for (SuperBowlFinal superBowlFinal: superBowlFinals){
            sum += superBowlFinal.getPointsDifference();
        }
        return (double)sum/superBowlFinals.size();
    }

    public static SuperBowlFinal mostSpectators(List<SuperBowlFinal> superBowlFinals){
        int max = Integer.MIN_VALUE;
        int id = -1;
        for (int i = 0; i < superBowlFinals.size(); i++){
            if(max < superBowlFinals.get(i).getSpectatorsCount()){
                max = superBowlFinals.get(i).getSpectatorsCount();
                id =i;
            }
        }
        return superBowlFinals.get(id);
    }

    public static int playedMatchesCount(List<SuperBowlFinal> superBowlFinals, String teamName){
        int count = 0;
        for (SuperBowlFinal superBowlFinal: superBowlFinals){
            if (superBowlFinal.getWinner().equals(teamName) || superBowlFinal.getLooser().equals(teamName)){
                count++;
            }
        }
        return count;
    }
}
