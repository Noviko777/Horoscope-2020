package allastro.horoscopedaily.check.model;

import android.graphics.drawable.Drawable;

public class Match {

    private Drawable drawable;
    private String name;
    private String description;
    private String color;

    public Match() {
    }

    public Match(Drawable drawable, String name, String description, String color) {
        this.drawable = drawable;
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
