package meandrick.martin.front_page_risaikuru;

public class RecItems {
    String mtitle;
    String mdesc;
    String mlikes;

    public RecItems(String title, String desc, String likes){
        mtitle = title;
        mdesc = desc;
        mlikes = likes;
    }

    public String getTitle() {
        return mtitle;
    }

    public String getDesc() {
        return mdesc;
    }

    public String getLikes() {
        return mlikes;
    }
}
