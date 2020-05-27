package enums;

public enum GenreEnums {
    tvmovie("电视电影","tvmovie"),cartoon("动画","cartoon"),western("西部","western");
    private String value;
    private String index;

    public static String getValueByName(String index){
        for (GenreEnums genreEnums:values())
            if (genreEnums.getIndex() == index) {
                return genreEnums.getValue();
            }
        return null;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    private GenreEnums(String value,String index) {
        this.value = value;
        this.index = index;
    }

}
