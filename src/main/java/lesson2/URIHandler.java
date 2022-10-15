package lesson2;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class URIHandler {
    public static URI getUri(String file, Object object) throws URISyntaxException {
        return Objects.requireNonNull(object.getClass().getClassLoader().getResource(file)).toURI();
    }
}
