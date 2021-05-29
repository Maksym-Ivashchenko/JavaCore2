package lessons.httplesson;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class NewUser {
        int id;
        String name;
        String username;
}
