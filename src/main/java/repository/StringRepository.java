package repository;

import java.io.IOException;
import java.util.ArrayList;

public interface StringRepository {
    ArrayList<String> FileRead(String path) throws IOException;
}
