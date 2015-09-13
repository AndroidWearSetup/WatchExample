package hackzurich.learnwithus.model;

import android.content.Intent;

public class Database {

    public final static String NAME = "name";
    public final static String PATH = "path";

    private String name;
    private String path;

    public Database(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public Database(Intent intent) {
        name = intent.getStringExtra(Database.NAME);
        path = intent.getStringExtra(Database.PATH);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static void packageIntent(Intent intent, String name, String path) {
        intent.putExtra(Database.NAME, name);
        intent.putExtra(Database.PATH, path);
    }
}
