public class SuperBowlFinal {
    private String id;
    private String date;
    private String winner;
    private String result;
    private String looser;
    private String location;
    private String cityAndState;
    private int spectatorsCount;

    public SuperBowlFinal(String id, String date, String winner, String result, String looser, String location, String cityAndState, int spectatorsCount) {
        this.id = id;
        this.date = date;
        this.winner = winner;
        this.result = result;
        this.looser = looser;
        this.location = location;
        this.cityAndState = cityAndState;
        this.spectatorsCount = spectatorsCount;
    }

    public SuperBowlFinal(String input){
        String[] arr = input.split(";");
        if(arr.length == 8){
            id = arr[0];
            date = arr[1];
            winner = arr[2];
            result = arr[3];
            looser = arr[4];
            location = arr[5];
            cityAndState = arr[6];
            spectatorsCount = Integer.parseInt(arr[7]);
        }
    }


    public int getPointsDifference(){
        int[] points = getPoints();
        return points[0]-points[1];
    }

    public int[] getPoints(){
        String[] arr = result.split("-");
        return new int[]{
                Integer.parseInt(arr[0]),
                Integer.parseInt(arr[1])
        };
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLooser() {
        return looser;
    }

    public void setLooser(String looser) {
        this.looser = looser;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCityAndState() {
        return cityAndState;
    }

    public void setCityAndState(String cityAndState) {
        this.cityAndState = cityAndState;
    }

    public int getSpectatorsCount() {
        return spectatorsCount;
    }

    public void setSpectatorsCount(int spectatorsCount) {
        this.spectatorsCount = spectatorsCount;
    }


    @Override
    public String toString(){
        RomanNumerals romanNumerals = new RomanNumerals(id);
        int[] points = getPoints();
        return  "\tSorszám (dátum): " + romanNumerals.getArabSsz() + " (" + date + ")\n" +
                "\tGyőztes csapat: " + winner + ", szerzett pontok: " + points[0] + "\n" +
                "\tVesztes csapat: " + looser + ", szerzett pontok: " + points[1] + "\n" +
                "\tHelyszín: " + location + "\n" +
                "\tVáros, állam: " + cityAndState + "\n" +
                "\tNézőszám: " + spectatorsCount;
    }
}
