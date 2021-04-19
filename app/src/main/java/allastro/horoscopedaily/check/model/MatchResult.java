package allastro.horoscopedaily.check.model;

public class MatchResult {

    private String firstZodiak;
    private String secondZodiak;
    private String percents;

    public MatchResult() {
    }

    public MatchResult(String firstZodiak, String secondZodiak, String percents) {
        this.firstZodiak = firstZodiak;
        this.secondZodiak = secondZodiak;
        this.percents = percents;
    }

    public String getFirstZodiak() {
        return firstZodiak;
    }

    public void setFirstZodiak(String firstZodiak) {
        this.firstZodiak = firstZodiak;
    }

    public String getSecondZodiak() {
        return secondZodiak;
    }

    public void setSecondZodiak(String secondZodiak) {
        this.secondZodiak = secondZodiak;
    }

    public String getPercents() {
        return percents;
    }

    public void setPercents(String percents) {
        this.percents = percents;
    }
}
