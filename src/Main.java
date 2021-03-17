import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        sb.append("Созданы директории и файлы: \n");

        //структура директорий
        File[] dirs  = {
                new File("/Users/admin/Games", "src"),
                new File("/Users/admin/Games", "res"),
                new File("/Users/admin/Games", "savegames"),
                new File("/Users/admin/Games", "temp"),
                new File("/Users/admin/Games/src/", "test"),
                new File("/Users/admin/Games/src/", "main"),
                new File("/Users/admin/Games/res", "drawables"),
                new File("/Users/admin/Games/res", "vectors"),
                new File("/Users/admin/Games/res", "icons"),
        };
        for (File dir : dirs) {
            setDir(dir, sb);
        }

        //структура файлов
        File[] files = {
                new File("/Users/admin/Games/temp", "temp.txt"),
                new File("/Users/admin/Games/src/main", "Utils.java"),
                new File("/Users/admin/Games/src/main", "Main.java"),
        };
        for (File f : files) {
            setFile(f, sb);
        }

        FileWriter writer = new FileWriter(files[0], true);
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
