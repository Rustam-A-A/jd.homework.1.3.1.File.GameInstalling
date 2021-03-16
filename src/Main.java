import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        sb.append("Созданы директории и файлы: \n");

        File src = new File("/Users/admin/Games", "src");
        setDir(src, sb);

        File res = new File("/Users/admin/Games", "res");
        setDir(res, sb);

        File savegames = new File("/Users/admin/Games", "savegames");
        setDir(savegames, sb);

        File temp = new File("/Users/admin/Games", "temp");
        setDir(temp, sb);

        File tempTxt = new File(temp, "temp.txt");
        setFile(tempTxt, sb);

        File main = new File(src, "main");
        setDir(main, sb);

        File utilsJava = new File(main, "Utils.java");
        setFile(utilsJava, sb);

        File test = new File(src, "test");
        setDir(test, sb);

        File mainJava = new File(main, "Main.java");
        setFile(mainJava, sb);

        File drawables = new File(res, "drawables");
        setDir(drawables, sb);

        File vectors = new File(res, "vectors");
        setDir(vectors, sb);

        File icons = new File(res, "icons");
        setDir(icons, sb);

        FileWriter writer = new FileWriter(tempTxt, true);
        writer.write(sb.toString());
        writer.close();
    }

    //метод создания директории
    public static void setDir(File dir, StringBuilder sb){
        if (dir.mkdir()) {
            sb.append("\nКаталог [ ")
                    .append(dir.getName())
                    .append(" ] \n")
                    .append(dir.getPath());
        }
    }

    //метод создания файла
    public static void setFile(File file, StringBuilder sb){
        try {
            if (file.createNewFile()) {
                sb.append("\nФайл ( ")
                        .append(file.getName())
                        .append(" ) \n")
                        .append(file.getPath());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
