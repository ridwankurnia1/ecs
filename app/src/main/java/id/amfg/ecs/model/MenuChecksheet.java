package id.amfg.ecs.model;

public class MenuChecksheet {
    private String img_name;
    private int img;

    public MenuChecksheet(String img_name, int img){
        this.img_name = img_name;
        this.img = img;
    }

    public String getImg_name(){
        return img_name;
    }

    public void setImg_name(){
        this.img_name = img_name;
    }

    public int getImg(){
        return img;
    }

    public void setImg(){
        this.img = img;
    }
}
