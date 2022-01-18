package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;


@Controller
public class NoteItController extends HttpServlet
{
    HashMap<Integer,Note> notes = new HashMap<>(); // store note object as data with id count
    private int count = 1;
    @Autowired
    store store;

    @GetMapping("/notes")
    public String index()
    {
        return "index.html";
    }

    @GetMapping("/create")
    public String create()
    {
        return "create.html";
    }

    @PostMapping("/create")
    public String createNote(Note note, HttpServletResponse response) // receive a note object store it in to hash map process the date, set to note object and sent it to browse page
    {
        Date date = new Date();
        note.setDateCreated(date);
        note.setDateEdited(date);
        notes.put(count++,note);
        try
        {
            response.sendRedirect("/browse");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/browse") // add the received note object though thymeleaf and use http language "notes : ${notes}" to loop the hash map using get.value
    public String browse(Model model)
    {
        model.addAttribute("notes",notes);
        return "browse.html";
    }


    @GetMapping("/view/{id}") // receive a int id from view and use it as key to get value from hash map and add the note object though thymeleaf
    public String view(Model model, @PathVariable int id)
    {
        model.addAttribute("note",notes.get(id));
        return "view.html";
    }
}
