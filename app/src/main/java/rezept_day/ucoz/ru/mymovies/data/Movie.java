package rezept_day.ucoz.ru.mymovies.data;

public class Movie {
    private int id;
    private int voteCount;//количество голосов
    private String title;//Заголовок фильма
    private String originalTitile;//Оригинальное название фильма
    private String overview;//Описание фильма
    private String posterParth;//Путь к постеру
    private String backdropPath;//Фоновое изображение
    private double voteAverage;//Рейтинг фильма
    private String releaseDate;//Дата релига

    public Movie(int id, int voteCount, String title, String originalTitile, String overview, String posterParth, String backdropPath, double voteAverage, String releaseDate) {
        this.id = id;
        this.voteCount = voteCount;
        this.title = title;
        this.originalTitile = originalTitile;
        this.overview = overview;
        this.posterParth = posterParth;
        this.backdropPath = backdropPath;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitile() {
        return originalTitile;
    }

    public void setOriginalTitile(String originalTitile) {
        this.originalTitile = originalTitile;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterParth() {
        return posterParth;
    }

    public void setPosterParth(String posterParth) {
        this.posterParth = posterParth;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
