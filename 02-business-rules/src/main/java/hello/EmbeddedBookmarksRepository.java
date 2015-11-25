package hello;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.HashMap;
import java.util.Map;

public class EmbeddedBookmarksRepository implements ApplicationListener<ContextRefreshedEvent> {

    private final Map<String, Bookmark> storage = new HashMap<>();


    Bookmark findOne(String id) {
        return storage.get(id);
    }

    void save(String user, Bookmark bookmark) {
        storage.put(user, bookmark);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        storage.put("user", new Bookmark("Impaq", "http://impaqgroup.com"));
        storage.put("manager", new Bookmark("Impaq", "http://impaqgroup.com"));
    }
}
