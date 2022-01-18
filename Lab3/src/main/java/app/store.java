package app;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope

public class store
{
    Note note;

    public Note getNote()
    {
        return note;
    }

    public void setNote(Note note)
    {
        this.note = note;
    }
}
